package com.xyl.Dao;

import com.xyl.Dao.inter.ICartDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.Cart;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public class CartDao implements ICartDao{
    SqlSession sqlSession = MybatisUtil.getSession();
    ICartDao iCartDao = sqlSession.getMapper(ICartDao.class);
    @Override
    public List<Cart> queryCartByUid(int uid) {
        List<Cart> carts = iCartDao.queryCartByUid(uid);
        return carts;
    }

    @Override
    public List<Cart> queryCartByUidAndBid(int uid, int bid) {
        List<Cart> carts = iCartDao.queryCartByUidAndBid(uid,bid);
        return carts;
    }

    @Override
    public int updateCartCountByUidAndBid(int uid, int bid) {
        int index = iCartDao.updateCartCountByUidAndBid(uid,bid);
        sqlSession.commit();
        return index;
    }

    @Override
    public int insertCart(int uid, float price, float totalprice, int counts, int bid, String title, String face) {
        int index = iCartDao.insertCart(uid, price, totalprice,counts,bid, title,face);
        sqlSession.commit();
        return 0;
    }

    @Override
    public int deleteCartByUid(int uid) {
        int index = iCartDao.deleteCartByUid(uid);
        sqlSession.commit();
        return index;
    }
}
