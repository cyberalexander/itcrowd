package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.service.IInquiryService;
import com.leonovich.itcrowd.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Facade layer for InquiryService
 * @see com.leonovich.itcrowd.service.InquiryService
 * Created by alexanderleonovich on 17.08.15.
 */
@Service("inquiryFacade")
@Transactional
public class InquiryFacade implements IInquiryFacade {

    @Autowired
    private IInquiryService inquiryService;

    public InquiryFacade() {
    }

    @Override
    public InquiryDTO getInquiryDTO(Long id) throws ServiceException {
        return inquiryService.getInquiryDTO(id);
    }

    @Override
    public List<InquiryDTO> getAllInquiryDTOs() throws ServiceException {
        return inquiryService.getAllInquiryDTOs();
    }

    @Override
    public Boolean saveInquiry(InquiryDTO inquiryDTO) throws ServiceException {
        return inquiryService.saveInquiry(inquiryDTO);
    }

    @Override
    public Boolean updateInquiry(InquiryDTO inquiryDTO) throws ServiceException {
        return inquiryService.updateInquiry(inquiryDTO);
    }

    @Override
    public Boolean deleteInquiry(Long id) throws ServiceException {
        return inquiryService.deleteInquiry(id);
    }

    @Override
    public List<InquiryDTO> getInquiryDTOsByCustomer(String customerName) throws ServiceException {
        return inquiryService.getInquiryDTOsByCustomer(customerName);
    }

    @Override
    public InquiryDTO getInquiryDTOByIdByCustomer(Long inquiryId, String customerName) throws ServiceException {
        return inquiryService.getInquiryDTOByIdByCustomer(inquiryId, customerName);
    }
}
