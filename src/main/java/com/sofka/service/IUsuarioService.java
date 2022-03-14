package com.sofka.service;

/**
 * librerias
 */
import com.sofka.domain.User;
import java.util.List;
import java.util.Optional;

/**
 * [la interfaz IUsuarioService para crear metodos a las peticiones]
 *
 * @version [1.0.000 2022-03-12]
 *
 * @author [Juan Esteban, Velasquez Posada ]
 *
 * @since [1.0.000 2022-03-12]
 *
 */
public interface IUsuarioService {
    
    public List<User> list();
    
    public User save(User user);
    
    public User update(Long id, User user);
    
    public void delete(User user);
    
    public Optional<User> findUser(User user);
}
