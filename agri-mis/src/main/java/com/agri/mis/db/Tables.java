/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db;


import com.agri.mis.db.tables.Address;
import com.agri.mis.db.tables.AuthorizationConsent;
import com.agri.mis.db.tables.BatchBase;
import com.agri.mis.db.tables.BatchCycle;
import com.agri.mis.db.tables.BatchCycleExecute;
import com.agri.mis.db.tables.BatchCycleInvest;
import com.agri.mis.db.tables.BatchProduct;
import com.agri.mis.db.tables.BatchRisk;
import com.agri.mis.db.tables.BatchTeam;
import com.agri.mis.db.tables.Category;
import com.agri.mis.db.tables.CheckApply;
import com.agri.mis.db.tables.CheckTrace;
import com.agri.mis.db.tables.City;
import com.agri.mis.db.tables.CmsBlog;
import com.agri.mis.db.tables.CmsCategory;
import com.agri.mis.db.tables.CmsTag;
import com.agri.mis.db.tables.CmsUserActive;
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
import com.agri.mis.db.tables.CustomerContract;
import com.agri.mis.db.tables.CustomerLink;
import com.agri.mis.db.tables.CustomerTrace;
import com.agri.mis.db.tables.DeliveryOrder;
import com.agri.mis.db.tables.DeliveryOrderItem;
import com.agri.mis.db.tables.DocResource;
import com.agri.mis.db.tables.EntryOrder;
import com.agri.mis.db.tables.EntryOrderItem;
import com.agri.mis.db.tables.FinanceExpense;
import com.agri.mis.db.tables.FinanceExpenseItem;
import com.agri.mis.db.tables.MarkCategory;
import com.agri.mis.db.tables.MarkMarket;
import com.agri.mis.db.tables.MarkProduct;
import com.agri.mis.db.tables.MarkProductMarket;
import com.agri.mis.db.tables.MisAccountBill;
import com.agri.mis.db.tables.MisAccountTitle;
import com.agri.mis.db.tables.MisBankAccount;
import com.agri.mis.db.tables.MisProductionOrder;
import com.agri.mis.db.tables.MisProductionOrderItem;
import com.agri.mis.db.tables.MisStockPlace;
import com.agri.mis.db.tables.MisStockPlaceItem;
import com.agri.mis.db.tables.MisStockPlaceItemSub;
import com.agri.mis.db.tables.Oauth2Authorization;
import com.agri.mis.db.tables.Oauth2RegisteredClient;
import com.agri.mis.db.tables.PlanPark;
import com.agri.mis.db.tables.Product;
import com.agri.mis.db.tables.PurchaseOrder;
import com.agri.mis.db.tables.PurchaseOrderItem;
import com.agri.mis.db.tables.SaleOrder;
import com.agri.mis.db.tables.SaleOrderItem;
import com.agri.mis.db.tables.SurveyPlantHouse;
import com.agri.mis.db.tables.SurveyStoreHouse;
import com.agri.mis.db.tables.SysConst;
import com.agri.mis.db.tables.SysConstItem;
import com.agri.mis.db.tables.SysMenu;
import com.agri.mis.db.tables.SysMenuAction;
import com.agri.mis.db.tables.Users;
import com.agri.mis.db.tables.Warehouse;


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
     * The table <code>public.authorization_consent</code>.
     */
    public static final AuthorizationConsent AUTHORIZATION_CONSENT = AuthorizationConsent.AUTHORIZATION_CONSENT;

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
     * The table <code>public.batch_cycle_invest</code>.
     */
    public static final BatchCycleInvest BATCH_CYCLE_INVEST = BatchCycleInvest.BATCH_CYCLE_INVEST;

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
     * The table <code>public.check_apply</code>.
     */
    public static final CheckApply CHECK_APPLY = CheckApply.CHECK_APPLY;

    /**
     * The table <code>public.check_trace</code>.
     */
    public static final CheckTrace CHECK_TRACE = CheckTrace.CHECK_TRACE;

    /**
     * The table <code>public.city</code>.
     */
    public static final City CITY = City.CITY;

    /**
     * The table <code>public.cms_blog</code>.
     */
    public static final CmsBlog CMS_BLOG = CmsBlog.CMS_BLOG;

    /**
     * The table <code>public.cms_category</code>.
     */
    public static final CmsCategory CMS_CATEGORY = CmsCategory.CMS_CATEGORY;

    /**
     * The table <code>public.cms_tag</code>.
     */
    public static final CmsTag CMS_TAG = CmsTag.CMS_TAG;

    /**
     * The table <code>public.cms_user_active</code>.
     */
    public static final CmsUserActive CMS_USER_ACTIVE = CmsUserActive.CMS_USER_ACTIVE;

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
     * The table <code>public.customer_contract</code>.
     */
    public static final CustomerContract CUSTOMER_CONTRACT = CustomerContract.CUSTOMER_CONTRACT;

    /**
     * The table <code>public.customer_link</code>.
     */
    public static final CustomerLink CUSTOMER_LINK = CustomerLink.CUSTOMER_LINK;

    /**
     * The table <code>public.customer_trace</code>.
     */
    public static final CustomerTrace CUSTOMER_TRACE = CustomerTrace.CUSTOMER_TRACE;

    /**
     * The table <code>public.delivery_order</code>.
     */
    public static final DeliveryOrder DELIVERY_ORDER = DeliveryOrder.DELIVERY_ORDER;

    /**
     * The table <code>public.delivery_order_item</code>.
     */
    public static final DeliveryOrderItem DELIVERY_ORDER_ITEM = DeliveryOrderItem.DELIVERY_ORDER_ITEM;

    /**
     * The table <code>public.doc_resource</code>.
     */
    public static final DocResource DOC_RESOURCE = DocResource.DOC_RESOURCE;

    /**
     * The table <code>public.entry_order</code>.
     */
    public static final EntryOrder ENTRY_ORDER = EntryOrder.ENTRY_ORDER;

    /**
     * The table <code>public.entry_order_item</code>.
     */
    public static final EntryOrderItem ENTRY_ORDER_ITEM = EntryOrderItem.ENTRY_ORDER_ITEM;

    /**
     * The table <code>public.finance_expense</code>.
     */
    public static final FinanceExpense FINANCE_EXPENSE = FinanceExpense.FINANCE_EXPENSE;

    /**
     * The table <code>public.finance_expense_item</code>.
     */
    public static final FinanceExpenseItem FINANCE_EXPENSE_ITEM = FinanceExpenseItem.FINANCE_EXPENSE_ITEM;

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
     * The table <code>public.mark_product_market</code>.
     */
    public static final MarkProductMarket MARK_PRODUCT_MARKET = MarkProductMarket.MARK_PRODUCT_MARKET;

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
     * The table <code>public.mis_production_order</code>.
     */
    public static final MisProductionOrder MIS_PRODUCTION_ORDER = MisProductionOrder.MIS_PRODUCTION_ORDER;

    /**
     * The table <code>public.mis_production_order_item</code>.
     */
    public static final MisProductionOrderItem MIS_PRODUCTION_ORDER_ITEM = MisProductionOrderItem.MIS_PRODUCTION_ORDER_ITEM;

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
     * The table <code>public.oauth2_authorization</code>.
     */
    public static final Oauth2Authorization OAUTH2_AUTHORIZATION = Oauth2Authorization.OAUTH2_AUTHORIZATION;

    /**
     * The table <code>public.oauth2_registered_client</code>.
     */
    public static final Oauth2RegisteredClient OAUTH2_REGISTERED_CLIENT = Oauth2RegisteredClient.OAUTH2_REGISTERED_CLIENT;

    /**
     * The table <code>public.plan_park</code>.
     */
    public static final PlanPark PLAN_PARK = PlanPark.PLAN_PARK;

    /**
     * The table <code>public.product</code>.
     */
    public static final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>public.purchase_order</code>.
     */
    public static final PurchaseOrder PURCHASE_ORDER = PurchaseOrder.PURCHASE_ORDER;

    /**
     * The table <code>public.purchase_order_item</code>.
     */
    public static final PurchaseOrderItem PURCHASE_ORDER_ITEM = PurchaseOrderItem.PURCHASE_ORDER_ITEM;

    /**
     * The table <code>public.sale_order</code>.
     */
    public static final SaleOrder SALE_ORDER = SaleOrder.SALE_ORDER;

    /**
     * The table <code>public.sale_order_item</code>.
     */
    public static final SaleOrderItem SALE_ORDER_ITEM = SaleOrderItem.SALE_ORDER_ITEM;

    /**
     * The table <code>public.survey_plant_house</code>.
     */
    public static final SurveyPlantHouse SURVEY_PLANT_HOUSE = SurveyPlantHouse.SURVEY_PLANT_HOUSE;

    /**
     * The table <code>public.survey_store_house</code>.
     */
    public static final SurveyStoreHouse SURVEY_STORE_HOUSE = SurveyStoreHouse.SURVEY_STORE_HOUSE;

    /**
     * The table <code>public.sys_const</code>.
     */
    public static final SysConst SYS_CONST = SysConst.SYS_CONST;

    /**
     * The table <code>public.sys_const_item</code>.
     */
    public static final SysConstItem SYS_CONST_ITEM = SysConstItem.SYS_CONST_ITEM;

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

    /**
     * The table <code>public.warehouse</code>.
     */
    public static final Warehouse WAREHOUSE = Warehouse.WAREHOUSE;
}
