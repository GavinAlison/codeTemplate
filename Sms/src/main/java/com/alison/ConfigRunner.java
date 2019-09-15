package com.alison;

import com.alison.config.UcpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author alison
 * @Date 2019/9/15  10:03
 * @Version 1.0
 * @Description
 */
@Component
public class ConfigRunner implements CommandLineRunner {

    @Autowired
    private UcpConfig ucpConfig;

    @Override
    public void run(String... args) throws Exception {
    }
}
