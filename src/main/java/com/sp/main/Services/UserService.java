package com.sp.main.Services;

import com.sp.main.Dto.UserRequest;
import com.sp.main.Entity.User;
import com.sp.main.exception.UserNotFoundException;
import com.sp.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public  User saveUser(UserRequest userRequest){
    User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getAge(), userRequest.getGender(), userRequest.getNationality());
     return repository.save(user);
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }
    public User getUser(int id) throws UserNotFoundException {
        User user = repository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id :"+id);
        }
    }
}
