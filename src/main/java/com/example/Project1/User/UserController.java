package com.example.Project1.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired //inyectamos directamente el userRepository para hacer consultas a la BD
    private UserRepository userRepository;

    @GetMapping //Si consumimos la clase api/users nos redirecciona a este mentodo directamente
    public List<User> getAllUsers()
    {
        return userRepository.findAll(); //Este metodo debe retornar todo lo que esta en la tabla de datos de usuarios
    }

    @GetMapping("/{id}") //Cuando consumimos la Api y pasamos un parametro ID
    public User getUserById(@PathVariable long id)
    {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }
}
