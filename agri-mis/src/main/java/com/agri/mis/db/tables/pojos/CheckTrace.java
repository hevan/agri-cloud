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
public class CheckTrace implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String entityName;
    private Long entityId;
    private Long userId;
    private Integer status;
    private Long corpId;
    private LocalDateTime createdAt;
    private String title;
    private String description;

    public CheckTrace() {}

    public CheckTrace(CheckTrace value) {
        this.id = value.id;
        this.entityName = value.entityName;
        this.entityId = value.entityId;
        this.userId = value.userId;
        this.status = value.status;
        this.corpId = value.corpId;
        this.createdAt = value.createdAt;
        this.title = value.title;
        this.description = value.description;
    }

    public CheckTrace(
        Long id,
        String entityName,
        Long entityId,
        Long userId,
        Integer status,
        Long corpId,
        LocalDateTime createdAt,
        String title,
        String description
    ) {
        this.id = id;
        this.entityName = entityName;
        this.entityId = entityId;
        this.userId = userId;
        this.status = status;
        this.corpId = corpId;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
    }

    /**
     * Getter for <code>public.check_trace.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.check_trace.id</code>.
     */
    public CheckTrace setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.entity_name</code>.
     */
    public String getEntityName() {
        return this.entityName;
    }

    /**
     * Setter for <code>public.check_trace.entity_name</code>.
     */
    public CheckTrace setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.entity_id</code>.
     */
    public Long getEntityId() {
        return this.entityId;
    }

    /**
     * Setter for <code>public.check_trace.entity_id</code>.
     */
    public CheckTrace setEntityId(Long entityId) {
        this.entityId = entityId;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.user_id</code>.
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.check_trace.user_id</code>.
     */
    public CheckTrace setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.status</code>.
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.check_trace.status</code>.
     */
    public CheckTrace setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.check_trace.corp_id</code>.
     */
    public CheckTrace setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.check_trace.created_at</code>.
     */
    public CheckTrace setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>public.check_trace.title</code>.
     */
    public CheckTrace setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Getter for <code>public.check_trace.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.check_trace.description</code>.
     */
    public CheckTrace setDescription(String description) {
        this.description = description;
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
        final CheckTrace other = (CheckTrace) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.entityName == null) {
            if (other.entityName != null)
                return false;
        }
        else if (!this.entityName.equals(other.entityName))
            return false;
        if (this.entityId == null) {
            if (other.entityId != null)
                return false;
        }
        else if (!this.entityId.equals(other.entityId))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.corpId == null) {
            if (other.corpId != null)
                return false;
        }
        else if (!this.corpId.equals(other.corpId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.entityName == null) ? 0 : this.entityName.hashCode());
        result = prime * result + ((this.entityId == null) ? 0 : this.entityId.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CheckTrace (");

        sb.append(id);
        sb.append(", ").append(entityName);
        sb.append(", ").append(entityId);
        sb.append(", ").append(userId);
        sb.append(", ").append(status);
        sb.append(", ").append(corpId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(title);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}
