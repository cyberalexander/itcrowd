package com.leonovich.itcrowd.service;


import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;

import java.util.List;

/**
 * Specific intarface for Inquiry-service
 * Created by alexanderleonovich on 16.08.15.
 */
public interface IInquiryService {

    /**
     * Get Inquiry persisted object from database
     * by unique id and convert it in DTO-object
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    InquiryDTO getInquiryDTO(Long id) throws ServiceException;

    /**
     * Get all Inquiry entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<InquiryDTO> getAllInquiryDTOs() throws ServiceException;

    /**
     * Save new instance of Inquiry after convertation it from
     * DTO object
     * @param inquiryDTO object for convertation in Inquiry entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean saveInquiry(InquiryDTO inquiryDTO) throws ServiceException;

    /**
     * Update instance of Inquiry, what contains in
     * database after convertation it from DTO object
     * @param inquiryDTO object for convertation in Customer entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean updateInquiry(InquiryDTO inquiryDTO) throws ServiceException;

    /**
     * Delete persisted entity from database by unique id
     * @param id unique identifier of entity
     * @return result of operation
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    Boolean deleteInquiry(Long id) throws ServiceException;

   /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameter for search
     * @return result of search
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    List<InquiryDTO> getInquiryDTOsByCustomer(String customerName) throws ServiceException;

    /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameter for search
     * @param inquiryId parameter for search
     * @return result of search
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    InquiryDTO getInquiryDTOByIdByCustomer(Long inquiryId, String customerName) throws ServiceException;
}
