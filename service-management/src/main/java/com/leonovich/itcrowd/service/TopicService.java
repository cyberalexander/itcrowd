package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.ITopicDao;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.model.TopicDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.leonovich.itcrowd.service.exception.ServiceExceptionCode.IS_SERVICE_08;
import static com.leonovich.itcrowd.service.exception.ServiceExceptionCode.IS_SERVICE_09;
import static com.leonovich.itcrowd.service.util.ServiceConstants.Const.RECEIVED_TOPIC;
import static com.leonovich.itcrowd.service.util.ServiceConstants.Const.RECEIVE_ALL_TOPICS;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

/**
 * Service class, for do operations
 * with Topic entity on Service layer
 * In this class entity convert to DTO object
 * Created by alexanderleonovich on 16.08.15.
 */
@Transactional(propagation = REQUIRED, readOnly = false)
@Service("topicService")
public class TopicService implements ITopicService {
    private static Logger logger = Logger.getLogger(TopicService.class);

    @Autowired
    private ITopicDao topicDao;
    @Autowired
    private DtoConverter converter;

    /**
     * Method get Topic persisted object from database
     * by unique id and convert it in DTO-object
     *
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public TopicDTO getTopicDTO(Long id) throws ServiceException {
        Topic topic;
        try {
            topic = topicDao.get(id);
            logger.info(RECEIVED_TOPIC + topic);
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_08);
        }
        return converter.createTopicDTO(topic);
    }

    /**
     * This method get all Topic entities from database and
     * convert it in DTO objects
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     * for handle exceptions on SERVICE layer in application
     */
    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public List<TopicDTO> getAllTopicDTOs() throws ServiceException {
        List<Topic> topics;
        try {
            topics = topicDao.getAll();
            logger.info(RECEIVE_ALL_TOPICS + topics.size());
        } catch (DaoException e) {
            throw new ServiceException(e, IS_SERVICE_09);
        }
        return converter.convertToTopicDTOlist(topics);
    }
}
