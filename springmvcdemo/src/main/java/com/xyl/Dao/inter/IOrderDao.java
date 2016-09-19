package com.xyl.Dao.inter;

import com.xyl.bean.Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public interface IOrderDao {
    public List<Order> queryOrderByUid(int id);
    public Order queryOrderByid(int id);
    /*public int insertOrder(int uid, Timestamp buydate,float totalprice,String receiver,String rphone,String raddress);*/
    public int insertOrder(Order order);

}
