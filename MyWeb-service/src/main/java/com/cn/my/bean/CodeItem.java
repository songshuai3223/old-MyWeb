package com.cn.my.bean;


import java.util.Date;

public class CodeItem{
    private Long itemId;

    private Long codeId;

    private String itemName;

    private String itemCode;

    private String itemDesc;

    private Boolean itemStatus;

    private Date createdTime;

    private Long createdBy;

    private Date updatedTime;

    private Long updateBy;

    /**
     * @return item_id
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return code_id
     */
    public Long getCodeId() {
        return codeId;
    }

    /**
     * @param codeId
     */
    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    /**
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * @return item_code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    /**
     * @return item_desc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * @return item_status
     */
    public Boolean getItemStatus() {
        return itemStatus;
    }

    /**
     * @param itemStatus
     */
    public void setItemStatus(Boolean itemStatus) {
        this.itemStatus = itemStatus;
    }

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return created_by
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return updated_time
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * @param updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * @return update_by
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}