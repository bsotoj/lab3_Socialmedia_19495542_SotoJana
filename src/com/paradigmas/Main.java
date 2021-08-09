package com.paradigmas;

import com.paradigmas.TDA.SocialNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main extends MenuInteractivo{

    public static void main(String[] args){
        var selectedOption = 0;
        var opcionContinuar = 0;
        var opcionIngresadaPorTeclado = new Scanner(System.in);

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
        while(selectedOption != 4){
            selectedOption = mostrarMenuInicial(sn1.getNombreRedSocial());
            switch(selectedOption){
            case 1:
                System.out.println("Ha seleccionado la opcion 1: registrarse");
                    while(opcionContinuar != 2){
                        System.out.println("Para registrar un usuario seleccione 1");
                        System.out.println("Para salir seleccione 2");
                        System.out.println("Una vez seleccionada la opcion pulse ENTER: ");
                        opcionContinuar = opcionIngresadaPorTeclado.nextInt();
                        switch(opcionContinuar){
                            case 1:
                                System.out.println("Ingrese el nombre de usuario y luego presione ENTER: ");
                                var nombreUsuario = opcionIngresadaPorTeclado.next();
                                System.out.println("Ingrese la contraseña del usuario y luego presione ENTER: ");
                                var contrasegna = opcionIngresadaPorTeclado.next();
                                sn1.register(nombreUsuario,contrasegna);
                                break;

                            case 2:
                                System.out.println("Ha seleccionador la opcion 2: salir");
                                break;

                            default:
                                System.out.println("Ingrese opcion correcta");
                        }
                    }
            case 2:
                System.out.println("OLAAAAAA");
                break;


            case 3:
                System.out.println("Ha seleccionado la opcion 3: visualizacion de la red social actual");
                System.out.println("La representacion de la red social es la siguiente: ");
                sn1.socialNetworkToString();
                break;

            case 4:
                exit(0);

            default:
                System.out.println("Ingrese opcion correcta");
            }
        }


    }
}
