package com.leonovich.itcrowd.web.util;

/**
 * My global server list of constants
 * Created by alexanderleonovich on 30.07.15.
 */
public class WebConstants {

    public static class Const {
        /* view names */
        public static final String INQUIRY = "inquiry";
        public static final String MAIN = "main";
        public static final String EDIT_INQUIRY = "edit_inquiry";
        public static final String ADD_INQUIRY = "add_inquiry";
        public static final String ADD_ATTRIBUTE = "add_attribute";
        public static final String TOPICS = "topics";

        /* Messages in logger */
        public static final String ERR_GET_INQ_LIST_0 = "Cannot get list inquiryDTOs!";
        public static final String ERR_GET_INQ_LIST_1 = "Cannot get list inquiryDTOs by CustomerName! Scusi!";
        public static final String ERR_GET_INQ = "Cannot get inquiryDTO by customer name and by inquiry id! Scusi";
        public static final String ERR_EDIT = "Can not edit Inquiry!";
        public static final String ERR_EDIT_WRITE = "Can not edit write Inquiry!";
        public static final String GET_LIST = "Getting list inquiryDTOs: ";
        public static final String GET_LIST_BU_CUST = "Getting list inquiryDTOs by Customer Name: ";
        public static final String GET_INQ_BU_CUST_BY_ID = "Getting inquiryDTO by Customer Name and by inquiry id: ";

        /* FIELD CONSTANTS */
        public static final int ZERO = 0;
        public static final String INQUIRYDTOS = "inquiryDTOs";
        public static final String INQUIRYDTO = "inquiryDTO";
        public static final String CUSTOMER = "customer";
        public static final String ATTRIBUTES = "attributes";
        public static final String TOPICDTOS = "topicDTOs";
        public static final String SUCCESS = "success";
        public static final String ATTRIBUTE_OF_INQUIRY = "attributeOfInquiryDTO";
    }
}
