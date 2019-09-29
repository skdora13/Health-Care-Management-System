
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

public class treatment extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
             String s1=request.getParameter("t1");
             String s2=request.getParameter("t2");   
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saiarchita");
                        Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select * from symptom");
while (rs.next())
{
    out.print("<!DOCTYPE html>");
 out.print("<html>");
   out.print("<head>");
       out.print("<meta charset='utf-8'>");
       out.print("<title>Pure CSS Slider</title>");
       out.print("<link rel='stylesheet' href='register.css' media='screen' title='no title' charset='utf-8'>");
   out.print("</head>");
   out.print("<body>");
       out.print("<div id='container'>");
          out.print("<div class='tp'>");
         out.print("</div>");
			out.print("<div class='header'><h1>Health Care Management System</h1></div>");
out.print("<div class='cbody'>");
out.print("<div class='con1' style='height:50vh; '>");
out.print("<h1 class='tet'> Treatment & Precaution</h1><center>");
out.print("<p>");
out.print("<form action='symptom' method='post'>");
 out.print("<table>");
out.print("<tr>");
out.print("<td><input type='text' name='t1' value="+rs.getString(1)+"></td>");
out.print("</tr>");
out.print("<tr>");
out.print("<td><textarea name='t2' rows=5 cols=45 placeholder='Treatment:'>"+rs.getString(2)+"</textarea></td>");
out.print("</tr>");
out.print("<tr>");
out.print("<td><textarea name='t3' rows=5 cols=45 placeholder='DietChart:'>"+rs.getString(3)+"</textarea></td>");
out.print("</tr>");
out.print("</table>");
out.print("</p>");
out.print("</center>");
out.print("<center>");
out.print("<input style='width:8vw;height:4vh;border:2px solid white;border-radius:2em 2em 2em 2em;background:red;color:white;' type='submit' value='Submit'>");
out.print("</center>");
out.print("</form>");
out.print("</div>");
out.print("<div class='con2'>");

out.print("<ul class=''>");
               out.print("<li><a href='#slide-1'>Home</a></li>");
               out.print("<li><a href='#slide-2'>Contact</a></li>");
               out.print("<li><a href='#slide-3'>About Us</a></li>");
               out.print("<li><a href='#slide-4'>Partners</a></li>");
               out.print("<li><a href='#slide-5'>Map<</a></li>");
           out.print("</ul>");
			
			 out.print("<ul class=''>");
               out.print("<li><a href='#slide-1'>Home</a></li>");
               out.print("<li><a href='#slide-2'>Contact</a></li>");
               out.print("<li><a href='#slide-3'>About Us</a></li>");
               out.print("<li><a href='#slide-4'>Partners</a></li>");
               out.print("<li><a href='#slide-5'>Map</a></li>");
           out.print("</ul>");
			
			 out.print("<ul class=''>");
               out.print("<li><a href='#slide-1'>Home</a></li>");
               out.print("<li><a href='#slide-2'>Contact</a></li>");
               out.print("<li><a href='#slide-3'>About Us</a></li>");
               out.print("<li><a href='#slide-4'>Partners</a></li>");
               out.print("<li><a href='#slide-5'>Map<</a></li>");
           out.print("</ul>");
 out.print("</div>");

 out.print(" </div>");
       out.print("</div>");
   out.print("</body>");
  out.print("</html>");

}   
          
                }catch(Exception e){}
    }
}
