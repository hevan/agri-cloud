/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.BatchRiskRecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function13;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row13;
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
public class BatchRisk extends TableImpl<BatchRiskRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.batch_risk</code>
     */
    public static final BatchRisk BATCH_RISK = new BatchRisk();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BatchRiskRecord> getRecordType() {
        return BatchRiskRecord.class;
    }

    /**
     * The column <code>public.batch_risk.id</code>.
     */
    public final TableField<BatchRiskRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("nextval('batch_risk_id'::regclass)", SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.batch_risk.product_id</code>.
     */
    public final TableField<BatchRiskRecord, Long> PRODUCT_ID = createField(DSL.name("product_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_risk.batch_id</code>.
     */
    public final TableField<BatchRiskRecord, Long> BATCH_ID = createField(DSL.name("batch_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_risk.cycle_name</code>.
     */
    public final TableField<BatchRiskRecord, String> CYCLE_NAME = createField(DSL.name("cycle_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.batch_risk.risk_category</code>.
     */
    public final TableField<BatchRiskRecord, String> RISK_CATEGORY = createField(DSL.name("risk_category"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.batch_risk.discription</code>.
     */
    public final TableField<BatchRiskRecord, String> DISCRIPTION = createField(DSL.name("discription"), SQLDataType.VARCHAR(1000), this, "");

    /**
     * The column <code>public.batch_risk.solution</code>.
     */
    public final TableField<BatchRiskRecord, String> SOLUTION = createField(DSL.name("solution"), SQLDataType.VARCHAR(1000), this, "");

    /**
     * The column <code>public.batch_risk.fee_amount</code>.
     */
    public final TableField<BatchRiskRecord, BigDecimal> FEE_AMOUNT = createField(DSL.name("fee_amount"), SQLDataType.NUMERIC(12, 2), this, "");

    /**
     * The column <code>public.batch_risk.created_user_id</code>.
     */
    public final TableField<BatchRiskRecord, Long> CREATED_USER_ID = createField(DSL.name("created_user_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_risk.created_by</code>.
     */
    public final TableField<BatchRiskRecord, String> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.batch_risk.occur_date</code>.
     */
    public final TableField<BatchRiskRecord, LocalDate> OCCUR_DATE = createField(DSL.name("occur_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.batch_risk.created_at</code>.
     */
    public final TableField<BatchRiskRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.batch_risk.corp_id</code>.
     */
    public final TableField<BatchRiskRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT, this, "");

    private BatchRisk(Name alias, Table<BatchRiskRecord> aliased) {
        this(alias, aliased, null);
    }

    private BatchRisk(Name alias, Table<BatchRiskRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.batch_risk</code> table reference
     */
    public BatchRisk(String alias) {
        this(DSL.name(alias), BATCH_RISK);
    }

    /**
     * Create an aliased <code>public.batch_risk</code> table reference
     */
    public BatchRisk(Name alias) {
        this(alias, BATCH_RISK);
    }

    /**
     * Create a <code>public.batch_risk</code> table reference
     */
    public BatchRisk() {
        this(DSL.name("batch_risk"), null);
    }

    public <O extends Record> BatchRisk(Table<O> child, ForeignKey<O, BatchRiskRecord> key) {
        super(child, key, BATCH_RISK);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<BatchRiskRecord> getPrimaryKey() {
        return Keys.BATCH_RISK_PKEY;
    }

    @Override
    public BatchRisk as(String alias) {
        return new BatchRisk(DSL.name(alias), this);
    }

    @Override
    public BatchRisk as(Name alias) {
        return new BatchRisk(alias, this);
    }

    @Override
    public BatchRisk as(Table<?> alias) {
        return new BatchRisk(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchRisk rename(String name) {
        return new BatchRisk(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchRisk rename(Name name) {
        return new BatchRisk(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchRisk rename(Table<?> name) {
        return new BatchRisk(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, Long, Long, String, String, String, String, BigDecimal, Long, String, LocalDate, LocalDateTime, Long> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function13<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super String, ? super String, ? super BigDecimal, ? super Long, ? super String, ? super LocalDate, ? super LocalDateTime, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function13<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super String, ? super String, ? super BigDecimal, ? super Long, ? super String, ? super LocalDate, ? super LocalDateTime, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
