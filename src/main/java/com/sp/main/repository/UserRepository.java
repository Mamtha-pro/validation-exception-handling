package com.sp.main.repository;

import com.sp.main.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserId(int id);
}
