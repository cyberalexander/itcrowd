package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.IInquiryDao;
import com.leonovich.itcrowd.dao.ITopicDao;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Inquiry;
import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.itcrowd.service.exception.ServiceExceptionCode.*;
import static com.leonovich.itcrowd.service.util.ServiceConstants.Const.*;
import static org.springframework.transaction.annotation.Propagation.*;

/**
 * Service class, for do operations
 * with Inquiry entity on Service layer
 * In this class entity convert to DTO object
 * Created by alexanderleonovich on 16.08.15.
 */
@Transactional(propagation = REQUIRED, readOnly = false)
@Service("inquiryService")
public class InquiryService implements IInquiryService {
    private static Logger logger = Logger.getLogger(InquiryService.class);

    @Autowired
    private IInquiryDao inquiryDao;
    @Autowired
    private ITopicDao topicDao;
    @Autowired
    private DtoConverter converter;

    public InquiryService() {
    }

    /**
     * Method get Inquiry persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public InquiryDTO getInquiryDTO(Long id) throws ServiceException {
        Inquiry inquiry;
        try {
            inquiry = inquiryDao.get(id);
            logger.info(RECEIVED_INQUIRY + inquiry);
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_01);
        }
        return converter.createInquiryDTO(inquiry);
    }

    /**
     * This method get all Inquiry entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<InquiryDTO> getAllInquiryDTOs() throws ServiceException {
        List<Inquiry> inquiries;
        try {
            inquiries = inquiryDao.getAll();
            logger.info(RECEIVE_ALL + inquiries.size());
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_02);
        }
        return converter.convertToDTOlist(inquiries);
    }

    /**
     * Method for save new instance of Inquiry after convertation it from
     * DTO object
     * @param inquiryDTO object for convertation in Inquiry entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean saveInquiry(InquiryDTO inquiryDTO) throws ServiceException {
        Inquiry inquiry = new Inquiry(inquiryDTO);
        try {
            Topic topic = topicDao.get(Long.valueOf(inquiryDTO.getTopic()));
            inquiry.setTopic(topic);
            inquiryDao.add(inquiry);
            logger.info(PERSIST_INQUIRY + inquiry);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_03);
        }
    }

    /**
     * Update instance of Inquiry what contains in
     * database after convertation it from DTO object
     * @param inquiryDTO object for convertation in Inquiry entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = REQUIRES_NEW, readOnly = false)
    public Boolean updateInquiry(InquiryDTO inquiryDTO) throws ServiceException {
        Inquiry inquiry = new Inquiry(inquiryDTO);
        try {
            Topic topic = topicDao.get(Long.valueOf(inquiryDTO.getTopic()));
            inquiry.setTopic(topic);
            inquiryDao.update(inquiry);
            logger.info(UPDATING_INQUIRY + inquiry);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_04);
        }
    }

    /**
     * Delete persisted entity from database by unique id
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public Boolean deleteInquiry(Long id) throws ServiceException {
        Inquiry inquiry;
        try {
            inquiry = inquiryDao.get(id);
            inquiryDao.delete(inquiry);
            logger.info(DELETE_INQUIRY + inquiry);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_05);
        }
    }

    /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameter for search
     * @return result of search
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public List<InquiryDTO> getInquiryDTOsByCustomer(String customerName) throws ServiceException {
        List<Inquiry> inquiries;
        try {
            inquiries = inquiryDao.getByCustomerName(customerName);
            logger.info(RECEIVE_BY_CUSTOMER + inquiries.size());
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_06);
        }
        return converter.convertToDTOlist(inquiries);
    }

    /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameter for search
     * @param inquiryId parameter for search
     * @return result of search
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    public InquiryDTO getInquiryDTOByIdByCustomer(Long inquiryId, String customerName) throws ServiceException {
        Inquiry inquiry;
        try {
            inquiry = inquiryDao.getByIdByCustomerName(inquiryId, customerName);
            logger.info(RECEIVE_BY_CUSTOMER_BY_ID + inquiry);
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_07);
        }
        return converter.createInquiryDTO(inquiry);
    }
}
