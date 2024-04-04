package com.ms.user.service.service.serviceImpl;

import com.ms.user.service.entity.User;
import com.ms.user.service.exception.ResourceNotFoundException;
import com.ms.user.service.repository.UserRepository;
import com.ms.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepos;

    @Override
    public User saveUser(User user) {
        //generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepos.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepos.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepos.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with given id is not found on server!! : "+userId));
    }


}
