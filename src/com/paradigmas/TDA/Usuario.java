package com.paradigmas.TDA;

import java.util.List;

public class Usuario {
    package com.company.TDA;

import java.util.List;

    public class Usuario {
        private static int contadorIdActual = 0;
        private int id;
        private String nombreUsuario;
        private String contrasegna;
        private List<Publicacion> publicaciones;
        private List<Usuario> contactosUsuario;
        private boolean sesionActiva = false;

        /**
         * constructor del usuario
         * @param nombreUsuario
         * @param contrasegna
         * return usuario
         */
        public Usuario( String nombreUsuario, String contrasegna) {
            setId(++contadorIdActual);
            this.nombreUsuario = nombreUsuario;
            this.contrasegna = contrasegna;
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

        public List<Publicacion> getPublicacionesRealizadas() {
            return publicacionesRealizadas;
        }

        public void setPublicacionesRealizadas(List<Publicacion> publicacionesRealizadas) {
            this.publicacionesRealizadas = publicacionesRealizadas;
        }

        public List<Contactos> getContactosUsuario() {
            return contactosUsuario;
        }

        public void setContactosUsuario(List<Contactos> contactosUsuario) {
            this.contactosUsuario = contactosUsuario;
        }

        public boolean isSesionActiva() {
            return sesionActiva;
        }

        public void setSesionActiva(boolean sesionActiva) {
            this.sesionActiva = sesionActiva;
        }
    }

}
