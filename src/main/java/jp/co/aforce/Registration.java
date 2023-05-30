package jp.co.aforce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class Registration
 */
@WebServlet("/jp.co.aforce/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/login_db");
			Connection con=ds.getConnection();
			
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			
			con.setAutoCommit(false);
			
			PreparedStatement st=con.prepareStatement("insert into login values(?,?)");
			st.setString(1, id);
			st.setString(2, password);
			st.executeUpdate();
			
			st=con.prepareStatement(
					"select * from login where id=?");
			st.setString(1,id);
			ResultSet rs=st.executeQuery();
			int line=0;
			while (rs.next()) {
				line++;
			}
			if(line==1) {
				con.commit();
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/regsuc.jsp");
				rd.forward(request, response);
			}else {
				con.rollback();
			}
			
			con.setAutoCommit(true);
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
