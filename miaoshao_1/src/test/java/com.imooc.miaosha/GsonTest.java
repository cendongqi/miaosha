package com.imooc.miaosha;

import com.google.gson.Gson;
import com.imooc.miaosha.domain.User;
import org.junit.jupiter.api.Test;

public class GsonTest {

    @Test
    public void testNullToGson() {
       User user = null;
        System.out.println(new Gson().toJson(user));
    }
}
