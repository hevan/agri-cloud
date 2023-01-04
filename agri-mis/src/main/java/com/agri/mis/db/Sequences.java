/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.account_pend_id_seq</code>
     */
    public static final Sequence<Long> ACCOUNT_PEND_ID_SEQ = Internal.createSequence("account_pend_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.account_title_id_seq</code>
     */
    public static final Sequence<Long> ACCOUNT_TITLE_ID_SEQ = Internal.createSequence("account_title_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.batch_risk_id</code>
     */
    public static final Sequence<Long> BATCH_RISK_ID = Internal.createSequence("batch_risk_id", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 999999999999L, false, null);

    /**
     * The sequence <code>public.check_process_id_seq</code>
     */
    public static final Sequence<Long> CHECK_PROCESS_ID_SEQ = Internal.createSequence("check_process_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.cms_video_id_seq</code>
     */
    public static final Sequence<Long> CMS_VIDEO_ID_SEQ = Internal.createSequence("cms_video_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.contract_id_seq</code>
     */
    public static final Sequence<Long> CONTRACT_ID_SEQ = Internal.createSequence("contract_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.corp_manage_id_seq</code>
     */
    public static final Sequence<Long> CORP_MANAGE_ID_SEQ = Internal.createSequence("corp_manage_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.market_id_seq</code>
     */
    public static final Sequence<Long> MARKET_ID_SEQ = Internal.createSequence("market_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.mk_category_id_seq</code>
     */
    public static final Sequence<Long> MK_CATEGORY_ID_SEQ = Internal.createSequence("mk_category_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.mk_product_id_seq</code>
     */
    public static final Sequence<Long> MK_PRODUCT_ID_SEQ = Internal.createSequence("mk_product_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.park_base_id_seq</code>
     */
    public static final Sequence<Long> PARK_BASE_ID_SEQ = Internal.createSequence("park_base_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.park_id_seq</code>
     */
    public static final Sequence<Long> PARK_ID_SEQ = Internal.createSequence("park_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.product_batch_id_seq</code>
     */
    public static final Sequence<Long> PRODUCT_BATCH_ID_SEQ = Internal.createSequence("product_batch_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.product_cycle_expense_id_seq</code>
     */
    public static final Sequence<Long> PRODUCT_CYCLE_EXPENSE_ID_SEQ = Internal.createSequence("product_cycle_expense_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, 2147483647, false, null);

    /**
     * The sequence <code>public.product_cycle_id_seq</code>
     */
    public static final Sequence<Long> PRODUCT_CYCLE_ID_SEQ = Internal.createSequence("product_cycle_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.product_market_id_seq</code>
     */
    public static final Sequence<Long> PRODUCT_MARKET_ID_SEQ = Internal.createSequence("product_market_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.product_risk_id_seq</code>
     */
    public static final Sequence<Long> PRODUCT_RISK_ID_SEQ = Internal.createSequence("product_risk_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.production_order_id_seq</code>
     */
    public static final Sequence<Long> PRODUCTION_ORDER_ID_SEQ = Internal.createSequence("production_order_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.production_order_item_id_seq</code>
     */
    public static final Sequence<Long> PRODUCTION_ORDER_ITEM_ID_SEQ = Internal.createSequence("production_order_item_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.purchase_order_id_seq</code>
     */
    public static final Sequence<Long> PURCHASE_ORDER_ID_SEQ = Internal.createSequence("purchase_order_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.purchase_order_item_id_seq</code>
     */
    public static final Sequence<Long> PURCHASE_ORDER_ITEM_ID_SEQ = Internal.createSequence("purchase_order_item_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.sale_order_id_seq</code>
     */
    public static final Sequence<Long> SALE_ORDER_ID_SEQ = Internal.createSequence("sale_order_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.sale_order_item_id_seq</code>
     */
    public static final Sequence<Long> SALE_ORDER_ITEM_ID_SEQ = Internal.createSequence("sale_order_item_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.stock_id_seq</code>
     */
    public static final Sequence<Long> STOCK_ID_SEQ = Internal.createSequence("stock_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.stock_item_id_seq</code>
     */
    public static final Sequence<Long> STOCK_ITEM_ID_SEQ = Internal.createSequence("stock_item_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.store_id_seq</code>
     */
    public static final Sequence<Long> STORE_ID_SEQ = Internal.createSequence("store_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.store_item_id_seq</code>
     */
    public static final Sequence<Long> STORE_ITEM_ID_SEQ = Internal.createSequence("store_item_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}
