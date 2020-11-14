package com.mds.bdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.bdms.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
