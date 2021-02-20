package com.example.LoginAndRegisDemo.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationSerivce;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationSerivce.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationSerivce.confirmToken(token);
    }
}
