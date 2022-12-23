/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db;


import com.agri.mis.db.tables.Address;
import com.agri.mis.db.tables.BatchBase;
import com.agri.mis.db.tables.BatchCycle;
import com.agri.mis.db.tables.BatchCycleExecute;
import com.agri.mis.db.tables.BatchCycleExpense;
import com.agri.mis.db.tables.BatchProduct;
import com.agri.mis.db.tables.BatchRisk;
import com.agri.mis.db.tables.BatchTeam;
import com.agri.mis.db.tables.Category;
import com.agri.mis.db.tables.CheckTemp;
import com.agri.mis.db.tables.CheckTempItem;
import com.agri.mis.db.tables.CheckTrace;
import com.agri.mis.db.tables.CmsBlog;
import com.agri.mis.db.tables.CmsCategory;
import com.agri.mis.db.tables.CmsResource;
import com.agri.mis.db.tables.CmsTag;
import com.agri.mis.db.tables.Corp;
import com.agri.mis.db.tables.CorpDepart;
import com.agri.mis.db.tables.CorpManager;
import com.agri.mis.db.tables.CorpManagerDepart;
import com.agri.mis.db.tables.CorpManagerRole;
import com.agri.mis.db.tables.CorpPark;
import com.agri.mis.db.tables.CorpParkBase;
import com.agri.mis.db.tables.CorpRole;
import com.agri.mis.db.tables.CorpRoleMenu;
import com.agri.mis.db.tables.Customer;
import com.agri.mis.db.tables.CustomerLink;
import com.agri.mis.db.tables.CustomerTrace;
import com.agri.mis.db.tables.DocResource;
import com.agri.mis.db.tables.MarkCategory;
import com.agri.mis.db.tables.MarkMarket;
import com.agri.mis.db.tables.MarkProduct;
import com.agri.mis.db.tables.MarkProductBatch;
import com.agri.mis.db.tables.MarkProductCycle;
import com.agri.mis.db.tables.MarkProductCycleExpense;
import com.agri.mis.db.tables.MarkProductMarket;
import com.agri.mis.db.tables.MarkProductRisk;
import com.agri.mis.db.tables.MisAccountBill;
import com.agri.mis.db.tables.MisAccountTitle;
import com.agri.mis.db.tables.MisBankAccount;
import com.agri.mis.db.tables.MisContract;
import com.agri.mis.db.tables.MisProductionOrder;
import com.agri.mis.db.tables.MisProductionOrderItem;
import com.agri.mis.db.tables.MisPurchaseOrder;
import com.agri.mis.db.tables.MisPurchaseOrderItem;
import com.agri.mis.db.tables.MisSaleOrder;
import com.agri.mis.db.tables.MisSaleOrderItem;
import com.agri.mis.db.tables.MisStock;
import com.agri.mis.db.tables.MisStockItem;
import com.agri.mis.db.tables.MisStockPlace;
import com.agri.mis.db.tables.MisStockPlaceItem;
import com.agri.mis.db.tables.MisStockPlaceItemSub;
import com.agri.mis.db.tables.MisStore;
import com.agri.mis.db.tables.MisStoreItem;
import com.agri.mis.db.tables.Product;
import com.agri.mis.db.tables.SysMenu;
import com.agri.mis.db.tables.SysMenuAction;
import com.agri.mis.db.tables.Users;


/**
 * Convenience access to all tables in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.address</code>.
     */
    public static final Address ADDRESS = Address.ADDRESS;

    /**
     * The table <code>public.batch_base</code>.
     */
    public static final BatchBase BATCH_BASE = BatchBase.BATCH_BASE;

    /**
     * The table <code>public.batch_cycle</code>.
     */
    public static final BatchCycle BATCH_CYCLE = BatchCycle.BATCH_CYCLE;

    /**
     * The table <code>public.batch_cycle_execute</code>.
     */
    public static final BatchCycleExecute BATCH_CYCLE_EXECUTE = BatchCycleExecute.BATCH_CYCLE_EXECUTE;

    /**
     * The table <code>public.batch_cycle_expense</code>.
     */
    public static final BatchCycleExpense BATCH_CYCLE_EXPENSE = BatchCycleExpense.BATCH_CYCLE_EXPENSE;

    /**
     * The table <code>public.batch_product</code>.
     */
    public static final BatchProduct BATCH_PRODUCT = BatchProduct.BATCH_PRODUCT;

    /**
     * The table <code>public.batch_risk</code>.
     */
    public static final BatchRisk BATCH_RISK = BatchRisk.BATCH_RISK;

    /**
     * The table <code>public.batch_team</code>.
     */
    public static final BatchTeam BATCH_TEAM = BatchTeam.BATCH_TEAM;

    /**
     * The table <code>public.category</code>.
     */
    public static final Category CATEGORY = Category.CATEGORY;

    /**
     * The table <code>public.check_temp</code>.
     */
    public static final CheckTemp CHECK_TEMP = CheckTemp.CHECK_TEMP;

    /**
     * The table <code>public.check_temp_item</code>.
     */
    public static final CheckTempItem CHECK_TEMP_ITEM = CheckTempItem.CHECK_TEMP_ITEM;

    /**
     * The table <code>public.check_trace</code>.
     */
    public static final CheckTrace CHECK_TRACE = CheckTrace.CHECK_TRACE;

    /**
     * The table <code>public.cms_blog</code>.
     */
    public static final CmsBlog CMS_BLOG = CmsBlog.CMS_BLOG;

    /**
     * The table <code>public.cms_category</code>.
     */
    public static final CmsCategory CMS_CATEGORY = CmsCategory.CMS_CATEGORY;

    /**
     * The table <code>public.cms_resource</code>.
     */
    public static final CmsResource CMS_RESOURCE = CmsResource.CMS_RESOURCE;

    /**
     * The table <code>public.cms_tag</code>.
     */
    public static final CmsTag CMS_TAG = CmsTag.CMS_TAG;

    /**
     * The table <code>public.corp</code>.
     */
    public static final Corp CORP = Corp.CORP;

    /**
     * The table <code>public.corp_depart</code>.
     */
    public static final CorpDepart CORP_DEPART = CorpDepart.CORP_DEPART;

    /**
     * The table <code>public.corp_manager</code>.
     */
    public static final CorpManager CORP_MANAGER = CorpManager.CORP_MANAGER;

    /**
     * The table <code>public.corp_manager_depart</code>.
     */
    public static final CorpManagerDepart CORP_MANAGER_DEPART = CorpManagerDepart.CORP_MANAGER_DEPART;

    /**
     * The table <code>public.corp_manager_role</code>.
     */
    public static final CorpManagerRole CORP_MANAGER_ROLE = CorpManagerRole.CORP_MANAGER_ROLE;

    /**
     * The table <code>public.corp_park</code>.
     */
    public static final CorpPark CORP_PARK = CorpPark.CORP_PARK;

    /**
     * The table <code>public.corp_park_base</code>.
     */
    public static final CorpParkBase CORP_PARK_BASE = CorpParkBase.CORP_PARK_BASE;

    /**
     * The table <code>public.corp_role</code>.
     */
    public static final CorpRole CORP_ROLE = CorpRole.CORP_ROLE;

    /**
     * The table <code>public.corp_role_menu</code>.
     */
    public static final CorpRoleMenu CORP_ROLE_MENU = CorpRoleMenu.CORP_ROLE_MENU;

    /**
     * The table <code>public.customer</code>.
     */
    public static final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>public.customer_link</code>.
     */
    public static final CustomerLink CUSTOMER_LINK = CustomerLink.CUSTOMER_LINK;

    /**
     * The table <code>public.customer_trace</code>.
     */
    public static final CustomerTrace CUSTOMER_TRACE = CustomerTrace.CUSTOMER_TRACE;

    /**
     * The table <code>public.doc_resource</code>.
     */
    public static final DocResource DOC_RESOURCE = DocResource.DOC_RESOURCE;

    /**
     * The table <code>public.mark_category</code>.
     */
    public static final MarkCategory MARK_CATEGORY = MarkCategory.MARK_CATEGORY;

    /**
     * The table <code>public.mark_market</code>.
     */
    public static final MarkMarket MARK_MARKET = MarkMarket.MARK_MARKET;

    /**
     * The table <code>public.mark_product</code>.
     */
    public static final MarkProduct MARK_PRODUCT = MarkProduct.MARK_PRODUCT;

    /**
     * The table <code>public.mark_product_batch</code>.
     */
    public static final MarkProductBatch MARK_PRODUCT_BATCH = MarkProductBatch.MARK_PRODUCT_BATCH;

    /**
     * The table <code>public.mark_product_cycle</code>.
     */
    public static final MarkProductCycle MARK_PRODUCT_CYCLE = MarkProductCycle.MARK_PRODUCT_CYCLE;

    /**
     * The table <code>public.mark_product_cycle_expense</code>.
     */
    public static final MarkProductCycleExpense MARK_PRODUCT_CYCLE_EXPENSE = MarkProductCycleExpense.MARK_PRODUCT_CYCLE_EXPENSE;

    /**
     * The table <code>public.mark_product_market</code>.
     */
    public static final MarkProductMarket MARK_PRODUCT_MARKET = MarkProductMarket.MARK_PRODUCT_MARKET;

    /**
     * The table <code>public.mark_product_risk</code>.
     */
    public static final MarkProductRisk MARK_PRODUCT_RISK = MarkProductRisk.MARK_PRODUCT_RISK;

    /**
     * The table <code>public.mis_account_bill</code>.
     */
    public static final MisAccountBill MIS_ACCOUNT_BILL = MisAccountBill.MIS_ACCOUNT_BILL;

    /**
     * The table <code>public.mis_account_title</code>.
     */
    public static final MisAccountTitle MIS_ACCOUNT_TITLE = MisAccountTitle.MIS_ACCOUNT_TITLE;

    /**
     * The table <code>public.mis_bank_account</code>.
     */
    public static final MisBankAccount MIS_BANK_ACCOUNT = MisBankAccount.MIS_BANK_ACCOUNT;

    /**
     * The table <code>public.mis_contract</code>.
     */
    public static final MisContract MIS_CONTRACT = MisContract.MIS_CONTRACT;

    /**
     * The table <code>public.mis_production_order</code>.
     */
    public static final MisProductionOrder MIS_PRODUCTION_ORDER = MisProductionOrder.MIS_PRODUCTION_ORDER;

    /**
     * The table <code>public.mis_production_order_item</code>.
     */
    public static final MisProductionOrderItem MIS_PRODUCTION_ORDER_ITEM = MisProductionOrderItem.MIS_PRODUCTION_ORDER_ITEM;

    /**
     * The table <code>public.mis_purchase_order</code>.
     */
    public static final MisPurchaseOrder MIS_PURCHASE_ORDER = MisPurchaseOrder.MIS_PURCHASE_ORDER;

    /**
     * The table <code>public.mis_purchase_order_item</code>.
     */
    public static final MisPurchaseOrderItem MIS_PURCHASE_ORDER_ITEM = MisPurchaseOrderItem.MIS_PURCHASE_ORDER_ITEM;

    /**
     * The table <code>public.mis_sale_order</code>.
     */
    public static final MisSaleOrder MIS_SALE_ORDER = MisSaleOrder.MIS_SALE_ORDER;

    /**
     * The table <code>public.mis_sale_order_item</code>.
     */
    public static final MisSaleOrderItem MIS_SALE_ORDER_ITEM = MisSaleOrderItem.MIS_SALE_ORDER_ITEM;

    /**
     * The table <code>public.mis_stock</code>.
     */
    public static final MisStock MIS_STOCK = MisStock.MIS_STOCK;

    /**
     * The table <code>public.mis_stock_item</code>.
     */
    public static final MisStockItem MIS_STOCK_ITEM = MisStockItem.MIS_STOCK_ITEM;

    /**
     * The table <code>public.mis_stock_place</code>.
     */
    public static final MisStockPlace MIS_STOCK_PLACE = MisStockPlace.MIS_STOCK_PLACE;

    /**
     * The table <code>public.mis_stock_place_item</code>.
     */
    public static final MisStockPlaceItem MIS_STOCK_PLACE_ITEM = MisStockPlaceItem.MIS_STOCK_PLACE_ITEM;

    /**
     * The table <code>public.mis_stock_place_item_sub</code>.
     */
    public static final MisStockPlaceItemSub MIS_STOCK_PLACE_ITEM_SUB = MisStockPlaceItemSub.MIS_STOCK_PLACE_ITEM_SUB;

    /**
     * The table <code>public.mis_store</code>.
     */
    public static final MisStore MIS_STORE = MisStore.MIS_STORE;

    /**
     * The table <code>public.mis_store_item</code>.
     */
    public static final MisStoreItem MIS_STORE_ITEM = MisStoreItem.MIS_STORE_ITEM;

    /**
     * The table <code>public.product</code>.
     */
    public static final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>public.sys_menu</code>.
     */
    public static final SysMenu SYS_MENU = SysMenu.SYS_MENU;

    /**
     * The table <code>public.sys_menu_action</code>.
     */
    public static final SysMenuAction SYS_MENU_ACTION = SysMenuAction.SYS_MENU_ACTION;

    /**
     * The table <code>public.users</code>.
     */
    public static final Users USERS = Users.USERS;
}
