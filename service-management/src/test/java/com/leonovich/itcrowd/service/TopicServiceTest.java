package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.ITopicDao;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.model.TopicDTO;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.service.util.DtoConverter;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.leonovich.itcrowd.util.TestConstants.TestConst.ONE;
import static com.leonovich.itcrowd.util.TestConstants.TestConst.TWO;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Test class for test methods in TopicService.class. Mockito used.
 * Created 18.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class TopicServiceTest {
    private static Logger logger = Logger.getLogger(TopicServiceTest.class);

    @Mock
    private ITopicDao topicDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private ITopicService topicService = new TopicService();

    private TopicDTO topicDTOI;
    private TopicDTO topicDTOII;
    private List<TopicDTO> topicDTOs;

    @Before
    public void setUp() throws Exception {
        topicDTOI = new TopicDTO(ONE, "TOPICNAME_1");
        topicDTOII = new TopicDTO(TWO, "TOPICNAME_2");
        topicDTOs = Arrays.asList(topicDTOI, topicDTOII);
    }

    @Test
    public void testGetTopicDTOStub() throws DaoException, ServiceException {
        try {
            stub(topicService.getTopicDTO(topicDTOI.getTopicId()))
                    .toReturn(topicDTOI);
            assertEquals(topicDTOI, topicService.getTopicDTO(topicDTOI
                    .getTopicId()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetTopicDTOVerify() throws DaoException, ServiceException {
        try {
            topicService.getTopicDTO(anyLong());
            verify(topicDao).get(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetTopicDTOException() throws DaoException, ServiceException {
        when(topicDao.get(anyLong())).thenThrow(new DaoException());
        topicService.getTopicDTO(anyLong());
    }

    @Test
    public void testGetAllTopicDTOsStub() throws DaoException, ServiceException{
        try{
            stub(topicService.getAllTopicDTOs()).toReturn(topicDTOs);
            assertEquals(topicDTOs, topicService.getAllTopicDTOs());
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

}
