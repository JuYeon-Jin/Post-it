package com.jjy.postmy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.jjy.postmy.dao")
public class MybatisConfig {
    // 여러가지 빈 설정 등을 추가
}
