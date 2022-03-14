package com.sofka.service;

/**
 * librerias
 */

import com.sofka.dao.UserDao;
import com.sofka.domain.User;
import java.util.List;
import java.sql.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * [la clase GameService se le agrega la anotacion Service para proyectar metodos a utilizar]
 *
 * @version [1.0.000 2022-03-12]
 *
 * @author [Juan Esteban, Velasquez Posada ]
 *
 * @since [1.0.000 2022-03-12]
 *
 */
@Service
public class UserService implements IUsuarioService{
    
    @Autowired // para inyectar usuarioDao
    private UserDao userDao;
    
    /**
     * @Override sobre escritura 
     * @return lista de usuarios por medio de la interfaz userDao
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        user.setId(id);
        return userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
        
    }

    @Transactional
    public  void updateName(Long id, User user){
        userDao.updateName(id, user.getName());
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<User> findUser(User user) {
        return userDao.findById(user.getId());
    }
    
}
