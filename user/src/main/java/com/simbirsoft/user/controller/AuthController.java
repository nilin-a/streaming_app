package com.simbirsoft.user.controller;
import com.simbirsoft.user.config.JwtAuthenticationFilter;
import com.simbirsoft.user.dto.SignInRequest;
import com.simbirsoft.user.dto.SignUpRequest;
import com.simbirsoft.user.dto.UserDTO;
import com.simbirsoft.user.service.AuthenticationService;
import com.simbirsoft.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    @GetMapping("/sign-in-page")
    public String signInPage(@ModelAttribute("user") SignInRequest signInRequest) {
        return "auth/sign-in";
    }

    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("user") @Valid SignInRequest signInRequest, HttpServletResponse response) {

        response.addCookie(new Cookie(
                JwtAuthenticationFilter.HEADER_NAME,
                JwtAuthenticationFilter.BEARER_PREFIX + authenticationService.signIn(signInRequest).getToken()
        ));
        return "redirect:/auth/menu";
    }

    @GetMapping("/sign-up-page")
    public String signUpPage(@ModelAttribute("user") SignUpRequest signUpRequest) {
        return "auth/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("user") @Valid SignUpRequest signUpRequest) {
        authenticationService.signUp(signUpRequest);
        return "redirect:/auth/menu";
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        UserDTO user = userService.getCurrentUser();
        model.addAttribute("user", user);
        return "menu";
    }

    @GetMapping("/log-out")
    public String logOut(HttpServletResponse response) {
        authenticationService.logOut();
        response.addCookie(new Cookie(JwtAuthenticationFilter.HEADER_NAME, ""));
        return "auth/sign-in";
    }

}
