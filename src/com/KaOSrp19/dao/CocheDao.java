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

    //CRAR COCHES
    public void insertarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO coches (matricula,marca,modelo,color,precio) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());



            preparedStatement.executeUpdate(); //////
            System.out.println(coche +"creado");

        }catch (SQLException e){
            System.out.println("Error al insertar el coches \n" + e.getMessage());
        }

    }

    //EDITAR COCHES
    public void editarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE coches SET matricula=?,marca=?,modelo=?,color=?,precio=? WHERE matricula=?" );

            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.setString(2,coche.getMarca());
            preparedStatement.setString(3,coche.getModelo());
            preparedStatement.setString(4,coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.executeUpdate();////
            System.out.println(coche +"Editado");
        }catch (SQLException e){
            System.out.println("Error al editar coches" + e);
        }

    }

    //ELIMINAR COCHES  /*modificamos*/
    public void eliminarCoche(Coche coche){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM coches WHERE matricula=?" );

            preparedStatement.setString(1,coche.getMatricula());
            preparedStatement.executeUpdate();////

            System.out.println("Se elimino correctamente");
        }catch (SQLException e){
            System.out.println("Error al eliminar coches" + e);
        }

    }

    //LISTAR COCHES
    public List<Coche> listaCoches(){
        List<Coche> listaCoche = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSetn = statement.executeQuery("SELECT * FROM coches");
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

    //BUSACAR COCHES POR MATRICULA
    public Coche buscarCochesPorMatricula(String matricula){
        Coche coche = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM coches WHERE matricula=?" );

            preparedStatement.setString(1, matricula);

            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){

                coche=new Coche();

                coche.setMatricula(resultSet.getString("matricula"));
                coche.setMarca(resultSet.getString("marca"));
                coche.setModelo(resultSet.getString("modelo"));
                coche.setColor(resultSet.getString("color"));
                coche.setPrecio(resultSet.getDouble("precio"));

            }

        }catch (SQLException e){
            System.out.println("Error al listar los choches por matricula " + e);
        }

        return coche;

    }
}
