
package com.Tienda_3QL.service;

import com.Tienda_3QL.domain.Articulo;
import java.util.List;



  
    public interface ArticuloService {
    
    
    public List<Articulo> getArticulos(boolean activos);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
    
    
    
    
}

    
    
    
    

