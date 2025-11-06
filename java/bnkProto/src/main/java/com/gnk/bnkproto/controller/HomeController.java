package com.gnk.bnkproto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 홈 컨트롤러
 * 메인 페이지 및 기본 라우팅을 담당합니다.
 */
@Controller
public class HomeController {

    /**
     * 메인 페이지
     */
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }
    
    /**
     * 헬스체크 엔드포인트
     */
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}

