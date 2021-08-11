

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuInteractivo {
    /**
     * desplegar menu inicial para el menu interactivo
     * @param nombreRedSocial
     * @return int
     */

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

    /**
     * desplegar menu para el usuario que ha iniciado sesion en la red social
     * @param nombreUsuarioLogeado
     * @return int
     */
    public static int mostrarMenuUsuarioIniciado(String nombreUsuarioLogeado){
        int opcionSeleccionada = 0;
        Scanner opcionIngresadaPorTeclado = new Scanner(System.in);
		System.out.println("\n" + "Hola " + nombreUsuarioLogeado + "\n");
        System.out.println("\n");
        System.out.println("Que accion deseas hacer?: ");
        System.out.println("1.Publicacion en el muro del usuario");
        System.out.println("2.Publicacion en el muro de otros usuarios");
        System.out.println("3.Seguir a un usuario");
        System.out.println("4.Compartir una publicacion en el propio muro");
        System.out.println("5.Compartir una publicacion en el muro de otros contactos");
        System.out.println("6.Visualizar tus acciones en la red social");
        System.out.println("7.Cerrar sesion");
        System.out.println("8.Salir del programa");
        opcionSeleccionada = opcionIngresadaPorTeclado.nextInt();
        return opcionSeleccionada;
    }




}
