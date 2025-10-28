package com.gnk.bnkproto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GNK 그린은행 메인 애플리케이션
 * 
 * @author GNK Team
 * @version 1.0
 */
@SpringBootApplication
public class BnkProtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BnkProtoApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("🌿 GNK 그린은행 서버가 시작되었습니다!");
        System.out.println("🌐 http://localhost:8080");
        System.out.println("========================================\n");
    }
}

