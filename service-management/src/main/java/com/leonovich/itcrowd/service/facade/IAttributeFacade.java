package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;

import java.util.List;

/**
 * Interface using facade pattern for AttributeFacade class.
 * @see AttributeFacade
 * Created by alexanderleonovich on 17.08.15.
 */
public interface IAttributeFacade {

    Boolean saveAttributeOfInquiry(AttributeOfInquiryDTO attributeOfInquiryDTO) throws ServiceException;

    List<AttributeOfInquiryDTO> getByInquiryId(Long id) throws ServiceException;
}
