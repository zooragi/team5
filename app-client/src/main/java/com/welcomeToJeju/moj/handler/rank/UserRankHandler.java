package com.welcomeToJeju.moj.handler.rank;

import com.welcomeToJeju.moj.dao.UserDao;
import com.welcomeToJeju.moj.domain.User;
import com.welcomeToJeju.moj.handler.Command;
import com.welcomeToJeju.moj.handler.CommandRequest;

public class UserRankHandler implements Command {
  UserDao userDao;

  public UserRankHandler(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[유저 순위 보기]");

    int i = 1;
    for(User user : userDao.sortUserByViewCount()) {
      System.out.printf("%d위 > %s (조회수 : %d)\n", i, user.getNickName(), user.getViewCount());
      i++;
    }
  }


}
