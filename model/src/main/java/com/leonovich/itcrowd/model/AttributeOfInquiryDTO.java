package com.leonovich.itcrowd.model;

import java.io.Serializable;

/**
 * Copy of domain entity AttributeOfInquiry
 * Created by alexanderleonovich on 14.08.15.
 */
public class AttributeOfInquiryDTO implements Serializable {

    private static final long serialVersionUID = -496923711574121507L;
    private Long id;
    private String name;
    private String value;

    public AttributeOfInquiryDTO() {
    }


    public AttributeOfInquiryDTO(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeOfInquiryDTO that = (AttributeOfInquiryDTO) o;

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
        return "AttributeOfInquiryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
