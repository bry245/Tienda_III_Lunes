
package com.Tienda_3QL.service;

import com.Tienda_3QL.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    
    public List<Cliente> getCliente();
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    public Cliente getCliente(Cliente cliente);
    
    public List<Cliente> getByApellidosIgnoreCase(String apellidos);
    
    
}
