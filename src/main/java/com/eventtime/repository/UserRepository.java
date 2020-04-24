package com.eventtime.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eventtime.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
