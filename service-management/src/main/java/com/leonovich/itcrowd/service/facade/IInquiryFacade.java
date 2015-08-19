package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;

import java.util.List;

/**
 * Interface using facade pattern for InquiryFacade class.
 * @see InquiryFacade
 * Created by alexanderleonovich on 16.08.15.
 */
public interface IInquiryFacade {


    InquiryDTO getInquiryDTO(Long id) throws ServiceException;

    List<InquiryDTO> getAllInquiryDTOs() throws ServiceException;

    Boolean saveInquiry(InquiryDTO inquiryDTO) throws ServiceException;

    Boolean updateInquiry(InquiryDTO inquiryDTO) throws ServiceException;

    Boolean deleteInquiry(Long id) throws ServiceException;

    List<InquiryDTO> getInquiryDTOsByCustomer(String customerName) throws ServiceException;

    InquiryDTO getInquiryDTOByIdByCustomer(Long inquiryId, String customerName) throws ServiceException;

}
