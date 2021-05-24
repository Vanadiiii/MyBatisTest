package ru.imatveev.mybatistest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("ru.imatveev.mybatistest.mappers")
public class MyBatisConfiguration {
}
