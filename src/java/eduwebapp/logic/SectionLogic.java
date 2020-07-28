package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;

public class SectionLogic extends Logic
{

    public SectionLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertNewSection(int pId, int pIdProfesor, int pIdAula, 
            int pIdAlumno, String pName)
    {
        DatabaseX database = getDatabase();
        String sql = "INSERT INTO cardexdb.seccion "
                + "(`id`,`idprofesor`,`idaula`,`idalumno`,`name`) "
                + "VALUES("+pId+","+pIdProfesor+","+pIdAula+","+pIdAlumno+","
                + "'"+pName+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     
    
}
