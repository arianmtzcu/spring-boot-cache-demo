package com.arian.example.caffeine.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arian.example.caffeine.persistence.model.User;
import com.arian.example.caffeine.service.UserService;

import lombok.RequiredArgsConstructor;

@Tag(name = "2. User Operations")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UsersController {

   private final UserService userService;

   @Operation(summary = "Find user by username")
   @GetMapping("/{username}")
   public User getUserByUserName(@PathVariable("username") String userName) {
      return this.userService.findByUserName(userName);
   }

}