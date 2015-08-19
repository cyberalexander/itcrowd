package com.leonovich.itcrowd.domain;

import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Domain entity AttributeOfInquiry
 * Created by alexanderleonovich on 14.08.15.
 */
@Entity
@Table(name = "T_ATTRIBUTES_OF_INQUIRY")
public class AttributeOfInquiry implements Serializable {

    private static final long serialVersionUID = 3561683435366179267L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_ID")
    private Long id;

    @ManyToOne(cascade = REFRESH)
    @JoinColumn(name = "F_INQUIRY_ID")
    private Inquiry inquiry;

    @Column(name = "F_NAME")
    private String name;

    @Column(name = "F_VALUE")
    private String value;


    public AttributeOfInquiry() {
    }

    public AttributeOfInquiry(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public AttributeOfInquiry(AttributeOfInquiryDTO attributeOfInquiryDTO) {
        name = attributeOfInquiryDTO.getName();
        value = attributeOfInquiryDTO.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeOfInquiry that = (AttributeOfInquiry) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttributeOfInquiry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
