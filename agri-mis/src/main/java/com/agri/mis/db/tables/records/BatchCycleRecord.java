/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.BatchCycle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BatchCycleRecord extends UpdatableRecordImpl<BatchCycleRecord> implements Record16<Long, String, String, String, Integer, LocalDate, LocalDate, Long, Short, Long, Double, Long, LocalDateTime, Short, BigDecimal, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.batch_cycle.id</code>.
     */
    public BatchCycleRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.batch_cycle.name</code>.
     */
    public BatchCycleRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.batch_cycle.description</code>.
     */
    public BatchCycleRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.batch_cycle.image_url</code>.
     */
    public BatchCycleRecord setImageUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.batch_cycle.days</code>.
     */
    public BatchCycleRecord setDays(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.days</code>.
     */
    public Integer getDays() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.batch_cycle.start_at</code>.
     */
    public BatchCycleRecord setStartAt(LocalDate value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.start_at</code>.
     */
    public LocalDate getStartAt() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>public.batch_cycle.end_at</code>.
     */
    public BatchCycleRecord setEndAt(LocalDate value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.end_at</code>.
     */
    public LocalDate getEndAt() {
        return (LocalDate) get(6);
    }

    /**
     * Setter for <code>public.batch_cycle.batch_id</code>.
     */
    public BatchCycleRecord setBatchId(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.batch_id</code>.
     */
    public Long getBatchId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.batch_cycle.status</code>.
     */
    public BatchCycleRecord setStatus(Short value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.status</code>.
     */
    public Short getStatus() {
        return (Short) get(8);
    }

    /**
     * Setter for <code>public.batch_cycle.parent_id</code>.
     */
    public BatchCycleRecord setParentId(Long value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.batch_cycle.progress</code>.
     */
    public BatchCycleRecord setProgress(Double value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.progress</code>.
     */
    public Double getProgress() {
        return (Double) get(10);
    }

    /**
     * Setter for <code>public.batch_cycle.created_user_id</code>.
     */
    public BatchCycleRecord setCreatedUserId(Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.batch_cycle.created_at</code>.
     */
    public BatchCycleRecord setCreatedAt(LocalDateTime value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(12);
    }

    /**
     * Setter for <code>public.batch_cycle.cycle_type</code>.
     */
    public BatchCycleRecord setCycleType(Short value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.cycle_type</code>.
     */
    public Short getCycleType() {
        return (Short) get(13);
    }

    /**
     * Setter for <code>public.batch_cycle.invest_estimated</code>.
     */
    public BatchCycleRecord setInvestEstimated(BigDecimal value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.invest_estimated</code>.
     */
    public BigDecimal getInvestEstimated() {
        return (BigDecimal) get(14);
    }

    /**
     * Setter for <code>public.batch_cycle.corp_id</code>.
     */
    public BatchCycleRecord setCorpId(Long value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row16<Long, String, String, String, Integer, LocalDate, LocalDate, Long, Short, Long, Double, Long, LocalDateTime, Short, BigDecimal, Long> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    @Override
    public Row16<Long, String, String, String, Integer, LocalDate, LocalDate, Long, Short, Long, Double, Long, LocalDateTime, Short, BigDecimal, Long> valuesRow() {
        return (Row16) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BatchCycle.BATCH_CYCLE.ID;
    }

    @Override
    public Field<String> field2() {
        return BatchCycle.BATCH_CYCLE.NAME;
    }

    @Override
    public Field<String> field3() {
        return BatchCycle.BATCH_CYCLE.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return BatchCycle.BATCH_CYCLE.IMAGE_URL;
    }

    @Override
    public Field<Integer> field5() {
        return BatchCycle.BATCH_CYCLE.DAYS;
    }

    @Override
    public Field<LocalDate> field6() {
        return BatchCycle.BATCH_CYCLE.START_AT;
    }

    @Override
    public Field<LocalDate> field7() {
        return BatchCycle.BATCH_CYCLE.END_AT;
    }

    @Override
    public Field<Long> field8() {
        return BatchCycle.BATCH_CYCLE.BATCH_ID;
    }

    @Override
    public Field<Short> field9() {
        return BatchCycle.BATCH_CYCLE.STATUS;
    }

    @Override
    public Field<Long> field10() {
        return BatchCycle.BATCH_CYCLE.PARENT_ID;
    }

    @Override
    public Field<Double> field11() {
        return BatchCycle.BATCH_CYCLE.PROGRESS;
    }

    @Override
    public Field<Long> field12() {
        return BatchCycle.BATCH_CYCLE.CREATED_USER_ID;
    }

    @Override
    public Field<LocalDateTime> field13() {
        return BatchCycle.BATCH_CYCLE.CREATED_AT;
    }

    @Override
    public Field<Short> field14() {
        return BatchCycle.BATCH_CYCLE.CYCLE_TYPE;
    }

    @Override
    public Field<BigDecimal> field15() {
        return BatchCycle.BATCH_CYCLE.INVEST_ESTIMATED;
    }

    @Override
    public Field<Long> field16() {
        return BatchCycle.BATCH_CYCLE.CORP_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public String component4() {
        return getImageUrl();
    }

    @Override
    public Integer component5() {
        return getDays();
    }

    @Override
    public LocalDate component6() {
        return getStartAt();
    }

    @Override
    public LocalDate component7() {
        return getEndAt();
    }

    @Override
    public Long component8() {
        return getBatchId();
    }

    @Override
    public Short component9() {
        return getStatus();
    }

    @Override
    public Long component10() {
        return getParentId();
    }

    @Override
    public Double component11() {
        return getProgress();
    }

    @Override
    public Long component12() {
        return getCreatedUserId();
    }

    @Override
    public LocalDateTime component13() {
        return getCreatedAt();
    }

    @Override
    public Short component14() {
        return getCycleType();
    }

    @Override
    public BigDecimal component15() {
        return getInvestEstimated();
    }

    @Override
    public Long component16() {
        return getCorpId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public String value4() {
        return getImageUrl();
    }

    @Override
    public Integer value5() {
        return getDays();
    }

    @Override
    public LocalDate value6() {
        return getStartAt();
    }

    @Override
    public LocalDate value7() {
        return getEndAt();
    }

    @Override
    public Long value8() {
        return getBatchId();
    }

    @Override
    public Short value9() {
        return getStatus();
    }

    @Override
    public Long value10() {
        return getParentId();
    }

    @Override
    public Double value11() {
        return getProgress();
    }

    @Override
    public Long value12() {
        return getCreatedUserId();
    }

    @Override
    public LocalDateTime value13() {
        return getCreatedAt();
    }

    @Override
    public Short value14() {
        return getCycleType();
    }

    @Override
    public BigDecimal value15() {
        return getInvestEstimated();
    }

    @Override
    public Long value16() {
        return getCorpId();
    }

    @Override
    public BatchCycleRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BatchCycleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BatchCycleRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BatchCycleRecord value4(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public BatchCycleRecord value5(Integer value) {
        setDays(value);
        return this;
    }

    @Override
    public BatchCycleRecord value6(LocalDate value) {
        setStartAt(value);
        return this;
    }

    @Override
    public BatchCycleRecord value7(LocalDate value) {
        setEndAt(value);
        return this;
    }

    @Override
    public BatchCycleRecord value8(Long value) {
        setBatchId(value);
        return this;
    }

    @Override
    public BatchCycleRecord value9(Short value) {
        setStatus(value);
        return this;
    }

    @Override
    public BatchCycleRecord value10(Long value) {
        setParentId(value);
        return this;
    }

    @Override
    public BatchCycleRecord value11(Double value) {
        setProgress(value);
        return this;
    }

    @Override
    public BatchCycleRecord value12(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public BatchCycleRecord value13(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public BatchCycleRecord value14(Short value) {
        setCycleType(value);
        return this;
    }

    @Override
    public BatchCycleRecord value15(BigDecimal value) {
        setInvestEstimated(value);
        return this;
    }

    @Override
    public BatchCycleRecord value16(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public BatchCycleRecord values(Long value1, String value2, String value3, String value4, Integer value5, LocalDate value6, LocalDate value7, Long value8, Short value9, Long value10, Double value11, Long value12, LocalDateTime value13, Short value14, BigDecimal value15, Long value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BatchCycleRecord
     */
    public BatchCycleRecord() {
        super(BatchCycle.BATCH_CYCLE);
    }

    /**
     * Create a detached, initialised BatchCycleRecord
     */
    public BatchCycleRecord(Long id, String name, String description, String imageUrl, Integer days, LocalDate startAt, LocalDate endAt, Long batchId, Short status, Long parentId, Double progress, Long createdUserId, LocalDateTime createdAt, Short cycleType, BigDecimal investEstimated, Long corpId) {
        super(BatchCycle.BATCH_CYCLE);

        setId(id);
        setName(name);
        setDescription(description);
        setImageUrl(imageUrl);
        setDays(days);
        setStartAt(startAt);
        setEndAt(endAt);
        setBatchId(batchId);
        setStatus(status);
        setParentId(parentId);
        setProgress(progress);
        setCreatedUserId(createdUserId);
        setCreatedAt(createdAt);
        setCycleType(cycleType);
        setInvestEstimated(investEstimated);
        setCorpId(corpId);
    }

    /**
     * Create a detached, initialised BatchCycleRecord
     */
    public BatchCycleRecord(com.agri.mis.db.tables.pojos.BatchCycle value) {
        super(BatchCycle.BATCH_CYCLE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDescription(value.getDescription());
            setImageUrl(value.getImageUrl());
            setDays(value.getDays());
            setStartAt(value.getStartAt());
            setEndAt(value.getEndAt());
            setBatchId(value.getBatchId());
            setStatus(value.getStatus());
            setParentId(value.getParentId());
            setProgress(value.getProgress());
            setCreatedUserId(value.getCreatedUserId());
            setCreatedAt(value.getCreatedAt());
            setCycleType(value.getCycleType());
            setInvestEstimated(value.getInvestEstimated());
            setCorpId(value.getCorpId());
        }
    }
}
