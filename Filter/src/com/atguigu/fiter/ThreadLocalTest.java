package com.atguigu.fiter;

import java.util.*;
import  java.lang.ThreadLocal;

/**
 * @ClassName : ThreadLocal  //类名
 * @Description : 事务管理  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/11  18:51
 */
public class ThreadLocalTest {
  public static ThreadLocal<Object> threadLocal= new ThreadLocal<Object>();

    private  static Random random = new Random();
    public static class Task   implements  Runnable{

        public void run() {
            //在run方法中随机生成一个变量（线程要关联的数据，当前线程名为key，保存到map中）
            //在run方法快结束之前，以当前线程名称取出数据并且打印，查看是否可以取出操作
            Integer i = random.nextInt(1000);
            String name = Thread.currentThread().getName(); //获取当前线程名
            System.out.println( "线程"+name+"生成的随机数是"+i);

            //设置threadLocal的值
            threadLocal.set(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取threadLocal的值
            System.out.println("线程"+name+"线程快结束时取出的关联的数据是"+threadLocal.get() );
            //采用匿名对象的方式去调用createOrder()方法
            new OrderService().createOrder();
        }


    }
    //创建三个线程对象
    public static void main(String[] args) {
        for (int i= 0;i<3;i++){
            new Thread(new Task()).start();
        }
    }

}


