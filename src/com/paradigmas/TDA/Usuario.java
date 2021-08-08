package com.paradigmas.TDA;

import java.util.ArrayList;
import java.util.List;


    public class Usuario {
        private static int contadorIdActual = 0;
        private int id;
        private String nombreUsuario;
        private String contrasegna;
        private List<Publicacion> publicacionesRealizadas;
        private List<Publicacion> publicacionesDirigidasAlUsuario;
        private List<Publicacion> publicacionesCompartidasPorElUsuario;
        private List<Publicacion> fechaPublicacionCompartidaPorElUsuario;

        private List<String> usuariosQueSigue; //lista de strings que contiene los nombres de los usuarios que sigue
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
            this.publicacionesRealizadas = new ArrayList<>();
            this.publicacionesDirigidasAlUsuario= new ArrayList<>();
            this.usuariosQueSigue = new ArrayList<>();
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

        public List<Publicacion> getFechaPublicacionCompartidaPorElUsuario() {
            return fechaPublicacionCompartidaPorElUsuario;
        }
    }


