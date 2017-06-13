package com.web.service;

import com.web.domain.User;
import com.web.exception.UserExistException;

/**
 * @author anyun
 * @date 2017/6/13
 * @time 16:13
 * @description
 */
public interface IUserService {

    /**
     * 提供注册服务
     * @param user
     * @throws UserExistException
     */
    void registerUser(User user) throws UserExistException;

    /**
     * 提供登录服务
     * @param userName
     * @param userPwd
     * @return
     */
    User loginUser(String userName, String userPwd);
}
