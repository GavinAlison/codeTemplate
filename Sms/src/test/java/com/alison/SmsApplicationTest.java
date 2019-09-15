package com.alison;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @Author alison
 * @Date 2019/9/14  14:12
 * @Version 1.0
 * @Description
 */
public class SmsApplicationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void sendSms(){
//        restTemplate.postForEntity();
    }

}
