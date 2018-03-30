package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class SingUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		UserDao userDao = new UserDao();
		String idCheck = userDao.findByLoginIdCheck(loginId);

		if (idCheck == null) {
			request.setAttribute("errMsg", "入力されたログインIDは既に使用されております");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward(request, response);
			return;

		} else if (!password.equals(passwordConfirm)) {
			try {
				request.setAttribute("errMsg", "パスワードと確認が一致しておりません");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
				dispatcher.forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ((loginId.isEmpty()) || (name.isEmpty()) || (birthDate.isEmpty())) {
			try {
				request.setAttribute("errMsg", "入力内容が正しくありません");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
				dispatcher.forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		userDao.signUp(loginId, password, name, birthDate);

		response.sendRedirect("UserListServlet");
	}
}