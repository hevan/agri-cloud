/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.BatchCycleRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function15;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row15;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BatchCycle extends TableImpl<BatchCycleRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.batch_cycle</code>
     */
    public static final BatchCycle BATCH_CYCLE = new BatchCycle();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BatchCycleRecord> getRecordType() {
        return BatchCycleRecord.class;
    }

    /**
     * The column <code>public.batch_cycle.id</code>.
     */
    public final TableField<BatchCycleRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.batch_cycle.name</code>.
     */
    public final TableField<BatchCycleRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.batch_cycle.description</code>.
     */
    public final TableField<BatchCycleRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.batch_cycle.image_url</code>.
     */
    public final TableField<BatchCycleRecord, String> IMAGE_URL = createField(DSL.name("image_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.batch_cycle.days</code>.
     */
    public final TableField<BatchCycleRecord, Integer> DAYS = createField(DSL.name("days"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.batch_cycle.start_at</code>.
     */
    public final TableField<BatchCycleRecord, LocalDate> START_AT = createField(DSL.name("start_at"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.batch_cycle.end_at</code>.
     */
    public final TableField<BatchCycleRecord, LocalDate> END_AT = createField(DSL.name("end_at"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.batch_cycle.batch_id</code>.
     */
    public final TableField<BatchCycleRecord, Long> BATCH_ID = createField(DSL.name("batch_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle.status</code>.
     */
    public final TableField<BatchCycleRecord, Short> STATUS = createField(DSL.name("status"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.batch_cycle.parent_id</code>.
     */
    public final TableField<BatchCycleRecord, Long> PARENT_ID = createField(DSL.name("parent_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle.progress</code>.
     */
    public final TableField<BatchCycleRecord, Double> PROGRESS = createField(DSL.name("progress"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.batch_cycle.created_user_id</code>.
     */
    public final TableField<BatchCycleRecord, Long> CREATED_USER_ID = createField(DSL.name("created_user_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle.created_by</code>.
     */
    public final TableField<BatchCycleRecord, String> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.batch_cycle.created_at</code>.
     */
    public final TableField<BatchCycleRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.batch_cycle.cycle_type</code>.
     */
    public final TableField<BatchCycleRecord, Short> CYCLE_TYPE = createField(DSL.name("cycle_type"), SQLDataType.SMALLINT, this, "");

    private BatchCycle(Name alias, Table<BatchCycleRecord> aliased) {
        this(alias, aliased, null);
    }

    private BatchCycle(Name alias, Table<BatchCycleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.batch_cycle</code> table reference
     */
    public BatchCycle(String alias) {
        this(DSL.name(alias), BATCH_CYCLE);
    }

    /**
     * Create an aliased <code>public.batch_cycle</code> table reference
     */
    public BatchCycle(Name alias) {
        this(alias, BATCH_CYCLE);
    }

    /**
     * Create a <code>public.batch_cycle</code> table reference
     */
    public BatchCycle() {
        this(DSL.name("batch_cycle"), null);
    }

    public <O extends Record> BatchCycle(Table<O> child, ForeignKey<O, BatchCycleRecord> key) {
        super(child, key, BATCH_CYCLE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<BatchCycleRecord, Long> getIdentity() {
        return (Identity<BatchCycleRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<BatchCycleRecord> getPrimaryKey() {
        return Keys.BATCH_CYCLE_PKEY;
    }

    @Override
    public BatchCycle as(String alias) {
        return new BatchCycle(DSL.name(alias), this);
    }

    @Override
    public BatchCycle as(Name alias) {
        return new BatchCycle(alias, this);
    }

    @Override
    public BatchCycle as(Table<?> alias) {
        return new BatchCycle(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycle rename(String name) {
        return new BatchCycle(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycle rename(Name name) {
        return new BatchCycle(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycle rename(Table<?> name) {
        return new BatchCycle(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, String, String, String, Integer, LocalDate, LocalDate, Long, Short, Long, Double, Long, String, LocalDateTime, Short> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function15<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super LocalDate, ? super LocalDate, ? super Long, ? super Short, ? super Long, ? super Double, ? super Long, ? super String, ? super LocalDateTime, ? super Short, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function15<? super Long, ? super String, ? super String, ? super String, ? super Integer, ? super LocalDate, ? super LocalDate, ? super Long, ? super Short, ? super Long, ? super Double, ? super Long, ? super String, ? super LocalDateTime, ? super Short, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
