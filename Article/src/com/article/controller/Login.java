package com.article.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.article.service.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码,创建PrintWriter对象
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//获取客户端post过来的数据
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		//调用LoginService处理业务
		Map<String, String> lsMap = new LoginService().login(userName,passWord);
		out.print(lsMap.get("errorCode"));
		//登陆成功，设置session
		if(lsMap.get("errorCode")=="1"){
			HttpSession session = request.getSession();
			session.setAttribute("userName", lsMap.get("userName"));
			session.setAttribute("headPic", lsMap.get("headPic"));
			System.out.println("Login.doPost--"+session);
		}
		
	}

}
