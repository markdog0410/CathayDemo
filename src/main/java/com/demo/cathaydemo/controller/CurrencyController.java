package com.demo.cathaydemo.controller;

import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.service.CurrencyService;
import com.demo.cathaydemo.util.ErrorCode;
import com.demo.cathaydemo.util.CurrencyExceptionHandler;
import com.demo.cathaydemo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bpi")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/fetchCoinDesk")
    public FetchCoinDeskRs fetchCoinDeskApi(){
        FetchCoinDeskRs response = new FetchCoinDeskRs();
        try {
            CoindeskVo result = currencyService.fetchCoinDeskApi();
            response.setCoindesk(result);
            response.setRsCode(ErrorCode.SUCCESS.getCode());
            response.setMessage(ErrorCode.SUCCESS.getMessage());
            return  response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }

    @GetMapping("/fetchAndTransform")
    public TransformCoindeskRs fetchApi(){
        TransformCoindeskRs response = new TransformCoindeskRs();
        try {
            boolean isTransformed = currencyService.fethAndSaveCurrencies();
            if(isTransformed){
                response.setCurrencies(currencyService.getAllCurrencies());
                response.setRsCode(ErrorCode.SUCCESS.getCode());
                response.setMessage(ErrorCode.SUCCESS.getMessage());
            }else {
                response.setRsCode(ErrorCode.TRANSFORM_DATA_FAILED.getCode());
                response.setMessage(ErrorCode.TRANSFORM_DATA_FAILED.getMessage());
            }
            return response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }

    @GetMapping("/getAllCurrencies")
    public GetAllCurrenciesRs getAllCurrencies() {
        GetAllCurrenciesRs response = new GetAllCurrenciesRs();
        try {
            List<Currency> currencies = currencyService.getAllCurrencies();
            response.setCurrencies(currencies);
            response.setRsCode(ErrorCode.SUCCESS.getCode());
            response.setMessage(ErrorCode.SUCCESS.getMessage());
            return response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }

    @PostMapping("/addNewCurrency")
    public NewCurrencyRs addNewCurrency(@RequestBody NewCurrencyRq request){
        NewCurrencyRs response = new NewCurrencyRs();
        try {
            boolean isCurrencyAdded = currencyService.addNewCurrency(request);
            if(isCurrencyAdded){
                response.setRsCode(ErrorCode.SUCCESS.getCode());
                response.setMessage(ErrorCode.SUCCESS.getMessage());
            }else {
                response.setRsCode(ErrorCode.CURRENCY_ALREADY_EXISTED.getCode());
                response.setMessage(ErrorCode.CURRENCY_ALREADY_EXISTED.getMessage());
            }
            return response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }

    @PostMapping("/updateCurrency")
    public UpdateCurrencyRs updateCurrency(@RequestBody UpdateCurrencyRq request){
        UpdateCurrencyRs response = new UpdateCurrencyRs();
        try {
            Currency updateResult = currencyService.updateCurrency(request);
            if (updateResult != null) {
                response.setCurrency(updateResult);
                response.setRsCode(ErrorCode.SUCCESS.getCode());
                response.setMessage(ErrorCode.SUCCESS.getMessage());
            } else {
                response.setRsCode(ErrorCode.NOT_MATCH_CURRENCY.getCode());
                response.setMessage(ErrorCode.NOT_MATCH_CURRENCY.getMessage());
            }
            return response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }

    @PostMapping("/deleteByCode")
    public DeleteCurrencyRs deleteCurrencyByCode(@RequestBody DeleteCurrencyRq request){
        DeleteCurrencyRs response = new DeleteCurrencyRs();
        try {
            boolean isDeleted = currencyService.deleteCurrencyByCode(request.getCode());

            if (isDeleted) {
                response.setMessage(ErrorCode.SUCCESS.getMessage());
                response.setRsCode(ErrorCode.SUCCESS.getCode());
            } else {
                response.setRsCode(ErrorCode.NOT_MATCH_CURRENCY.getCode());
                response.setMessage(ErrorCode.NOT_MATCH_CURRENCY.getMessage());
            }
            return response;
        }catch (CurrencyExceptionHandler e){
            response.setRsCode(e.getErrorCode().getCode());
            response.setMessage(e.getErrorCode().getMessage());
            return response;
        }
    }


}
