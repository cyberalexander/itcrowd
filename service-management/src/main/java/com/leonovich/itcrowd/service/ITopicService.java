package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.model.TopicDTO;

import java.util.List;

/**
 * Specific intarface for Topic-service
 * Created by alexanderleonovich on 16.08.15.
 */
public interface ITopicService {

    /**
     * Get Topic persisted object from database
     * by unique id and convert it in DTO-object
     *
     * @param id - id of entity in database
     * @return DTO copy of object
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    TopicDTO getTopicDTO(Long id) throws ServiceException;

    /**
     * Get all Topic entities from database and
     * convert it in DTO objects
     *
     * @return List of DTO objects
     * @throws ServiceException - custom Exception class
     *                          for handle exceptions on SERVICE layer in application
     */
    List<TopicDTO> getAllTopicDTOs() throws ServiceException;

}
