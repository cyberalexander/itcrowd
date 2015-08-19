package com.leonovich.itcrowd.dao.util;

/**
 * My global server list of constants
 * Created by alexanderleonovich on 30.07.15.
 */
public class DaoConstants {

    public static class Const {
        /*  MESSAGES  */
        public static final String PREFIX = "Action from IP ADDRESS: ";
        public static final String GET_MESSAGE = " -=- Getting object with id: ";
        public static final String GET_LIST_MESSAGE = " -=- Getting list of objects";
        public static final String ADD_MESSAGE = " -=- Adding object with id: ";
        public static final String UPDATE_MESSAGE = " -=- Updating object";
        public static final String DELETE_MESSAGE = " -=- Deleting object";
        public static final String GET_HQL_MESSAGE = " -=- Getting hql query";


        public static final String GET_BY_TOPIC_NAME = " -=- Getting Topic by topic name.";
        public static final String GET_BY_CUSTOMER_NAME = " -=- Getting inquiries by customer name.";
        public static final String GET_BY_CUSTOMER_NAME_ID = " -=- Getting inquiry by customer name an by inquiry ID.";

        /* FIELD CONSTANTS */
        public static final String CUSTOMER_NAME = "customerName";
        public static final String INQUIRY_ID = "inquiryId";
        public static final String PARAM = "param";


        /* QUERY CONSTANTS */

        public static final String QUERY_GET_BY_CUSTOMER_NAME = "SELECT inc FROM Inquiry inc WHERE" +
                " inc.customerName like :customerName ORDER BY inc.modifiedWhen DESC";

        public static final String QUERY_GET_BY_ID_BY_CUSTOMER_NAME = "SELECT inc FROM Inquiry inc WHERE" +
                " inc.inquiryId like :inquiryId and inc.customerName like :customerName ORDER BY inc.modifiedWhen DESC";

        public static final String QUERY_GET_BY_INQUIRY_ID = "SELECT at FROM AttributeOfInquiry at WHERE at.inquiry.inquiryId = :id";

        public static final String QUERY_GET_BY_TOPIC_NAME = "from Topic tpc where tpc.topicName like :param ";
    }
}
