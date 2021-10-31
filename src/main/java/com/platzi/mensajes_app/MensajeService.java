package com.platzi.mensajes_app;

import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(){
        //Ingreso de datos por el usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje: ");
        String mensaje = sc.nextLine();

        System.out.println("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);

        //enviar a la capa DAO
        MensajeDAO.CrearMensajeDB(registro);
    }

    public static void listarMensajes(){
        MensajeDAO.leerMensajeDB();

    }

    public static void  borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el Id del mensaje a eliminar: ");
        int id_mensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(id_mensaje);

    }
    public static void editarMensaje(){

    }
}
