/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.Category;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CategoryRecord extends UpdatableRecordImpl<CategoryRecord> implements Record6<Long, String, String, String, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.category.id</code>.
     */
    public CategoryRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.category.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.category.path_name</code>.
     */
    public CategoryRecord setPathName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.category.path_name</code>.
     */
    public String getPathName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.category.name</code>.
     */
    public CategoryRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.category.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.category.image_url</code>.
     */
    public CategoryRecord setImageUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.category.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.category.parent_id</code>.
     */
    public CategoryRecord setParentId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.category.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.category.corp_id</code>.
     */
    public CategoryRecord setCorpId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.category.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String, Long, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Long, String, String, String, Long, Long> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Category.CATEGORY.ID;
    }

    @Override
    public Field<String> field2() {
        return Category.CATEGORY.PATH_NAME;
    }

    @Override
    public Field<String> field3() {
        return Category.CATEGORY.NAME;
    }

    @Override
    public Field<String> field4() {
        return Category.CATEGORY.IMAGE_URL;
    }

    @Override
    public Field<Long> field5() {
        return Category.CATEGORY.PARENT_ID;
    }

    @Override
    public Field<Long> field6() {
        return Category.CATEGORY.CORP_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPathName();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getImageUrl();
    }

    @Override
    public Long component5() {
        return getParentId();
    }

    @Override
    public Long component6() {
        return getCorpId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPathName();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getImageUrl();
    }

    @Override
    public Long value5() {
        return getParentId();
    }

    @Override
    public Long value6() {
        return getCorpId();
    }

    @Override
    public CategoryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CategoryRecord value2(String value) {
        setPathName(value);
        return this;
    }

    @Override
    public CategoryRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public CategoryRecord value4(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public CategoryRecord value5(Long value) {
        setParentId(value);
        return this;
    }

    @Override
    public CategoryRecord value6(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public CategoryRecord values(Long value1, String value2, String value3, String value4, Long value5, Long value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CategoryRecord
     */
    public CategoryRecord() {
        super(Category.CATEGORY);
    }

    /**
     * Create a detached, initialised CategoryRecord
     */
    public CategoryRecord(Long id, String pathName, String name, String imageUrl, Long parentId, Long corpId) {
        super(Category.CATEGORY);

        setId(id);
        setPathName(pathName);
        setName(name);
        setImageUrl(imageUrl);
        setParentId(parentId);
        setCorpId(corpId);
    }

    /**
     * Create a detached, initialised CategoryRecord
     */
    public CategoryRecord(com.agri.mis.db.tables.pojos.Category value) {
        super(Category.CATEGORY);

        if (value != null) {
            setId(value.getId());
            setPathName(value.getPathName());
            setName(value.getName());
            setImageUrl(value.getImageUrl());
            setParentId(value.getParentId());
            setCorpId(value.getCorpId());
        }
    }
}
