/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String code;
    private String description;
    private Long addressId;
    private LocalDateTime createdAt;
    private Long corpId;
    private Boolean isCustomer;
    private Boolean isSupply;
    private String managerName;
    private String managerMobile;
    private Long createdUserId;

    public Customer() {}

    public Customer(Customer value) {
        this.id = value.id;
        this.name = value.name;
        this.code = value.code;
        this.description = value.description;
        this.addressId = value.addressId;
        this.createdAt = value.createdAt;
        this.corpId = value.corpId;
        this.isCustomer = value.isCustomer;
        this.isSupply = value.isSupply;
        this.managerName = value.managerName;
        this.managerMobile = value.managerMobile;
        this.createdUserId = value.createdUserId;
    }

    public Customer(
        Long id,
        String name,
        String code,
        String description,
        Long addressId,
        LocalDateTime createdAt,
        Long corpId,
        Boolean isCustomer,
        Boolean isSupply,
        String managerName,
        String managerMobile,
        Long createdUserId
    ) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.addressId = addressId;
        this.createdAt = createdAt;
        this.corpId = corpId;
        this.isCustomer = isCustomer;
        this.isSupply = isSupply;
        this.managerName = managerName;
        this.managerMobile = managerMobile;
        this.createdUserId = createdUserId;
    }

    /**
     * Getter for <code>public.customer.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.customer.id</code>.
     */
    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.customer.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.customer.name</code>.
     */
    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.customer.code</code>.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for <code>public.customer.code</code>.
     */
    public Customer setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Getter for <code>public.customer.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.customer.description</code>.
     */
    public Customer setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>public.customer.address_id</code>.
     */
    public Long getAddressId() {
        return this.addressId;
    }

    /**
     * Setter for <code>public.customer.address_id</code>.
     */
    public Customer setAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    /**
     * Getter for <code>public.customer.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.customer.created_at</code>.
     */
    public Customer setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.customer.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.customer.corp_id</code>.
     */
    public Customer setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.customer.is_customer</code>.
     */
    public Boolean getIsCustomer() {
        return this.isCustomer;
    }

    /**
     * Setter for <code>public.customer.is_customer</code>.
     */
    public Customer setIsCustomer(Boolean isCustomer) {
        this.isCustomer = isCustomer;
        return this;
    }

    /**
     * Getter for <code>public.customer.is_supply</code>.
     */
    public Boolean getIsSupply() {
        return this.isSupply;
    }

    /**
     * Setter for <code>public.customer.is_supply</code>.
     */
    public Customer setIsSupply(Boolean isSupply) {
        this.isSupply = isSupply;
        return this;
    }

    /**
     * Getter for <code>public.customer.manager_name</code>.
     */
    public String getManagerName() {
        return this.managerName;
    }

    /**
     * Setter for <code>public.customer.manager_name</code>.
     */
    public Customer setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    /**
     * Getter for <code>public.customer.manager_mobile</code>.
     */
    public String getManagerMobile() {
        return this.managerMobile;
    }

    /**
     * Setter for <code>public.customer.manager_mobile</code>.
     */
    public Customer setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
        return this;
    }

    /**
     * Getter for <code>public.customer.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    /**
     * Setter for <code>public.customer.created_user_id</code>.
     */
    public Customer setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Customer other = (Customer) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.code == null) {
            if (other.code != null)
                return false;
        }
        else if (!this.code.equals(other.code))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.addressId == null) {
            if (other.addressId != null)
                return false;
        }
        else if (!this.addressId.equals(other.addressId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.corpId == null) {
            if (other.corpId != null)
                return false;
        }
        else if (!this.corpId.equals(other.corpId))
            return false;
        if (this.isCustomer == null) {
            if (other.isCustomer != null)
                return false;
        }
        else if (!this.isCustomer.equals(other.isCustomer))
            return false;
        if (this.isSupply == null) {
            if (other.isSupply != null)
                return false;
        }
        else if (!this.isSupply.equals(other.isSupply))
            return false;
        if (this.managerName == null) {
            if (other.managerName != null)
                return false;
        }
        else if (!this.managerName.equals(other.managerName))
            return false;
        if (this.managerMobile == null) {
            if (other.managerMobile != null)
                return false;
        }
        else if (!this.managerMobile.equals(other.managerMobile))
            return false;
        if (this.createdUserId == null) {
            if (other.createdUserId != null)
                return false;
        }
        else if (!this.createdUserId.equals(other.createdUserId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.addressId == null) ? 0 : this.addressId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.isCustomer == null) ? 0 : this.isCustomer.hashCode());
        result = prime * result + ((this.isSupply == null) ? 0 : this.isSupply.hashCode());
        result = prime * result + ((this.managerName == null) ? 0 : this.managerName.hashCode());
        result = prime * result + ((this.managerMobile == null) ? 0 : this.managerMobile.hashCode());
        result = prime * result + ((this.createdUserId == null) ? 0 : this.createdUserId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(code);
        sb.append(", ").append(description);
        sb.append(", ").append(addressId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(corpId);
        sb.append(", ").append(isCustomer);
        sb.append(", ").append(isSupply);
        sb.append(", ").append(managerName);
        sb.append(", ").append(managerMobile);
        sb.append(", ").append(createdUserId);

        sb.append(")");
        return sb.toString();
    }
}
