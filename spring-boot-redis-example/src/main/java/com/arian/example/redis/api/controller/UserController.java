package com.arian.example.redis.api.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arian.example.redis.domain.entities.User;
import com.arian.example.redis.service.UserService;

import lombok.RequiredArgsConstructor;

@Tag(name = "2. User Operations")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   @PostMapping
   public User save(@RequestBody User user) {
      return this.userService.save(user);
   }

   @GetMapping
   public List<User> findAll() {
      return this.userService.findAll();
   }

   @GetMapping("/{id}")
   public User findById(@PathVariable Long id) {
      return this.userService.findById(id);
   }

   @PatchMapping("/{id}/{salary}")
   public User updateSalary(@PathVariable Long id, @PathVariable float salary) {
      return this.userService.updateSalary(id, salary);
   }

   @DeleteMapping("/{id}")
   public void deleteById(@PathVariable Long id) {
      this.userService.deleteById(id);
   }

}