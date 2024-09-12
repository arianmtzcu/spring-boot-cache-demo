package com.arian.example.caffeine.service;

import static com.arian.example.caffeine.util.Constants.USER_CACHE;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.arian.example.caffeine.domain.model.User;
import com.arian.example.caffeine.domain.repository.UserRepository;

@Service
public class UserService {

   private final UserRepository userRepository;

   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Cacheable(value = USER_CACHE, unless = "#result == null")
   public User findByUserName(String userName) {
      return this.userRepository.findByUserName(userName);
   }

}