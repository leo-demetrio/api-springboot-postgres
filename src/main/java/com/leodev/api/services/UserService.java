package com.leodev.api.services;

import com.leodev.api.entities.User;
import com.leodev.api.repositories.UserRepository;
import com.leodev.api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User user){
        return repository.save(user);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public User update(long id, User obj){
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }
    private void updateData(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
