/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.BatchCycleExpenseRecord;

import java.math.BigDecimal;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function11;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row11;
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
public class BatchCycleExpense extends TableImpl<BatchCycleExpenseRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.batch_cycle_expense</code>
     */
    public static final BatchCycleExpense BATCH_CYCLE_EXPENSE = new BatchCycleExpense();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BatchCycleExpenseRecord> getRecordType() {
        return BatchCycleExpenseRecord.class;
    }

    /**
     * The column <code>public.batch_cycle_expense.id</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.batch_cycle_expense.batch_cycle_id</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Long> BATCH_CYCLE_ID = createField(DSL.name("batch_cycle_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle_expense.invest_product_id</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Long> INVEST_PRODUCT_ID = createField(DSL.name("invest_product_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle_expense.invest_product_name</code>.
     */
    public final TableField<BatchCycleExpenseRecord, String> INVEST_PRODUCT_NAME = createField(DSL.name("invest_product_name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.batch_cycle_expense.description</code>.
     */
    public final TableField<BatchCycleExpenseRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.batch_cycle_expense.invest_amount</code>.
     */
    public final TableField<BatchCycleExpenseRecord, BigDecimal> INVEST_AMOUNT = createField(DSL.name("invest_amount"), SQLDataType.NUMERIC(12, 2), this, "");

    /**
     * The column <code>public.batch_cycle_expense.invest_price</code>.
     */
    public final TableField<BatchCycleExpenseRecord, BigDecimal> INVEST_PRICE = createField(DSL.name("invest_price"), SQLDataType.NUMERIC(12, 2), this, "");

    /**
     * The column <code>public.batch_cycle_expense.invest_quantity</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Double> INVEST_QUANTITY = createField(DSL.name("invest_quantity"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>public.batch_cycle_expense.corp_id</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.batch_cycle_expense.batch_id</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Long> BATCH_ID = createField(DSL.name("batch_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.batch_cycle_expense.expense_type</code>.
     */
    public final TableField<BatchCycleExpenseRecord, Short> EXPENSE_TYPE = createField(DSL.name("expense_type"), SQLDataType.SMALLINT, this, "");

    private BatchCycleExpense(Name alias, Table<BatchCycleExpenseRecord> aliased) {
        this(alias, aliased, null);
    }

    private BatchCycleExpense(Name alias, Table<BatchCycleExpenseRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.batch_cycle_expense</code> table reference
     */
    public BatchCycleExpense(String alias) {
        this(DSL.name(alias), BATCH_CYCLE_EXPENSE);
    }

    /**
     * Create an aliased <code>public.batch_cycle_expense</code> table reference
     */
    public BatchCycleExpense(Name alias) {
        this(alias, BATCH_CYCLE_EXPENSE);
    }

    /**
     * Create a <code>public.batch_cycle_expense</code> table reference
     */
    public BatchCycleExpense() {
        this(DSL.name("batch_cycle_expense"), null);
    }

    public <O extends Record> BatchCycleExpense(Table<O> child, ForeignKey<O, BatchCycleExpenseRecord> key) {
        super(child, key, BATCH_CYCLE_EXPENSE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<BatchCycleExpenseRecord> getPrimaryKey() {
        return Keys.BATCH_CYCLE_EXPENSE_PKEY;
    }

    @Override
    public BatchCycleExpense as(String alias) {
        return new BatchCycleExpense(DSL.name(alias), this);
    }

    @Override
    public BatchCycleExpense as(Name alias) {
        return new BatchCycleExpense(alias, this);
    }

    @Override
    public BatchCycleExpense as(Table<?> alias) {
        return new BatchCycleExpense(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycleExpense rename(String name) {
        return new BatchCycleExpense(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycleExpense rename(Name name) {
        return new BatchCycleExpense(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BatchCycleExpense rename(Table<?> name) {
        return new BatchCycleExpense(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<Long, Long, Long, String, String, BigDecimal, BigDecimal, Double, Long, Long, Short> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function11<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super BigDecimal, ? super BigDecimal, ? super Double, ? super Long, ? super Long, ? super Short, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function11<? super Long, ? super Long, ? super Long, ? super String, ? super String, ? super BigDecimal, ? super BigDecimal, ? super Double, ? super Long, ? super Long, ? super Short, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
