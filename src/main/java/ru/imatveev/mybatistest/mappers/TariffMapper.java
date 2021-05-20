package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.Mapper;
import ru.imatveev.mybatistest.domain.entity.Tariff;

public interface TariffMapper {
    Tariff getTariffById(Integer id);
}
