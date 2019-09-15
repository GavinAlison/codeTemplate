package com.alison.service.impl;

import com.alison.config.ApiConfig;
import com.alison.service.SmsService;
import com.alison.util.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.beans.Encoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author alison
 * @Date 2019/9/15  11:07
 * @Version 1.0
 * @Description
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private ApiConfig apiConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void sendSms() {
        String url = apiConfig.getUcpConfig().getSendsms();
        Map<String, String> bodyMap = new LinkedHashMap<>();
        bodyMap.put("appid", EncodeUtil.decode(apiConfig.getUcpConfig().getAuth().getAppId()));
        bodyMap.put("sid", EncodeUtil.decode(apiConfig.getUcpConfig().getAuth().getSid()));
        bodyMap.put("token", EncodeUtil.decode(apiConfig.getUcpConfig().getAuth().getToken()));
        bodyMap.put("templateid", apiConfig.getUcpConfig().getPayloads().getTemplated());
//        bodyMap.put("mobile", apiConfig.getMobile());
        long expiredTime = apiConfig.getUcpConfig().getPayloads().getExpireTime();
        Random random = new Random(3);
        StringBuffer verficationCode = new StringBuffer("");
        for (int i = 0; i < apiConfig.getUcpConfig().getPayloads().getVerficationCodeLen(); i++) {
            verficationCode.append(random.nextInt(9) + 1);
        }
//        save2RedisCache(verficationCode.toString(), expiredTime);
        bodyMap.put("param", verficationCode.append(",").append(expiredTime).toString());
        Map<String, Object> result = restTemplate.postForObject(url, bodyMap, Map.class);
        System.out.println(result);
        if (!"000000".equalsIgnoreCase(result.get("code").toString())) {
            log.error(result.get("msg").toString());
            throw new RuntimeException("send sms exception: " + result.get("msg"));
        }
        log.info("send sms success!");
    }

    private void save2RedisCache(String verficateCode, long expiredTime) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("VERFICATION:CODE", verficateCode, expiredTime, TimeUnit.SECONDS);
    }


}
