package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.model.TopicDTO;

import java.util.List;

/**
 * Interface using facade pattern for Topic class.
 * @see TopicFacade
 * Created by alexanderleonovich on 16.08.15.
 */
public interface ITopicFacade {

    List<TopicDTO> getAllTopicDTOs() throws ServiceException;
}
