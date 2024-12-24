package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Users;
import com.infosys.eDoctor.repository.UsersRepo;
import com.infosys.eDoctor.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public Boolean loginUser(LoginRequest loginRequest) {
        Optional<Users> userOptional = usersRepo.findByEmail(loginRequest.getUserId());

        if (userOptional.isEmpty()) return false;

        Users user = userOptional.get();
        return passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()) &&
                user.getUserType().equals(loginRequest.getUserType());
    }
}
