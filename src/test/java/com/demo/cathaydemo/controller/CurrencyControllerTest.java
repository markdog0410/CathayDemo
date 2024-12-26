package com.demo.cathaydemo.controller;

import com.demo.cathaydemo.service.CurrencyService;
import com.demo.cathaydemo.vo.DeleteCurrencyRq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CurrencyService currencyService;

    //5. 測試呼叫coindesk API，並顯示其內容
    @Test
    void fetchCoindeskApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/v1/bpi/fetchCoinDesk"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }

    //6. 測試呼叫資料轉換的API，並顯示其內容
    @Test
    void fetchCoindeskApiAndTransform() throws Exception {
        MvcResult result = mockMvc.perform(get("/v1/bpi/fetchAndTransform"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }

    //1. 測試呼叫查詢幣別對應表資料API，並顯示其內容
    @Test
    void getAllCurrencies() throws Exception {
        MvcResult result = mockMvc.perform(get("/v1/bpi/getAllCurrencies"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }

    //2. 測試呼叫新增幣別對應表資料API
    @Test
    void addNewCurrency() throws Exception {
        String request = "{\"code\":\"TWD\",\"symbol\":\"NT$\",\"rate\": \"33.1\",\"description\":\"New Taiwan dollar\",\"rateFloat\":33.1}";

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/v1/bpi/addNewCurrency")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }

    //3. 測試呼叫更新幣別對應表資料API，並顯示其內容
    @Test
    void updateCurrency() throws Exception {
        String request = "{\"code\":\"BTC\",\"symbol\":\"$$\",\"rate\":\"150,000.0\",\"description\":\"To the moon\",\"rateFloat\":150000.0}";

        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.post("/v1/bpi/updateCurrency")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }

    //4. 測試呼叫刪除幣別對應表資料API
    @Test
    void deleteByCode() throws Exception {
        String request = "{\"code\": \"ETH\"}";

        MvcResult result = mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/bpi/deleteByCode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
            .andExpect(status().isOk())
            .andReturn();

        System.out.println("API Response: " + result.getResponse().getContentAsString());
    }


}
