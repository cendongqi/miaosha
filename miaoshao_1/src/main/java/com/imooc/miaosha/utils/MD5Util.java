package com.imooc.miaosha.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    private MD5Util() {

    }

    public static String MD5(String source) {
        return DigestUtils.md5Hex(source);
    }

    public static String formPassToDbPass(String inputPass, String randomSalt) {
        return MD5(MD5(randomSalt) + inputPass + MD5(randomSalt));
    }
}
