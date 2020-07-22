package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

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
    
}
