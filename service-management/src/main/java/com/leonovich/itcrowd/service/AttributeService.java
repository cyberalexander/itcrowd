package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.IAttributeDao;
import com.leonovich.itcrowd.dao.IInquiryDao;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.AttributeOfInquiry;
import com.leonovich.itcrowd.domain.Inquiry;
import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.itcrowd.service.exception.ServiceExceptionCode.IS_SERVICE_10;
import static com.leonovich.itcrowd.service.exception.ServiceExceptionCode.IS_SERVICE_11;
import static com.leonovich.itcrowd.service.util.ServiceConstants.Const.SAVE_ATTRIBUTE;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Service class, for do operations
 * with AttributeOfInquiry entity on Service layer
 * In this class entity convert to DTO object
 * Created by alexanderleonovich on 16.08.15.
 */
@Transactional(propagation = REQUIRED, readOnly = false)
@Service("attributeService")
public class AttributeService implements IAttributeService {
    private static Logger logger = Logger.getLogger(AttributeService.class);

    @Autowired
    private IInquiryDao inquiryDao;
    @Autowired
    private IAttributeDao attributeDao;
    @Autowired
    private DtoConverter converter;

    /**
     * Save new instance of AttributeOfInquiry after convertation it from
     * DTO object
     * @param attributeOfInquiryDTO object for convertation in AttributeOfInquiry entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean saveAttributeOfInquiry(AttributeOfInquiryDTO attributeOfInquiryDTO) throws ServiceException {
        AttributeOfInquiry attribute = new AttributeOfInquiry(attributeOfInquiryDTO);
        try {
            Inquiry inquiry = inquiryDao.get(attributeOfInquiryDTO.getId());
            attribute.setInquiry(inquiry);
            attributeDao.add(attribute);
            logger.info(SAVE_ATTRIBUTE + attribute);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_10);
        }
    }

    /**
     * Method getting list of attributes by unique inquiry id
     * @param id unique inquiry id for search Attributes Of Inquiry
     * @return list of attributes
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public List<AttributeOfInquiryDTO> getByInquiryId(Long id) throws ServiceException {
        List<AttributeOfInquiry> attributes;
        try {
            attributes = attributeDao.getByInquiryId(id);
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_11);
        }
        return converter.convertToAttributeDTOlist(attributes);
    }
}
