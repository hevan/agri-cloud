/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.MisAccountBillRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function21;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row21;
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
public class MisAccountBill extends TableImpl<MisAccountBillRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.mis_account_bill</code>
     */
    public static final MisAccountBill MIS_ACCOUNT_BILL = new MisAccountBill();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MisAccountBillRecord> getRecordType() {
        return MisAccountBillRecord.class;
    }

    /**
     * The column <code>public.mis_account_bill.id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.mis_account_bill.bill_name</code>.
     */
    public final TableField<MisAccountBillRecord, String> BILL_NAME = createField(DSL.name("bill_name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.mis_account_bill.amount</code>.
     */
    public final TableField<MisAccountBillRecord, BigDecimal> AMOUNT = createField(DSL.name("amount"), SQLDataType.NUMERIC(12, 3), this, "");

    /**
     * The column <code>public.mis_account_bill.customer_id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_account_bill.order_id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_account_bill.direction</code>.
     */
    public final TableField<MisAccountBillRecord, Integer> DIRECTION = createField(DSL.name("direction"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.mis_account_bill.occur_at</code>.
     */
    public final TableField<MisAccountBillRecord, LocalDateTime> OCCUR_AT = createField(DSL.name("occur_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.mis_account_bill.end_at</code>.
     */
    public final TableField<MisAccountBillRecord, LocalDateTime> END_AT = createField(DSL.name("end_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.mis_account_bill.status</code>.
     */
    public final TableField<MisAccountBillRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER.defaultValue(DSL.field("1", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.mis_account_bill.batch_id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> BATCH_ID = createField(DSL.name("batch_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_account_bill.created_user_id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> CREATED_USER_ID = createField(DSL.name("created_user_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_account_bill.created_at</code>.
     */
    public final TableField<MisAccountBillRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.mis_account_bill.created_by</code>.
     */
    public final TableField<MisAccountBillRecord, String> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.mis_account_bill.updted_at</code>.
     */
    public final TableField<MisAccountBillRecord, LocalDateTime> UPDTED_AT = createField(DSL.name("updted_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.mis_account_bill.updated_by</code>.
     */
    public final TableField<MisAccountBillRecord, String> UPDATED_BY = createField(DSL.name("updated_by"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.mis_account_bill.corp_id</code>.
     */
    public final TableField<MisAccountBillRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_account_bill.bill_no</code>.
     */
    public final TableField<MisAccountBillRecord, String> BILL_NO = createField(DSL.name("bill_no"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.mis_account_bill.bill_type</code>.
     */
    public final TableField<MisAccountBillRecord, String> BILL_TYPE = createField(DSL.name("bill_type"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.mis_account_bill.check_status</code>.
     */
    public final TableField<MisAccountBillRecord, Integer> CHECK_STATUS = createField(DSL.name("check_status"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.mis_account_bill.quantity</code>.
     */
    public final TableField<MisAccountBillRecord, Double> QUANTITY = createField(DSL.name("quantity"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>public.mis_account_bill.order_type</code>.
     */
    public final TableField<MisAccountBillRecord, String> ORDER_TYPE = createField(DSL.name("order_type"), SQLDataType.VARCHAR(50), this, "");

    private MisAccountBill(Name alias, Table<MisAccountBillRecord> aliased) {
        this(alias, aliased, null);
    }

    private MisAccountBill(Name alias, Table<MisAccountBillRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.mis_account_bill</code> table reference
     */
    public MisAccountBill(String alias) {
        this(DSL.name(alias), MIS_ACCOUNT_BILL);
    }

    /**
     * Create an aliased <code>public.mis_account_bill</code> table reference
     */
    public MisAccountBill(Name alias) {
        this(alias, MIS_ACCOUNT_BILL);
    }

    /**
     * Create a <code>public.mis_account_bill</code> table reference
     */
    public MisAccountBill() {
        this(DSL.name("mis_account_bill"), null);
    }

    public <O extends Record> MisAccountBill(Table<O> child, ForeignKey<O, MisAccountBillRecord> key) {
        super(child, key, MIS_ACCOUNT_BILL);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<MisAccountBillRecord, Long> getIdentity() {
        return (Identity<MisAccountBillRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MisAccountBillRecord> getPrimaryKey() {
        return Keys.ACCOUNT_PEND_PKEY;
    }

    @Override
    public MisAccountBill as(String alias) {
        return new MisAccountBill(DSL.name(alias), this);
    }

    @Override
    public MisAccountBill as(Name alias) {
        return new MisAccountBill(alias, this);
    }

    @Override
    public MisAccountBill as(Table<?> alias) {
        return new MisAccountBill(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public MisAccountBill rename(String name) {
        return new MisAccountBill(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MisAccountBill rename(Name name) {
        return new MisAccountBill(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public MisAccountBill rename(Table<?> name) {
        return new MisAccountBill(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row21 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row21<Long, String, BigDecimal, Long, Long, Integer, LocalDateTime, LocalDateTime, Integer, Long, Long, LocalDateTime, String, LocalDateTime, String, Long, String, String, Integer, Double, String> fieldsRow() {
        return (Row21) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function21<? super Long, ? super String, ? super BigDecimal, ? super Long, ? super Long, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? super Integer, ? super Long, ? super Long, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? super String, ? super Long, ? super String, ? super String, ? super Integer, ? super Double, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function21<? super Long, ? super String, ? super BigDecimal, ? super Long, ? super Long, ? super Integer, ? super LocalDateTime, ? super LocalDateTime, ? super Integer, ? super Long, ? super Long, ? super LocalDateTime, ? super String, ? super LocalDateTime, ? super String, ? super Long, ? super String, ? super String, ? super Integer, ? super Double, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
