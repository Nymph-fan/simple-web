package com.web.service.impl;

import com.web.dao.IUserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.domain.User;
import com.web.exception.UserExistException;
import com.web.service.IUserService;

/**
 * @author anyun
 * @date 2017/6/13
 * @time 16:14
 * @description
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    public void registerUser(User user) throws UserExistException {
        if (userDao.find(user.getUserName())!=null) {
            //checked exception
            //unchecked exception
            //这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
            throw new UserExistException("注册的用户名已存在！！！");
        }
        userDao.add(user);
    }

    public User loginUser(String userName, String userPwd) {
        return userDao.find(userName, userPwd);
    }
}
