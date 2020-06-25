

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="root";
		String pass="MyNewPass";
		String url="jdbc:mysql://localhost:3306/springdb?useSSL=false";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try{
			
			PrintWriter out=response.getWriter();
			out.println("connecting to db"+url);
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url,user,pass);
			
			out.println("Success connection");
			System.out.println("Success");
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
