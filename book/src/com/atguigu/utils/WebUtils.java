package com.atguigu.utils;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    //使用泛型减去类型转换
    public static  <T>  T  copyparamToBean(Map value, T bean){


        try {

//   将请求都数据加入到user对象中
            BeanUtils.populate(bean,value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
//    将String类型都数据转换为int类型都数据
    public static int parseInt(String strInt,int defalutValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defalutValue;
    }
}
