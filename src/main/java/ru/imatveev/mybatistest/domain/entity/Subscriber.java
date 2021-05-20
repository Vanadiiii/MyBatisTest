package ru.imatveev.mybatistest.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Subscriber {
    private Long id;
    private String name;
    private Tariff tariff;
    private List<Payment> payments;
}
