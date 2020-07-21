package eduwebapp.objects;

public class StudentObj 
{
    private int id;
    private String name;
    private int age;

    public StudentObj(int pId, String pName, int pAge) 
    {
        this.id = pId;
        this.name = pName;
        this.age = pAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int pAge) {
        this.age = pAge;
    }

}
