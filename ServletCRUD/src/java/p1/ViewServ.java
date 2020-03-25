package p1;

import dao.StudentDAO;
import dto.StudentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServ extends HttpServlet 
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
        List<StudentDTO> al = StudentDAO.retrieveStudents();
        Iterator<StudentDTO> itr = al.iterator();
        out.println("<h2 align='center'>List of Students</h2>");
        out.println("<table border='2' align='center'>");
        out.println("<tr><th>Roll Number</th><th>Name</th><th></th><th></th></tr>");
        while(itr.hasNext())
        {
            StudentDTO st = itr.next();
            out.println("<tr>"
                    + "<th>"+st.getRoll()+"</th>"
                    + "<th>"+st.getName()+"</th>"
                    + "<th><a href='DeleteServ?roll="+st.getRoll()+"'>Delete</a></th>"
                    + "<th><a href='UpdateServ?roll="+st.getRoll()+"'>Update</a></th>"
                    + "</tr>");
        }
    }
}