package com.dobi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Fastjson解析json
 */
public class FastjsonTest {

    public static void main(String[] args) {

        //遇到"就转义\"
        String json ="{\"code\":404,\"data\":[{\"age\":28,\"id\":2,\"name\":\"zhangsan2\"},{\"age\":38,\"id\":3,\"name\":\"zhangsan3\"},{\"age\":48,\"id\":4,\"name\":\"zhangsan4\"},{\"age\":58,\"id\":5,\"name\":\"zhangsan5\"}],\"message\":\"success\"}";


        //json字符串转换成json对象
        JSONObject jsonObject = new JSONObject();
        JSONObject parseObj = jsonObject.parseObject(json);
        String message =parseObj.getString("message");
        System.out.println(message);
        JSONArray jsonArray = parseObj.getJSONArray("data");
        for (Object obj: jsonArray) {
            JSONObject jsonObject1 = (JSONObject) obj;
            String name = jsonObject1.getString("name");
            System.out.println(name);
        }
    }
}
