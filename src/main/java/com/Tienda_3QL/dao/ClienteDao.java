
package com.Tienda_3QL.dao;

import com.Tienda_3QL.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


/*Esta interfaz se ua como puente para extraer metodos del crudRepository*/
public interface ClienteDao extends CrudRepository<Cliente, Long>{
  
    List<Cliente>findByApellidos(String apellidos);/*Para agregar un metodo*/
    
    
}
