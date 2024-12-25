package com.demo.cathaydemo.service;

import com.demo.cathaydemo.dao.CurrencyRepository;
import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.vo.CoindeskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public void fethAndSaveCurrencies() {
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        CoindeskVo response = restTemplate.getForEntity(url, CoindeskVo.class).getBody();

        System.out.println(response);

    }
}
