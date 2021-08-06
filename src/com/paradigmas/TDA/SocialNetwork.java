package com.paradigmas.TDA;


import java.util.ArrayList;
import java.util.List;

public class SocialNetwork implements RedSocial {
    private List<Usuario> usuariosRedSocial;
    private List<Publicacion> publicacionesRedSocial;
    private String nombreRedSocial;

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
        if(!(getActiveUser() == null)){
            getActiveUser().setSesionActiva(false);
        }
        else{
            System.out.println("No existe usuario con sesion activa en la red social");
        }

    }
    /**
     * verificar la existencia de un usuario
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
     * obtener usuario con sesion activa en la red social
     * @return usuarioSesionActiva
     */
    public Usuario getActiveUser(){
        for(Usuario usuarioSesionActiva : this.usuariosRedSocial){
            if (usuarioSesionActiva.isSesionActiva() == true){
                return usuarioSesionActiva;
            }

        }

        return null;
    }

    //-------------------------------------------------------------------------------------------------------------------------------
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

