package com.demo.cathaydemo.controller;

import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.service.CurrencyService;
import com.demo.cathaydemo.util.ResultBean;
import com.demo.cathaydemo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bpi")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @GetMapping("/fetchApi")
    public String fetchApi(){
        return currencyService.fethAndSaveCurrencies();
    }

    @GetMapping("/getAllCurrencies")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @PostMapping("/addNewCurrency")
    public String addNewCurrency(@RequestBody NewCurrencyRq request){
        return currencyService.addNewCurrency(request);
    }

    @PostMapping("/updateCurrency")
    public UpdateCurrencyRs updateCurrency(@RequestBody UpdateCurrencyRq request){
        UpdateCurrencyRs response = new UpdateCurrencyRs();
        Currency updateResult = currencyService.updateCurrency(request);
        if(updateResult != null){
            response.setCode(updateResult.getCode());
            response.setSymbol(updateResult.getSymbol());
            response.setRate(updateResult.getRate());
            response.setDescription(updateResult.getDescription());
            response.setRateFloat(updateResult.getRateFloat());
            return response;
        }else {
            response.setRsCode("9999");
            response.setMessage("Something wrong in updateCurrency.");
            return response;
        }

    }

    @PostMapping("/deleteByCode")
    public DeleteCurrencyRs deleteCurrencyByCode(@RequestBody DeleteCurrencyRq request){
        boolean isDeleted = currencyService.deleteCurrencyByCode(request.getCode());
        DeleteCurrencyRs response = new DeleteCurrencyRs();
        if(!isDeleted){
            response.setMessage("Delete failed.");
            response.setRsCode("9999");
            return response;
        }else{
            return response;
        }

    }
}
