package com.msproject.pet.service;

import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.entity.UserRepository;
import com.msproject.pet.exception.DuplicateUserIdException;
import com.msproject.pet.web.dtos.FindUserIdDto;
import com.msproject.pet.web.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserEntity userEntity = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (userEntity.getUserId().equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(userEntity.getUserId(), userEntity.getUserPw(), authorities);
    }

    @Transactional
    public UserEntity saveUser(UserDto userDto) throws Exception{

        System.out.println(userDto.getUserId());

        validateDuplicateEmail(userDto.getUserId());

        UserEntity userEntity = UserEntity.builder()
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .userName(userDto.getUserName())
                .phoneNum(userDto.getPhoneNum())
                .zipCode(userDto.getZipCode())
                .addr(userDto.getAddr())
                .email(userDto.getEmail())
                .build();

        return userRepository.save(userEntity);
    }

    private void validateDuplicateEmail(String userId) {

        if (userRepository.existsByUserId(userId)) {
            throw new DuplicateUserIdException();
        }
    }

     public Boolean checkId(String userId){
        return userRepository.existsByUserId(userId);
     }


    //, get, update, delete
    public UserEntity update(UserDto userDto){
        UserEntity entity = userRepository.findByUserId(userDto.getUserId()).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

        entity.change(userDto.getUserName(),userDto.getPhoneNum(),userDto.getZipCode(), userDto.getAddr(), userDto.getDetailAddr(),userDto.getEmail());

        return userRepository.save(entity);
    }

    public void delete(Long id){
        UserEntity entity = userRepository.findById(id).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

        userRepository.delete(entity);
    }

    public UserDto getUser(Long id){
        UserEntity entity = userRepository.findById(id).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

        return UserDto.builder()
                .idx(entity.getIdx())
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .userName(entity.getUserName())
                .phoneNum(entity.getPhoneNum())
                .zipCode(entity.getZipCode())
                .addr(entity.getAddr())
                .detailAddr(entity.getDetailAddr())
                .email(entity.getEmail())
                .build();
    }

    public UserDto getUser(String userId){
        UserEntity entity = userRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

        return UserDto.builder()
                .idx(entity.getIdx())
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .userName(entity.getUserName())
                .phoneNum(entity.getPhoneNum())
                .zipCode(entity.getZipCode())
                .addr(entity.getAddr())
                .detailAddr(entity.getDetailAddr())
                .email(entity.getEmail())
                .build();
    }

    public Boolean checkEmail(String email) {

        {
            return userRepository.existsByEmail(email);
        }
    }

    public UserEntity findId(FindUserIdDto findUserIdDto) {

        Optional<UserEntity> user = userRepository.findByUserNameAndEmail(findUserIdDto.getUserName(), findUserIdDto.getEmail());
        UserEntity userEntity = user.orElseThrow();
        return userEntity;
    }
}
