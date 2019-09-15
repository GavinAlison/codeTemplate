package com.alison.config;

/**
 * @Author alison
 * @Date 2019/9/15  10:55
 * @Version 1.0
 * @Description
 */

import lombok.Data;

@Data
public class Payloads {
    private String templated;
    private String verficationCode;
    private int verficationCodeLen;
    private long expireTime;
}