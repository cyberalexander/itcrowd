package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Inquiry;

import java.util.List;

/**
 * Interface for implementation by InquiryDap class
 * for specific operations with Inquiry-entity
 *
 * @see com.leonovich.itcrowd.dao.IInquiryDao
 * Created by alexanderleonovich on 14.08.15.
 */
public interface IInquiryDao extends IGenericDao<Inquiry, Long> {

    /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameters for search
     * @return result of search
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    List<Inquiry> getByCustomerName(String customerName) throws DaoException;

    /**
     * Find Inquiry  by parameters
     * @param customerName parameters for search
     * @param inquiryId id of inquiry
     * @return result of search
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    Inquiry getByIdByCustomerName(Long inquiryId, String customerName) throws DaoException;
}
