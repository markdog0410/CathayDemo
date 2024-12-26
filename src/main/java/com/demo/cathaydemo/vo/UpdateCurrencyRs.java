package com.demo.cathaydemo.vo;

import com.demo.cathaydemo.entity.Currency;
import com.demo.cathaydemo.util.ResultBean;

public class UpdateCurrencyRs extends ResultBean {

    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
