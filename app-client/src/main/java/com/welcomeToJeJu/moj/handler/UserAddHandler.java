package com.welcomeToJeju.moj.handler;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.welcomeToJeju.moj.dao.UserDao;
import com.welcomeToJeju.moj.domain.User;
import com.welcomeToJeju.util.Prompt;

public class UserAddHandler implements Command{
  UserDao userDao;
  SqlSession sqlSession;

  public UserAddHandler(UserDao userDao, SqlSession sqlSession) {
    this.userDao = userDao;
    this.sqlSession = sqlSession;
  }

  public void execute(CommandRequest request) throws Exception{

    System.out.println("[회원 가입하기]");

    User user = new User();

    user.setEmail(Prompt.inputString("이메일 > "));
    user.setPassword(Prompt.inputString("암호 > "));
    user.setNickName(Prompt.inputString("닉네임 > "));
    user.setRegisteredDate(new Date(System.currentTimeMillis()));

    userDao.insert(user);

    sqlSession.commit();

    System.out.println("회원 등록 완료");
  }

}
