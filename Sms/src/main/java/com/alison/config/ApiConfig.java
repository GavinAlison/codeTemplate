package com.alison.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author alison
 * @Date 2019/9/15  10:59
 * @Version 1.0
 * @Description
 */
@Data
@Component
@Configuration
public class ApiConfig {

    @Autowired
    private UcpConfig ucpConfig;

    @Value("${mobile}")
    private String mobile;
}
