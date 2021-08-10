


import java.util.Date;
import java.util.List;

public class Publicacion {
    private static int contadorIdActual = 0;
    private int id;
    private String contenido;
    private String tipoPublicacion;
    private Usuario autor;
    private Date fechaPublicacion;
    private List<Reaccion> reaccionesPublicacion;

    /**
     * constructor de una publicacion
     * @param contenido
     * @param tipoPublicacion
     * @param autor
     * @param fechaPublicacion
     * return publicacion
     */
    public Publicacion(String contenido, String tipoPublicacion, Usuario autor, Date fechaPublicacion) {
        setId(++contadorIdActual);
        this.contenido = contenido;
        this.tipoPublicacion = tipoPublicacion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * conversion de un objetvo tipo Publicacion a string
     * @return String
     */
    public String publicacionToString(){
        return "Publicacion: " + id +
                '\n' +
                "Autor: " + autor.getNombreUsuario() +
                '\n' +
                "Fecha de publicacion: " + fechaPublicacion +
                '\n' +
                "Tipo de contenido: " + tipoPublicacion +
                '\n' +
                "Contenido: " + contenido + '\n';

    }


}
