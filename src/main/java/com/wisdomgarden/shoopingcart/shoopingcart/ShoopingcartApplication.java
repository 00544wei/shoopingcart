package com.wisdomgarden.shoopingcart.shoopingcart;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoopingcartApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ShoopingcartApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


}
