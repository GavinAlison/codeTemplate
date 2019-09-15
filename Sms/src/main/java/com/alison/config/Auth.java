package com.alison.config;

import lombok.Data;

/**
 * @Author alison
 * @Date 2019/9/15  10:54
 * @Version 1.0
 * @Description
 */
@Data
public class Auth {
    private String appId;
    private String sid;
    private String token;
}