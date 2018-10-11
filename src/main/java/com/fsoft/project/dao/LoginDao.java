package com.fsoft.project.dao;

import com.fsoft.project.entity.Member;

public interface LoginDao {
  Member getMember(String email, String password);
}
