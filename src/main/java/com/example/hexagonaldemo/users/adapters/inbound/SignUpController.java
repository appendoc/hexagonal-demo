package com.example.hexagonaldemo.users.adapters.inbound;

import com.example.hexagonaldemo.users.application.port.inbound.SignUpUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class SignUpController {

    private final SignUpUseCase signUpUseCase;

    public SignUpController(SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    @PostMapping
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        final SignUpUseCase.SignUpRequest signUpRequest = new SignUpUseCase.SignUpRequest(
                signUpRequestDto.getEmail(),
                signUpRequestDto.getName()
        );
        final SignUpUseCase.SignUpResponse response = signUpUseCase.signUp(signUpRequest);
        return new SignUpResponseDto(
                response.id()
        );
    }
}
