package com.kenny.springsecurity.repo;

import com.kenny.springsecurity.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, String> {

    Optional<Token> findByToken(String token);

//    List<Token> findAllByUser_UidAndExpiredFalseAndRevokedFalse(Long uid);
    List<Token> findAllByUser_IdAndExpiredFalseAndRevokedFalse(int id);

}
