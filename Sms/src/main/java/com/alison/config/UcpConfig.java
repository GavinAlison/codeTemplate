package com.alison.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author alison
 * @Date 2019/9/14  16:11
 * @Version 1.0
 * @Description
 */
@Data
@Component
@ConfigurationProperties(prefix = "ucp")
public class UcpConfig {
    private String product;
    private String desc;
    private String sendsms;
    private Auth auth;
    private Payloads payloads;
}




