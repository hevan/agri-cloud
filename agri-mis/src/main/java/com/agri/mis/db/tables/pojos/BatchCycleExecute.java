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
public class BatchCycleExecute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Long createdUserId;
    private String createdBy;
    private Long batchCycleId;
    private Short status;
    private String description;
    private LocalDateTime createdAt;
    private Double progress;
    private Long corpId;
    private Long batchId;

    public BatchCycleExecute() {}

    public BatchCycleExecute(BatchCycleExecute value) {
        this.id = value.id;
        this.name = value.name;
        this.startAt = value.startAt;
        this.endAt = value.endAt;
        this.createdUserId = value.createdUserId;
        this.createdBy = value.createdBy;
        this.batchCycleId = value.batchCycleId;
        this.status = value.status;
        this.description = value.description;
        this.createdAt = value.createdAt;
        this.progress = value.progress;
        this.corpId = value.corpId;
        this.batchId = value.batchId;
    }

    public BatchCycleExecute(
        Long id,
        String name,
        LocalDateTime startAt,
        LocalDateTime endAt,
        Long createdUserId,
        String createdBy,
        Long batchCycleId,
        Short status,
        String description,
        LocalDateTime createdAt,
        Double progress,
        Long corpId,
        Long batchId
    ) {
        this.id = id;
        this.name = name;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdUserId = createdUserId;
        this.createdBy = createdBy;
        this.batchCycleId = batchCycleId;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.progress = progress;
        this.corpId = corpId;
        this.batchId = batchId;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.id</code>.
     */
    public BatchCycleExecute setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.name</code>.
     */
    public BatchCycleExecute setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.start_at</code>.
     */
    public LocalDateTime getStartAt() {
        return this.startAt;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.start_at</code>.
     */
    public BatchCycleExecute setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.end_at</code>.
     */
    public LocalDateTime getEndAt() {
        return this.endAt;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.end_at</code>.
     */
    public BatchCycleExecute setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_user_id</code>.
     */
    public BatchCycleExecute setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_by</code>.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_by</code>.
     */
    public BatchCycleExecute setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.batch_cycle_id</code>.
     */
    public Long getBatchCycleId() {
        return this.batchCycleId;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.batch_cycle_id</code>.
     */
    public BatchCycleExecute setBatchCycleId(Long batchCycleId) {
        this.batchCycleId = batchCycleId;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.status</code>.
     */
    public Short getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.status</code>.
     */
    public BatchCycleExecute setStatus(Short status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.description</code>.
     */
    public BatchCycleExecute setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_at</code>.
     */
    public BatchCycleExecute setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.progress</code>.
     */
    public Double getProgress() {
        return this.progress;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.progress</code>.
     */
    public BatchCycleExecute setProgress(Double progress) {
        this.progress = progress;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.corp_id</code>.
     */
    public BatchCycleExecute setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.batch_id</code>.
     */
    public Long getBatchId() {
        return this.batchId;
    }

    /**
     * Setter for <code>public.batch_cycle_execute.batch_id</code>.
     */
    public BatchCycleExecute setBatchId(Long batchId) {
        this.batchId = batchId;
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
        final BatchCycleExecute other = (BatchCycleExecute) obj;
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
        if (this.startAt == null) {
            if (other.startAt != null)
                return false;
        }
        else if (!this.startAt.equals(other.startAt))
            return false;
        if (this.endAt == null) {
            if (other.endAt != null)
                return false;
        }
        else if (!this.endAt.equals(other.endAt))
            return false;
        if (this.createdUserId == null) {
            if (other.createdUserId != null)
                return false;
        }
        else if (!this.createdUserId.equals(other.createdUserId))
            return false;
        if (this.createdBy == null) {
            if (other.createdBy != null)
                return false;
        }
        else if (!this.createdBy.equals(other.createdBy))
            return false;
        if (this.batchCycleId == null) {
            if (other.batchCycleId != null)
                return false;
        }
        else if (!this.batchCycleId.equals(other.batchCycleId))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.progress == null) {
            if (other.progress != null)
                return false;
        }
        else if (!this.progress.equals(other.progress))
            return false;
        if (this.corpId == null) {
            if (other.corpId != null)
                return false;
        }
        else if (!this.corpId.equals(other.corpId))
            return false;
        if (this.batchId == null) {
            if (other.batchId != null)
                return false;
        }
        else if (!this.batchId.equals(other.batchId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.startAt == null) ? 0 : this.startAt.hashCode());
        result = prime * result + ((this.endAt == null) ? 0 : this.endAt.hashCode());
        result = prime * result + ((this.createdUserId == null) ? 0 : this.createdUserId.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.batchCycleId == null) ? 0 : this.batchCycleId.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.progress == null) ? 0 : this.progress.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.batchId == null) ? 0 : this.batchId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BatchCycleExecute (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(startAt);
        sb.append(", ").append(endAt);
        sb.append(", ").append(createdUserId);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(batchCycleId);
        sb.append(", ").append(status);
        sb.append(", ").append(description);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(progress);
        sb.append(", ").append(corpId);
        sb.append(", ").append(batchId);

        sb.append(")");
        return sb.toString();
    }
}
