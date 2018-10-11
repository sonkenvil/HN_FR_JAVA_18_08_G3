package com.fsoft.project.service.impl;

import com.fsoft.project.dao.LoginDao;
import com.fsoft.project.entity.Member;
import com.fsoft.project.service.LoginService;

public class LoginServiceImpl implements LoginService{
  private LoginDao loginDao;
  public LoginServiceImpl(LoginDao dao) {
    this.loginDao = dao;
  }
  @Override
  public Member getMember(String email, String password) {
    return loginDao.getMember(email, password);
  }

}
