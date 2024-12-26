package com.demo.cathaydemo.vo;

import com.demo.cathaydemo.util.ResultBean;

public class FetchCoinDeskRs extends ResultBean {

    private CoindeskVo coindesk;

    public CoindeskVo getCoindesk() {
        return coindesk;
    }

    public void setCoindesk(CoindeskVo coindesk) {
        this.coindesk = coindesk;
    }
}
