package com.send.email.repository;

import com.send.email.model.UserTb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTb, Long> {
}
