package com.fsoft.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fsoft.project.dao.LoginDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Member;
import com.fsoft.project.utils.constants.QueryConstants;

public class LoginDaoImpl implements LoginDao{
  /*private Connection connection;
  private PreparedStatement ps;
  private ResultSet rs;
  @Override
  public Member getMember(String email, String password) {
    Member member = null;
    connection = DbHelper.getConnection();
    if(connection == null) return null;
    try {
      ps = connection.prepareStatement(QueryConstants.GET_MEMBER);
      ps.setString(1, email);
      ps.setString(2, password);
      rs = ps.executeQuery();
      if(rs.next()) {
        member = new Member();
        member.setId(rs.getInt("Id"));
        member.setEmail(rs.getString("Email"));
        member.setRole(rs.getBoolean("Role"));
        member.setFirstName(rs.getString("Firstname"));
        member.setLastName(rs.getString("LastName"));
        member.setAddress(rs.getString("Address"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return member;
  }
 */
}
