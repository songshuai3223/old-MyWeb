package com.cn.my.bean;

import java.util.Date;

public class Code {
    private Integer id;

    private Long codeId;

    private String codeNameCn;

    private String codeNameEn;

    private String codeDesc;

    private Boolean codeStatus;

    private Date createTime;

    private Long createBy;

    private Date updateDate;

    private Long updateBy;

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
     * @return code_name_cn
     */
    public String getCodeNameCn() {
        return codeNameCn;
    }

    /**
     * @param codeNameCn
     */
    public void setCodeNameCn(String codeNameCn) {
        this.codeNameCn = codeNameCn == null ? null : codeNameCn.trim();
    }

    /**
     * @return code_name_en
     */
    public String getCodeNameEn() {
        return codeNameEn;
    }

    /**
     * @param codeNameEn
     */
    public void setCodeNameEn(String codeNameEn) {
        this.codeNameEn = codeNameEn == null ? null : codeNameEn.trim();
    }

    /**
     * @return code_desc
     */
    public String getCodeDesc() {
        return codeDesc;
    }

    /**
     * @param codeDesc
     */
    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc == null ? null : codeDesc.trim();
    }

    /**
     * @return code_status
     */
    public Boolean getCodeStatus() {
        return codeStatus;
    }

    /**
     * @param codeStatus
     */
    public void setCodeStatus(Boolean codeStatus) {
        this.codeStatus = codeStatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_by
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}