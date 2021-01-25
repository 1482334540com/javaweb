package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * @ClassName : OderDaoImpl  //类名
 * @Description : OderDao的实现类  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/8  16:19
 */
public class OderDaoImpl extends  BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}


