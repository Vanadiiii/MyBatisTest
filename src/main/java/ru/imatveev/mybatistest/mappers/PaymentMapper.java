package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import ru.imatveev.mybatistest.domain.entity.Payment;

import java.util.List;

@Mapper
public interface PaymentMapper {
    @Select("select * from payment p where ref_subscriber = #{id}")
    @Result(property = "id", column = "id", id = true)
    @Result(property = "summa", column = "summa")
    List<Payment> getPaymentsBySubscriberId(@Param("id") int id);
}
