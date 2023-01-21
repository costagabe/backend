package com.project.backend.queries.impl;

import com.project.backend.domain.Transfer;
import com.project.backend.dtos.ChartsDTO;
import com.project.backend.queries.TransferQuery;
import com.project.backend.utils.transfer.enums.TransferQueryField;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class TransferQueryImpl implements TransferQuery {

    private final EntityManager entityManager;

    @Override
    public ChartsDTO getChartsValue() {
        Float dayValue = getTodayEntries(TransferQueryField.TRANSFER_VALUE).orElse(0F);
        Float weekValue = getWeekEntries(TransferQueryField.TRANSFER_VALUE).orElse(0F);
        Float monthValue = getMonthEntries(TransferQueryField.TRANSFER_VALUE).orElse(0F);

        Float dayFee = getTodayEntries(TransferQueryField.FEE).orElse(0F);
        Float weekFee = getWeekEntries(TransferQueryField.FEE).orElse(0F);
        Float monthFee = getMonthEntries(TransferQueryField.FEE).orElse(0F);

        return ChartsDTO
                .builder()
                .dayValue(dayValue)
                .monthValue(monthValue)
                .weekValue(weekValue)
                .dayFee(dayFee)
                .monthFee(monthFee)
                .weekFee(weekFee)
                .build();
    }

    private Optional<Float> getTodayEntries(TransferQueryField field) {
        return getTransfersBetweenDates(LocalDate.now(), LocalDate.now(), field);
    }

    private Optional<Float> getWeekEntries(TransferQueryField field) {

        LocalDate sunday = LocalDate.now().with(DayOfWeek.of(1));
        LocalDate saturday = LocalDate.now().with(DayOfWeek.of(7));

        return getTransfersBetweenDates(sunday, saturday, field);
    }

    private Optional<Float> getMonthEntries(TransferQueryField field) {
        LocalDate day1 = LocalDate.now().withDayOfMonth(1);
        LocalDate day2 = LocalDate.now()
                .withDayOfMonth(day1.getMonth().length(day1.isLeapYear()));

        return getTransfersBetweenDates(day1, day2, field);
    }

    private Optional<Float> getTransfersBetweenDates(LocalDate date1, LocalDate date2, TransferQueryField field) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Float> cq = cb.createQuery(Float.class);
        Root<Transfer> root = cq.from(Transfer.class);

        Expression<Float> total = cb.sum(root.get(field.getValue()));

        cq.select(total.alias("total"));

        cq.where(cb.between(root.get("scheduleDate"), date1, date2));

        final TypedQuery<Float> tq = entityManager.createQuery(cq);

        try {
            return tq.getResultList().stream().findFirst();
        } catch (NullPointerException e) {
            return Optional.of(0F);
        }
    }


}
