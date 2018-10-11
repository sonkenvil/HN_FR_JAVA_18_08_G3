package com.fsoft.project.service;

import com.fsoft.project.entity.Member;

public interface LoginService {
  Member getMember(String email, String password);
}
