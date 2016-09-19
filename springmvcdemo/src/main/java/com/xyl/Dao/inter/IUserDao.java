package com.xyl.Dao.inter;

import com.xyl.bean.User;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/6.
 */
public interface IUserDao {
    public List<User> queryAll();
    public List<User> queryByName(String name);
    public int addUser(User user);
}
