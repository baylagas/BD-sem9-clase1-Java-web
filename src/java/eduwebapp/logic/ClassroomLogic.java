package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.ClassroomObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ClassroomLogic extends Logic
{

    public ClassroomLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertNewClassroom(String pCodigo, int pCapacidad)
    {
        DatabaseX database = getDatabase();
        String sql = "insert into cardexdb.aula "
                + "(id, codigo, capacidad) "
                + "value(0, '"+pCodigo+"', "+pCapacidad+")";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 
    
    public int deleteClassroom(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM cardexdb.aula "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
    public ArrayList<ClassroomObj> getAllClassrooms()
    {
        DatabaseX database = getDatabase();
        ArrayList<ClassroomObj> classroomArray = new ArrayList<>();
        String sql = "select * from cardexdb.aula";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                int iId;
                String strCodigo;
                int iCapacidad;
                ClassroomObj temp;
                
                while(result.next())
                {
                    iId = result.getInt("id");
                    strCodigo = result.getString("codigo");
                    iCapacidad = result.getInt("capacidad");
                    temp = new ClassroomObj(iId, strCodigo, iCapacidad);
                    classroomArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return classroomArray;
    }
    
    public ClassroomObj getClassroomById(int pId)
    {
        DatabaseX database = getDatabase();
        ArrayList<ClassroomObj> classroomArray = new ArrayList<>();
        String sql = "select * from cardexdb.aula where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        ClassroomObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iId;
                String strCodigo;
                int iCapacidad;
                while(result.next())
                {
                    iId = result.getInt("id");
                    strCodigo = result.getString("codigo");
                    iCapacidad = result.getInt("capacidad");
                    temp = new ClassroomObj(pId, strCodigo, iCapacidad);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return temp;
    } 
    
    public int updateClassroom(int pId, String pCodigo, int pCapacidad) 
    {
        DatabaseX database = getDatabase();
        String sql = "UPDATE cardexdb.aula "
                + "SET codigo = '"+pCodigo+"', capacidad="+pCapacidad+" "
                + "WHERE (id = '"+pId+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
}
