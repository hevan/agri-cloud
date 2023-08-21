/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.BatchProduct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BatchProductRecord extends UpdatableRecordImpl<BatchProductRecord> implements Record17<Long, String, String, Long, LocalDate, LocalDate, Integer, BigDecimal, Double, Long, String, Long, Long, LocalDateTime, String, Integer, Double> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.batch_product.id</code>.
     */
    public BatchProductRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.batch_product.name</code>.
     */
    public BatchProductRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.batch_product.code</code>.
     */
    public BatchProductRecord setCode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.code</code>.
     */
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.batch_product.product_id</code>.
     */
    public BatchProductRecord setProductId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.product_id</code>.
     */
    public Long getProductId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.batch_product.start_at</code>.
     */
    public BatchProductRecord setStartAt(LocalDate value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.start_at</code>.
     */
    public LocalDate getStartAt() {
        return (LocalDate) get(4);
    }

    /**
     * Setter for <code>public.batch_product.end_at</code>.
     */
    public BatchProductRecord setEndAt(LocalDate value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.end_at</code>.
     */
    public LocalDate getEndAt() {
        return (LocalDate) get(5);
    }

    /**
     * Setter for <code>public.batch_product.days</code>.
     */
    public BatchProductRecord setDays(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.days</code>.
     */
    public Integer getDays() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.batch_product.estimated_price</code>.
     */
    public BatchProductRecord setEstimatedPrice(BigDecimal value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.estimated_price</code>.
     */
    public BigDecimal getEstimatedPrice() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>public.batch_product.area</code>.
     */
    public BatchProductRecord setArea(Double value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.area</code>.
     */
    public Double getArea() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>public.batch_product.corp_id</code>.
     */
    public BatchProductRecord setCorpId(Long value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.batch_product.calc_unit</code>.
     */
    public BatchProductRecord setCalcUnit(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.calc_unit</code>.
     */
    public String getCalcUnit() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.batch_product.park_id</code>.
     */
    public BatchProductRecord setParkId(Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.park_id</code>.
     */
    public Long getParkId() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.batch_product.created_user_id</code>.
     */
    public BatchProductRecord setCreatedUserId(Long value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.batch_product.created_at</code>.
     */
    public BatchProductRecord setCreatedAt(LocalDateTime value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>public.batch_product.description</code>.
     */
    public BatchProductRecord setDescription(String value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.description</code>.
     */
    public String getDescription() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.batch_product.status</code>.
     */
    public BatchProductRecord setStatus(Integer value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.status</code>.
     */
    public Integer getStatus() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>public.batch_product.quantity</code>.
     */
    public BatchProductRecord setQuantity(Double value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_product.quantity</code>.
     */
    public Double getQuantity() {
        return (Double) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row17<Long, String, String, Long, LocalDate, LocalDate, Integer, BigDecimal, Double, Long, String, Long, Long, LocalDateTime, String, Integer, Double> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    @Override
    public Row17<Long, String, String, Long, LocalDate, LocalDate, Integer, BigDecimal, Double, Long, String, Long, Long, LocalDateTime, String, Integer, Double> valuesRow() {
        return (Row17) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BatchProduct.BATCH_PRODUCT.ID;
    }

    @Override
    public Field<String> field2() {
        return BatchProduct.BATCH_PRODUCT.NAME;
    }

    @Override
    public Field<String> field3() {
        return BatchProduct.BATCH_PRODUCT.CODE;
    }

    @Override
    public Field<Long> field4() {
        return BatchProduct.BATCH_PRODUCT.PRODUCT_ID;
    }

    @Override
    public Field<LocalDate> field5() {
        return BatchProduct.BATCH_PRODUCT.START_AT;
    }

    @Override
    public Field<LocalDate> field6() {
        return BatchProduct.BATCH_PRODUCT.END_AT;
    }

    @Override
    public Field<Integer> field7() {
        return BatchProduct.BATCH_PRODUCT.DAYS;
    }

    @Override
    public Field<BigDecimal> field8() {
        return BatchProduct.BATCH_PRODUCT.ESTIMATED_PRICE;
    }

    @Override
    public Field<Double> field9() {
        return BatchProduct.BATCH_PRODUCT.AREA;
    }

    @Override
    public Field<Long> field10() {
        return BatchProduct.BATCH_PRODUCT.CORP_ID;
    }

    @Override
    public Field<String> field11() {
        return BatchProduct.BATCH_PRODUCT.CALC_UNIT;
    }

    @Override
    public Field<Long> field12() {
        return BatchProduct.BATCH_PRODUCT.PARK_ID;
    }

    @Override
    public Field<Long> field13() {
        return BatchProduct.BATCH_PRODUCT.CREATED_USER_ID;
    }

    @Override
    public Field<LocalDateTime> field14() {
        return BatchProduct.BATCH_PRODUCT.CREATED_AT;
    }

    @Override
    public Field<String> field15() {
        return BatchProduct.BATCH_PRODUCT.DESCRIPTION;
    }

    @Override
    public Field<Integer> field16() {
        return BatchProduct.BATCH_PRODUCT.STATUS;
    }

    @Override
    public Field<Double> field17() {
        return BatchProduct.BATCH_PRODUCT.QUANTITY;
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
        return getCode();
    }

    @Override
    public Long component4() {
        return getProductId();
    }

    @Override
    public LocalDate component5() {
        return getStartAt();
    }

    @Override
    public LocalDate component6() {
        return getEndAt();
    }

    @Override
    public Integer component7() {
        return getDays();
    }

    @Override
    public BigDecimal component8() {
        return getEstimatedPrice();
    }

    @Override
    public Double component9() {
        return getArea();
    }

    @Override
    public Long component10() {
        return getCorpId();
    }

    @Override
    public String component11() {
        return getCalcUnit();
    }

    @Override
    public Long component12() {
        return getParkId();
    }

    @Override
    public Long component13() {
        return getCreatedUserId();
    }

    @Override
    public LocalDateTime component14() {
        return getCreatedAt();
    }

    @Override
    public String component15() {
        return getDescription();
    }

    @Override
    public Integer component16() {
        return getStatus();
    }

    @Override
    public Double component17() {
        return getQuantity();
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
        return getCode();
    }

    @Override
    public Long value4() {
        return getProductId();
    }

    @Override
    public LocalDate value5() {
        return getStartAt();
    }

    @Override
    public LocalDate value6() {
        return getEndAt();
    }

    @Override
    public Integer value7() {
        return getDays();
    }

    @Override
    public BigDecimal value8() {
        return getEstimatedPrice();
    }

    @Override
    public Double value9() {
        return getArea();
    }

    @Override
    public Long value10() {
        return getCorpId();
    }

    @Override
    public String value11() {
        return getCalcUnit();
    }

    @Override
    public Long value12() {
        return getParkId();
    }

    @Override
    public Long value13() {
        return getCreatedUserId();
    }

    @Override
    public LocalDateTime value14() {
        return getCreatedAt();
    }

    @Override
    public String value15() {
        return getDescription();
    }

    @Override
    public Integer value16() {
        return getStatus();
    }

    @Override
    public Double value17() {
        return getQuantity();
    }

    @Override
    public BatchProductRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BatchProductRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BatchProductRecord value3(String value) {
        setCode(value);
        return this;
    }

    @Override
    public BatchProductRecord value4(Long value) {
        setProductId(value);
        return this;
    }

    @Override
    public BatchProductRecord value5(LocalDate value) {
        setStartAt(value);
        return this;
    }

    @Override
    public BatchProductRecord value6(LocalDate value) {
        setEndAt(value);
        return this;
    }

    @Override
    public BatchProductRecord value7(Integer value) {
        setDays(value);
        return this;
    }

    @Override
    public BatchProductRecord value8(BigDecimal value) {
        setEstimatedPrice(value);
        return this;
    }

    @Override
    public BatchProductRecord value9(Double value) {
        setArea(value);
        return this;
    }

    @Override
    public BatchProductRecord value10(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public BatchProductRecord value11(String value) {
        setCalcUnit(value);
        return this;
    }

    @Override
    public BatchProductRecord value12(Long value) {
        setParkId(value);
        return this;
    }

    @Override
    public BatchProductRecord value13(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public BatchProductRecord value14(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public BatchProductRecord value15(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BatchProductRecord value16(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public BatchProductRecord value17(Double value) {
        setQuantity(value);
        return this;
    }

    @Override
    public BatchProductRecord values(Long value1, String value2, String value3, Long value4, LocalDate value5, LocalDate value6, Integer value7, BigDecimal value8, Double value9, Long value10, String value11, Long value12, Long value13, LocalDateTime value14, String value15, Integer value16, Double value17) {
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
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BatchProductRecord
     */
    public BatchProductRecord() {
        super(BatchProduct.BATCH_PRODUCT);
    }

    /**
     * Create a detached, initialised BatchProductRecord
     */
    public BatchProductRecord(Long id, String name, String code, Long productId, LocalDate startAt, LocalDate endAt, Integer days, BigDecimal estimatedPrice, Double area, Long corpId, String calcUnit, Long parkId, Long createdUserId, LocalDateTime createdAt, String description, Integer status, Double quantity) {
        super(BatchProduct.BATCH_PRODUCT);

        setId(id);
        setName(name);
        setCode(code);
        setProductId(productId);
        setStartAt(startAt);
        setEndAt(endAt);
        setDays(days);
        setEstimatedPrice(estimatedPrice);
        setArea(area);
        setCorpId(corpId);
        setCalcUnit(calcUnit);
        setParkId(parkId);
        setCreatedUserId(createdUserId);
        setCreatedAt(createdAt);
        setDescription(description);
        setStatus(status);
        setQuantity(quantity);
    }

    /**
     * Create a detached, initialised BatchProductRecord
     */
    public BatchProductRecord(com.agri.mis.db.tables.pojos.BatchProduct value) {
        super(BatchProduct.BATCH_PRODUCT);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCode(value.getCode());
            setProductId(value.getProductId());
            setStartAt(value.getStartAt());
            setEndAt(value.getEndAt());
            setDays(value.getDays());
            setEstimatedPrice(value.getEstimatedPrice());
            setArea(value.getArea());
            setCorpId(value.getCorpId());
            setCalcUnit(value.getCalcUnit());
            setParkId(value.getParkId());
            setCreatedUserId(value.getCreatedUserId());
            setCreatedAt(value.getCreatedAt());
            setDescription(value.getDescription());
            setStatus(value.getStatus());
            setQuantity(value.getQuantity());
        }
    }
}
