package com.dubm.apply.mybatis.po;

import java.math.BigDecimal;
import java.util.Date;

public class Media {
    private Long id;

    private String mediaName;

    private String mediaFullName;

    private String address;

    private String payMethod;

    private Long createId;

    private Date createTime;

    private Long modifyId;

    private Date modifyTime;

    private String receivedSubject;

    private String receivedAcct;

    private String bankName;

    private String remark;

    private String newMedia;

    private String newRebate;

    private String rebateInstructions;

    private Byte delFlag;

    private BigDecimal mediaAmount;

    private BigDecimal depositAmount;

    private Byte depositStatus;

    private Date periodStart;

    private Date periodEnd;

    private Long coId;

    private BigDecimal totalDepositAmount;

    private BigDecimal totalRechargeAmount;

    private Integer mediaFlag;

    private Byte splitFlag;

    private Byte isSmallMedia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName == null ? null : mediaName.trim();
    }

    public String getMediaFullName() {
        return mediaFullName;
    }

    public void setMediaFullName(String mediaFullName) {
        this.mediaFullName = mediaFullName == null ? null : mediaFullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getReceivedSubject() {
        return receivedSubject;
    }

    public void setReceivedSubject(String receivedSubject) {
        this.receivedSubject = receivedSubject == null ? null : receivedSubject.trim();
    }

    public String getReceivedAcct() {
        return receivedAcct;
    }

    public void setReceivedAcct(String receivedAcct) {
        this.receivedAcct = receivedAcct == null ? null : receivedAcct.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNewMedia() {
        return newMedia;
    }

    public void setNewMedia(String newMedia) {
        this.newMedia = newMedia == null ? null : newMedia.trim();
    }

    public String getNewRebate() {
        return newRebate;
    }

    public void setNewRebate(String newRebate) {
        this.newRebate = newRebate == null ? null : newRebate.trim();
    }

    public String getRebateInstructions() {
        return rebateInstructions;
    }

    public void setRebateInstructions(String rebateInstructions) {
        this.rebateInstructions = rebateInstructions == null ? null : rebateInstructions.trim();
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public BigDecimal getMediaAmount() {
        return mediaAmount;
    }

    public void setMediaAmount(BigDecimal mediaAmount) {
        this.mediaAmount = mediaAmount;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Byte getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(Byte depositStatus) {
        this.depositStatus = depositStatus;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Long getCoId() {
        return coId;
    }

    public void setCoId(Long coId) {
        this.coId = coId;
    }

    public BigDecimal getTotalDepositAmount() {
        return totalDepositAmount;
    }

    public void setTotalDepositAmount(BigDecimal totalDepositAmount) {
        this.totalDepositAmount = totalDepositAmount;
    }

    public BigDecimal getTotalRechargeAmount() {
        return totalRechargeAmount;
    }

    public void setTotalRechargeAmount(BigDecimal totalRechargeAmount) {
        this.totalRechargeAmount = totalRechargeAmount;
    }

    public Integer getMediaFlag() {
        return mediaFlag;
    }

    public void setMediaFlag(Integer mediaFlag) {
        this.mediaFlag = mediaFlag;
    }

    public Byte getSplitFlag() {
        return splitFlag;
    }

    public void setSplitFlag(Byte splitFlag) {
        this.splitFlag = splitFlag;
    }

    public Byte getIsSmallMedia() {
        return isSmallMedia;
    }

    public void setIsSmallMedia(Byte isSmallMedia) {
        this.isSmallMedia = isSmallMedia;
    }
}