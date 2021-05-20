package ru.imatveev.mybatistest.mappers;

import ru.imatveev.mybatistest.domain.entity.Payment;

import java.util.List;

public interface PaymentMapper {
    List<Payment> getPaymentsByIdSub(Integer id);
}
