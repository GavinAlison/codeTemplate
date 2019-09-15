package com.alison.util;

import lombok.experimental.UtilityClass;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author alison
 * @Date 2019/9/15  18:25
 * @Version 1.0
 * @Description
 */
@UtilityClass
public class EncodeUtil {

    private final static Base64.Decoder decoder = Base64.getDecoder();

    private final static Base64.Encoder encoder = Base64.getEncoder();

    public static String encode(String str) {
        try {
            String encodeStr = encoder.encodeToString(str.getBytes("UTF-8"));
            return encoder.encodeToString(encodeStr.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String decode(String encodeText) {
        try {
            String decodeStr = new String(decoder.decode(encodeText), "UTF-8");
            return new String(decoder.decode(decodeStr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }

    public static void main(String[] args) throws Exception {
        String apikey = "cdfc9e5bf8d05c5ea8cc940b38a75961";
        String encodeText = EncodeUtil.encode(apikey);
        System.out.println(EncodeUtil.encode(apikey));
        System.out.println(EncodeUtil.decode(encodeText));
    }
}
