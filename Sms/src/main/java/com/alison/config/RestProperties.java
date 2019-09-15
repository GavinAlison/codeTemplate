package com.alison.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author alison
 * @Date 2019/9/15  11:20
 * @Version 1.0
 * @Description
 */
@Data
@Component
@ConfigurationProperties(prefix = "rest")
public class RestProperties {
    private int readTimeout;
    private int connectTimeout;

}
