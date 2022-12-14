/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.MisAccountTitle;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MisAccountTitleRecord extends UpdatableRecordImpl<MisAccountTitleRecord> implements Record8<Long, String, String, String, String, Long, Long, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mis_account_title.id</code>.
     */
    public MisAccountTitleRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mis_account_title.name</code>.
     */
    public MisAccountTitleRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mis_account_title.code</code>.
     */
    public MisAccountTitleRecord setCode(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.code</code>.
     */
    public String getCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.mis_account_title.description</code>.
     */
    public MisAccountTitleRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.mis_account_title.category</code>.
     */
    public MisAccountTitleRecord setCategory(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.category</code>.
     */
    public String getCategory() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.mis_account_title.parent_id</code>.
     */
    public MisAccountTitleRecord setParentId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.mis_account_title.corp_id</code>.
     */
    public MisAccountTitleRecord setCorpId(Long value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.mis_account_title.direction</code>.
     */
    public MisAccountTitleRecord setDirection(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_account_title.direction</code>.
     */
    public Integer getDirection() {
        return (Integer) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, String, String, String, String, Long, Long, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<Long, String, String, String, String, Long, Long, Integer> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.ID;
    }

    @Override
    public Field<String> field2() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.NAME;
    }

    @Override
    public Field<String> field3() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.CODE;
    }

    @Override
    public Field<String> field4() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.DESCRIPTION;
    }

    @Override
    public Field<String> field5() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.CATEGORY;
    }

    @Override
    public Field<Long> field6() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.PARENT_ID;
    }

    @Override
    public Field<Long> field7() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.CORP_ID;
    }

    @Override
    public Field<Integer> field8() {
        return MisAccountTitle.MIS_ACCOUNT_TITLE.DIRECTION;
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
    public String component4() {
        return getDescription();
    }

    @Override
    public String component5() {
        return getCategory();
    }

    @Override
    public Long component6() {
        return getParentId();
    }

    @Override
    public Long component7() {
        return getCorpId();
    }

    @Override
    public Integer component8() {
        return getDirection();
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
    public String value4() {
        return getDescription();
    }

    @Override
    public String value5() {
        return getCategory();
    }

    @Override
    public Long value6() {
        return getParentId();
    }

    @Override
    public Long value7() {
        return getCorpId();
    }

    @Override
    public Integer value8() {
        return getDirection();
    }

    @Override
    public MisAccountTitleRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value3(String value) {
        setCode(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value4(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value5(String value) {
        setCategory(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value6(Long value) {
        setParentId(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value7(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord value8(Integer value) {
        setDirection(value);
        return this;
    }

    @Override
    public MisAccountTitleRecord values(Long value1, String value2, String value3, String value4, String value5, Long value6, Long value7, Integer value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MisAccountTitleRecord
     */
    public MisAccountTitleRecord() {
        super(MisAccountTitle.MIS_ACCOUNT_TITLE);
    }

    /**
     * Create a detached, initialised MisAccountTitleRecord
     */
    public MisAccountTitleRecord(Long id, String name, String code, String description, String category, Long parentId, Long corpId, Integer direction) {
        super(MisAccountTitle.MIS_ACCOUNT_TITLE);

        setId(id);
        setName(name);
        setCode(code);
        setDescription(description);
        setCategory(category);
        setParentId(parentId);
        setCorpId(corpId);
        setDirection(direction);
    }

    /**
     * Create a detached, initialised MisAccountTitleRecord
     */
    public MisAccountTitleRecord(com.agri.mis.db.tables.pojos.MisAccountTitle value) {
        super(MisAccountTitle.MIS_ACCOUNT_TITLE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCode(value.getCode());
            setDescription(value.getDescription());
            setCategory(value.getCategory());
            setParentId(value.getParentId());
            setCorpId(value.getCorpId());
            setDirection(value.getDirection());
        }
    }
}
