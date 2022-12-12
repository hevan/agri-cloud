package com.agri.mis.exception;

public class BusiNotFoundException extends RuntimeException {

   public String entityName;
   public Long entityId;


    public BusiNotFoundException(Long entityId, String entityName, String message)
    {
      super(message);
      this.entityId = entityId;
      this.entityName = entityName;
    }


    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
