package eduwebapp.objects;

public class SectionObj 
{
    private int id;
    private int idProfesor;
    private int idAula;
    private int idAlumno;
    private String name;

    public SectionObj(int pId, int pIdProfesor, int pIdAula, 
            int pIdAlumno, String pName) 
    {
        setId(pId);
        setIdProfesor(pIdProfesor);
        setIdAula(pIdAula);
        setIdAlumno(pIdAlumno);
        setName(pName);
    }

    public int getId() {
        return id;
    }

    private void setId(int pId) {
        this.id = pId;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    private void setIdProfesor(int pIdProfesor) {
        this.idProfesor = pIdProfesor;
    }

    public int getIdAula() {
        return idAula;
    }

    private void setIdAula(int pIdAula) {
        this.idAula = pIdAula;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    private void setIdAlumno(int pIdAlumno) {
        this.idAlumno = pIdAlumno;
    }

    public String getName() {
        return name;
    }

    private void setName(String pName) {
        this.name = pName;
    }
    
}
