package com.leonovich.itcrowd.web.controller;

import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
import com.leonovich.itcrowd.model.InquiryDTO;
import com.leonovich.itcrowd.model.TopicDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.facade.IAttributeFacade;
import com.leonovich.itcrowd.service.facade.IInquiryFacade;
import com.leonovich.itcrowd.service.facade.ITopicFacade;
import com.leonovich.itcrowd.web.exception.WebException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.leonovich.itcrowd.web.exception.WebExceptionCode.*;
import static com.leonovich.itcrowd.web.util.WebConstants.Const.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Main controller in application
 * Created by alexanderleonovich on 16.08.15.
 */
@RestController
@RequestMapping("/customers")
@PropertySource(value = {"classpath:messages.properties"})
public class AppController {
    private static Logger logger = Logger.getLogger(AppController.class);

    @Autowired
    private IInquiryFacade inquiryFacade;
    @Autowired
    private ITopicFacade topicFacade;
    @Autowired
    private IAttributeFacade attributeFacade;
    @Autowired
    private Environment env;

    /**
     * This Controller will get all inquiries.
     * And show main page with list of inquiries
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/inquiries"}, method = GET)
    @ResponseBody
    public ModelAndView listInquiries(ModelAndView model) throws WebException {
        List<InquiryDTO> inquiryDTOs;
        try {
            inquiryDTOs = inquiryFacade.getAllInquiryDTOs();
        } catch (ServiceException e) {
            logger.info(ERR_GET_INQ_LIST_0);
            throw new WebException(e, NC_WEB_000);
        }
        logger.info(GET_LIST + inquiryDTOs.size());
        model.addObject(INQUIRYDTOS, inquiryDTOs);
        model.setViewName(MAIN);
        return model;
    }

    /**
     * This Controller will get list of inquiries
     * by customer name
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/{customerName}/inquiries"}, method = GET)
    @ResponseBody
    public ModelAndView listInquiriesByCustomer(
            @PathVariable String customerName,
            ModelAndView model) throws WebException {
        List<InquiryDTO> inquiryDTOs;
        try {
            inquiryDTOs = inquiryFacade.getInquiryDTOsByCustomer(customerName);
        } catch (ServiceException e) {
            logger.info(ERR_GET_INQ_LIST_1);
            throw new WebException(e, NC_WEB_001);
        }
        logger.info(GET_LIST_BU_CUST + inquiryDTOs.size());
        model.addObject(INQUIRYDTOS, inquiryDTOs);
        model.addObject(CUSTOMER, inquiryDTOs.get(ZERO).getCustomerName());
        model.setViewName(MAIN);
        return model;
    }

    /**
     * This Controller will get unique instance of InquiryDTO
     * by Inquiry Id and by Customer name
     *
     * @param model Spring Model for work with attributes of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/{customerName}/inquiries/{inquiryId}"}, method = GET)
    @ResponseBody
    public ModelAndView getInquiryByIdByCustomer(
            @PathVariable String customerName,
            @PathVariable Long inquiryId,
            ModelAndView model) throws WebException {
        InquiryDTO inquiryDTO;
        List<AttributeOfInquiryDTO> attributes;
        try {
            inquiryDTO = inquiryFacade
                    .getInquiryDTOByIdByCustomer(inquiryId, customerName);
            attributes = attributeFacade.getByInquiryId(inquiryId);
        } catch (ServiceException e) {
            logger.info(ERR_GET_INQ);
            throw new WebException(e, NC_WEB_002);
        }
        logger.info(GET_INQ_BU_CUST_BY_ID + inquiryDTO);
        model.addObject(INQUIRYDTO, inquiryDTO);
        model.addObject(ATTRIBUTES, attributes);
        model.addObject(CUSTOMER, inquiryDTO.getCustomerName());
        model.setViewName(INQUIRY);
        return model;
    }

    /**
     * This Controller will get  inquiry instance from
     * databse and set it in view page for editing
     * fields in this object.
     *
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/edit/{inquiryId}/inquiry"}, method = GET)
    @ResponseBody
    public ModelAndView editInquiryById(
            @PathVariable Long inquiryId,
            ModelAndView model) throws WebException {
        InquiryDTO inquiryDTO;
        List<TopicDTO> topicDTOs;
        try {
            topicDTOs = topicFacade.getAllTopicDTOs();
            inquiryDTO = inquiryFacade.getInquiryDTO(inquiryId);
        } catch (ServiceException e) {
            logger.info(ERR_EDIT);
            throw new WebException(e, NC_WEB_003);
        }
        model.addObject(INQUIRYDTO, inquiryDTO);
        model.addObject(TOPICDTOS, topicDTOs);
        model.setViewName(EDIT_INQUIRY);
        return model;
    }

    /**
     * Controller get edited object of Inquiry from client
     * and update instance in database.
     * @param inquiryDTO object for update in database
     * @param bindingResult binding of parameters in object
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/{customerName}/inquiries/{inquiryId}"}, method = POST)
    @ResponseBody
    public ModelAndView editWriteInquiryById(
            @Validated InquiryDTO inquiryDTO,
            BindingResult bindingResult,
            @PathVariable String customerName,
            @PathVariable Long inquiryId,
            ModelAndView model) throws WebException {
        try {
            inquiryFacade.updateInquiry(inquiryDTO);
        } catch (ServiceException e) {
            logger.info(ERR_EDIT_WRITE);
            throw new WebException(e, NC_WEB_004);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("update.ok"));
        return listInquiries(model);
    }

    /**
     * This Controller will create new   inquiry instance and
     * set it in view page for adding content in fields of this object.
     * @param customerName name of customer, for who we create inquiry
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/{customerName}/inquiries"}, method = POST)
    @ResponseBody
    public ModelAndView addInquiry(@PathVariable String customerName,
                                   ModelAndView model) throws WebException {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setCustomerName(customerName);
        model.addObject(INQUIRYDTO, inquiryDTO);
        List<TopicDTO> topicDTOs;
        try {
            topicDTOs = topicFacade.getAllTopicDTOs();
        } catch (ServiceException e) {
            throw new WebException(e, NC_WEB_005);
        }
        model.addObject(TOPICDTOS, topicDTOs);
        model.setViewName(ADD_INQUIRY);
        return model;
    }

    /**
     * Controller get instance of entity with setting fields
     * and save this instance in database
     * @param inquiryDTO object for add in database
     * @param bindingResult binding of parameters in object
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/save/inquiries"}, method = POST)
    @ResponseBody
    public ModelAndView addWriteInquiry(
            @Validated InquiryDTO inquiryDTO,
            BindingResult bindingResult,
            ModelAndView model) throws WebException {
        try {
            inquiryFacade.saveInquiry(inquiryDTO);
        } catch (ServiceException e) {
            throw new WebException(e, NC_WEB_006);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("save.ok"));
        return listInquiries(model);
    }

    /**
     * Controller Create new instance of attribute of inquiry and set this
     * instance in view page for setting content in fields of this object
     * @param inquiryId unique identifier of inquiry object, what persisted in
     *                  database
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/add/{inquiryId}/attribute/inquiries"}, method = GET)
    @ResponseBody
    public ModelAndView addAttributesOfInquiry(
            @PathVariable Long inquiryId,
            ModelAndView model) throws WebException {
        AttributeOfInquiryDTO attributeOfInquiryDTO = new AttributeOfInquiryDTO();
        attributeOfInquiryDTO.setId(inquiryId);
        model.addObject(ATTRIBUTE_OF_INQUIRY, attributeOfInquiryDTO);
        model.setViewName(ADD_ATTRIBUTE);
        return model;
    }

    /**
     * Controller get instance of attribute of inquiry object from
     * view (client) with setting fields and save it in database
     * @param attributeOfInquiryDTO object for add in database
     * @param bindingResult binding of parameters in object
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/save/attribute/inquiries"}, method = POST)
    @ResponseBody
    public ModelAndView addWriteAttributeOfInquiry(
            @Validated AttributeOfInquiryDTO attributeOfInquiryDTO,
            BindingResult bindingResult,
            ModelAndView model) throws WebException {
        try {
            attributeFacade.saveAttributeOfInquiry(attributeOfInquiryDTO);
        } catch (ServiceException e) {
            throw new WebException(e, NC_WEB_007);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("save.attribute.ok"));
        return listInquiries(model);
    }

    /**
     * Controller get id of object for delete from client and delete this
     * object by unique identifier
     * @param inquiryId unique identifier of inquiry object, what persisted in
     *                  database
     * @param model Spring Model for work with form attribute of request
     *              and choose view for response.
     * @return  model object (model of data and view)
     * @throws WebException catch ServiceException.
     */
    @RequestMapping(value = {"/delete/{inquiryId}/inquiry"}, method = POST)
    @ResponseBody
    public ModelAndView deleteInquiry(
            @PathVariable Long inquiryId,
            ModelAndView model) throws WebException {
        try {
            inquiryFacade.deleteInquiry(inquiryId);
        } catch (ServiceException e) {
            throw new WebException(e, NC_WEB_009);
        }
        model.addObject(SUCCESS, env.getRequiredProperty("delete.ok"));
        return listInquiries(model);
    }

}
