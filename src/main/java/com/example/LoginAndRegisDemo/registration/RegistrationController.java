package com.example.LoginAndRegisDemo.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registraionSerivce;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registraionSerivce.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registraionSerivce.confirmToken(token);
    }
}
