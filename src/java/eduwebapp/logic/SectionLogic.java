package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.SectionObj;
import eduwebapp.objects.SectionViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SectionLogic extends Logic
{

    public SectionLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public int insertNewSection(int pIdProfesor, int pIdAula, 
            int pIdAlumno, String pName)
    {
        DatabaseX database = getDatabase();
        String sql = "INSERT INTO cardexdb.seccion "
                + "(`id`,`idprofesor`,`idaula`,`idalumno`,`name`) "
                + "VALUES(0,"+pIdProfesor+","+pIdAula+","+pIdAlumno+","
                + "'"+pName+"');";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    }     

    public ArrayList<SectionViewObj> getAllSectionView() 
    {
        DatabaseX database = getDatabase();
        ArrayList<SectionViewObj> sectionArray = new ArrayList<>();
        String sql = "SELECT * FROM cardexdb.seccion_view;";
        ResultSet result = database.executeQuery(sql);
        
        if(result!=null)
        {
            try 
            {
                
                int iId;
                String strProfe;
                String strCod;
                String strAlumni;
                String strSeccionName;                
                
                SectionViewObj temp;
                
                while(result.next())
                {
                    iId = result.getInt("id");
                    strProfe = result.getString("profe");
                    strCod = result.getString("cod");
                    strAlumni = result.getString("alumni");
                    strSeccionName = result.getString("seccionname");
                    temp = new SectionViewObj(iId, strProfe, strCod, strAlumni, strSeccionName);
                    sectionArray.add(temp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TeacherLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return sectionArray;        
        
    }
    
    public int deleteSection(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "DELETE FROM cardexdb.seccion "
                + "WHERE id = '"+pId+"';";
        int rows = database.executeNonQueryRows(sql);
        return rows;
    } 

    public SectionObj getSectionById(int pId)
    {
        DatabaseX database = getDatabase();
        String sql = "select * from cardexdb.seccion where id="+pId+";";
        ResultSet result = database.executeQuery(sql);
        
        SectionObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int iId;
                int iIdProfesor;
                int iIdAula;
                int iIdAlumno;
                String strName;
                while(result.next())
                {
                    iId = result.getInt("id");
                    iIdProfesor = result.getInt("idprofesor");
                    iIdAula = result.getInt("idaula");
                    iIdAlumno = result.getInt("idalumno");
                    strName = result.getString("name");
                    temp = new SectionObj(iId, iIdProfesor, iIdAula, iIdAlumno, strName);
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
