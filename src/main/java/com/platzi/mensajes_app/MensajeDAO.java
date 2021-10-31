package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    public static  void CrearMensajeDB(Mensajes mensaje ){
        Conexion db_connect = new Conexion();
         try(Connection conexion = db_connect.get_connection()){
             PreparedStatement ps = null;
             try{
                 String query = "INSERT INTO `mensajes` ( `mensaje`, `autor_mensaje`) VALUES (?,?)";
                 ps = conexion.prepareStatement(query);
                 ps.setString(1, mensaje.getMensaje());
                 ps.setString(2, mensaje.getAutor_mensaje());
                 ps.executeUpdate();
                 System.out.println("Mensaje creado exitosamente");

             }catch (SQLException ex){
                 System.out.println(ex);

             }

         }catch (SQLException e){
             System.out.println(e);

         }

    }

    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();

        //prepara la sentencia
        PreparedStatement ps = null;
        //trae los datos en filas para procesarlos
        ResultSet rs = null;

        try(Connection conexion = db_connect.get_connection()){
            String query = "SELECT * FROM `mensajes` ";
            ps = conexion.prepareStatement(query);
            //ejecuta la consulta
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("Id: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("autor mensaje: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
            }

        }catch (SQLException e){
            System.out.println("Error al recuperar los datos: "+e);

        }


    }

    public static void borrarMensajeDB(int id_mensaje){

        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje borrado exitosamente");

            }catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e);
            }

        }catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado exitosamente!");
            }catch (SQLException e) {
                System.out.println("Error al actualizar el mensaje: "+e);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

}
