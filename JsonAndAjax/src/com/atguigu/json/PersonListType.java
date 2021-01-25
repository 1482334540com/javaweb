package com.atguigu.json;


import com.atguigu.pojo.Person;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
//泛型放的是最终需要转换为的类型
public class PersonListType extends TypeToken<ArrayList<Person>> {
}
