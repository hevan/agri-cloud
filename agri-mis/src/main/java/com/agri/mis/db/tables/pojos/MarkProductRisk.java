/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MarkProductRisk implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cycleName;
    private String riskCategory;
    private String description;
    private String solution;
    private BigDecimal feeAmount;
    private String name;
    private Long id;
    private Long productBatchId;

    public MarkProductRisk() {}

    public MarkProductRisk(MarkProductRisk value) {
        this.cycleName = value.cycleName;
        this.riskCategory = value.riskCategory;
        this.description = value.description;
        this.solution = value.solution;
        this.feeAmount = value.feeAmount;
        this.name = value.name;
        this.id = value.id;
        this.productBatchId = value.productBatchId;
    }

    public MarkProductRisk(
        String cycleName,
        String riskCategory,
        String description,
        String solution,
        BigDecimal feeAmount,
        String name,
        Long id,
        Long productBatchId
    ) {
        this.cycleName = cycleName;
        this.riskCategory = riskCategory;
        this.description = description;
        this.solution = solution;
        this.feeAmount = feeAmount;
        this.name = name;
        this.id = id;
        this.productBatchId = productBatchId;
    }

    /**
     * Getter for <code>public.mark_product_risk.cycle_name</code>.
     */
    public String getCycleName() {
        return this.cycleName;
    }

    /**
     * Setter for <code>public.mark_product_risk.cycle_name</code>.
     */
    public MarkProductRisk setCycleName(String cycleName) {
        this.cycleName = cycleName;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.risk_category</code>.
     */
    public String getRiskCategory() {
        return this.riskCategory;
    }

    /**
     * Setter for <code>public.mark_product_risk.risk_category</code>.
     */
    public MarkProductRisk setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.mark_product_risk.description</code>.
     */
    public MarkProductRisk setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.solution</code>.
     */
    public String getSolution() {
        return this.solution;
    }

    /**
     * Setter for <code>public.mark_product_risk.solution</code>.
     */
    public MarkProductRisk setSolution(String solution) {
        this.solution = solution;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.fee_amount</code>.
     */
    public BigDecimal getFeeAmount() {
        return this.feeAmount;
    }

    /**
     * Setter for <code>public.mark_product_risk.fee_amount</code>.
     */
    public MarkProductRisk setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.mark_product_risk.name</code>.
     */
    public MarkProductRisk setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.mark_product_risk.id</code>.
     */
    public MarkProductRisk setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.mark_product_risk.product_batch_id</code>.
     */
    public Long getProductBatchId() {
        return this.productBatchId;
    }

    /**
     * Setter for <code>public.mark_product_risk.product_batch_id</code>.
     */
    public MarkProductRisk setProductBatchId(Long productBatchId) {
        this.productBatchId = productBatchId;
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
        final MarkProductRisk other = (MarkProductRisk) obj;
        if (this.cycleName == null) {
            if (other.cycleName != null)
                return false;
        }
        else if (!this.cycleName.equals(other.cycleName))
            return false;
        if (this.riskCategory == null) {
            if (other.riskCategory != null)
                return false;
        }
        else if (!this.riskCategory.equals(other.riskCategory))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.solution == null) {
            if (other.solution != null)
                return false;
        }
        else if (!this.solution.equals(other.solution))
            return false;
        if (this.feeAmount == null) {
            if (other.feeAmount != null)
                return false;
        }
        else if (!this.feeAmount.equals(other.feeAmount))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.productBatchId == null) {
            if (other.productBatchId != null)
                return false;
        }
        else if (!this.productBatchId.equals(other.productBatchId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.cycleName == null) ? 0 : this.cycleName.hashCode());
        result = prime * result + ((this.riskCategory == null) ? 0 : this.riskCategory.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.solution == null) ? 0 : this.solution.hashCode());
        result = prime * result + ((this.feeAmount == null) ? 0 : this.feeAmount.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.productBatchId == null) ? 0 : this.productBatchId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MarkProductRisk (");

        sb.append(cycleName);
        sb.append(", ").append(riskCategory);
        sb.append(", ").append(description);
        sb.append(", ").append(solution);
        sb.append(", ").append(feeAmount);
        sb.append(", ").append(name);
        sb.append(", ").append(id);
        sb.append(", ").append(productBatchId);

        sb.append(")");
        return sb.toString();
    }
}
