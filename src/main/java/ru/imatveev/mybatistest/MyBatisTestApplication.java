package ru.imatveev.mybatistest;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.imatveev.mybatistest.domain.entity.Subscriber;
import ru.imatveev.mybatistest.mappers.SubscriberMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Slf4j
public class MyBatisTestApplication {
    public static void main(String[] args) {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            SubscriberMapper subscriberMapper = sqlSessionFactory
                    .openSession()
                    .getMapper(SubscriberMapper.class);

            List<Subscriber> subscribers = subscriberMapper.getSubscribers();
            Subscriber subscriber = subscriberMapper.getSubscriberById(1);

            System.out.println();
            log.info("all subscribers -> {}", subscribers.toString());
            log.info("subscriber with id = 1 -> {}", subscriber.toString());

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
