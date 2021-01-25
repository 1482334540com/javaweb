package com.atguigu.json;


import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

//    1.2.1、javaBean和json的互转
    @Test
    public void test1(){
        Person person = new Person(1,"username");
        // 创建Gson对象实例
        Gson gson = new Gson();
        // toJson方法可以把java对象转换成为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println("java对象转换成为json字符串:"+personJsonString);
        // fromJson把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println("把json字符串转换回Java对象"+person1);
    }

//    1.2.2、List 和json的互转
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person(1, "admin"));
        personList.add(new Person(2, "root"));

        Gson gson = new Gson();

        // 把List转换为json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println("把List转换为json字符串"+personListJsonString);

        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println("把json字符串转换为list集合"+person);
    }

//    1.2.3、map 和json的互转
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();

        personMap.put(1, new Person(1, "admin"));
        personMap.put(2, new Person(2, "root"));

        Gson gson = new Gson();
        // 把map 合转换成为 json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println("把map合转换成为json字符串"+personMapJsonString);
//这样的方式有弊端，需要写一个类继承TypeToken<需要转换的最终类型>类
//        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
//采用匿名内部类的方式，随写随new，不要单独写类继承TypeToken<需要转换的最终类型>类，可以省去创建多余的类
        Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());

        System.out.println(personMap2);
        Person p = personMap2.get(1);
        System.out.println("把json字符串转化为map集合"+p);

    }


}
