/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.MarkProduct;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MarkProductRecord extends UpdatableRecordImpl<MarkProductRecord> implements Record7<Long, String, String, Long, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mark_product.id</code>.
     */
    public MarkProductRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mark_product.name</code>.
     */
    public MarkProductRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mark_product.code</code>.
     */
    public MarkProductRecord setCode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.code</code>.
     */
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.mark_product.category_id</code>.
     */
    public MarkProductRecord setCategoryId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.category_id</code>.
     */
    public Long getCategoryId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.mark_product.image_url</code>.
     */
    public MarkProductRecord setImageUrl(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.mark_product.calc_unit</code>.
     */
    public MarkProductRecord setCalcUnit(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.calc_unit</code>.
     */
    public String getCalcUnit() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.mark_product.description</code>.
     */
    public MarkProductRecord setDescription(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.mark_product.description</code>.
     */
    public String getDescription() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, String, String, Long, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, String, String, Long, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MarkProduct.MARK_PRODUCT.ID;
    }

    @Override
    public Field<String> field2() {
        return MarkProduct.MARK_PRODUCT.NAME;
    }

    @Override
    public Field<String> field3() {
        return MarkProduct.MARK_PRODUCT.CODE;
    }

    @Override
    public Field<Long> field4() {
        return MarkProduct.MARK_PRODUCT.CATEGORY_ID;
    }

    @Override
    public Field<String> field5() {
        return MarkProduct.MARK_PRODUCT.IMAGE_URL;
    }

    @Override
    public Field<String> field6() {
        return MarkProduct.MARK_PRODUCT.CALC_UNIT;
    }

    @Override
    public Field<String> field7() {
        return MarkProduct.MARK_PRODUCT.DESCRIPTION;
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
        return getCategoryId();
    }

    @Override
    public String component5() {
        return getImageUrl();
    }

    @Override
    public String component6() {
        return getCalcUnit();
    }

    @Override
    public String component7() {
        return getDescription();
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
        return getCategoryId();
    }

    @Override
    public String value5() {
        return getImageUrl();
    }

    @Override
    public String value6() {
        return getCalcUnit();
    }

    @Override
    public String value7() {
        return getDescription();
    }

    @Override
    public MarkProductRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MarkProductRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MarkProductRecord value3(String value) {
        setCode(value);
        return this;
    }

    @Override
    public MarkProductRecord value4(Long value) {
        setCategoryId(value);
        return this;
    }

    @Override
    public MarkProductRecord value5(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public MarkProductRecord value6(String value) {
        setCalcUnit(value);
        return this;
    }

    @Override
    public MarkProductRecord value7(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MarkProductRecord values(Long value1, String value2, String value3, Long value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MarkProductRecord
     */
    public MarkProductRecord() {
        super(MarkProduct.MARK_PRODUCT);
    }

    /**
     * Create a detached, initialised MarkProductRecord
     */
    public MarkProductRecord(Long id, String name, String code, Long categoryId, String imageUrl, String calcUnit, String description) {
        super(MarkProduct.MARK_PRODUCT);

        setId(id);
        setName(name);
        setCode(code);
        setCategoryId(categoryId);
        setImageUrl(imageUrl);
        setCalcUnit(calcUnit);
        setDescription(description);
    }

    /**
     * Create a detached, initialised MarkProductRecord
     */
    public MarkProductRecord(com.agri.mis.db.tables.pojos.MarkProduct value) {
        super(MarkProduct.MARK_PRODUCT);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCode(value.getCode());
            setCategoryId(value.getCategoryId());
            setImageUrl(value.getImageUrl());
            setCalcUnit(value.getCalcUnit());
            setDescription(value.getDescription());
        }
    }
}
