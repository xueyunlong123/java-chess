package com.xyl.Dao;

import com.xyl.Dao.inter.IUserDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/6.
 */
public class UserDao implements IUserDao{
    //获取会话
    SqlSession sqlSession = MybatisUtil.getSession();
    IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
    @Override
    public List<User> queryAll() {

        return iUserDao.queryAll();
    }

    @Override
    public List<User> queryByName(String name) {
        return iUserDao.queryByName(name);
    }

    @Override
    public int addUser(User user) {
        int index = iUserDao.addUser(user);
        sqlSession.commit();
        return index;
    }
}
