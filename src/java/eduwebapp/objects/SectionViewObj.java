package eduwebapp.objects;

public class SectionViewObj 
{

    private int id;
    private String profe;
    private String cod;
    private String alumni;
    private String seccionname;

    public SectionViewObj(int pId, String pProfe, String pCod, 
            String pAlumni, String pSeccionName) 
    {
        setId(pId);
        setProfe(pProfe);
        setCod(pCod);
        setAlumni(pAlumni);
        setSeccionName(pSeccionName);
    }

    public int getId() {
        return id;
    }

    private void setId(int pId) {
        this.id = pId;
    }

    public String getProfe() {
        return profe;
    }

    private void setProfe(String pProfe) {
        this.profe = pProfe;
    }

    public String getCod() {
        return cod;
    }

    private void setCod(String pCod) {
        this.cod = pCod;
    }

    public String getAlumni() {
        return alumni;
    }

    private void setAlumni(String pAlumni) {
        this.alumni = pAlumni;
    }

    public String getSeccionName() {
        return seccionname;
    }

    private void setSeccionName(String pSeccionName) {
        this.seccionname = pSeccionName;
    }
    
}
