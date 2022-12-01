package com.Tienda_3QL.service;

import com.Tienda_3QL.dao.ClienteDao;
import com.Tienda_3QL.dao.CreditoDao;
import com.Tienda_3QL.domain.Cliente;
import com.Tienda_3QL.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service/*Informa al controller que es un servicio*/
public class ClienteServiceimpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional (readOnly=true) //La consulta es solo lectura
    public List<Cliente> getCliente() {

        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional //Transaccion de lectura y escritura
    public void save(Cliente cliente) {
        Credito credito =cliente.getCredito();
        credito=creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional 
    public void delete(Cliente cliente) {
       clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);/*Si no lo enceuntra devuelve null*/
        
    }

    @Override
    public List<Cliente> getByApellidosIgnoreCase(String apellidos) {
    return clienteDao.findByApellidos("Castro mora");
    }

    

}
