package com.demo.cathaydemo.vo;

import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.util.ResultBean;

import java.util.List;

public class TransformCoindeskRs extends ResultBean {

    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
