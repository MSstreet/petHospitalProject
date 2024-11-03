package com.msproject.pet.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RequiredArgsConstructor
@CrossOrigin
@RestController
public class OAuthController {

    @GetMapping("/loginSuccess")
    public Map<String, Object> getUserInfo(OAuth2AuthenticationToken authentication) {
        Map<String, Object> userDetails = authentication.getPrincipal().getAttributes();
        System.out.println("카카오 사용자 정보: " + userDetails);
        return userDetails; // 사용자 정보 JSON 반환
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "로그인 실패";
    }
}
