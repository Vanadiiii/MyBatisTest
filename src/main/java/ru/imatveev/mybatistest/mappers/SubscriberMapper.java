package ru.imatveev.mybatistest.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import ru.imatveev.mybatistest.domain.entity.Subscriber;
import ru.imatveev.mybatistest.domain.entity.Tariff;

import java.util.List;
import java.util.Optional;

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
    Optional<Subscriber> getSubscriberById(@Param("id") int id);

    @Select("select * from subscriber")
    @ResultMap("subscriberSubSelectMap")
    List<Subscriber> findAllBySubSelects();

    @Select("select s.*, p.id p_id, p.summa p_summa, t.id t_id, t.descr t_descr" +
            " from subscriber s " +
            " left join payment p on s.id = p.ref_subscriber " +
            " left join tariff t on t.id = s.ref_tariff")
    @Results(id = "subscriberJoinMap",
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name"),
                    @Result(property = "payments",
                            javaType = List.class,
                            many = @Many(columnPrefix = "p_", resultMap = "ru.imatveev.mybatistest.mappers.PaymentMapper.paymentMap")),
                    @Result(property = "tariff",
                            javaType = Tariff.class,
                            one = @One(columnPrefix = "t_", resultMap = "ru.imatveev.mybatistest.mappers.TariffMapper.tariffMap")
                    )
            })
    List<Subscriber> findAllByJoins();
}