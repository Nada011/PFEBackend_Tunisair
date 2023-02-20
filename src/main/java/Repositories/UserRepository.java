package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.User;


public interface UserRepository extends JpaRepository <User, Long> {

}
