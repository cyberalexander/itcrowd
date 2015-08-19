package com.leonovich.itcrowd.service.exception;

/**
 * Enum of messages with exception-codes for Service-layer
 * @author Alexander Leonovich
 * Created 14.08.15.
 * @version 1.0
 */
public enum ServiceExceptionCode {
    IS_SERVICE_01("Can`t get Inquiry"),
    IS_SERVICE_02("Can`t get all Inquiries"),
    IS_SERVICE_03("Can`t save Inquiry"),
    IS_SERVICE_04("Can`t update Inquiry"),
    IS_SERVICE_05("Can`t delete Inquiry by id"),
    IS_SERVICE_06("Can`t get Inquiries by customer. Error search!"),
    IS_SERVICE_07("Can`t get Inquiries by customer and by id. Error search!"),
    IS_SERVICE_08("Can`t get Topic by ID!"),
    IS_SERVICE_09("Can`t get all Topics"),
    IS_SERVICE_10("Can`t save AttributeOfInquiry"),
    IS_SERVICE_11("Can`t get AttributeOfInquiry by ID");

    private final String value;

    private ServiceExceptionCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
