package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Inquiry;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.List;

import static com.leonovich.itcrowd.dao.exception.DaoExceptionCode.IS_DAO_07;
import static com.leonovich.itcrowd.dao.exception.DaoExceptionCode.IS_DAO_08;
import static com.leonovich.itcrowd.dao.util.DaoConstants.Const.*;
import static java.net.InetAddress.getLocalHost;

/**
 * Class of specific operations with Inquiry-entity
 * Created by alexanderleonovich on 14.08.15.
 */
@Repository
public class InquiryDao extends GenericAbstractDao<Inquiry, Long> implements IInquiryDao {
    private static Logger logger = Logger.getLogger(InquiryDao.class);

    public InquiryDao() {
        super(Inquiry.class);
    }

    /**
     * Find Inquiry or Inquiries by parameters
     * @param customerName parameters for search
     * @return result of search
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Inquiry> getByCustomerName(String customerName) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_BY_CUSTOMER_NAME);
            List<Inquiry> inquiries = getQuery(QUERY_GET_BY_CUSTOMER_NAME)
                    .setParameter(CUSTOMER_NAME, customerName).list();
            return inquiries;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, IS_DAO_07);
        }
    }

    /**
     * Find Inquiry  by parameters
     * @param customerName parameters for search
     * @param inquiryId id of inquiry
     * @return result of search
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    public Inquiry getByIdByCustomerName(Long inquiryId, String customerName) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_BY_CUSTOMER_NAME_ID);
            Inquiry inquiry = (Inquiry) getQuery(QUERY_GET_BY_ID_BY_CUSTOMER_NAME)
                    .setParameter(INQUIRY_ID, inquiryId)
                    .setParameter(CUSTOMER_NAME, customerName).uniqueResult();
            return inquiry;
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, IS_DAO_08);
        }
    }
}
