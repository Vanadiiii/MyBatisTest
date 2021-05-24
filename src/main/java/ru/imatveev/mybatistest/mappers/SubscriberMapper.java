package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import ru.imatveev.mybatistest.domain.entity.Subscriber;
import ru.imatveev.mybatistest.domain.entity.Tariff;

import java.util.List;

@Mapper
public interface SubscriberMapper {

    @Select("select * from subscriber where id = #{id}")
    @Results(id = "subscriberSubSelectMap",
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name"),
                    @Result(property = "payments",
                            column = "id",
                            javaType = List.class,
                            many = @Many(select = "ru.imatveev.mybatistest.mappers.PaymentMapper.getPaymentsBySubscriberId", fetchType = FetchType.LAZY)),
                    @Result(property = "tariff",
                            column = "ref_tariff",
                            javaType = Tariff.class,
                            one = @One(select = "ru.imatveev.mybatistest.mappers.TariffMapper.getTariffById", fetchType = FetchType.LAZY))
            })
    Subscriber getSubscriberById(@Param("id") int id);

    @Select("select * from subscriber")
    @ResultMap("subscriberSubSelectMap")
    List<Subscriber> findAll();
}