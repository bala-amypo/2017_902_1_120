// package com.example.demo.service.impl;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.AuthService;
// import org.springframework.stereotype.Service;

// @Service
// public class AuthServiceImpl implements AuthService {

//     private final UserAccountRepository userAccountRepository;

//     public AuthServiceImpl(UserAccountRepository userAccountRepository) {
//         this.userAccountRepository = userAccountRepository;
//     }

//     @Override
//     public UserAccount register(String email, String password) {
//         UserAccount user = new UserAccount();
//         user.setEmail(email);
//         user.setPassword(password); // plain password for now
//         user.setRole("ROLE_USER");
//         return userAccountRepository.save(user);
//     }

//     @Override
//     public UserAccount login(String email, String password) {
//         return userAccountRepository
//                 .findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository userAccountRepository;

    public AuthServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount register(String email, String password) {
        UserAccount user = new UserAccount();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("USER"); // default role

        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount login(String email, String password) {
        UserAccount user = userAccountRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
