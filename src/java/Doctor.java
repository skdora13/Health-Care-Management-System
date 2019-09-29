

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Doctor extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
             String s1=request.getParameter("t1");
             String s2=request.getParameter("t2");
             String s3=request.getParameter("t3");
             String s4=request.getParameter("t4");
             String s5=request.getParameter("t5");
                     String s6=request.getParameter("t6");
             Class.forName("oracle.jdbc.driver.OracleDriver");
              
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saiarchita");
             PreparedStatement st=con.prepareStatement("insert into doctor values(?,?,?,?,?,?) ");
             st.setString(1, s1);
              st.setString(2, s2);
               st.setString(3, s3);
                st.setString(4, s4);
                 st.setString(5, s5);
                   st.setString(6, s6);
                    st.executeUpdate();
                    out.print("hello");
             
             
                     
             
             
                }catch(Exception e){}
    }
}
