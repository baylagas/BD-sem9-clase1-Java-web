package eduwebapp.objects;

public class ClassroomObj 
{
    private int id; 
    private String codigo; 
    private int capacidad; 

    public ClassroomObj(int pId, String pCodigo, int pCapacidad) 
    {
        setId(pId);
        setCodigo(pCodigo);
        setCapacidad(pCapacidad);
    }

    public int getId() {
        return id;
    }

    private void setId(int pId) {
        this.id = pId;
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String pCodigo) {
        this.codigo = pCodigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    private void setCapacidad(int pCapacidad) {
        this.capacidad = pCapacidad;
    }
    
    
}
