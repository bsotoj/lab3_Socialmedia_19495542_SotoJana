package com.paradigmas.TDA;

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
         * @param nombreUsuario
         * @param contrasegna
         * return usuario
         */
        public Usuario( String nombreUsuario, String contrasegna) {
            setId(++contadorIdActual);
            this.nombreUsuario = nombreUsuario;
            this.contrasegna = contrasegna;
            this.fechaCreacionCuenta = new Date();
            this.publicacionesRealizadas = new ArrayList<>();
            this.publicacionesDirigidasAlUsuario= new ArrayList<>();
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

        @Override
        public String toString() {

            return "Usuario{" +
                    "id=" + id +
                    ", nombreUsuario='" + nombreUsuario + '\'' +
                    ", contrasegna='" + contrasegna + '\'' +
                    ", fechaCreacionCuenta=" + fechaCreacionCuenta +




                    ", publicacionesRealizadas=" + publicacionesRealizadas +
                    ", publicacionesDirigidasAlUsuario=" + publicacionesDirigidasAlUsuario +
                    ", publicacionesCompartidasPorElUsuario=" + publicacionesCompartidasPorElUsuario +
                    ", fechaPublicacionCompartidaPorElUsuario=" + fechaPublicacionCompartidaPorElUsuario +
                    ", usuariosQueSigue=" + usuariosQueSigue +
                    ", sesionActiva=" + sesionActiva +
                    '}';
        }

        public String userToString(){
            return "Nombre usuario: " +
                    '\n' +
                    "ID = " + id +
                    '\n' +
                    "Fecha creacion de cuenta: " + fechaCreacionCuenta +
                    '\n' +



        }
    }


