package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.Mapper;
import ru.imatveev.mybatistest.domain.entity.Subscriber;

import java.util.List;

public interface SubscriberMapper {
    Subscriber getSubscriberById(int id);

    List<Subscriber> getSubscribers();
}
