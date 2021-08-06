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
        sn1.login("usuario1","pass1");
        sn1.post("video","mi primer post");
        sn1.post("video","mi primer post");
       // Usuario newUsuario = sn1.getUsuariosRedSocial().get(0);
        sn1.logout();
       // System.out.println(sn1.getUsuariosRedSocial().contains(newUsuario));
        //System.out.println(sn1.toString());
        // System.out.println("ahora es con logout");
        // sn1.logout();
        // System.out.println(sn1.toString());

    }
}
