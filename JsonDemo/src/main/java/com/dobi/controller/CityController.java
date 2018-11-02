package com.dobi.controller;


import com.dobi.bean.City;
import com.dobi.bean.Province;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 */
@RestController
public class CityController {
    private static final String TAG = "CityController";

    private static List<Province> provinceList = new ArrayList<>();

    private static Map<Integer , List<City>> map = new HashMap<Integer , List<City>>();

    static{

        provinceList.add(new Province(1,"广东"));
        provinceList.add(new Province(2,"湖北"));
        provinceList.add(new Province(3,"湖南"));
        provinceList.add(new Province(4,"广西"));

        List<City> list01 = new ArrayList<City>();
        list01.add(new City(1, "深圳"));
        list01.add(new City(2, "广州"));
        list01.add(new City(3, "惠州"));

        List<City> list02= new ArrayList<City>();
        list02.add(new City(1, "武汉"));
        list02.add(new City(2, "黄冈"));
        list02.add(new City(3, "十堰"));

        List<City> list03 = new ArrayList<City>();
        list03.add(new City(1, "长沙"));
        list03.add(new City(2, "岳阳"));
        list03.add(new City(3, "益阳"));

        List<City> list04 = new ArrayList<City>();
        list04.add(new City(1, "南宁"));
        list04.add(new City(2, "桂林"));
        list04.add(new City(3, "北海"));

        map.put(1 , list01);
        map.put(2, list02);
        map.put(3 , list03);
        map.put(4 , list04);

    }


    //获取省份
    @RequestMapping("listProvince")
    public List<Province> listProvince(){

        return provinceList;
    }

    //获取省份
    @RequestMapping("listCity")
    public List<City> listCity(int id){

        return map.get(id);
    }
}
