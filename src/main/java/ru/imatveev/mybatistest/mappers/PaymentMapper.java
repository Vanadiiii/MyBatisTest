package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.*;
import ru.imatveev.mybatistest.domain.entity.Payment;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PaymentMapper {
    @Select("select * from payment p where ref_subscriber = #{id}")
    @Result(property = "id", column = "id", id = true)
    @Result(property = "summa", column = "summa")
    List<Payment> getPaymentsBySubscriberId(@Param("id") int id);

    @Select("select * from payment where id = #{id};")
    @Results(id = "paymentMap",
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "summa", column = "summa")
            })
    Optional<Payment> getPaymentById(@Param("id") int id);
}
