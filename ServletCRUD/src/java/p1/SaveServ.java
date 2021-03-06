package p1;

import dao.StudentDAO;
import dto.StudentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServ extends HttpServlet 
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
        int rollno = Integer.parseInt(request.getParameter("t1"));
        String name = request.getParameter("t2");
        
        //saving data in DTO object
        StudentDTO st = new StudentDTO();
        st.setRoll(rollno);     //storing values using setter
        st.setName(name);
            //or
        //StudentDTO str = new StudentDTO(rollno, name);    //storing values using constructor
        
        //pass DTO object to DAO
        int x = StudentDAO.saveStudent(st);
        if(x>0)
        {
            out.println("<script>");
            out.println("alert('Student Saved Successfully !!')");
            out.println("</script>");
            
            //RequestDispatcher rd = request.getRequestDispatcher("index.html");
            //rd.include(request, response);
                    //or
            request.getRequestDispatcher("index.html").include(request, response);
        }
    }
}