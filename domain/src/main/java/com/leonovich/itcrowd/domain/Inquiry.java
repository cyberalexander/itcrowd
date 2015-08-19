package com.leonovich.itcrowd.domain;

import com.leonovich.itcrowd.model.InquiryDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Domain entity Inquiry
 * Created by alexanderleonovich on 14.08.15.
 */
@Entity
@Table(name = "T_INQUIRIES")
public class Inquiry implements Serializable {

    private static final long serialVersionUID = 2885245630134778942L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_INQUIRY_ID")
    private Long inquiryId;

    @Column(name = "F_DESCRIPTION", columnDefinition = "text")
    private String description;

    @Temporal(TIMESTAMP)
    @Column(name = "F_CREATE_DATE", updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "F_MODIFIED_WHEN")
    private Date modifiedWhen;

    @Column(name = "F_CUSTOMER_NAME")
    private String customerName;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "F_TOPIC_ID")
    private Topic topic;

    @OneToMany(mappedBy = "inquiry", fetch = LAZY, cascade = {REFRESH, REMOVE})
    private Set<AttributeOfInquiry> attributeOfInquirySet;

    public Inquiry(InquiryDTO inquiryDTO) {
        inquiryId = inquiryDTO.getInquiryId();
        description = inquiryDTO.getDescription();
        createDate = inquiryDTO.getCreateDate();
        modifiedWhen = inquiryDTO.getModifiedWhen();
        customerName = inquiryDTO.getCustomerName();
    }

    public Inquiry() {
    }

    public Inquiry(Long inquiryId, String description, Date createDate, String customerName) {
        this.inquiryId = inquiryId;
        this.description = description;
        this.createDate = createDate;
        this.customerName = customerName;
    }

    public Inquiry(Long inquiryId, String description, Date createDate, Date modifiedWhen, String customerName) {
        this.inquiryId = inquiryId;
        this.description = description;
        this.createDate = createDate;
        this.modifiedWhen = modifiedWhen;
        this.customerName = customerName;
    }

    public Inquiry(Long inquiryId, String description, String customerName, Topic topic) {
        this.inquiryId = inquiryId;
        this.description = description;
        this.customerName = customerName;
        this.topic = topic;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getModifiedWhen() {
        return modifiedWhen;
    }

    public void setModifiedWhen(Date modifiedWhen) {
        this.modifiedWhen = modifiedWhen;
    }

    public Set<AttributeOfInquiry> getAttributeOfInquirySet() {
        return attributeOfInquirySet;
    }

    public void setAttributeOfInquirySet(Set<AttributeOfInquiry> attributeOfInquirySet) {
        this.attributeOfInquirySet = attributeOfInquirySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inquiry inquiry = (Inquiry) o;

        if (inquiryId != null ? !inquiryId.equals(inquiry.inquiryId) : inquiry.inquiryId != null) return false;
        if (description != null ? !description.equals(inquiry.description) : inquiry.description != null) return false;
        if (createDate != null ? !createDate.equals(inquiry.createDate) : inquiry.createDate != null) return false;
        if (modifiedWhen != null ? !modifiedWhen.equals(inquiry.modifiedWhen) : inquiry.modifiedWhen != null)
            return false;
        return !(customerName != null ? !customerName.equals(inquiry.customerName) : inquiry.customerName != null);

    }

    @Override
    public int hashCode() {
        int result = inquiryId != null ? inquiryId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifiedWhen != null ? modifiedWhen.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "inquiryId=" + inquiryId +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", modifiedWhen=" + modifiedWhen +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
