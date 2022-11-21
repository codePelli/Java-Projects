package pac;
import java.util.Set;

public class Alumno implements java.io.Serializable{
    private Long id;
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String sexo;
    Set<Modulo> modulos;


    public Alumno(String nombre, String nacionalidad, int edad,  String sexo, Set<Modulo>modulos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.sexo = sexo;
        this.modulos = modulos;
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

    //Getter y setter nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    //Getter y setter edad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Getter y setter sexo
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //Getter y setter modulos
    public Set<Modulo> getModulos() {
        return modulos;
    }
    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "Insert into alumno, nombre: "+ nombre + ", nacionalidad: " + nacionalidad + 
        		", edad: " + edad + ", sexo: " + sexo + ", modulos: " + modulos.size();
    }
}