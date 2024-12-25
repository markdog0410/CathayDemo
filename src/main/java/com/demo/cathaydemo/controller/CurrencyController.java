package com.demo.cathaydemo.controller;

import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @GetMapping("/fetchApi")
    public String fetchApi(){
        currencyService.fethAndSaveCurrencies();
        return "轉換完成";
    }

    @GetMapping("/getAllCurrencies")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }
}
