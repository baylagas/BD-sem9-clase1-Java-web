package eduwebapp.logic;

import balcorpfw.database.DatabaseX;
import balcorpfw.logic.Logic;
import eduwebapp.objects.UserObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UserLogic extends Logic
{

    public UserLogic(String pConnectionString) 
    {
        super(pConnectionString);
    }
    
    public UserObj getUserByEmail(String pEmail)
    {
        DatabaseX database = getDatabase();
        String sql = "select * from cardexdb.usuario "
                + "where email like '"+pEmail+"';";
        ResultSet result = database.executeQuery(sql);
        
        UserObj temp = null;
        
        if(result!=null)
        {
            
            try 
            {
                int id;
                String username;
                String email;
                String password;
                int idtype;
                while(result.next())
                {
                    id = result.getInt("id");
                    username = result.getString("username");
                    email = result.getString("email");
                    password = result.getString("password");
                    idtype = result.getInt("idtype");
                    temp = new UserObj(id, username, email, password, idtype);
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
