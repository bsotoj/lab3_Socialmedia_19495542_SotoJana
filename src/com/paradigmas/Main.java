package com.paradigmas;

import com.paradigmas.TDA.SocialNetwork;
import com.paradigmas.TDA.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SocialNetwork sn1 = new SocialNetwork("manc ave");
        sn1.register("usuario1","pass1");
        sn1.register("usuario2", "pass2");
        sn1.register("usuario3","pass3");
        sn1.register("usuario4","pass4");
        //sn1 = [usuario1,usuario2,usuario3,usuario4]
        Usuario usuario1 = sn1.getUsuariosRedSocial().get(0);
        Usuario usuario2 = sn1.getUsuariosRedSocial().get(1);
        Usuario usuario3 = sn1.getUsuariosRedSocial().get(2);
        Usuario usuario4 = sn1.getUsuariosRedSocial().get(3);
        //listaDeUsuarios = [usuario1,usuario3,usuario4]
        List <Usuario> listaDeUsuarios = new ArrayList<>();
        listaDeUsuarios.add(usuario1);
        listaDeUsuarios.add(usuario3);
        listaDeUsuarios.add(usuario4);
        sn1.login("usuario1","pass1");
        sn1.post("video","mi primer post");
        sn1.post("foto","mi primera foto dirigida a usuarios",listaDeUsuarios);
        System.out.println("contenido de la publicacion: " + sn1.getUsuariosRedSocial().get(0).getPublicacionesDirigidasAlUsuario().get(0).getContenido() + "autor: " + sn1.getUsuariosRedSocial().get(0).getPublicacionesDirigidasAlUsuario().get(0).getAutor().getNombreUsuario() );
        System.out.println("contenido de la publicacion: " + sn1.getUsuariosRedSocial().get(2).getPublicacionesDirigidasAlUsuario().get(0).getContenido()+ "autor: " + sn1.getUsuariosRedSocial().get(2).getPublicacionesDirigidasAlUsuario().get(0).getAutor().getNombreUsuario());
        System.out.println("contenido de la publicacion: " + sn1.getUsuariosRedSocial().get(3).getPublicacionesDirigidasAlUsuario().get(0).getContenido()+ "autor: " + sn1.getUsuariosRedSocial().get(3).getPublicacionesDirigidasAlUsuario().get(0).getAutor().getNombreUsuario());
       // Usuario newUsuario = sn1.getUsuariosRedSocial().get(0);
        sn1.logout();

       // System.out.println(sn1.getUsuariosRedSocial().contains(newUsuario));
        //System.out.println(sn1.toString());
        // System.out.println("ahora es con logout");
        // sn1.logout();
        // System.out.println(sn1.toString());

    }
}
