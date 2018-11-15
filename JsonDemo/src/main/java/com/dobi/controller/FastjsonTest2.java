package com.dobi.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * fastjson---对象转json字符串
 */
public class FastjsonTest2 {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","du");
        jsonObject1.put("age","13");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","he");
        jsonObject2.put("age","63");
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonObject.put("data",jsonArray);
        jsonObject.put("code",404);
        jsonObject.put("message","success");
        System.out.println(jsonObject.toJSONString());
    }
}
