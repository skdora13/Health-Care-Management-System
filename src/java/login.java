
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
             String s1=request.getParameter("t1");
             String s2=request.getParameter("t2");   
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saiarchita");
                        Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select * from reg");
while (rs.next())
{
    String un=rs.getString(4);
    String pass=rs.getString(5);
    if(s1.trim().equalsIgnoreCase(un)&&s2.trim().equalsIgnoreCase(pass))
    {
        RequestDispatcher rd=request.getRequestDispatcher("home.html");
        rd.forward(request, (ServletResponse) response);
    }
    if(s1.trim().equalsIgnoreCase("admin")&&s2.trim().equalsIgnoreCase("admin"))
    {
        RequestDispatcher rd=request.getRequestDispatcher("home1.html");
        rd.forward(request, (ServletResponse) response);
    
    }
}   
          
                }catch(Exception e){}
    }
}
