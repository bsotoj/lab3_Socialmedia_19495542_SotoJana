package com.paradigmas;

import com.paradigmas.TDA.SocialNetwork;
import com.paradigmas.TDA.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SocialNetwork sn1 = new SocialNetwork("Manc Ave");
        sn1.register("usuario1","pass1");
        sn1.register("usuario2","pass2");
        sn1.register("usuario3","pass3");
        sn1.register("usuario4","pass4");
        sn1.register("usuario5","pass5");
        sn1.login("usuario3","pass3");
        List<String> listaUsuarios = new ArrayList<>();
        listaUsuarios.add("usuario1");
        listaUsuarios.add("usuario5");
        listaUsuarios.add("usuario4");
        sn1.post("video","mi primer post");
        sn1.post("foto", "mi primera foto dirigida a usuarios",listaUsuarios);
        sn1.follow("usuario4");
        sn1.logout();
        sn1.login("usuario4","pass4");
        sn1.follow("usuario3");

        //Se usa como referencia la base del metodo mostrar menu visto en clases del profesor Gonzalo Martinez



    }
}
