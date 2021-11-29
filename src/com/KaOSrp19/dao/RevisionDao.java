package com.KaOSrp19.dao;

import com.KaOSrp19.model.Cliente;
import com.KaOSrp19.model.Coche;
import com.KaOSrp19.model.Revision;
import com.KaOSrp19.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {
    Connection connection;
    public RevisionDao(){
        connection = ConectorBD.getConnection();
    }

    //CREAR REVION
    public void insertarCoche(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO revisiones (codigo,filtro,aceite,frenos) VALUES (?,?,?,?)");

            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());

            preparedStatement.executeUpdate(); //////
            System.out.println(revision +"creado");

        }catch (SQLException e){
            System.out.println("Error en la revision \n" + e.getMessage());
        }

    }

    //EDITAR REVISIONES
    public void editarRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE revisiones SET codigo=?,filtro=?,aceite=?,frenos=? WHERE codigo=?" );

            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.setString(2,revision.getFiltro());
            preparedStatement.setString(3,revision.getAceite());
            preparedStatement.setString(4,revision.getFrenos());


            preparedStatement.setString(5,revision.getCodigo());

            preparedStatement.executeUpdate();////
            System.out.println(revision +"Editado");
        }catch (SQLException e){
            System.out.println("Error al editar revision" + e);
        }

    }

    //ELIMINAR REVISIONES  /*modificar*/
    public void eliminarRevision(Revision revision){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM revisiones WHERE codigo=?" );

            preparedStatement.setString(1,revision.getCodigo());
            preparedStatement.executeUpdate();////

            System.out.println("Se elimino correctamente");
        }catch (SQLException e){
            System.out.println("Error al eliminar revision" + e);
        }

    }

    //LISTAR REVISIONES
    public List<Revision> listaRevision(){
        List<Revision> listaRevision = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSetn = statement.executeQuery("SELECT * FROM revisiones");
            while (resultSetn.next()){
                Revision revision= new Revision();
                revision.setCodigo(resultSetn.getString("codigo"));
                revision.setFiltro(resultSetn.getString("filtro"));
                revision.setAceite(resultSetn.getString("aceite"));
                revision.setFrenos(resultSetn.getString("frenos"));

                listaRevision.add(revision);
            }

        }catch (SQLException e){
            System.out.println("Error al listar las revisiones " + e.getMessage());
        }

        return listaRevision;

    }

    //BUSCAR REVISION POR CODIGO
    public Revision buscarClientePorNif(String codigo){
        Revision revision=null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM revisiones WHERE codigo=?" );

            preparedStatement.setString(1, codigo);

            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){

                revision=new Revision();

                revision.setCodigo(resultSet.getString("codigo"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFrenos(resultSet.getString("frenos"));


            }

        }catch (SQLException e){
            System.out.println("Error al buscar revision " + e);
        }

        return revision;

    }
}
