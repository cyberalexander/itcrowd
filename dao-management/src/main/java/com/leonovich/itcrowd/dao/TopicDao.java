package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Topic;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;

import static com.leonovich.itcrowd.dao.exception.DaoExceptionCode.IS_DAO_10;
import static com.leonovich.itcrowd.dao.util.DaoConstants.Const.*;
import static java.net.InetAddress.getLocalHost;

/**
 * Class of specific operations with Topic-entity
 * Created by alexanderleonovich on 14.08.15.
 */
@Repository
public class TopicDao extends GenericAbstractDao<Topic, Long> implements ITopicDao {
    private static Logger logger = Logger.getLogger(TopicDao.class);

    public TopicDao() {
        super(Topic.class);
    }


    /**
     * Method getting Topic object by unique name of Topic
     * @param topicName - CustomerType Caprtion
     * @return Topic entity
     * @throws DaoException - custom Exception class
     * for handle exceptions on DAO layer in application
     */
    @Override
    public Topic getByTopicName(String topicName) throws DaoException {
        try {
            logger.info(PREFIX + getLocalHost().getHostAddress() + GET_BY_TOPIC_NAME);
            return (Topic) getQuery(QUERY_GET_BY_TOPIC_NAME)
                    .setParameter(PARAM, topicName).uniqueResult();
        } catch (UnknownHostException | HibernateException e) {
            throw new DaoException(e, IS_DAO_10);
        }
    }
}
