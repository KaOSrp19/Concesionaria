package com.KaOSrp19;

import com.KaOSrp19.dao.ClienteDao;
import com.KaOSrp19.dao.CocheDao;
import com.KaOSrp19.dao.RevisionDao;
import com.KaOSrp19.model.Cliente;
import com.KaOSrp19.model.Coche;
import com.KaOSrp19.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Connection connection = ConectorBD.getConnection();

        ClienteDao clienteDao = new ClienteDao();


        //CREAR CLIENTE
        //Cliente mario = new Cliente("000000","Mario Ortega","Cochabamba","Av.Ayacucho",2987654);
        /*clienteDao.insertarCliente(mario);*/

        /**------------CLIENTES-----------------*/

        //BUSCAR______________________
        /*Cliente buscarCliente = clienteDao.buscarClientePorNif("333333");
        if (buscarCliente!=null){
            System.out.println(buscarCliente.toString());
        }else{
            System.out.println("No existe el cliente buscado");
        }*/


        //EDITAR_____________________
        /*Cliente tadeo = clienteDao.buscarClientePorNif("333333");
        if (tadeo!=null){
            tadeo.setNombre("Carla Ortega G");
            System.out.println(tadeo.getNombre().length());
            clienteDao.editarCliente(tadeo);
        }*/

        //ELIMINAR_____________________
        /*Cliente eliminar= clienteDao.buscarClientePorNif("123456");
        if (eliminar!=null){
            clienteDao.eliminarCliente(eliminar);
        }*/

        //LISTAR_____________________
        List<Cliente> clientes = clienteDao.listaClientes();
        for (Cliente cliente: clientes){
            System.out.println(cliente);
        }






    }
}
