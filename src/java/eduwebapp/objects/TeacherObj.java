package eduwebapp.objects;

public class TeacherObj 
{
    private int id;
    private int name;
    private int profession;

    public TeacherObj(int pId, int pName, int pProfession) 
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

    public int getName() {
        return name;
    }

    private void setName(int pName) 
    {
        this.name = pName;
    }

    public int getProfession() 
    {
        return profession;
    }

    private void setProfession(int pProfession) 
    {
        this.profession = pProfession;
    }
    
}
