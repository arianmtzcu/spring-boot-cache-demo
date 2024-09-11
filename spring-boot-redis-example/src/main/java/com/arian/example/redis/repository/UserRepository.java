package com.arian.example.redis.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arian.example.redis.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

   @Modifying(clearAutomatically = true, flushAutomatically = true)
   @Transactional
   @Query(value = "UPDATE user SET salary = :salary WHERE id = :id", nativeQuery = true)
   int updateSalary(@Param("id") Long id, @Param("salary") float salary);

   default Optional<User> findUser(Long id) {
      System.out.println("Call repository to get id=" + id);
      return this.findById(id);
   }

}
