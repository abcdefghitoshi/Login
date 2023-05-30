package jp.co.aforce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/jp.co.aforce/login")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			String url = "jdbc:mysql://localhost:3306/login_db";
			String user = "root";
			String pass = "furutsuka0";
			String sql = "SELECT id FROM login WHERE id=? AND password=?";

			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, Id);
				pstmt.setString(2, password);
				ResultSet res = pstmt.executeQuery();

				if (res.next()) {
					request.setAttribute("id", res.getString("id"));
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/loginSuccess.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("loginFailure", "IDもしくはパスワードが違います");
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
					rd.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
