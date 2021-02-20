package com.example.LoginAndRegisDemo.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    @Transactional
    public void setConfirmedAt(String token){
        ConfirmationToken  confirmationToken = confirmationTokenRepository.findByToken(token).orElseThrow(
                () -> new IllegalStateException("Token not existed")
        );
        confirmationToken.setConfirmAt(LocalDateTime.now());
    }
}
