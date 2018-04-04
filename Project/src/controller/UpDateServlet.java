package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UpDateServlet
 */
@WebServlet("/UpDateServlet")
public class UpDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpDateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");

		System.out.println(id);

		UserDao userDao = new UserDao();
		List<User> userList = userDao.findByUserInfo(id);

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpDate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String id = request.getParameter("id");
		UserDao userDao = new UserDao();

		if (!password.equals(passwordConfirm)) {
			try {
				request.setAttribute("errMsg", "パスワードと確認が一致しておりません");

				List<User> userList = userDao.findByUserInfo(id);
				request.setAttribute("userList", userList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpDate.jsp");
				dispatcher.forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		userDao.upDate(password, name, birthDate, id);
		response.sendRedirect("UserListServlet");
	}
}
