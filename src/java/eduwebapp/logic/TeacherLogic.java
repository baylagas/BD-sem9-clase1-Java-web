package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

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
}
