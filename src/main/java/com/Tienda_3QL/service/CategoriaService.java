
package com.Tienda_3QL.service;

import com.Tienda_3QL.domain.Categoria;
import java.util.List;



  
    public interface CategoriaService {
    
    
    public List<Categoria> getCategorias(boolean activos);/*Para categorias activas*/
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
    public Categoria getCategoria(Categoria categoria);
    
    
    
    
}

    
    
    
    

