package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;

import java.util.List;

/**
 * Specific intarface for Inquiry-service
 * Created by alexanderleonovich on 16.08.15.
 */
public interface IAttributeService {

    /**
     * Save new instance of AttributeOfInquiry after convertation it from
     * DTO object
     * @param attributeOfInquiryDTO object for convertation in AttributeOfInquiry entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean saveAttributeOfInquiry(AttributeOfInquiryDTO attributeOfInquiryDTO) throws ServiceException;

    /**
     * Method getting list of attributes by unique inquiry id
     * @param id unique inquiry id for search Attributes Of Inquiry
     * @return list of attributes
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<AttributeOfInquiryDTO> getByInquiryId(Long id) throws ServiceException;
}
