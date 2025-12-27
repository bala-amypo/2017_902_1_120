// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework..stereotype.Repository;
// import com.example.demo.entity.UserAccountRepository;
// @Repository
// public interface UserAccountRepository extends JpaRepository<UserAccountRepository,Integer>{

// }

package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
    boolean existsByEmail(String email);
}