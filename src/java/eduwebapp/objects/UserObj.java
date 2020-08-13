package eduwebapp.objects;

public class UserObj 
{
    private int id;
    private String username;
    private String email;
    private String password;
    private int idtype;

    public UserObj(int pId, String pUsername, String pEmail, 
            String pPassword, int pIdType) 
    {
        setId(pId);
        setUsername(pUsername);
        setEmail(pEmail);
        setPassword(pPassword);
        setIdType(pIdType);
    }

    public int getId() 
    {
        return id;
    }

    private void setId(int pId) 
    {
        this.id = pId;
    }

    public String getUsername() 
    {
        return username;
    }

    private void setUsername(String pUsername) 
    {
        this.username = pUsername;
    }

    public String getEmail() 
    {
        return email;
    }

    private void setEmail(String pEmail) 
    {
        this.email = pEmail;
    }

    public String getPassword() 
    {
        return password;
    }

    private void setPassword(String pPassword) 
    {
        this.password = pPassword;
    }

    public int getIdtype() 
    {
        return idtype;
    }

    private void setIdType(int pIdType) 
    {
        this.idtype = pIdType;
    }
    
}
