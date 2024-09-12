package com.arian.example.caffeine.domain.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

   private String id;

   private String userName;

   private String nombre;

   public static User newUser(String userName, String nombre) {
      return new User(UUID.randomUUID().toString(), userName, nombre);
   }

}
