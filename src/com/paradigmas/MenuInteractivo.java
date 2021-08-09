package com.paradigmas;

import java.util.Scanner;


public class MenuInteractivo {
    public static int mostrarMenuInicial(String nombreRedSocial){
        int opcionSeleccionada = 0;
        Scanner opcionIngresadaPorTeclado = new Scanner(System.in);
        System.out.println("Bienvenido a la red social: " + nombreRedSocial) ;
        System.out.println("-----------------");
        System.out.println("Seleccione la accion que desea realizar: ");
        System.out.println("1.Registrarse");
        System.out.println("2.Iniciar sesion");
        System.out.println("3.Visualizacion de la red social actual");
        System.out.println("4.Salir");
        System.out.println("-----------------");
        System.out.println("Ingrese su opcion (1,2,3 o 4) y luego aprete la tecla ENTER: ");
        opcionSeleccionada = opcionIngresadaPorTeclado.nextInt();
        return opcionSeleccionada;
    }

}
