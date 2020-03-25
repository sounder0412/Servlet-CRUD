package p1;

import dao.StudentDAO;
import dto.StudentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServ extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //fetching data from request
        int rollno = Integer.parseInt(request.getParameter("roll"));
        StudentDTO st = StudentDAO.searchStudent(rollno);
        out.println("<form action='UpdateServ2' method='post'>");
        out.println("Roll Number : <input type='text' name='t1' value='"+st.getRoll()+"' readonly><br><br>");
        out.println("Name : <input type='text' name='t2' value='"+st.getName()+"'><br><br>");
        out.println("<input type='submit' value='Update Student'>");
        out.println("</form>");
    }
}