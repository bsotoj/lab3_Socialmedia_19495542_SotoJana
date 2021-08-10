

import java.util.Date;

public class Reaccion {


    private static int contadorIdActual = 0;
    private int id;
    private Usuario usuarioQueReacciona;
    private Date fechaPublicacion;
    private String contenido;
    private String tipoReaccion;

    public Reaccion(Usuario usuarioQueReacciona, Date fechaPublicacion, String contenido, String tipoReaccion) {
        setId(++contadorIdActual);
        this.usuarioQueReacciona = usuarioQueReacciona;
        this.fechaPublicacion = fechaPublicacion;
        this.contenido = contenido;
        this.tipoReaccion = tipoReaccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioQueReacciona() {
        return usuarioQueReacciona;
    }

    public void setUsuarioQueReacciona(Usuario usuarioQueReacciona) {
        this.usuarioQueReacciona = usuarioQueReacciona;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipoReaccion() {
        return tipoReaccion;
    }

    public void setTipoReaccion(String tipoReaccion) {
        this.tipoReaccion = tipoReaccion;
    }
}
