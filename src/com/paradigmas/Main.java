package com.paradigmas;

import com.paradigmas.TDA.SocialNetwork;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main extends MenuInteractivo {

    public static void main(String[] args) {

        SocialNetwork sn1 = new SocialNetwork("Manc Ave");
        sn1.register("usuario1", "pass1");
        sn1.register("usuario2", "pass2");
        sn1.register("usuario3", "pass3");
        sn1.register("usuario4", "pass4");
        sn1.register("usuario5", "pass5");
        sn1.register("usuario5", "pass5");
        sn1.login("usuario3", "pass3");
        List<String> listaUsuarios = new ArrayList<>();
        listaUsuarios.add("usuario1");
        listaUsuarios.add("usuario5");
        listaUsuarios.add("usuario4");
        sn1.post("video", "mi primer post");
        sn1.post("foto", "mi primera foto dirigida a usuarios", listaUsuarios);
        sn1.follow("usuario4");
        sn1.logout();
        sn1.login("usuario4", "pass4");
        sn1.follow("usuario3");
        sn1.logout();
        //Se usa como referencia la base del metodo mostrar menu visto en clases del profesor Gonzalo Martinez


        var selectedOption = 0;
        var input = new Scanner(System.in);

        while(selectedOption != 4){
            selectedOption = mostrarMenuInicial(sn1.getNombreRedSocial());
            switch(selectedOption){
                //Registrar usuario
                case 1:
                    System.out.println("Ha seleccionado la opcion 1: Registrarse");
                    System.out.println("Ingrese el nombre de usuario a registrar");
                    var firstInput = input.nextLine();
                    System.out.println("Ingrese la contrasegna del usuario");
                    var secondInput = input.nextLine();
                    sn1.register(firstInput,secondInput);
                    break;
                case 2:// caso cuando el usuario quiere iniciar sesion
                    System.out.println("Ingrese nombre de usuario: ");
                    var nombre = input.nextLine();
                    System.out.println("Ingrese contrasegna: ");
                    var pass = input.nextLine();
                    sn1.login(nombre,pass); //el usuario esta logeado

                    if(sn1.existeUsuarioSesionActiva()){
                        var selectedOption2 = 0;
                        while(selectedOption2 != 7){
                            selectedOption2 =   mostrarMenuUsuarioIniciado(sn1.getUsuarioSesionActiva().getNombreUsuario());
                            switch (selectedOption2){
                                case 1: //Publicacion en el muro del usuario con sesion activa
                                    System.out.println("Que tipo de publicacion es? (video,foto,url,texto,audio) ");
                                    String tipoPublicacion = input.nextLine();
                                    System.out.println("Cual es el contenido de la publicacion? ");
                                    String contenido = input.nextLine();
                                    sn1.post(tipoPublicacion,contenido);
                                    break;
                                case 2: //Publicacion en el muro de otros usuarios
                                    System.out.println("Que tipo de publicacion es? (video,foto,url,texto,audio) ");
                                    String tipoPublicacion1 = input.nextLine();
                                    System.out.println("Cual es el contenido de la publicacion? ");
                                    String contenido1 = input.nextLine();
                                    List<String> usuarios = new ArrayList<>();
                                    String usuario;
                                    Scanner continuar = new Scanner(System.in); //se agrega un scanner aparte
                                    System.out.println("Ingresa uno a uno a los usuarios a los que quieres enviar la publicacion: ");
                                    int continuarAgregandoUsuarios = 0;
                                    while(continuarAgregandoUsuarios == 0 ){
                                        System.out.println("Nombre usuario a enviar publicacion ");
                                        usuario = input.nextLine();
                                        usuarios.add(usuario);
                                        System.out.println("Si quieres seguir agregando usuario pulsa 0, si quieres enviar la publicacion pulsa 1");
                                        continuarAgregandoUsuarios = continuar.nextInt();
                                    }
                                    sn1.post(tipoPublicacion1,contenido1,usuarios);
                                    break;

                                case 3:
                                    System.out.println("follow");
                                    break;

                                case 4:
                                    System.out.println("share");
                                    break;

                                case 5:
                                    System.out.println("share2");
                                    break;
                                case 6:
                                    System.out.println("ToString");
                                    break;
                                case 7:
                                    System.out.println("Has cerrado la sesion");
                                    sn1.logout();
                                    break;

                                case 8:
                                    exit(0); //salir del programa
                                default:
                                    System.out.println("Ingrese una opcion correcta");
                            }
                        }
                    }

                    else{
                        System.out.println("usuario o contrasegna incorrecto");
                    }

                    break; // este es el break del case 2


                //SocialNetworkToString
                case 3:
                    System.out.println("Ha seleccionado la opcion 3: visualizacion de la red social");
                    sn1.socialNetworkToString();
                    break;

                //Fin del programa
                case 4:
                    exit(0);

                default:
                    System.out.println("Ingrese opcion correcta");
            }


        }
    }
}







