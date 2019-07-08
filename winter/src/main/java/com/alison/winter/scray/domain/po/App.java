package com.alison.winter.scray.domain.po;

import lombok.Data;
import java.util.Date;

/**
 * @author huangyong
 * @version: 0.1
 **/


@Data
public class App {

    private Long id;

    private String name;

    private byte[] icon;

    private Date createTime;

    private Date updateTime;
}
