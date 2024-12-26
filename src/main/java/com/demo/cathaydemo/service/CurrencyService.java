package com.demo.cathaydemo.service;

import com.demo.cathaydemo.dao.CurrencyRepository;
import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.util.ErrorCode;
import com.demo.cathaydemo.util.CurrencyExceptionHandler;
import com.demo.cathaydemo.vo.CoindeskVo;
import com.demo.cathaydemo.vo.NewCurrencyRq;
import com.demo.cathaydemo.vo.UpdateCurrencyRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public CoindeskVo fetchCoinDeskApi(){
        try {
            String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
            return restTemplate.getForEntity(url, CoindeskVo.class).getBody();
        }catch (Exception e){
            throw new CurrencyExceptionHandler(ErrorCode.FETCH_COINDESK_API_ERROR);
        }
    }

    public List<Currency> getAllCurrencies() {
        try{
            return currencyRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new CurrencyExceptionHandler(ErrorCode.SYSTEM_ERROR);
        }

    }

    public boolean fethAndSaveCurrencies() {
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        try {
            CoindeskVo response = restTemplate.getForEntity(url, CoindeskVo.class).getBody();

            if (response != null && response.getBpi() != null) {
                Map<String, Currency> currencies = response.getBpi();
                String updatedIsoTime = response.getTime().getUpdatedISO();
                //offsetDateTime default use ISO 8601
                OffsetDateTime offsetDateTime = OffsetDateTime.parse(updatedIsoTime);

                for (Map.Entry<String, Currency> currencyEntry : currencies.entrySet()) {
                    Currency currencyInfo = new Currency();
                    currencyInfo.setCode(currencyEntry.getValue().getCode());
                    currencyInfo.setSymbol(currencyEntry.getValue().getSymbol());
                    currencyInfo.setRate(currencyEntry.getValue().getRate());
                    currencyInfo.setDescription(currencyEntry.getValue().getDescription());
                    currencyInfo.setRateFloat(currencyEntry.getValue().getRateFloat());
                    currencyInfo.setUpdateTime(Date.from(offsetDateTime.toInstant()));

                    currencyRepository.save(currencyInfo);
                }
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CurrencyExceptionHandler(ErrorCode.TRANSFORM_DATA_ERROR);
        }

    }

    public boolean addNewCurrency(NewCurrencyRq request) {
        try {
            boolean isExisted = currencyRepository.existsById(request.getCode());
            if (isExisted) {
                return false;
            }else {
                Currency currency = new Currency();
                currency.setCode(request.getCode());
                currency.setSymbol(request.getSymbol());
                currency.setRate(request.getRate());
                currency.setDescription(request.getDescription());
                currency.setRateFloat(request.getRateFloat());
                currency.setUpdateTime(new Date());

                currencyRepository.save(currency);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CurrencyExceptionHandler(ErrorCode.INSERT_NEW_CURRENCY_ERROR);
        }
    }

    public Currency updateCurrency(UpdateCurrencyRq request) {
        try {
            Optional<Currency> getCurrencyByCode = currencyRepository.findById(request.getCode());

            if (getCurrencyByCode.isPresent()) {
                Currency existedCurrency = getCurrencyByCode.get();

                if (request.getSymbol() != null) {
                    existedCurrency.setSymbol(request.getSymbol());
                }
                if (request.getRate() != null) {
                    existedCurrency.setRate(request.getRate());
                }
                if (request.getDescription() != null) {
                    existedCurrency.setDescription(request.getDescription());
                }
                if (request.getRateFloat() != null) {
                    existedCurrency.setRateFloat(request.getRateFloat());
                }
                return currencyRepository.save(existedCurrency);
            }else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new CurrencyExceptionHandler(ErrorCode.UPDATE_CURRENCY_ERROR);
        }
    }

    public boolean deleteCurrencyByCode(String code){
        try {
            Optional<Currency> currencyOptional = currencyRepository.findById(code);
            if (currencyOptional.isPresent()) {
                currencyRepository.deleteById(code);
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new CurrencyExceptionHandler(ErrorCode.DELETE_CURRENCY_ERROR);
        }
    }


}
