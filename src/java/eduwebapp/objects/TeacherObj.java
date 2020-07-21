package eduwebapp.objects;

//pojo Plain Old Java Object
public class TeacherObj 
{
    private int id;
    private String name;
    private String profession;

    public TeacherObj(int pId, String pName, String pProfession) 
    {
        setId(pId);
        setName(pName);
        setProfession(pProfession);
    }

    public int getId() 
    {
        return id;
    }

    private void setId(int pId) 
    {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    private void setName(String pName) 
    {
        this.name = pName;
    }

    public String getProfession() 
    {
        return profession;
    }

    private void setProfession(String pProfession) 
    {
        this.profession = pProfession;
    }
    
}
