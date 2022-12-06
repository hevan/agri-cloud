/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.MarkProductCycle;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MarkProductCycleRecord extends UpdatableRecordImpl<MarkProductCycleRecord> implements Record10<Long, String, String, String, Long, Integer, BigDecimal, Long, LocalDate, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mark_product_cycle.id</code>.
     */
    public MarkProductCycleRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mark_product_cycle.name</code>.
     */
    public MarkProductCycleRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mark_product_cycle.description</code>.
     */
    public MarkProductCycleRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.mark_product_cycle.image_url</code>.
     */
    public MarkProductCycleRecord setImageUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.mark_product_cycle.product_batch_id</code>.
     */
    public MarkProductCycleRecord setProductBatchId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.product_batch_id</code>.
     */
    public Long getProductBatchId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.mark_product_cycle.days</code>.
     */
    public MarkProductCycleRecord setDays(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.days</code>.
     */
    public Integer getDays() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.mark_product_cycle.amount</code>.
     */
    public MarkProductCycleRecord setAmount(BigDecimal value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>public.mark_product_cycle.parent_id</code>.
     */
    public MarkProductCycleRecord setParentId(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.mark_product_cycle.start_at</code>.
     */
    public MarkProductCycleRecord setStartAt(LocalDate value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.start_at</code>.
     */
    public LocalDate getStartAt() {
        return (LocalDate) get(8);
    }

    /**
     * Setter for <code>public.mark_product_cycle.end_at</code>.
     */
    public MarkProductCycleRecord setEndAt(LocalDate value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product_cycle.end_at</code>.
     */
    public LocalDate getEndAt() {
        return (LocalDate) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, String, Long, Integer, BigDecimal, Long, LocalDate, LocalDate> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, String, String, String, Long, Integer, BigDecimal, Long, LocalDate, LocalDate> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.ID;
    }

    @Override
    public Field<String> field2() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.NAME;
    }

    @Override
    public Field<String> field3() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.IMAGE_URL;
    }

    @Override
    public Field<Long> field5() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.PRODUCT_BATCH_ID;
    }

    @Override
    public Field<Integer> field6() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.DAYS;
    }

    @Override
    public Field<BigDecimal> field7() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.AMOUNT;
    }

    @Override
    public Field<Long> field8() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.PARENT_ID;
    }

    @Override
    public Field<LocalDate> field9() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.START_AT;
    }

    @Override
    public Field<LocalDate> field10() {
        return MarkProductCycle.MARK_PRODUCT_CYCLE.END_AT;
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
    public Long component5() {
        return getProductBatchId();
    }

    @Override
    public Integer component6() {
        return getDays();
    }

    @Override
    public BigDecimal component7() {
        return getAmount();
    }

    @Override
    public Long component8() {
        return getParentId();
    }

    @Override
    public LocalDate component9() {
        return getStartAt();
    }

    @Override
    public LocalDate component10() {
        return getEndAt();
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
    public Long value5() {
        return getProductBatchId();
    }

    @Override
    public Integer value6() {
        return getDays();
    }

    @Override
    public BigDecimal value7() {
        return getAmount();
    }

    @Override
    public Long value8() {
        return getParentId();
    }

    @Override
    public LocalDate value9() {
        return getStartAt();
    }

    @Override
    public LocalDate value10() {
        return getEndAt();
    }

    @Override
    public MarkProductCycleRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value4(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value5(Long value) {
        setProductBatchId(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value6(Integer value) {
        setDays(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value7(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value8(Long value) {
        setParentId(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value9(LocalDate value) {
        setStartAt(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord value10(LocalDate value) {
        setEndAt(value);
        return this;
    }

    @Override
    public MarkProductCycleRecord values(Long value1, String value2, String value3, String value4, Long value5, Integer value6, BigDecimal value7, Long value8, LocalDate value9, LocalDate value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MarkProductCycleRecord
     */
    public MarkProductCycleRecord() {
        super(MarkProductCycle.MARK_PRODUCT_CYCLE);
    }

    /**
     * Create a detached, initialised MarkProductCycleRecord
     */
    public MarkProductCycleRecord(Long id, String name, String description, String imageUrl, Long productBatchId, Integer days, BigDecimal amount, Long parentId, LocalDate startAt, LocalDate endAt) {
        super(MarkProductCycle.MARK_PRODUCT_CYCLE);

        setId(id);
        setName(name);
        setDescription(description);
        setImageUrl(imageUrl);
        setProductBatchId(productBatchId);
        setDays(days);
        setAmount(amount);
        setParentId(parentId);
        setStartAt(startAt);
        setEndAt(endAt);
    }

    /**
     * Create a detached, initialised MarkProductCycleRecord
     */
    public MarkProductCycleRecord(com.agri.mis.db.tables.pojos.MarkProductCycle value) {
        super(MarkProductCycle.MARK_PRODUCT_CYCLE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDescription(value.getDescription());
            setImageUrl(value.getImageUrl());
            setProductBatchId(value.getProductBatchId());
            setDays(value.getDays());
            setAmount(value.getAmount());
            setParentId(value.getParentId());
            setStartAt(value.getStartAt());
            setEndAt(value.getEndAt());
        }
    }
}
