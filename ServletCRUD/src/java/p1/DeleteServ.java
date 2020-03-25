package p1;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServ extends HttpServlet 
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
        int rollno = Integer.parseInt(request.getParameter("roll"));
        int x = StudentDAO.deleteSetudent(rollno);
        if(x>0)
        {
            out.println("<script>");
            out.println("alert('Student Deleted Successfully !!')");
            out.println("</script>");
            
            //RequestDispatcher rd = request.getRequestDispatcher("ViewServ");
            //rd.include(request, response);
                    //or
            request.getRequestDispatcher("ViewServ").include(request, response);
        }
    }
}