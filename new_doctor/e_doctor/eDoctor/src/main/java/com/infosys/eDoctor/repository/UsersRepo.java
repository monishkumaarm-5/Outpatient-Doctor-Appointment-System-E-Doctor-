package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String userId);
}
