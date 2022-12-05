
package com.Tienda_3QL.service;

import com.Tienda_3QL.dao.UsuarioDao;
import com.Tienda_3QL.domain.Cliente;
import com.Tienda_3QL.domain.Rol;
import com.Tienda_3QL.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService{

     @Autowired
     private UsuarioDao usuarioDao;
    
    @Override
    @Transactional (readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //Busacr Un usuario por username
      
       Usuario usuario= usuarioDao.findByUsername(username);
       
       if( usuario==null){
           throw new UsernameNotFoundException(username);
           
       }
        var roles =new ArrayList<GrantedAuthority>();
        for(Rol rol:usuario.getRoles()){
            
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //se retorna el usuario con detalles
        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }
    
    

}
