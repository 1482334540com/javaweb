package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;

public class Test {
    public static void main(String[] args) {
        System.out.println(JdbcUtils.getConnection());
    }
}
