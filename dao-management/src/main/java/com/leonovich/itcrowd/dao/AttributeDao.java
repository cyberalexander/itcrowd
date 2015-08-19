package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.AttributeOfInquiry;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.List;

import static com.leonovich.itcrowd.dao.exception.DaoExceptionCode.IS_DAO_09;
import static com.leonovich.itcrowd.dao.util.DaoConstants.Const.PREFIX;
import static com.leonovich.itcrowd.dao.util.DaoConstants.Const.QUERY_GET_BY_INQUIRY_ID;
import static java.net.InetAddress.getLocalHost;

/**
 * Class of specific operations with AttributeOfInquiry-entity
 * Created by alexanderleonovich on 17.08.15.
 */
@Repository
public class AttributeDao extends GenericAbstractDao<AttributeOfInquiry, Long> implements IAttributeDao {
    private static Logger logger = Logger.getLogger(AttributeDao.class);

    public AttributeDao() {
        super(AttributeOfInquiry.class);
    }


    /**
     * Method get list of attributes of inquiry for inquiry
     * by inquiry id
     * @param id identifier of inquiry entity
     * @return list of attributes
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<AttributeOfInquiry> getByInquiryId(Long id) throws DaoException {
            try {
                logger.info(PREFIX + getLocalHost().getHostAddress() + " GET ATTRIBUTES IN DAO LAYER");
                List<AttributeOfInquiry> inquiries = getQuery(QUERY_GET_BY_INQUIRY_ID)
                        .setParameter("id", id).list();
                return inquiries;
            } catch (UnknownHostException | HibernateException e) {
                throw new DaoException(e, IS_DAO_09);
            }
    }
}
