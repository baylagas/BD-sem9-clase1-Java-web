package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.TeacherObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherLogic extends Logic
{

    public TeacherLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertNewTeacher(String pName, String pProfession)
    {
        DatabaseX database = getDatabase();
        String sql = "insert into cardexdb.profesor "
                + "(id, name, profesion) "
                + "value(0, '"+pName+"', '"+pProfession+"')";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public int deleteTeacher(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM cardexdb.profesor "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }
    
    public ArrayList<TeacherObj> getAllTeachers()
    {
        DatabaseX database = getDatabase();
        ArrayList<TeacherObj> teacherArray = new ArrayList<>();
        String sql = "select * from cardexdb.profesor";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iId;
                String strName;
                String strProfession;
                TeacherObj temp;
                
                while(result.next())
                {
                    iId = result.getInt("id");
                    strName = result.getString("name");
                    strProfession = result.getString("profesion");
                    temp = new TeacherObj(iId, strName, strProfession);
                    teacherArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return teacherArray;
    }
    
    public TeacherObj getTeacherById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<TeacherObj> teacherArray = new ArrayList<>();
        String sql = "select * from cardexdb.profesor where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        TeacherObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iId;
                String strName;
                String strProfesion;
                while(result.next())
                {
                    iId = result.getInt("id");
                    strName = result.getString("name");
                    strProfesion = result.getString("profesion");
                    temp = new TeacherObj(pId, strName, strProfesion);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    }
    
}
