package pac;

public class Modulo {
    private Long id;
    private String nombre;
    private String codigo;

    public Modulo(String s) {

    }

    public Modulo(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
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
    
    //Getter y setter codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Insert into modulo, nombre: "+ nombre + ", codigo: " + codigo;
    }
}