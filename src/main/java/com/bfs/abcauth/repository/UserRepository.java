package com.bfs.abcauth.repository;

import com.bfs.abcauth.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    public List<User> findByEmailAndPassword(String email, String password);
}
