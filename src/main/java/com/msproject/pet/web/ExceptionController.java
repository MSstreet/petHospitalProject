package com.msproject.pet.web;

import com.msproject.pet.exception.DuplicateUserIdException;
import com.msproject.pet.exception.InCorrectImageFileException;
import com.msproject.pet.exception.WithdrawalException;
import com.msproject.pet.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DuplicateUserIdException.class)
    public JSONObject duplicateEmailException(){
        return ErrorResponse.JsonErrorResponse(400, "중복된 이메일 입니다.");
    }

    @ExceptionHandler(InCorrectImageFileException.class)
    public JSONObject InCorrectImageFileException(){
        return ErrorResponse.JsonErrorResponse(401, "올바른 이미지 파일이 아닙니다.");
    }

    @ExceptionHandler(WithdrawalException.class)
    public JSONObject WithdrawalException(){
        return ErrorResponse.JsonErrorResponse(402, "탈퇴한 회원입니다.");
    }

}
