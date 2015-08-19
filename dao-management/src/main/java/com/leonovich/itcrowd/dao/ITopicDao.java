package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.dao.exception.DaoException;

/**
 * Interface for implementation by Topic class
 * for specific operations with Topic-entity
 *
 * @see com.leonovich.itcrowd.dao.AttributeDao
 * Created by alexanderleonovich on 14.08.15.
 */
public interface ITopicDao extends IGenericDao<Topic, Long> {

    /**
     * Get Topic from database by unique name
     *
     * @param topicName - Topic name
     * @return Topic object
     * @throws DaoException - custom Exception class
     *                      for handle exceptions on DAO layer in application
     */
    Topic getByTopicName(String topicName) throws DaoException;
}
