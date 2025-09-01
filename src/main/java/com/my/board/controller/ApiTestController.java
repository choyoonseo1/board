package com.my.board.controller;

import com.my.board.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ApiTestController {
    @GetMapping("/api")
    public String apiMain() {
        return "test/api";
    }

    @GetMapping("/apiTest")
    @ResponseBody
    // 클래스 데이터를 json으로 변경해서 보내줌
    public LoginDto getTest() {
        return new LoginDto("choyoonseo","1234");
    }

    @GetMapping("/stringTest")
    @ResponseBody
    public String postString() {
        return "스트링데이터보냄";
    }

    @PostMapping("/apiEntityTest")
    // @RequestBody에서 직접 받으려면 JSON으로 전달해야 함.
    public ResponseEntity<String> apiEntityTest(@RequestBody LoginDto dto) {
        String info = dto.getUserId() + " / " + dto.getPassword();
        return ResponseEntity.status(HttpStatus.OK)
                .body(info);
    }

    @PostMapping("/mapTest")
    @ResponseBody
    public Map<String, String> apiMapTest(@RequestBody LoginDto dto){
        Map<String, String> map = new HashMap<>();
        map.put("아이디", dto.getUserId());
        map.put("비번", dto.getPassword());
        return map;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "삭제가 되었습니다.";
    }
}
