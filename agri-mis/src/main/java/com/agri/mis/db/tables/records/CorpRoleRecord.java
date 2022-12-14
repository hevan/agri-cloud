/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CorpRole;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CorpRoleRecord extends UpdatableRecordImpl<CorpRoleRecord> implements Record3<Long, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.corp_role.id</code>.
     */
    public CorpRoleRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_role.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.corp_role.name</code>.
     */
    public CorpRoleRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_role.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.corp_role.corp_id</code>.
     */
    public CorpRoleRecord setCorpId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_role.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, String, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CorpRole.CORP_ROLE.ID;
    }

    @Override
    public Field<String> field2() {
        return CorpRole.CORP_ROLE.NAME;
    }

    @Override
    public Field<Long> field3() {
        return CorpRole.CORP_ROLE.CORP_ID;
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
    public Long component3() {
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
    public Long value3() {
        return getCorpId();
    }

    @Override
    public CorpRoleRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CorpRoleRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CorpRoleRecord value3(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public CorpRoleRecord values(Long value1, String value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CorpRoleRecord
     */
    public CorpRoleRecord() {
        super(CorpRole.CORP_ROLE);
    }

    /**
     * Create a detached, initialised CorpRoleRecord
     */
    public CorpRoleRecord(Long id, String name, Long corpId) {
        super(CorpRole.CORP_ROLE);

        setId(id);
        setName(name);
        setCorpId(corpId);
    }

    /**
     * Create a detached, initialised CorpRoleRecord
     */
    public CorpRoleRecord(com.agri.mis.db.tables.pojos.CorpRole value) {
        super(CorpRole.CORP_ROLE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setCorpId(value.getCorpId());
        }
    }
}
