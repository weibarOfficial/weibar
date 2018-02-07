package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ConfigController {

    @RequestMapping(value = "/MP_verify_7qm8PpRJuG7GvPzC.txt" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object config(HttpServletRequest request, HttpServletResponse response) {
        return "7qm8PpRJuG7GvPzC";
    }
}
