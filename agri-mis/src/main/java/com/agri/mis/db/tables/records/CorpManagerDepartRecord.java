/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CorpManagerDepart;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CorpManagerDepartRecord extends UpdatableRecordImpl<CorpManagerDepartRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.corp_manager_depart.id</code>.
     */
    public CorpManagerDepartRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_manager_depart.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.corp_manager_depart.manager_id</code>.
     */
    public CorpManagerDepartRecord setManagerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_manager_depart.manager_id</code>.
     */
    public Long getManagerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.corp_manager_depart.depart_id</code>.
     */
    public CorpManagerDepartRecord setDepartId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_manager_depart.depart_id</code>.
     */
    public Long getDepartId() {
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
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CorpManagerDepart.CORP_MANAGER_DEPART.ID;
    }

    @Override
    public Field<Long> field2() {
        return CorpManagerDepart.CORP_MANAGER_DEPART.MANAGER_ID;
    }

    @Override
    public Field<Long> field3() {
        return CorpManagerDepart.CORP_MANAGER_DEPART.DEPART_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getManagerId();
    }

    @Override
    public Long component3() {
        return getDepartId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getManagerId();
    }

    @Override
    public Long value3() {
        return getDepartId();
    }

    @Override
    public CorpManagerDepartRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CorpManagerDepartRecord value2(Long value) {
        setManagerId(value);
        return this;
    }

    @Override
    public CorpManagerDepartRecord value3(Long value) {
        setDepartId(value);
        return this;
    }

    @Override
    public CorpManagerDepartRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CorpManagerDepartRecord
     */
    public CorpManagerDepartRecord() {
        super(CorpManagerDepart.CORP_MANAGER_DEPART);
    }

    /**
     * Create a detached, initialised CorpManagerDepartRecord
     */
    public CorpManagerDepartRecord(Long id, Long managerId, Long departId) {
        super(CorpManagerDepart.CORP_MANAGER_DEPART);

        setId(id);
        setManagerId(managerId);
        setDepartId(departId);
    }

    /**
     * Create a detached, initialised CorpManagerDepartRecord
     */
    public CorpManagerDepartRecord(com.agri.mis.db.tables.pojos.CorpManagerDepart value) {
        super(CorpManagerDepart.CORP_MANAGER_DEPART);

        if (value != null) {
            setId(value.getId());
            setManagerId(value.getManagerId());
            setDepartId(value.getDepartId());
        }
    }
}
