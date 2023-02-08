package com.msproject.pet.web;

import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.service.UserService;
import com.msproject.pet.util.JwtUtil;
import com.msproject.pet.web.dtos.FindUserIdDto;
import com.msproject.pet.web.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    //private final PasswordEncoder passwordEncoder;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @GetMapping("/check")
    public Boolean checkId(@RequestParam String userId){

        System.out.println(userId);
        System.out.println("컨트롤러에 들어와?");
        return userService.checkId(userId);
    }

    @GetMapping("/check/mail")
    public Boolean checkEmail(@RequestParam String email){

        System.out.println("check" + email);
        System.out.println("컨트롤러에 들어와?");
        return userService.checkEmail(email);
    }

    @PostMapping("/find")
    public String findId(@RequestBody FindUserIdDto findUserIdDto){

        System.out.println("들어오는지확인!!!");
        System.out.println(findUserIdDto.getUserName());
        System.out.println(findUserIdDto.getEmail());

        UserEntity user = userService.findId(findUserIdDto);
        return user.getUserId();

    }



    @PostMapping("/join")
    public Long saveUser(@RequestBody @Valid UserDto userDto) throws Exception {

        System.out.println(userDto.getUserId());

        System.out.println(userDto.getAddr());
        System.out.println(userDto.getZipCode());
        System.out.println(userDto.getDetailAddr());

        UserEntity user = userService.saveUser(userDto);


        return  user.getIdx();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> paramMap) {
        String userId = paramMap.get("user_id");
        String userPw = paramMap.get("user_pw");

        UserDetails loginUser = userService.loadUserByUsername(userId); //userId로 정보 가져오기

        Authentication authentication = authenticationManager.authenticate(     //가져온 정보와 입력한 비밀번호로 검증
                new UsernamePasswordAuthenticationToken(loginUser, userPw)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);   // 검증 통과 후 authentication 세팅

        String accessToken = jwtUtil.createToken(loginUser.getUsername(), loginUser.getUsername());     //accessToken 생성

        Map<String, Object> result = new HashMap<>();

        result.put("user_id", loginUser.getUsername());
        result.put("user_token", accessToken);
        result.put("user_role", loginUser.getAuthorities().stream().findFirst().get().getAuthority());

        result.put("user_idx",userService.getUser(userId).getIdx());
        //result.put("user_pw",userService.getUser(userId).getUserPw());

        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PatchMapping("/")
    public UserEntity update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

//    @GetMapping("/checkpw/{id}")
//    public String checkPw(@PathVariable Long id, @RequestParam String beforePw){
//
//        passwordEncoder.encode(beforePw);
//
//        String encodePw = userService.getUser(id).getUserPw();
//
//
//
//    }




















}
