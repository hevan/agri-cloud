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
import com.agri.mis.db.tables.MisStockPlace;
import com.agri.mis.db.tables.MisStockPlaceItem;
import com.agri.mis.db.tables.MisStockPlaceItemSub;
import com.agri.mis.db.tables.Oauth2Authorization;
import com.agri.mis.db.tables.Oauth2RegisteredClient;
import com.agri.mis.db.tables.PlanPark;
import com.agri.mis.db.tables.Product;
import com.agri.mis.db.tables.ProductSku;
import com.agri.mis.db.tables.ProductionOrder;
import com.agri.mis.db.tables.ProductionOrderItem;
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
import com.agri.mis.db.tables.records.AddressRecord;
import com.agri.mis.db.tables.records.AuthorizationConsentRecord;
import com.agri.mis.db.tables.records.BatchBaseRecord;
import com.agri.mis.db.tables.records.BatchCycleExecuteRecord;
import com.agri.mis.db.tables.records.BatchCycleInvestRecord;
import com.agri.mis.db.tables.records.BatchCycleRecord;
import com.agri.mis.db.tables.records.BatchProductRecord;
import com.agri.mis.db.tables.records.BatchRiskRecord;
import com.agri.mis.db.tables.records.BatchTeamRecord;
import com.agri.mis.db.tables.records.CategoryRecord;
import com.agri.mis.db.tables.records.CheckApplyRecord;
import com.agri.mis.db.tables.records.CheckTraceRecord;
import com.agri.mis.db.tables.records.CityRecord;
import com.agri.mis.db.tables.records.CmsBlogRecord;
import com.agri.mis.db.tables.records.CmsCategoryRecord;
import com.agri.mis.db.tables.records.CmsTagRecord;
import com.agri.mis.db.tables.records.CmsUserActiveRecord;
import com.agri.mis.db.tables.records.CorpDepartRecord;
import com.agri.mis.db.tables.records.CorpManagerDepartRecord;
import com.agri.mis.db.tables.records.CorpManagerRecord;
import com.agri.mis.db.tables.records.CorpManagerRoleRecord;
import com.agri.mis.db.tables.records.CorpParkBaseRecord;
import com.agri.mis.db.tables.records.CorpParkRecord;
import com.agri.mis.db.tables.records.CorpRecord;
import com.agri.mis.db.tables.records.CorpRoleMenuRecord;
import com.agri.mis.db.tables.records.CorpRoleRecord;
import com.agri.mis.db.tables.records.CustomerContractRecord;
import com.agri.mis.db.tables.records.CustomerLinkRecord;
import com.agri.mis.db.tables.records.CustomerRecord;
import com.agri.mis.db.tables.records.CustomerTraceRecord;
import com.agri.mis.db.tables.records.DeliveryOrderItemRecord;
import com.agri.mis.db.tables.records.DeliveryOrderRecord;
import com.agri.mis.db.tables.records.DocResourceRecord;
import com.agri.mis.db.tables.records.EntryOrderItemRecord;
import com.agri.mis.db.tables.records.EntryOrderRecord;
import com.agri.mis.db.tables.records.FinanceExpenseItemRecord;
import com.agri.mis.db.tables.records.FinanceExpenseRecord;
import com.agri.mis.db.tables.records.MarkCategoryRecord;
import com.agri.mis.db.tables.records.MarkMarketRecord;
import com.agri.mis.db.tables.records.MarkProductMarketRecord;
import com.agri.mis.db.tables.records.MarkProductRecord;
import com.agri.mis.db.tables.records.MisAccountBillRecord;
import com.agri.mis.db.tables.records.MisAccountTitleRecord;
import com.agri.mis.db.tables.records.MisBankAccountRecord;
import com.agri.mis.db.tables.records.MisStockPlaceItemRecord;
import com.agri.mis.db.tables.records.MisStockPlaceItemSubRecord;
import com.agri.mis.db.tables.records.MisStockPlaceRecord;
import com.agri.mis.db.tables.records.Oauth2AuthorizationRecord;
import com.agri.mis.db.tables.records.Oauth2RegisteredClientRecord;
import com.agri.mis.db.tables.records.PlanParkRecord;
import com.agri.mis.db.tables.records.ProductRecord;
import com.agri.mis.db.tables.records.ProductSkuRecord;
import com.agri.mis.db.tables.records.ProductionOrderItemRecord;
import com.agri.mis.db.tables.records.ProductionOrderRecord;
import com.agri.mis.db.tables.records.PurchaseOrderItemRecord;
import com.agri.mis.db.tables.records.PurchaseOrderRecord;
import com.agri.mis.db.tables.records.SaleOrderItemRecord;
import com.agri.mis.db.tables.records.SaleOrderRecord;
import com.agri.mis.db.tables.records.SurveyPlantHouseRecord;
import com.agri.mis.db.tables.records.SurveyStoreHouseRecord;
import com.agri.mis.db.tables.records.SysConstItemRecord;
import com.agri.mis.db.tables.records.SysConstRecord;
import com.agri.mis.db.tables.records.SysMenuActionRecord;
import com.agri.mis.db.tables.records.SysMenuRecord;
import com.agri.mis.db.tables.records.UsersRecord;
import com.agri.mis.db.tables.records.WarehouseRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddressRecord> ADDRESS_PKEY = Internal.createUniqueKey(Address.ADDRESS, DSL.name("address_pkey"), new TableField[] { Address.ADDRESS.ID }, true);
    public static final UniqueKey<AuthorizationConsentRecord> AUTHORIZATION_CONSENT_PKEY = Internal.createUniqueKey(AuthorizationConsent.AUTHORIZATION_CONSENT, DSL.name("authorization_consent_pkey"), new TableField[] { AuthorizationConsent.AUTHORIZATION_CONSENT.REGISTERED_CLIENT_ID, AuthorizationConsent.AUTHORIZATION_CONSENT.PRINCIPAL_NAME }, true);
    public static final UniqueKey<BatchBaseRecord> BATCH_BASE_PKEY = Internal.createUniqueKey(BatchBase.BATCH_BASE, DSL.name("batch_base_pkey"), new TableField[] { BatchBase.BATCH_BASE.ID }, true);
    public static final UniqueKey<BatchCycleRecord> BATCH_CYCLE_PKEY = Internal.createUniqueKey(BatchCycle.BATCH_CYCLE, DSL.name("batch_cycle_pkey"), new TableField[] { BatchCycle.BATCH_CYCLE.ID }, true);
    public static final UniqueKey<BatchCycleExecuteRecord> BATCH_CYCLE_EXECUTE_PKEY = Internal.createUniqueKey(BatchCycleExecute.BATCH_CYCLE_EXECUTE, DSL.name("batch_cycle_execute_pkey"), new TableField[] { BatchCycleExecute.BATCH_CYCLE_EXECUTE.ID }, true);
    public static final UniqueKey<BatchCycleInvestRecord> BATCH_CYCLE_INVEST_PKEY = Internal.createUniqueKey(BatchCycleInvest.BATCH_CYCLE_INVEST, DSL.name("batch_cycle_invest_pkey"), new TableField[] { BatchCycleInvest.BATCH_CYCLE_INVEST.ID }, true);
    public static final UniqueKey<BatchProductRecord> PRODUCT_BATCH_PKEY = Internal.createUniqueKey(BatchProduct.BATCH_PRODUCT, DSL.name("product_batch_pkey"), new TableField[] { BatchProduct.BATCH_PRODUCT.ID }, true);
    public static final UniqueKey<BatchRiskRecord> BATCH_RISK_PKEY = Internal.createUniqueKey(BatchRisk.BATCH_RISK, DSL.name("batch_risk_pkey"), new TableField[] { BatchRisk.BATCH_RISK.ID }, true);
    public static final UniqueKey<BatchTeamRecord> BATCH_TEAM_PKEY = Internal.createUniqueKey(BatchTeam.BATCH_TEAM, DSL.name("batch_team_pkey"), new TableField[] { BatchTeam.BATCH_TEAM.ID }, true);
    public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = Internal.createUniqueKey(Category.CATEGORY, DSL.name("category_pkey"), new TableField[] { Category.CATEGORY.ID }, true);
    public static final UniqueKey<CheckApplyRecord> CHECK_APPLY_PKEY = Internal.createUniqueKey(CheckApply.CHECK_APPLY, DSL.name("check_apply_pkey"), new TableField[] { CheckApply.CHECK_APPLY.ID }, true);
    public static final UniqueKey<CheckTraceRecord> CHECK_TRACE_PKEY = Internal.createUniqueKey(CheckTrace.CHECK_TRACE, DSL.name("check_trace_pkey"), new TableField[] { CheckTrace.CHECK_TRACE.ID }, true);
    public static final UniqueKey<CityRecord> CITY_PKEY = Internal.createUniqueKey(City.CITY, DSL.name("city_pkey"), new TableField[] { City.CITY.ID }, true);
    public static final UniqueKey<CmsBlogRecord> CMS_BLOG_PKEY = Internal.createUniqueKey(CmsBlog.CMS_BLOG, DSL.name("cms_blog_pkey"), new TableField[] { CmsBlog.CMS_BLOG.ID }, true);
    public static final UniqueKey<CmsCategoryRecord> CMS_CATEGORY_PKEY = Internal.createUniqueKey(CmsCategory.CMS_CATEGORY, DSL.name("cms_category_pkey"), new TableField[] { CmsCategory.CMS_CATEGORY.ID }, true);
    public static final UniqueKey<CmsTagRecord> CMS_TAG_PKEY = Internal.createUniqueKey(CmsTag.CMS_TAG, DSL.name("cms_tag_pkey"), new TableField[] { CmsTag.CMS_TAG.ID }, true);
    public static final UniqueKey<CmsUserActiveRecord> CMS_USER_ACTIVE_PKEY = Internal.createUniqueKey(CmsUserActive.CMS_USER_ACTIVE, DSL.name("cms_user_active_pkey"), new TableField[] { CmsUserActive.CMS_USER_ACTIVE.ID }, true);
    public static final UniqueKey<CorpRecord> CORP_PKEY = Internal.createUniqueKey(Corp.CORP, DSL.name("corp_pkey"), new TableField[] { Corp.CORP.ID }, true);
    public static final UniqueKey<CorpDepartRecord> CORP_DEPART_PKEY = Internal.createUniqueKey(CorpDepart.CORP_DEPART, DSL.name("corp_depart_pkey"), new TableField[] { CorpDepart.CORP_DEPART.ID }, true);
    public static final UniqueKey<CorpManagerRecord> CORP_MANAGER_PKEY = Internal.createUniqueKey(CorpManager.CORP_MANAGER, DSL.name("corp_manager_pkey"), new TableField[] { CorpManager.CORP_MANAGER.ID }, true);
    public static final UniqueKey<CorpManagerDepartRecord> CORP_MANAGER_DEPART_PKEY = Internal.createUniqueKey(CorpManagerDepart.CORP_MANAGER_DEPART, DSL.name("corp_manager_depart_pkey"), new TableField[] { CorpManagerDepart.CORP_MANAGER_DEPART.ID }, true);
    public static final UniqueKey<CorpManagerRoleRecord> CORP_MANAGER_ROLE_PKEY = Internal.createUniqueKey(CorpManagerRole.CORP_MANAGER_ROLE, DSL.name("corp_manager_role_pkey"), new TableField[] { CorpManagerRole.CORP_MANAGER_ROLE.ID }, true);
    public static final UniqueKey<CorpParkRecord> PARK_PKEY = Internal.createUniqueKey(CorpPark.CORP_PARK, DSL.name("park_pkey"), new TableField[] { CorpPark.CORP_PARK.ID }, true);
    public static final UniqueKey<CorpParkBaseRecord> PARK_BASE_PKEY = Internal.createUniqueKey(CorpParkBase.CORP_PARK_BASE, DSL.name("park_base_pkey"), new TableField[] { CorpParkBase.CORP_PARK_BASE.ID }, true);
    public static final UniqueKey<CorpRoleRecord> CORP_ROLE_PKEY = Internal.createUniqueKey(CorpRole.CORP_ROLE, DSL.name("corp_role_pkey"), new TableField[] { CorpRole.CORP_ROLE.ID }, true);
    public static final UniqueKey<CorpRoleMenuRecord> CORP_ROLE_MENU_PKEY = Internal.createUniqueKey(CorpRoleMenu.CORP_ROLE_MENU, DSL.name("corp_role_menu_pkey"), new TableField[] { CorpRoleMenu.CORP_ROLE_MENU.ID }, true);
    public static final UniqueKey<CustomerRecord> CUSTOMER_PKEY = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("customer_pkey"), new TableField[] { Customer.CUSTOMER.ID }, true);
    public static final UniqueKey<CustomerContractRecord> CONTRACT_PKEY = Internal.createUniqueKey(CustomerContract.CUSTOMER_CONTRACT, DSL.name("contract_pkey"), new TableField[] { CustomerContract.CUSTOMER_CONTRACT.ID }, true);
    public static final UniqueKey<CustomerLinkRecord> CUSTOMER_LINK_PKEY = Internal.createUniqueKey(CustomerLink.CUSTOMER_LINK, DSL.name("customer_link_pkey"), new TableField[] { CustomerLink.CUSTOMER_LINK.ID }, true);
    public static final UniqueKey<CustomerTraceRecord> CUSTOMER_TRACE_PKEY = Internal.createUniqueKey(CustomerTrace.CUSTOMER_TRACE, DSL.name("customer_trace_pkey"), new TableField[] { CustomerTrace.CUSTOMER_TRACE.ID }, true);
    public static final UniqueKey<DeliveryOrderRecord> DELIVERY_ORDER_PKEY = Internal.createUniqueKey(DeliveryOrder.DELIVERY_ORDER, DSL.name("delivery_order_pkey"), new TableField[] { DeliveryOrder.DELIVERY_ORDER.ID }, true);
    public static final UniqueKey<DeliveryOrderItemRecord> DELIVERY_ORDER_ITEM_PKEY = Internal.createUniqueKey(DeliveryOrderItem.DELIVERY_ORDER_ITEM, DSL.name("delivery_order_item_pkey"), new TableField[] { DeliveryOrderItem.DELIVERY_ORDER_ITEM.ID }, true);
    public static final UniqueKey<DocResourceRecord> DOC_RESOURCE_PKEY = Internal.createUniqueKey(DocResource.DOC_RESOURCE, DSL.name("doc_resource_pkey"), new TableField[] { DocResource.DOC_RESOURCE.ID }, true);
    public static final UniqueKey<EntryOrderRecord> ENTRY_ORDER_PKEY = Internal.createUniqueKey(EntryOrder.ENTRY_ORDER, DSL.name("entry_order_pkey"), new TableField[] { EntryOrder.ENTRY_ORDER.ID }, true);
    public static final UniqueKey<EntryOrderItemRecord> ENTRY_ORDER_ITEM_PKEY = Internal.createUniqueKey(EntryOrderItem.ENTRY_ORDER_ITEM, DSL.name("entry_order_item_pkey"), new TableField[] { EntryOrderItem.ENTRY_ORDER_ITEM.ID }, true);
    public static final UniqueKey<FinanceExpenseRecord> BATCH_CYCLE_EXPENSE_PKEY = Internal.createUniqueKey(FinanceExpense.FINANCE_EXPENSE, DSL.name("batch_cycle_expense_pkey"), new TableField[] { FinanceExpense.FINANCE_EXPENSE.ID }, true);
    public static final UniqueKey<FinanceExpenseItemRecord> BATCH_CYCLE_EXPENSE_ITEM_PKEY = Internal.createUniqueKey(FinanceExpenseItem.FINANCE_EXPENSE_ITEM, DSL.name("batch_cycle_expense_item_pkey"), new TableField[] { FinanceExpenseItem.FINANCE_EXPENSE_ITEM.ID }, true);
    public static final UniqueKey<MarkCategoryRecord> MK_CATEGORY_PKEY = Internal.createUniqueKey(MarkCategory.MARK_CATEGORY, DSL.name("mk_category_pkey"), new TableField[] { MarkCategory.MARK_CATEGORY.ID }, true);
    public static final UniqueKey<MarkMarketRecord> MARKET_PKEY = Internal.createUniqueKey(MarkMarket.MARK_MARKET, DSL.name("market_pkey"), new TableField[] { MarkMarket.MARK_MARKET.ID }, true);
    public static final UniqueKey<MarkProductRecord> MK_PRODUCT_PKEY = Internal.createUniqueKey(MarkProduct.MARK_PRODUCT, DSL.name("mk_product_pkey"), new TableField[] { MarkProduct.MARK_PRODUCT.ID }, true);
    public static final UniqueKey<MarkProductMarketRecord> PRODUCT_MARKET_PKEY = Internal.createUniqueKey(MarkProductMarket.MARK_PRODUCT_MARKET, DSL.name("product_market_pkey"), new TableField[] { MarkProductMarket.MARK_PRODUCT_MARKET.ID }, true);
    public static final UniqueKey<MisAccountBillRecord> ACCOUNT_PEND_PKEY = Internal.createUniqueKey(MisAccountBill.MIS_ACCOUNT_BILL, DSL.name("account_pend_pkey"), new TableField[] { MisAccountBill.MIS_ACCOUNT_BILL.ID }, true);
    public static final UniqueKey<MisAccountTitleRecord> ACCOUNT_TITLE_PKEY = Internal.createUniqueKey(MisAccountTitle.MIS_ACCOUNT_TITLE, DSL.name("account_title_pkey"), new TableField[] { MisAccountTitle.MIS_ACCOUNT_TITLE.ID }, true);
    public static final UniqueKey<MisBankAccountRecord> BANK_ACCOUNT_PKEY = Internal.createUniqueKey(MisBankAccount.MIS_BANK_ACCOUNT, DSL.name("bank_account_pkey"), new TableField[] { MisBankAccount.MIS_BANK_ACCOUNT.ID }, true);
    public static final UniqueKey<MisStockPlaceRecord> MIS_STOCK_PLACE_PKEY = Internal.createUniqueKey(MisStockPlace.MIS_STOCK_PLACE, DSL.name("mis_stock_place_pkey"), new TableField[] { MisStockPlace.MIS_STOCK_PLACE.ID }, true);
    public static final UniqueKey<MisStockPlaceItemRecord> MIS_STOCK_PLACE_ITEM_PKEY = Internal.createUniqueKey(MisStockPlaceItem.MIS_STOCK_PLACE_ITEM, DSL.name("mis_stock_place_item_pkey"), new TableField[] { MisStockPlaceItem.MIS_STOCK_PLACE_ITEM.ID }, true);
    public static final UniqueKey<MisStockPlaceItemSubRecord> MIS_STOCK_PLACE_ITEM_SUB_PKEY = Internal.createUniqueKey(MisStockPlaceItemSub.MIS_STOCK_PLACE_ITEM_SUB, DSL.name("mis_stock_place_item_sub_pkey"), new TableField[] { MisStockPlaceItemSub.MIS_STOCK_PLACE_ITEM_SUB.ID }, true);
    public static final UniqueKey<Oauth2AuthorizationRecord> OAUTH2_AUTHORIZATION_PKEY = Internal.createUniqueKey(Oauth2Authorization.OAUTH2_AUTHORIZATION, DSL.name("oauth2_authorization_pkey"), new TableField[] { Oauth2Authorization.OAUTH2_AUTHORIZATION.ID }, true);
    public static final UniqueKey<Oauth2RegisteredClientRecord> OAUTH2_REGISTERED_CLIENT_PKEY = Internal.createUniqueKey(Oauth2RegisteredClient.OAUTH2_REGISTERED_CLIENT, DSL.name("oauth2_registered_client_pkey"), new TableField[] { Oauth2RegisteredClient.OAUTH2_REGISTERED_CLIENT.ID }, true);
    public static final UniqueKey<PlanParkRecord> PLAN_PARK_PKEY = Internal.createUniqueKey(PlanPark.PLAN_PARK, DSL.name("plan_park_pkey"), new TableField[] { PlanPark.PLAN_PARK.ID }, true);
    public static final UniqueKey<ProductRecord> PRODUCT_PKEY = Internal.createUniqueKey(Product.PRODUCT, DSL.name("product_pkey"), new TableField[] { Product.PRODUCT.ID }, true);
    public static final UniqueKey<ProductSkuRecord> PRODUCT_SKU_PKEY = Internal.createUniqueKey(ProductSku.PRODUCT_SKU, DSL.name("product_sku_pkey"), new TableField[] { ProductSku.PRODUCT_SKU.ID }, true);
    public static final UniqueKey<ProductionOrderRecord> PRODUCTION_ORDER_PKEY = Internal.createUniqueKey(ProductionOrder.PRODUCTION_ORDER, DSL.name("production_order_pkey"), new TableField[] { ProductionOrder.PRODUCTION_ORDER.ID }, true);
    public static final UniqueKey<ProductionOrderItemRecord> PRODUCTION_ORDER_ITEM_PKEY = Internal.createUniqueKey(ProductionOrderItem.PRODUCTION_ORDER_ITEM, DSL.name("production_order_item_pkey"), new TableField[] { ProductionOrderItem.PRODUCTION_ORDER_ITEM.ID }, true);
    public static final UniqueKey<PurchaseOrderRecord> PURCHASE_ORDER_PKEY = Internal.createUniqueKey(PurchaseOrder.PURCHASE_ORDER, DSL.name("purchase_order_pkey"), new TableField[] { PurchaseOrder.PURCHASE_ORDER.ID }, true);
    public static final UniqueKey<PurchaseOrderItemRecord> PURCHASE_ORDER_ITEM_PKEY = Internal.createUniqueKey(PurchaseOrderItem.PURCHASE_ORDER_ITEM, DSL.name("purchase_order_item_pkey"), new TableField[] { PurchaseOrderItem.PURCHASE_ORDER_ITEM.ID }, true);
    public static final UniqueKey<SaleOrderRecord> SALE_ORDER_PKEY = Internal.createUniqueKey(SaleOrder.SALE_ORDER, DSL.name("sale_order_pkey"), new TableField[] { SaleOrder.SALE_ORDER.ID }, true);
    public static final UniqueKey<SaleOrderItemRecord> SALE_ORDER_ITEM_PKEY = Internal.createUniqueKey(SaleOrderItem.SALE_ORDER_ITEM, DSL.name("sale_order_item_pkey"), new TableField[] { SaleOrderItem.SALE_ORDER_ITEM.ID }, true);
    public static final UniqueKey<SurveyPlantHouseRecord> SURVEY_PLANT_HOUSE_PKEY = Internal.createUniqueKey(SurveyPlantHouse.SURVEY_PLANT_HOUSE, DSL.name("survey_plant_house_pkey"), new TableField[] { SurveyPlantHouse.SURVEY_PLANT_HOUSE.ID }, true);
    public static final UniqueKey<SurveyStoreHouseRecord> SURVEY_STORE_HOUSE_PKEY = Internal.createUniqueKey(SurveyStoreHouse.SURVEY_STORE_HOUSE, DSL.name("survey_store_house_pkey"), new TableField[] { SurveyStoreHouse.SURVEY_STORE_HOUSE.ID }, true);
    public static final UniqueKey<SysConstRecord> SYS_CONST_PKEY = Internal.createUniqueKey(SysConst.SYS_CONST, DSL.name("sys_const_pkey"), new TableField[] { SysConst.SYS_CONST.ID }, true);
    public static final UniqueKey<SysConstItemRecord> SYS_CONST_ITEM_PKEY = Internal.createUniqueKey(SysConstItem.SYS_CONST_ITEM, DSL.name("sys_const_item_pkey"), new TableField[] { SysConstItem.SYS_CONST_ITEM.ID }, true);
    public static final UniqueKey<SysMenuRecord> SYS_MENU_PKEY = Internal.createUniqueKey(SysMenu.SYS_MENU, DSL.name("sys_menu_pkey"), new TableField[] { SysMenu.SYS_MENU.ID }, true);
    public static final UniqueKey<SysMenuActionRecord> SYS_MENU_ACTION_PKEY = Internal.createUniqueKey(SysMenuAction.SYS_MENU_ACTION, DSL.name("sys_menu_action_pkey"), new TableField[] { SysMenuAction.SYS_MENU_ACTION.ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);
    public static final UniqueKey<WarehouseRecord> WAREHOUSE_PKEY = Internal.createUniqueKey(Warehouse.WAREHOUSE, DSL.name("warehouse_pkey"), new TableField[] { Warehouse.WAREHOUSE.ID }, true);
}
