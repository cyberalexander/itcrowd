package com.leonovich.itcrowd.service.facade;

import com.leonovich.itcrowd.model.TopicDTO;
import com.leonovich.itcrowd.service.ITopicService;
import com.leonovich.itcrowd.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Facade layer for TopicService
 * @see com.leonovich.itcrowd.service.TopicService
 * Created by alexanderleonovich on 17.08.15.
 */
@Service("topicFacade")
@Transactional
public class TopicFacade implements ITopicFacade {

    @Autowired
    private ITopicService topicService;

    public TopicFacade() {
    }

    @Override
    public List<TopicDTO> getAllTopicDTOs() throws ServiceException {
        return topicService.getAllTopicDTOs();
    }

}
