package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.*;
import ru.imatveev.mybatistest.domain.entity.Tariff;

import java.util.Optional;

@Mapper
public interface TariffMapper {
    @Select("select * from tariff where id = #{id}")
    @Results(id = "tariffMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "descr", column = "descr")
    })
    Optional<Tariff> getTariffById(@Param("id") int id);
}
