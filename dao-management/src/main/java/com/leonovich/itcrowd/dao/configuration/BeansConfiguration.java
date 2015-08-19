package com.leonovich.itcrowd.dao.configuration;


import com.leonovich.itcrowd.dao.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexanderleonovich on 16.08.15.
 * Configuration class for GenericDao Spring beas
 */
@Configuration
public class BeansConfiguration {

    /**
     * Initialize GenericDao-Bean for work with Topic entity
     * @return GenericDao for Topic.class
     */
    @Bean(name = "topicDao")
    public ITopicDao topicDao() {
        return new TopicDao();
    }

    /**
     * Initialize GenericDao-Bean for work with Inquiry entity
     * @return GenericDao for Inquiry.class
     */
    @Bean(name = "inquiryDao")
    public IInquiryDao inquiryDao() {
        return new InquiryDao();
    }

    /**
     * Initialize GenericDao-Bean for work with AttributeOfInquiry entity
     * @return GenericDao for AttributeOfInquiry.class
     */
    @Bean(name = "attributeDao")
    public IAttributeDao attributeOfInquiryDao() {
        return new AttributeDao();
    }


}
