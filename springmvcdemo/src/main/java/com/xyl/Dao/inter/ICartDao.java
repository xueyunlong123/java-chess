package com.xyl.Dao.inter;

import com.xyl.bean.Cart;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public interface ICartDao {
    public List<Cart> queryCartByUid(int uid);
    public List<Cart> queryCartByUidAndBid(int uid,int bid);
    public int updateCartCountByUidAndBid(int uid,int bid);
    //public int insertCart(int uid,float price,float totalprice,int counts,int bid,String title,String face);
    public int insertCart(int uid, float price, float totalprice, int counts, int bid, String title, String face);
    public int deleteCartByUid(int uid);

}
