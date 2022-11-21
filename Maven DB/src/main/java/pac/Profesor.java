package pac;

public class Profesor {
    private long id;
    private String nombre;
    private String sexo;

    public Profesor() {

    }

    public Profesor(String nombre, String sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }
    //Getter y setter id
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Getter y setter nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Getter y setter sexo
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Insert into profesor, nombre: "+ nombre + ", sexo: " +sexo ;
    }
}