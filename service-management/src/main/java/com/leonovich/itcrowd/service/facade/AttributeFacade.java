package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.service.IAttributeService;
import com.leonovich.itcrowd.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Facade layer for AttributeService
 * @see com.leonovich.itcrowd.service.AttributeService
 * Created by alexanderleonovich on 17.08.15.
 */
@Service("attributeFacade")
@Transactional
public class AttributeFacade implements IAttributeFacade{

    @Autowired
    private IAttributeService attributeService;

    @Override
    public Boolean saveAttributeOfInquiry(AttributeOfInquiryDTO attributeOfInquiryDTO) throws ServiceException {
        return attributeService.saveAttributeOfInquiry(attributeOfInquiryDTO);
    }

    @Override
    public List<AttributeOfInquiryDTO> getByInquiryId(Long id) throws ServiceException {
        return attributeService.getByInquiryId(id);
    }

}
