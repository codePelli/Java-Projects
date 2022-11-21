package server;

public class Tarea {

    private String descripcion;
    private String estado;


    public Tarea(String descripcion, String estado) {
        super();
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Con el toString marcariamos como se verian las respuestas de las tareas.
    public String toString() {
        return "Tarea - " + " Descripcion: " + descripcion + ", estado: " + estado;
    }

}
