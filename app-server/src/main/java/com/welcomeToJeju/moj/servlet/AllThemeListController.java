package com.welcomeToJeju.moj.servlet;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.welcomeToJeju.moj.dao.ThemeDao;
import com.welcomeToJeju.moj.domain.Theme;


@WebServlet("/theme/list")
public class AllThemeListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ThemeDao themeDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    themeDao = (ThemeDao) 웹애플리케이션공용저장소.getAttribute("themeDao");
  }

  // 공개테마만
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    try {
      Collection<Theme> themeList = themeDao.findPublicTheme();

      request.setAttribute("allThemeList", themeList);

      request.getRequestDispatcher("/theme/AllThemeList.jsp").forward(request, response);

    } catch (Exception e){
      request.setAttribute("error", e);

      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

  }
}
