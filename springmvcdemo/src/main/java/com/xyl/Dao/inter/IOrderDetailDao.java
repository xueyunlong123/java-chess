package com.xyl.Dao.inter;

import com.xyl.bean.OrderDetail;

import java.util.List;


/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public interface IOrderDetailDao {
    public int insertOrderDetail(OrderDetail orderDetail);
    public List<OrderDetail> queryOrderDetailByOid(int oid);
}
