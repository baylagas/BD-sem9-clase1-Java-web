package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.StudentObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentLogic extends Logic
{

    public StudentLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertNewStudent(String pName, String pAge)
    {
        DatabaseX database = getDatabase();
        String sql = "insert into cardexdb.alumno "
                + "(id, name, age) "
                + "value(0, '"+pName+"', "+pAge+")";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }  
    
    public int deleteTeacher(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM cardexdb.alumno "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
    public ArrayList<StudentObj> getAllStudents()
    {
        DatabaseX database = getDatabase();
        ArrayList<StudentObj> studentArray = new ArrayList<>();
        String sql = "select * from cardexdb.alumno";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iId;
                String strName;
                int iAge;
                StudentObj temp;
                
                while(result.next())
                {
                    iId = result.getInt("id");
                    strName = result.getString("name");
                    iAge = result.getInt("age");
                    temp = new StudentObj(iId, strName, iAge);
                    studentArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return studentArray;
    }    
    
    public StudentObj getStudentById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<StudentObj> studentArray = new ArrayList<>();
        String sql = "select * from cardexdb.alumno where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        StudentObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iId;
                String strName;
                int iAge;
                while(result.next())
                {
                    iId = result.getInt("id");
                    strName = result.getString("name");
                    iAge = result.getInt("age");
                    temp = new StudentObj(pId, strName, iAge);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }    
    
    public int updateStudent(int pId, String pName, int pAge) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE cardexdb.alumno "
                + "SET name = '"+pName+"', age="+pAge+" "
                + "WHERE (id = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }    
    
}
