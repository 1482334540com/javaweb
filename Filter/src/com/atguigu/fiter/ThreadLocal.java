package com.atguigu.fiter;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;


/**
 * @ClassName : ThreadLocal  //类名
 * @Description : 事务管理  //描述
 * @Author : ${""} //作者
 * @Date: 2020/11/11  18:51
 */
public class ThreadLocal {
    public  final  static Map< String ,Object> data = new Hashtable<>();
    private  static Random random = new Random();
    public static class Task   implements  Runnable{

        public void run() {
            //在run方法中随机生成一个变量（线程要关联的数据，当前线程名为key，保存到map中）
            //在run方法快结束之前，以当前线程名称取出数据并且打印，查看是否可以取出操作
            Integer i = random.nextInt(1000);
            String name = Thread.currentThread().getName(); //获取当前线程名
            System.out.println( "线程"+name+"生成的随机数是"+i);
            data.put(name,i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("线程"+name+"线程快结束时取出的关联的数据是"+data.get(name));
        }


    }
            //创建三个线程对象
    public static void main(String[] args) {
        for (int i= 0;i<3;i++){
            new Thread(new Task()).start();
        }
    }
    
}
  

