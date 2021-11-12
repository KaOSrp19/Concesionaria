package com.KaOSrp19.dao;

import com.KaOSrp19.model.Cliente;
import com.KaOSrp19.model.Coche;
import com.KaOSrp19.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDao {
    Connection connection;

    public CocheDao(){
        connection = ConectorBD.getConnection();
    }
    public void insertarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO coche (matricula,marca,modelo,color,precio) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.executeUpdate(); //////
            System.out.println(coche +"creado");

        }catch (SQLException e){
            System.out.println("Error al insertar el coche \n" + e.getMessage());
        }

    }

    public void editarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE coche SET matricula=?,marca=?,modelo=?,color=?,precio=? WHERE matricula=?" );

            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());

            preparedStatement.setString(6,coche.getMatricula());

            preparedStatement.executeUpdate();////
            System.out.println(coche +"Editado");
        }catch (SQLException e){
            System.out.println("Error al editar coche" + e);
        }

    }
    public void eliminarCoche(String matricula){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM coche WHERE matricula=?" );

            preparedStatement.setString(1,matricula);
            preparedStatement.executeUpdate();////

            System.out.println(matricula +"eliminado");
        }catch (SQLException e){
            System.out.println("Error al eliminar coche" + e);
        }

    }

    public List<Coche> listaCoches(){
        List<Coche> listaCoche = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSetn = statement.executeQuery("SELECT * FROM cohe");
            while (resultSetn.next()){
                Coche coche = new Coche();
                coche.setMatricula(resultSetn.getString("matricula"));
                coche.setMarca(resultSetn.getString("marca"));
                coche.setModelo(resultSetn.getString("modelo"));
                coche.setColor(resultSetn.getString("color"));
                coche.setPrecio(resultSetn.getDouble("precio"));

                listaCoche.add(coche);
            }

        }catch (SQLException e){
            System.out.println("Error al listar los coches " + e.getMessage());
        }

        return listaCoche;

    }
}
