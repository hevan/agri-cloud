/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CmsTag;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmsTagRecord extends UpdatableRecordImpl<CmsTagRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.cms_tag.id</code>.
     */
    public CmsTagRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_tag.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.cms_tag.name</code>.
     */
    public CmsTagRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_tag.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CmsTag.CMS_TAG.ID;
    }

    @Override
    public Field<String> field2() {
        return CmsTag.CMS_TAG.NAME;
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
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public CmsTagRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CmsTagRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CmsTagRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CmsTagRecord
     */
    public CmsTagRecord() {
        super(CmsTag.CMS_TAG);
    }

    /**
     * Create a detached, initialised CmsTagRecord
     */
    public CmsTagRecord(Long id, String name) {
        super(CmsTag.CMS_TAG);

        setId(id);
        setName(name);
    }

    /**
     * Create a detached, initialised CmsTagRecord
     */
    public CmsTagRecord(com.agri.mis.db.tables.pojos.CmsTag value) {
        super(CmsTag.CMS_TAG);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
        }
    }
}
