package com.msproject.pet.service;

import com.msproject.pet.entity.*;
import com.msproject.pet.exception.DuplicateUserIdException;
import com.msproject.pet.exception.WithdrawalException;
import com.msproject.pet.repository.BoardReplyRepository;
import com.msproject.pet.repository.ReviewRepository;
import com.msproject.pet.repository.UserHistoryRepository;
import com.msproject.pet.repository.WishRepository;
import com.msproject.pet.web.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final UserRepositoryCustom userRepositoryCustom;

    private final UserHistoryRepository userHistoryRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final JavaMailSender mailSender;

    private final ReviewRepository reviewRepository;

    private final WishRepository wishRepository;

    private final BoardRepository boardRepository;

    private final BoardReplyRepository boardReplyRepository;

    //private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        UserEntity userEntity = userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        //UserEntity userEntity = userRepositoryCustom.findByUserId(username);

//        if(userEntity.isDeleteYn()){
//            throw new WithdrawalException();
//        }

        if (userEntity.getUserId().equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(userEntity.getUserId(), userEntity.getUserPw(), authorities);
    }

    @Transactional
    public UserEntity saveUser(UserDto userDto) throws Exception{

        System.out.println(userDto.getUserId());
        System.out.println(userDto.getDetailAddr());
        validateDuplicateEmail(userDto.getUserId());

        UserEntity userEntity = UserEntity.builder()
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .userName(userDto.getUserName())
                .phoneNum(userDto.getPhoneNum())
                .zipCode(userDto.getZipCode())
                .addr(userDto.getAddr())
                .email(userDto.getEmail())
                .detailAddr(userDto.getDetailAddr())
                .build();

        return userRepository.save(userEntity);
    }

    private void validateDuplicateEmail(String userId) {
//        if (userRepositoryCustom.CheckExistsByUserId(userId)) {
//            throw new DuplicateUserIdException();
//        }
    }

     public Boolean checkId(String userId){
        //return userRepositoryCustom.CheckExistsByUserId(userId);
        return userRepository.existsByUserId(userId);
     }

    //, get, update, delete
    public UserEntity update(UserDto userDto){
        UserEntity entity = userRepository.findByUserId(userDto.getUserId()).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

        //userDto.setUpdatedAt(LocalDateTime.now());

        entity.change(userDto.getUserName(),userDto.getPhoneNum(),userDto.getZipCode(), userDto.getAddr(), userDto.getDetailAddr(),userDto.getEmail());

        return userRepository.save(entity);
    }

    public void delete(Long id){

        UserEntity entity = userRepository.findById(id).orElseThrow(()->new RuntimeException("존재하지 않는 유저입니다."));

//        entity.changeState();
//        userRepository.save(entity);

        List<ReviewEntity> reviewEntities = reviewRepository.findByUserEntity(entity);
        for (ReviewEntity entity1 : reviewEntities) {
            entity1.changeDeleteState();
        }
        List<BoardEntity> boardEntities = boardRepository.findByUserEntity(entity);
        for (BoardEntity boardEntity : boardEntities) {
            boardEntity.changeDeleteState();
        }
        List<BoardReply> boardReplies = boardReplyRepository.findByUserEntity(entity);

        for (BoardReply boardReply : boardReplies){
            boardReplyRepository.delete(boardReply);
            //boardReply.changeDeleteState();
        }


        UserHistory userHistory = UserHistory.builder()
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .userName(entity.getUserName())
                .phoneNum(entity.getPhoneNum())
                .zipCode(entity.getZipCode())
                .addr(entity.getAddr())
                .detailAddr(entity.getDetailAddr())
                .email(entity.getEmail())
                .build();

        userHistoryRepository.save(userHistory);

        userRepositoryCustom.delete(entity.getIdx());
        //userRepository.delete(entity);
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

        //return userRepositoryCustom.existsByEmail(email);
        return userRepository.existsByEmail(email);
    }

    public UserEntity findId(FindUserIdDto findUserIdDto) {

        Boolean check = userRepository.existsByUserNameAndEmail(findUserIdDto.getUserName(), findUserIdDto.getEmail());

        if(check){
            Optional<UserEntity> user = userRepository.findByUserNameAndEmail(findUserIdDto.getUserName(), findUserIdDto.getEmail());
            UserEntity userEntity = user.orElseThrow();
            return userEntity;
        }else{
            return null;
        }
//        Optional<UserEntity> user = userRepository.findByUserNameAndEmail(findUserIdDto.getUserName(), findUserIdDto.getEmail());
//        UserEntity userEntity = user.orElseThrow();
    }

    public UserEntity findPw(String userEmail) {

//        Boolean check = userRepository.existsByUserNameAndEmail(findUserIdDto.getUserName(), findUserIdDto.getEmail());
        Boolean check = userRepository.existsByEmail(userEmail);

        if(check){
            Optional<UserEntity> user = userRepository.findByEmail(userEmail);
            UserEntity userEntity = user.orElseThrow();

            MailDto mailDto = createMailAndChangePassword(userEntity);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            mailSend(mailDto);

            return userEntity;

        }else{
            return null;
        }
    }

    public MailDto createMailAndChangePassword(UserEntity userEntity) {

        String str = getTempPassword();

        MailDto dto = new MailDto();

        dto.setAddress(userEntity.getEmail());
        dto.setTitle("AnimalH 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. AnimalH 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 "
                + str + " 입니다." + "로그인 후에 비밀번호를 변경을 해주세요");


        userEntity.changePw(passwordEncoder.encode(str));

        userRepository.save(userEntity);


        return dto;
    }

//    public void updatePassword(String str, String userEmail){
//        String memberPassword = str;
//
//        Long memberId = mr.findByMemberEmail(userEmail).getId();
//        mmr.updatePassword(memberId,memberPassword);
//    }

    private String getTempPassword() {

        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

    public void mailSend(MailDto mailDTO) {
        System.out.println("전송 완료!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDTO.getAddress());
        message.setSubject(mailDTO.getTitle());
        message.setText(mailDTO.getMessage());
        message.setFrom("kssjjh123@gmail.com");
        message.setReplyTo("kssjjh123@gmail.com");
        System.out.println("message"+message);
        mailSender.send(message);
    }

    public Boolean updatePw(UserPwChangeDto userPwChangeDto) {
        Optional<UserEntity> user = userRepository.findById(userPwChangeDto.getIdx());
        UserEntity userEntity = user.orElseThrow();

        if(passwordEncoder.matches(userPwChangeDto.getPassword(),userEntity.getUserPw())){
            userEntity.changePw(passwordEncoder.encode(userPwChangeDto.getNewPassword()));

            userRepository.save(userEntity);

            return true;
        }else{
            return false;
        }

    }
}
