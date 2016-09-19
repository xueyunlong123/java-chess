package com.xyl.test;

import com.xyl.Dao.UserDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.User;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/6.
 */
public class testMybatis {
    public static void main(String[] args){

        UserDao userDao = new UserDao();
        List<User> userList = userDao.queryByName("22");
        User user = userList.get(0);

        System.out.println(user.getPassword());

    }
}
