package com.leonovich.itcrowd.service.util;

import com.leonovich.itcrowd.domain.AttributeOfInquiry;
import com.leonovich.itcrowd.domain.Inquiry;
import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.model.TopicDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.leonovich.itcrowd.service.util.ServiceConstants.Const.ZERO;

/**
 * Custom class - converter from Persisted entity to DTO object
 * Created by alexanderleonovich on 14.08.15.
 */
@Component
public class DtoConverter {

    public DtoConverter() {
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of AttributeOfInquiry entity
     * @param attributeofInquiry object for convertation
     * @return DTO AttributeOfInquiry object
     */
    public AttributeOfInquiryDTO createAttributeOfInquiryDTO(
            AttributeOfInquiry attributeofInquiry) {
        return new AttributeOfInquiryDTO(
                attributeofInquiry.getId(),
                attributeofInquiry.getName(),
                attributeofInquiry.getValue());
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Inquiry entity
     * @param inquiry object for convertation
     * @return DTO Inquiry object
     */
    public InquiryDTO createInquiryDTO(Inquiry inquiry) {
        InquiryDTO inquiryDTO = new InquiryDTO(
                inquiry.getInquiryId(),
                inquiry.getDescription(),
                inquiry.getCreateDate(),
                inquiry.getModifiedWhen(),
                inquiry.getCustomerName());
        if (null != inquiry &&
                null != inquiry.getTopic() &&
                null != inquiry.getTopic().getTopicName()){
            inquiryDTO.setTopic(inquiry.getTopic().getTopicName());
        }
        return inquiryDTO;
    }

    /**
     * Method create new instance of DTO object form
     * persisted instance of Topic entity
     * @param topic object for convertation
     * @return DTO Topic object
     */
    public TopicDTO createTopicDTO(Topic topic) {
        TopicDTO topicDTO = new TopicDTO(
                topic.getTopicId(),
                topic.getTopicName());
        return topicDTO;
    }


    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param inquiries list of entities
     * @return list of DTO objects
     */
    public List<InquiryDTO> convertToDTOlist(List<Inquiry> inquiries){
        List<InquiryDTO> inquiryDTOs = new ArrayList<>(
                inquiries != null ? inquiries.size() : ZERO);
        if (inquiries != null) {
            for (Inquiry inquiry : inquiries) {
                inquiryDTOs.add(createInquiryDTO(inquiry));
            }
        }
        return inquiryDTOs;
    }

    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param atributesOfInquiry list of entities
     * @return list of DTO objects
     */
    public List<AttributeOfInquiryDTO> convertToAttributeDTOlist(
            List<AttributeOfInquiry> atributesOfInquiry){
        List<AttributeOfInquiryDTO> attributesOfInquiryDTOs = new ArrayList<>(
                atributesOfInquiry != null ? atributesOfInquiry.size() : ZERO);
        if (atributesOfInquiry != null) {
            for (AttributeOfInquiry attributeOfInquiry : atributesOfInquiry) {
                attributesOfInquiryDTOs.add(
                        createAttributeOfInquiryDTO(attributeOfInquiry));
            }
        }
        return attributesOfInquiryDTOs;
    }

    /**
     * Util method for convert List Persisted ojects
     * in DTO objects
     * @param topics list of entities
     * @return list of DTO objects
     */
    public List<TopicDTO> convertToTopicDTOlist(List<Topic> topics){
        List<TopicDTO> topicDTOs = new ArrayList<>(
                topics != null ? topics.size() : ZERO);
        if (topics != null) {
            for (Topic topic : topics) {
                topicDTOs.add(createTopicDTO(topic));
            }
        }
        return topicDTOs;
    }
}
