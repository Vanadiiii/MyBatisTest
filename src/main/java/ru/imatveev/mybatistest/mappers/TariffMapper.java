package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import ru.imatveev.mybatistest.domain.entity.Tariff;

@Mapper
public interface TariffMapper {
    @Select("select * from tariff where id = #{id}")
    @Result(property = "id", column = "id", id = true)
    @Result(property = "descr", column = "descr")
    Tariff getTariffById(@Param("id") int id);
}
