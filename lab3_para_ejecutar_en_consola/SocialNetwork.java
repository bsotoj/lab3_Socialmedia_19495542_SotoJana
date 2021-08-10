



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocialNetwork implements RedSocial,Authentication,Visualize {
    private List<Usuario> usuariosRedSocial;
    private List<Publicacion> publicacionesRedSocial;
    private String nombreRedSocial;
    private Usuario usuarioSesionActiva; // cada vez que se use el metodo existeUsuarioSesionActiva este atributo sobreescribe
                                        // la direccion de memoria con la direccion del nuevo usuario con sesion iniciada
    private String representacionRedSocial;

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
        if(!existeUsuarioRedSocial(usuariosRedSocial, nombreUsuario,contrasegna)){
            Usuario nuevoUsuario = new Usuario(nombreUsuario,contrasegna);
            this.usuariosRedSocial.add(nuevoUsuario);
            System.out.println("Se ha registrado al usuario " + nombreUsuario + " con exito");
            return;

        }
        else{
            System.out.println("Este usuario ya existe");
        }

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
            if(usuariosRedSocial.get(posicionUsuarioBuscado).getContrasegna().equals(constrasegna)) {
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


    /**
     * POST PUBLICADO EN EL MURO DE OTROS USUARIOS
     * @param tipoPublicacion
     * @param contenido
     * @param listaUsuariosPublicacionDirigida
     */
    public void post(String tipoPublicacion, String contenido, List<String> listaUsuariosPublicacionDirigida){
        if((!existePublicacion(publicacionesRedSocial,tipoPublicacion,contenido)) && existeUsuarioSesionActiva() && usuariosExistenEnRedSocial(listaUsuariosPublicacionDirigida)){
            Date fechaPost = new Date();
            Publicacion nuevaPublicacion = new Publicacion(contenido,tipoPublicacion,usuarioSesionActiva,fechaPost);
            this.publicacionesRedSocial.add(nuevaPublicacion);
            usuarioSesionActiva.getPublicacionesRealizadas().add(nuevaPublicacion);
            //public Usuario getUsuarioPorNombre(String nombreUsuarioBuscado){
            for(String usuarioActual : listaUsuariosPublicacionDirigida){
                getUsuarioPorNombre(usuarioActual).getPublicacionesDirigidasAlUsuario().add(nuevaPublicacion);
            }
            System.out.println("La publicacion ha sido posteada en el muro de los usuarios con exito");
            return;
        }
        System.out.println("no se ha podido realizar la publicacion");
    }

    /**
     * FOLLOW
     * Usuario con sesion activa puede seguir a otro usuario de la red social
     * @param nombreUsuarioASeguir
     * @return void
     */
    public void follow(String nombreUsuarioASeguir) {
        if((existeUsuario(usuariosRedSocial, nombreUsuarioASeguir)) && existeUsuarioSesionActiva()){
            if(!(usuarioSesionActiva.getNombreUsuario().equals(nombreUsuarioASeguir))){ //un usuario no se puede seguir a si mismo
                usuarioSesionActiva.getUsuariosQueSigue().add(nombreUsuarioASeguir);
                System.out.println("El usuario " + usuarioSesionActiva.getNombreUsuario() + " sigue al usuario " + nombreUsuarioASeguir);
                return;
            }
            else{
                System.out.println("El usuario " + usuarioSesionActiva.getNombreUsuario() + " no se puede seguir a si mismo");
            }
        }
        else{
            System.out.println("no es posible realizar la operacion, el usuario a seguir no se encuentra en la red social o no se ha iniciado sesion");
        }
    }

    /**
     * SHARE COMPARTIDO EN EL MURO DEL USUARIO CON SESION ACTIVA
     * @param idPost
     * @return void
     */
    public void share(int idPost){
        if(existePublicacion(idPost) && existeUsuarioSesionActiva()){
            Date fechaDelShare = new Date();
            usuarioSesionActiva.getFechaPublicacionCompartidaPorElUsuario().add(fechaDelShare);
            usuarioSesionActiva.getPublicacionesCompartidasPorElUsuario().add(getPublicacionPorId(idPost));
            System.out.println("El usuario "+ usuarioSesionActiva.getNombreUsuario() +" ha compartido la publicacion con id "+ idPost + " en su propio muro");

        }
        else{
            System.out.println("No se ha podido compartir la publicacion, verifique que la publicacion exista y/o el usuario ha iniciado sesion");

        }
    }

    /**
     * SOBRECARGA DEL METODO share
     * SHARE COMPARTIDO EN EL MURO DE UNA LISTA DE USUARIOS
     * @param idPost
     * @param listaUsuariosConQuienCompartir
     * @return void
     */
   // public boolean sonLosUsuariosAmigosDelUsuarioSesionActiva (List<String> usuariosAVerificar){
   // public Usuario getUsuarioPorNombre(String nombreUsuarioBuscado){

    public void share(int idPost, List<String> listaUsuariosConQuienCompartir){
        if(existePublicacion(idPost) && existeUsuarioSesionActiva()){
            if(sonLosUsuariosAmigosDelUsuarioSesionActiva(listaUsuariosConQuienCompartir)){
                Date fechaDelShare = new Date();
                usuarioSesionActiva.getFechaPublicacionCompartidaPorElUsuario().add(fechaDelShare);
                usuarioSesionActiva.getPublicacionesCompartidasPorElUsuario().add(getPublicacionPorId(idPost));
                for(String usuarioActual: listaUsuariosConQuienCompartir){
                    getUsuarioPorNombre(usuarioActual).getPublicacionesDirigidasAlUsuario().add(getPublicacionPorId(idPost));

                }
                System.out.println("El usuario " +usuarioSesionActiva.getNombreUsuario() + " ha compartido la publicacion con id " + idPost + " en el muro de sus contactos" );

            }
            else{
                System.out.println("Los usuarios seleccionados no se encuentran en la lista de seguidores del usuario con sesion activa");
            }

        }
        else{
            System.out.println("No se ha podido compartir la publicacion, verifique que la publicacion exista y/o el usuario ha iniciado sesion");
        }

    }

    /**
     * representacion de una red social/usuario con sesion activa a string
     * @return void
     */
    public void socialNetworkToString(){
        representacionRedSocial = "";
        if(existeUsuarioSesionActiva()){
            representacionRedSocial = usuarioSesionActiva.userSesionActivaToString();
        }
        else{
            representacionRedSocial = representacionRedSocial + "Representacion de la red social: " + nombreRedSocial + '\n'
                    + "Usuarios de la red social: " + '\n';
            if(usuariosRedSocial == null){
                representacionRedSocial = representacionRedSocial + '\n';
            }
            else{
                for(Usuario usuarioActual: usuariosRedSocial){
                    representacionRedSocial = representacionRedSocial + usuarioActual.usuarioToString() + '\n';
                }
            }
            representacionRedSocial = representacionRedSocial + "Publicaciones de la red social: " + '\n';

            if(publicacionesRedSocial == null){
                representacionRedSocial = representacionRedSocial + '\n';
            }
            else{
                for(Publicacion publicacionActual: publicacionesRedSocial){
                    representacionRedSocial = representacionRedSocial + publicacionActual.publicacionToString() + '\n';
                }
            }

        }
        printSocialNetwork();
    }

    /**
     * imprimir por pantalla el string obtenido de socialNetworkToString
     * @return void
     */
    public void printSocialNetwork(){
        System.out.println(representacionRedSocial);
    }
    /**
     * verificar la existencia de un grupo de usuarios en la red social
     * @param usuariosAVerificar
     * @return boolean
     */
    public boolean usuariosExistenEnRedSocial(List<String> usuariosAVerificar){
        boolean respuesta = false;
        for(String usuarioActual: usuariosAVerificar){
            respuesta = existeUsuario(usuariosRedSocial,usuarioActual);
        }
        return respuesta;
    }

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
            if(usuarioActual.getNombreUsuario().equals(nombreUsuario)){
                return true;
            }
        }
        return false;

    }

    /**
     * verifica la existencia de un usuario en la red social para registrarlo
     * @param listaUsuarios
     * @param nombreUsuario
     * @param contrasegna
     * @return boolean
     */
    public boolean existeUsuarioRedSocial(List<Usuario> listaUsuarios, String nombreUsuario, String contrasegna){
        if(listaUsuarios == null){
            return false;
        }
        for(Usuario usuarioActual: listaUsuarios){
            if((usuarioActual.getNombreUsuario().equals(nombreUsuario)) && (usuarioActual.getContrasegna().equals(contrasegna))){
                return true;
            }
        }
        return false;

    }


    /**
     * metodo que verifica si una lista de usuarios se encuentra dentro de los contacto del usuario con sesion activa
     * @param usuariosAVerificar
     * @return boolean
     */

    public boolean sonLosUsuariosAmigosDelUsuarioSesionActiva (List<String> usuariosAVerificar){
        boolean respuesta = false;
        for(String usuarioActual: usuariosAVerificar){
            respuesta = usuarioSesionActiva.getUsuariosQueSigue().contains(usuarioActual);
        }
        return respuesta;
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
            if(publicacionActual.getContenido().equals(contenido) && publicacionActual.getTipoPublicacion().equals(tipoPublicacion)){
                return true;
            }
        }
        return false;
    }

    /**
     * APLICACION DE SOBRECARGA EN EL METODO existePublicacion
     * verifica la existencia de una publicacion en social network a partir de una ID
     * @param idPost
     * @return boolean
     */
    public boolean existePublicacion(int idPost){
        for(Publicacion publicacionActual: publicacionesRedSocial){
            if(publicacionActual.getId() == idPost){
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
            if (usuarios.get(posicion).getNombreUsuario().equals(usuarioBuscado)){
                return posicion;
            }
            posicion+=1;
        }

        return -1;
    }

    /**
     * obtener a un usuario de la red social por nombre
     * @param nombreUsuarioBuscado
     * @return usuario
     */
    public Usuario getUsuarioPorNombre(String nombreUsuarioBuscado){
        for(Usuario usuarioActual: this.usuariosRedSocial){
            if(usuarioActual.getNombreUsuario().equals(nombreUsuarioBuscado)){
                return usuarioActual;
            }
        }
        return null;
    }

    /**
     * obtener una publicacion de la red social a partir de un id
     * @param idPost
     * @return publicacion
     */
    public Publicacion getPublicacionPorId(int idPost){
        for(Publicacion publicacionActual: this.publicacionesRedSocial){
            if(publicacionActual.getId() == idPost){
                return publicacionActual;
            }
        }
        return null;
    }
    /**
     * verificar existencia de un usuario logeado en socialnetwork + actualiza el atributo usuarioSesionActiva
     * con el usuario que actualmente esta logeado
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

    public String getNombreRedSocial() {
        return nombreRedSocial;
    }

    public Usuario getUsuarioSesionActiva() {
        return usuarioSesionActiva;
    }
}




