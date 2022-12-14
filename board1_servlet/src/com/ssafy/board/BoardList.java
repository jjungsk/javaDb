package com.ssafy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("  <head>");
		out.println("    <meta charset=\"UTF-8\" />");
		out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
		out.println("    <link");
		out.println("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"");
		out.println("      rel=\"stylesheet\"");
		out.println("      integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"");
		out.println("      crossorigin=\"anonymous\"");
		out.println("    />");
		out.println("    <link href=\"/root/assets/css/app.css\" rel=\"stylesheet\" />");
		out.println("    <title>SSAFY</title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("    <div class=\"container\">");
		out.println("      <div class=\"row justify-content-center\">");
		out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
		out.println("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">");
		out.println("            <mark class=\"sky\">?????????</mark>");
		out.println("          </h2>");
		out.println("        </div>");
		out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
		out.println("          <div class=\"row align-self-center mb-2\">");
		out.println("            <div class=\"col-md-2 text-start\">");
		out.println("              <button type=\"button\" id=\"btn-mv-register\" class=\"btn btn-outline-primary btn-sm\">");
		out.println("                ?????????");
		out.println("              </button>");
		out.println("            </div>");
		out.println("            <div class=\"col-md-7 offset-3\">");
		out.println("              <form class=\"d-flex\">");
		out.println("                <select");
		out.println("                  id=\"key\"");
		out.println("                  class=\"form-select form-select-sm ms-5 me-1 w-50\"");
		out.println("                  aria-label=\"????????????\"");
		out.println("                >");
		out.println("                  <option selected>????????????</option>");
		out.println("                  <option value=\"articleno\">?????????</option>");
		out.println("                  <option value=\"subject\">??????</option>");
		out.println("                  <option value=\"userid\">?????????</option>");
		out.println("                </select>");
		out.println("                <div class=\"input-group input-group-sm\">");
		out.println("                  <input type=\"text\" class=\"form-control\" placeholder=\"?????????...\" />");
		out.println("                  <button class=\"btn btn-dark\" type=\"button\">??????</button>");
		out.println("                </div>");
		out.println("              </form>");
		out.println("            </div>");
		out.println("          </div>");
		out.println("          <table class=\"table table-hover\">");
		out.println("            <thead>");
		out.println("              <tr class=\"text-center\">");
		out.println("                <th scope=\"col\">?????????</th>");
		out.println("                <th scope=\"col\">??????</th>");
		out.println("                <th scope=\"col\">?????????</th>");
		out.println("                <th scope=\"col\">?????????</th>");
		out.println("                <th scope=\"col\">?????????</th>");
		out.println("              </tr>");
		out.println("            </thead>");
		out.println("            <tbody>");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC", "root", "jsk382382!");
			
			StringBuilder sql = new StringBuilder();
			sql.append("select article_no, user_id, subject, content, hit, register_time \n");
//			sql.append("select b.article_no, m.user_name, b.subject, b.content, b.hit, b.register_time \n");
			sql.append("from board \n");
//			sql.append("from board b join members m \n");
//			sql.append("on b.member_id = m.member_id \n");
			sql.append("order by article_no desc ");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				out.println("              <tr class=\"text-center\">");
				out.println("                <th scope=\"row\">" + rs.getInt("article_no") + "</th>");
				out.println("                <td class=\"text-start\">");
				out.println("                  <a");
				out.println("                    href=\"#\"");
				out.println("                    class=\"article-title link-dark\"");
				out.println("                    data-no=\"" + rs.getInt("article_no") + "\"");
				out.println("                    style=\"text-decoration: none\"");
				out.println("                  >");
				out.println(rs.getString("subject"));
				out.println("                  </a>");
				out.println("                </td>");
				out.println("                <td>" + rs.getString("user_id") + "</td>");
				out.println("                <td>" + rs.getInt("hit") + "</td>");
				out.println("                <td>" + rs.getString("register_time") + "</td>");
				out.println("              </tr>");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null)
					rs.close();
				if (pstmt!=null)
					pstmt.close();
				if (conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		out.println("            </tbody>");
		out.println("          </table>");
		out.println("        </div>");
		out.println("        <div class=\"row\">");
		out.println("          <ul class=\"pagination justify-content-center\">");
		out.println("            <li class=\"page-item\">");
		out.println("              <a class=\"page-link\" href=\"#\">??????</a>");
		out.println("            </li>");
		out.println("            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">1</a></li>");
		out.println("            <li class=\"page-item active\">");
		out.println("              <a class=\"page-link\" href=\"#\">2</a>");
		out.println("            </li>");
		out.println("            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>");
		out.println("            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">4</a></li>");
		out.println("            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">5</a></li>");
		out.println("            <li class=\"page-item\"><a class=\"page-link\" href=\"#\">??????</a></li>");
		out.println("          </ul>");
		out.println("        </div>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("    <script");
		out.println("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"");
		out.println("      integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"");
		out.println("      crossorigin=\"anonymous\"");
		out.println("    ></script>");
		out.println("    <script>");
		out.println("      let titles = document.querySelectorAll(\".article-title\");");
		out.println("      titles.forEach(function (title) {");
		out.println("        title.addEventListener(\"click\", function () {");
		out.println("          location.href = \"/board1_servlet/view?article_no=\" + this.getAttribute(\"data-no\");");
		out.println("        });");
		out.println("      });");
		out.println("");
		out.println("      document.querySelector(\"#btn-mv-register\").addEventListener(\"click\", function () {");
		out.println("        location.href = \"/board1_servlet/board/write.html\";");
		out.println("      });");
		out.println("    </script>");
		out.println("  </body>");
		out.println("</html>");
		
	}



}
