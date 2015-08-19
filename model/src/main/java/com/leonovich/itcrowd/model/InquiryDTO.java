package com.leonovich.itcrowd.model;


import java.io.Serializable;
import java.util.Date;
/**
 * Copy of domain entity Inquiry
 * Created by alexanderleonovich on 14.08.15.
 */
public class InquiryDTO implements Serializable {


    private static final long serialVersionUID = 1511705880514947313L;

    private Long inquiryId;

    private String description;

    private Date createDate;

    private Date modifiedWhen;

    private String customerName;

    private String topic;

    public InquiryDTO() {
    }

    public InquiryDTO(Long inquiryId, String description, String customerName, String topic) {
        this.inquiryId = inquiryId;
        this.description = description;
        this.customerName = customerName;
        this.topic = topic;
    }

    public InquiryDTO(Long inquiryId, String description, Date createDate, Date modifiedWhen, String customerName) {
        this.inquiryId = inquiryId;
        this.description = description;
        this.createDate = createDate;
        this.modifiedWhen = modifiedWhen;
        this.customerName = customerName;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedWhen() {
        return modifiedWhen;
    }

    public void setModifiedWhen(Date modifiedWhen) {
        this.modifiedWhen = modifiedWhen;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InquiryDTO that = (InquiryDTO) o;

        if (inquiryId != null ? !inquiryId.equals(that.inquiryId) : that.inquiryId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifiedWhen != null ? !modifiedWhen.equals(that.modifiedWhen) : that.modifiedWhen != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        return !(topic != null ? !topic.equals(that.topic) : that.topic != null);

    }

    @Override
    public int hashCode() {
        int result = inquiryId != null ? inquiryId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifiedWhen != null ? modifiedWhen.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InquiryDTO{" +
                "inquiryId=" + inquiryId +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", modifiedWhen=" + modifiedWhen +
                ", customerName='" + customerName + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
