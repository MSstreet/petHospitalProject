package com.msproject.pet.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/oauth")
@RestController
public class OAuthController {

    @ResponseBody
    @GetMapping("/kakao")
    public void kakaoCallback(@RequestParam String code){
        System.out.println(code);
    }
}
