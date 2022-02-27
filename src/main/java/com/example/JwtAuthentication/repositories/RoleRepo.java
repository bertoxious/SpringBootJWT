package com.example.JwtAuthentication.repositories;

import com.example.JwtAuthentication.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {
}
