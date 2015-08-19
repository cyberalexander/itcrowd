package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.AttributeOfInquiry;

import java.util.List;

/**
 * Interface for implementation by AttributeOfInquiry class
 * for specific operations with AttributeOfInquiry-entity
 *
 * @see com.leonovich.itcrowd.dao.AttributeDao
 * Created by alexanderleonovich on 17.08.15.
 */
public interface IAttributeDao extends IGenericDao<AttributeOfInquiry, Long> {

    /**
     * Method get list of attributes of inquiry for inquiry
     * by inquiry id
     * @param id identifier of inquiry entity
     * @return list of attributes
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    List<AttributeOfInquiry> getByInquiryId(Long id) throws DaoException;
}
