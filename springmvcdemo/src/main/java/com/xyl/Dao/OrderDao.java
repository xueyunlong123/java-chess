package com.xyl.Dao;

import com.xyl.Dao.inter.IOrderDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.Order;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public class OrderDao implements IOrderDao {
    SqlSession sqlSession = MybatisUtil.getSession();
    IOrderDao iOrderDao = sqlSession.getMapper(IOrderDao.class);

    @Override
    public List<Order> queryOrderByUid(int id) {
        List<Order> orders = iOrderDao.queryOrderByUid(id);
        return orders;
    }

    @Override
    public Order queryOrderByid(int id) {
        Order order = iOrderDao.queryOrderByid(id);
        return order;
    }

    @Override
    public int insertOrder(Order order) {
        int index = iOrderDao.insertOrder(order);
        System.out.println(index);
        sqlSession.commit();
        return index;
    }
}
