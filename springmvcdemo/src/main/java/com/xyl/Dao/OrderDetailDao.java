package com.xyl.Dao;

import com.xyl.Dao.inter.IOrderDetailDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.OrderDetail;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public class OrderDetailDao implements IOrderDetailDao{

    SqlSession sqlSession = MybatisUtil.getSession();
    IOrderDetailDao iOrderDetailDao = sqlSession.getMapper(IOrderDetailDao.class);
    @Override
    public int insertOrderDetail(OrderDetail orderDetail) {
        int index = iOrderDetailDao.insertOrderDetail(orderDetail);
        sqlSession.commit();
        return index;
    }

    @Override
    public List<OrderDetail> queryOrderDetailByOid(int oid) {
        List<OrderDetail> orderDetails = iOrderDetailDao.queryOrderDetailByOid(oid);
        return orderDetails;
    }
}
