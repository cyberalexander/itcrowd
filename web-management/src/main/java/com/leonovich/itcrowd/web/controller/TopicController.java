package com.leonovich.itcrowd.web.controller;

import com.leonovich.itcrowd.model.TopicDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.facade.ITopicFacade;
import com.leonovich.itcrowd.web.exception.WebException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.leonovich.itcrowd.web.exception.WebExceptionCode.NC_WEB_010;
import static com.leonovich.itcrowd.web.util.WebConstants.Const.TOPICDTOS;
import static com.leonovich.itcrowd.web.util.WebConstants.Const.TOPICS;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Controller for Topic requests from client
 * Created by alexanderleonovich on 16.08.15.
 */
@RestController
@RequestMapping("/")
public class TopicController {
    private static final Logger logger = Logger.getLogger(TopicController.class);

    @Autowired
    private ITopicFacade topicFacade;

    /**
     * Controller get all topics from database and set
     * it in model, after this list of topics will be
     * show to users, who call this controller
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = "/topics", method = GET)
    public ModelAndView welcome(ModelAndView model) throws WebException{
        List<TopicDTO> topicDTOs;
        try {
            topicDTOs = topicFacade.getAllTopicDTOs();
        } catch (ServiceException e) {
            logger.info("Cannot get list topicDTOs");
            throw new WebException(e, NC_WEB_010);
        }
        logger.info("Getting list topicDTOs: " + topicDTOs.size());
        model.addObject(TOPICDTOS, topicDTOs);
        model.setViewName(TOPICS);
        return model;
    }
}
