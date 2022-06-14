package com.webApp.examPortal.repository;



import com.webApp.examPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String email);
    User findByRoles(String roles);


}
