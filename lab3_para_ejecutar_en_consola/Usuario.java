

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    public class Usuario {
        private static int contadorIdActual = 0;
        private int id;
        private String nombreUsuario;
        private String contrasegna;
        private Date fechaCreacionCuenta;
        private List<Publicacion> publicacionesRealizadas;
        private List<Publicacion> publicacionesDirigidasAlUsuario;
        private List<Publicacion> publicacionesCompartidasPorElUsuario;
        private List<Date> fechaPublicacionCompartidaPorElUsuario;

        private List<String> usuariosQueSigue; //lista de strings que contiene los nombres de los usuarios que sigue
        private boolean sesionActiva = false;

        /**
         * constructor del usuario
         *
         * @param nombreUsuario
         * @param contrasegna   return usuario
         */
        public Usuario(String nombreUsuario, String contrasegna) {
            setId(++contadorIdActual);
            this.nombreUsuario = nombreUsuario;
            this.contrasegna = contrasegna;
            this.fechaCreacionCuenta = new Date();
            this.publicacionesRealizadas = new ArrayList<>();
            this.publicacionesDirigidasAlUsuario = new ArrayList<>();
            this.usuariosQueSigue = new ArrayList<>();
            this.publicacionesCompartidasPorElUsuario = new ArrayList<>();
            this.fechaPublicacionCompartidaPorElUsuario = new ArrayList<>();
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getContrasegna() {
            return contrasegna;
        }

        public void setContrasegna(String contrasegna) {
            this.contrasegna = contrasegna;
        }


        public boolean isSesionActiva() {
            return sesionActiva;
        }

        public void setSesionActiva(boolean sesionActiva) {
            this.sesionActiva = sesionActiva;
        }

        public List<Publicacion> getPublicacionesRealizadas() {
            return publicacionesRealizadas;
        }

        public List<Publicacion> getPublicacionesDirigidasAlUsuario() {
            return publicacionesDirigidasAlUsuario;
        }

        public List<String> getUsuariosQueSigue() {
            return usuariosQueSigue;
        }


        public List<Publicacion> getPublicacionesCompartidasPorElUsuario() {
            return publicacionesCompartidasPorElUsuario;
        }

        public List<Date> getFechaPublicacionCompartidaPorElUsuario() {
            return fechaPublicacionCompartidaPorElUsuario;
        }

        public Date getFechaCreacionCuenta() {
            return fechaCreacionCuenta;
        }

        /**
         * representacion de un usuario a String
         * @return String
         */
        public String usuarioToString(){
            String usuarioAString = "";
            usuarioAString = usuarioAString +
                    "Nombre usuario: " + nombreUsuario +
                    '\n' +
                    "ID = " + id +
                    '\n' +
                    "Sesion activa: " + sesionActiva +
                    '\n' +
                    "Fecha creacion de cuenta: " + fechaCreacionCuenta +
                    '\n' +
                    "Lista de personas que sigue el usuario: " + '\n';
            if(usuariosQueSigue == null){
                usuarioAString = usuarioAString + '\n';
            }
            else {
                for (String usuarioActual : usuariosQueSigue) {
                    usuarioAString = usuarioAString + usuarioActual + '\n';
                }
            }
            return usuarioAString;

        }

        /**
         * representacion de un usuario con sesion activa en la red social a string
         * @return String
         */
        public String userSesionActivaToString() {
            String usuarioAString = "";
            int contadorPosicion = 0;
            usuarioAString = usuarioAString +
                    "Nombre usuario: " + nombreUsuario +
                    '\n' +
                    "ID = " + id +
                    '\n' +
                    "Sesion activa: " + sesionActiva +
                    '\n' +
                    "Fecha creacion de cuenta: " + fechaCreacionCuenta +
                    '\n' +
                    "Publicaciones realizadas: " + '\n';

            if (publicacionesRealizadas == null) {
                usuarioAString = usuarioAString + '\n';
            } else {

                for (Publicacion publicacionRealizadaActual : publicacionesRealizadas) {
                    usuarioAString = usuarioAString + publicacionRealizadaActual.publicacionToString() + '\n';
                }

            }
            usuarioAString += "Publicaciones dirigidas al usuario: " + '\n';
            if (publicacionesDirigidasAlUsuario == null) {
                usuarioAString = usuarioAString + '\n';
            } else {
                for (Publicacion publicacionDirigidaAlUsuarioActual : publicacionesDirigidasAlUsuario) {
                    usuarioAString = usuarioAString + publicacionDirigidaAlUsuarioActual.publicacionToString() + '\n';
                }

            }
            usuarioAString += "Publicaciones compartidas por el usuario: " + '\n';

            if (publicacionesDirigidasAlUsuario == null) {
                usuarioAString = usuarioAString + '\n';
            } else {

                while (contadorPosicion < publicacionesCompartidasPorElUsuario.size()) {
                    usuarioAString = usuarioAString + "Fecha en la que se comparte publicacion: " + fechaPublicacionCompartidaPorElUsuario.get(contadorPosicion) +
                            '\n' + publicacionesCompartidasPorElUsuario.get(contadorPosicion).publicacionToString() + '\n';
                    contadorPosicion += 1;
                }
            }


            usuarioAString += "Usuarios que sigue: " + '\n';

            if (usuariosQueSigue == null) {
                usuarioAString = usuarioAString + '\n';
            } else {
                for (String nombreUsuarioActual : usuariosQueSigue) {
                    usuarioAString = usuarioAString + nombreUsuarioActual + '\n';
                }

            }

            return usuarioAString;
        }

    }

