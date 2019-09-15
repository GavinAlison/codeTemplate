package com.alison.controller;

import com.alison.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author alison
 * @Date 2019/9/15  10:02
 * @Version 1.0
 * @Description
 */
@RestController
public class SmsController {
    @Autowired
    private SmsService smsService;

    @GetMapping("/sendSms")
    public String sendSms() {
        smsService.sendSms();
        return "ok";
    }
}
