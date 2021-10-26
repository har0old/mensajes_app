package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connection(){
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3308/mensajes_app", "root", "");
            if (conection != null) {
                System.out.println("Conexiones exitosa!");
            }
        }catch(SQLException e){
                System.out.println(e);
            }
            return conection;
        }
    }

