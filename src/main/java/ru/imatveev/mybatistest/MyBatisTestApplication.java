package ru.imatveev.mybatistest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.imatveev.mybatistest.mappers.SubscriberMapper;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class MyBatisTestApplication implements CommandLineRunner {
    private final SubscriberMapper subscriberMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisTestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("subscriber with id = {} -> {}", 1, subscriberMapper.getSubscriberById(1).getId());

        log.info("all subscribers -> {}", subscriberMapper.findAll());
    }
}
