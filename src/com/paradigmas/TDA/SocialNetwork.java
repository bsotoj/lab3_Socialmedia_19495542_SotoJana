package com.paradigmas.TDA;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialNetwork implements RedSocial,Authentication,Visualize {
    private List<Usuario> usuariosRedSocial;
    private List<Publicacion> publicacionesRedSocial;
    private String nombreRedSocial;
    private Usuario usuarioSesionActiva; // cada vez que se use el metodo existeUsuarioSesionActiva este atributo se sobreescribe
                                        // la direccion de memoria con la direccion del nuevo usuario con sesion iniciada

    /**
     * constructor SocialNetwork
     * @param nombreRedSocial
     * return SocialNetwork
     */
    public SocialNetwork(String nombreRedSocial) {
        this.nombreRedSocial = nombreRedSocial;
        this.usuariosRedSocial = new ArrayList<>();
        this.publicacionesRedSocial = new ArrayList<>();

    }


    /**
     * REGISTER
     * registrar a un usuario en la redsocial
     * @param nombreUsuario
     * @param contrasegna
     * return void
     */
    public void register(String nombreUsuario, String contrasegna){
        if(!existeUsuario(usuariosRedSocial, nombreUsuario)){
            Usuario nuevoUsuario = new Usuario(nombreUsuario,contrasegna);
            this.usuariosRedSocial.add(nuevoUsuario);
            System.out.println("Se ha registrado al usuario " + nombreUsuario + " con exito");
            return;

        }
        System.out.println("Este usuario ya existe");


    }

    /**
     * LOGIN
     * logear a un usuario en la red social
     * @param nombreUsuario
     * @param constrasegna
     * return void
     */

    public void login (String nombreUsuario, String constrasegna){
        int posicionUsuarioBuscado;
        if(!(this.usuariosRedSocial.size() == 0)){
            posicionUsuarioBuscado = getUsuarioPorPosicion(this.usuariosRedSocial, nombreUsuario);
            if(usuariosRedSocial.get(posicionUsuarioBuscado).getContrasegna() == constrasegna) {
                usuariosRedSocial.get(posicionUsuarioBuscado).setSesionActiva(true);
                System.out.println("El usuario " + nombreUsuario + " ha iniciado sesion");
                return;
            }
            else{
                System.out.println("La contraseña ingresada para el usuario " + nombreUsuario + " no es correcta");
            }
        }
        else{
            System.out.println("No hay usuarios registrados en la red social");
        }


    }

    /**
     * LOGOUT
     * desconectar a un usuario de la red social
     * @return void
     */

    public void logout(){
        if(existeUsuarioSesionActiva()){
            this.usuarioSesionActiva.setSesionActiva(false);
            System.out.println("El usuario " + this.usuarioSesionActiva.getNombreUsuario() + " ha cerrado sesion");
        }
        else{
            System.out.println("No existe usuario con sesion activa en la red social");
        }

    }
    /**
     * POST PUBLICADO EN EL MURO DEL USUARIO CON SESION ACTIVA
     * @param tipoPublicacion
     * @param contenido
     * @return
     */
    @Override
    public void post(String tipoPublicacion, String contenido) {
        if((!existePublicacion(publicacionesRedSocial, tipoPublicacion, contenido)) && existeUsuarioSesionActiva()){
            Date fechaPost = new Date();
            //public Publicacion(String contenido, String tipoPublicacion, Usuario autor, Date fechaPublicacion) {
            Publicacion nuevaPublicacion = new Publicacion(contenido,tipoPublicacion,usuarioSesionActiva, fechaPost);
            this.publicacionesRedSocial.add(nuevaPublicacion);
            usuarioSesionActiva.getPublicacionesRealizadas().add(nuevaPublicacion);
            System.out.println("Se ha realizado la publicacion " + contenido + " por el usuario " + usuarioSesionActiva.getNombreUsuario());
            return;

        }
        System.out.println("Ya existe una publicacion con ese titulo " + contenido + " del tipo " + tipoPublicacion);
    }
   
    public boolean usuariosExistenEnRedSocial(List<Usuario> usuariosAVerificar){
        void boolean respuesta;
        for(Usuario usuarioActual: usuariosAVerificar){
            boolean = usuariosRedSocial.contains(usuarioActual);
        }
        return respuesta;
    }
    //------------------------------------------------------------------------------------
    /**
     * verificar la existencia de un usuario en socialnetwork
     * @param listaUsuarios
     * @param nombreUsuario
     * @return boolean
     */
    public boolean existeUsuario(List<Usuario> listaUsuarios, String nombreUsuario){
        if(listaUsuarios == null){
            return false;
        }
        for(Usuario usuarioActual: listaUsuarios){
            if(usuarioActual.getNombreUsuario() == nombreUsuario){
                return true;
            }
        }
        return false;

    }

    /**
     * verificar la existencia de una publicacion en socialnetwork
     * @param listaPublicaciones
     * @param tipoPublicacion
     * @param contenido
     * @return boolean
     */
    public boolean existePublicacion(List<Publicacion> listaPublicaciones, String tipoPublicacion, String contenido){
        if(listaPublicaciones == null){
            return false;
        }
        for(Publicacion publicacionActual: listaPublicaciones){
            if(publicacionActual.getContenido() == contenido && publicacionActual.getTipoPublicacion() == tipoPublicacion ){
                return true;
            }
        }
        return false;
    }

    public List<Usuario> getUsuariosRedSocial() {
        return usuariosRedSocial;
    }

    public List<Publicacion> getPublicacionesRedSocial() {
        return publicacionesRedSocial;
    }

    /**
     * obtener la posicion de un usuario en especifico dentro de una lista de usuarios
     * @param usuarios
     * @param usuarioBuscado
     * @return posicion
     */
    public int getUsuarioPorPosicion(List<Usuario> usuarios, String usuarioBuscado) {
        int posicion = 0;
        while (posicion < usuarios.size()) {
            if (usuarioBuscado == usuarios.get(posicion).getNombreUsuario()){
                return posicion;
            }
            posicion+=1;
        }

        return -1;
    }

    /**
     * verificar existencia de un usuario logeado en socialnetwork +  obtener dicho usuario
     * @return boolean
     */
    public boolean existeUsuarioSesionActiva (){
        for(Usuario usuario : this.usuariosRedSocial){
            if(usuario.isSesionActiva() == true){
                this.usuarioSesionActiva  = usuario;
                return true;
            }
        }
        return false;

    }


    // ESTOY TESTEANDO ALGUNAS COSAS
    public String imprimirUsuarios(){
        String cadena = new String();
        for(Usuario usuarioActual: this.usuariosRedSocial){
            cadena = cadena + usuarioActual.getNombreUsuario() + " estado actual de sesion " + usuarioActual.isSesionActiva() + '\n';
        }
        return cadena;
    }
    @Override
    public String toString() {
        return "SocialNetwork{" +
                "usuariosRedSocial= " + imprimirUsuarios() +
                ", nombreRedSocial='" + nombreRedSocial + '\'' +
                '}';
    }


}




