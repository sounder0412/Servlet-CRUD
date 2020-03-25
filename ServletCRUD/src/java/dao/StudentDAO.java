package dao;

import conn.ConnectionDB;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO 
{
    //saving data in db
    public static int saveStudent(StudentDTO st)
    {
        //load driver & establish connection
        Connection con = ConnectionDB.getConnection();
        int x=0;
        try{
            //prepare sql statement
            PreparedStatement ps = con.prepareStatement("insert into student values(?,?)");
            ps.setInt(1, st.getRoll());     //value fetched from getter
            ps.setString(2, st.getName());
            x = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        return x;
    }
    
    //retrieving data from db
    public static List<StudentDTO> retrieveStudents()
    {
        List<StudentDTO> al = new ArrayList<StudentDTO>();
        Connection con = ConnectionDB.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                StudentDTO st = new StudentDTO();
                st.setRoll(rs.getInt(1));
                st.setName(rs.getString(2));
                al.add(st);
            }
        }catch(Exception e){
            System.out.println(e);
        } 
        return al;
    }
    
    //delete student from db
    public static int deleteSetudent(int roll)
    {
        int x=0;
        Connection con = ConnectionDB.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("delete from student where rollno=?");
            ps.setInt(1, roll);
            x = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        return x;
    }
    
    //search student from db
    public static StudentDTO searchStudent(int roll)
    {
        StudentDTO st=null;
        Connection con = ConnectionDB.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("select * from student where rollno=?");
            ps.setInt(1, roll);
            ResultSet rs = ps.executeQuery();
            rs.next();
            st = new StudentDTO();
            st.setRoll(roll);
            st.setName(rs.getString(2));
        }catch(Exception e){
            System.out.println(e);
        }
        return st;
    }
    
    //update student in db on basis of rollno
    public static int updateStudent(StudentDTO st)
    {
        int x=0;
        Connection con = ConnectionDB.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("update student set name=? where rollno=?");
            ps.setString(1, st.getName());
            ps.setInt(2, st.getRoll());
            x = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        return x;
    }
}