package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.IInquiryDao;
import com.leonovich.itcrowd.dao.ITopicDao;
import com.leonovich.itcrowd.domain.Inquiry;
import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.service.exception.ServiceException;
import com.leonovich.itcrowd.model.InquiryDTO;
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

import static com.leonovich.itcrowd.util.TestConstants.TestConst.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Test class for test methods in InquiryService.class. Mockito used.
 * Created 18.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class InquiryServiceTest {
    private static Logger logger = Logger.getLogger(InquiryServiceTest.class);

    @Mock
    private ITopicDao topicDao;
    @Mock
    private DtoConverter converter;
    @Mock
    private IInquiryDao inquiryDao;
    @InjectMocks
    private IInquiryService inquiryService = new InquiryService();

    private Inquiry inquiryI;
    private Inquiry inquiryII;
    private InquiryDTO inquiryDTOI;
    private InquiryDTO inquiryDTOII;
    private InquiryDTO inquiryDTOIII;
    private List<InquiryDTO> inquiryDTOs;

    @Before
    public void setUp() throws Exception {
        inquiryI = new Inquiry(ONE, "Description1",  "TestCustomer1", new Topic(ONE, "1"));
        inquiryII = new Inquiry(TWO, "Description2",  "TestCustomer2", new Topic(TWO, "topicName2"));
        inquiryDTOI = new InquiryDTO(ONE, "Description1", "TestCustomer1", "1");
        inquiryDTOII = new InquiryDTO(TWO, "Description2",  "TestCustomer2", "topicName2");
        inquiryDTOIII = new InquiryDTO(THREE, "Description3",  "TestCustomer3", "2");
        inquiryDTOs = Arrays.asList(inquiryDTOI, inquiryDTOII);
    }

    @Test
    public void testGetInquiryDTOStub() throws DaoException, ServiceException {
        try {
            stub(inquiryService.getInquiryDTO(inquiryDTOI.getInquiryId()))
                    .toReturn(inquiryDTOI);
            assertEquals(inquiryDTOI, inquiryService.getInquiryDTO(inquiryDTOI
                    .getInquiryId()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetInquiryDTOVerify() throws DaoException, ServiceException {
        try {
            inquiryService.getInquiryDTO(anyLong());
            verify(inquiryDao).get(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetInquiryDTOException() throws DaoException, ServiceException {
        when(inquiryDao.get(anyLong())).thenThrow(new DaoException());
        inquiryService.getInquiryDTO(anyLong());
    }

    @Test
    public void testGetAllInquiryDTOsStub() throws DaoException, ServiceException{
        try{
            stub(inquiryService.getAllInquiryDTOs()).toReturn(inquiryDTOs);
            assertEquals(inquiryDTOs, inquiryService.getAllInquiryDTOs());
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testSaveInquiryVerify() throws DaoException, ServiceException{
        try {
            inquiryService.saveInquiry(inquiryDTOIII);
            verify(topicDao).get(Long.valueOf(inquiryDTOIII.getTopic()));
            verify(inquiryDao).add(any(Inquiry.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testUpdateInquiry() throws DaoException, ServiceException{
        inquiryI.setCustomerName(inquiryII.getCustomerName());
        inquiryDTOI.setCustomerName((inquiryDTOII.getCustomerName()));
        try {
            inquiryService.updateInquiry(inquiryDTOI);
            verify(inquiryDao).update(any(Inquiry.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testDeleteInquiry() throws DaoException, ServiceException {
        try {
            doNothing().when(inquiryDao).delete(inquiryII);
            assertTrue(inquiryService.deleteInquiry(inquiryII.getInquiryId()));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetInquiryDTOsByCustomerStub() throws DaoException, ServiceException {
        try {
            stub(inquiryService.getInquiryDTOsByCustomer(inquiryDTOI.getCustomerName()))
                    .toReturn(inquiryDTOs);
            assertEquals(inquiryDTOs, inquiryService.getInquiryDTOsByCustomer(inquiryDTOI
                    .getCustomerName()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetInquiryDTOsByCustomerVerify() throws DaoException, ServiceException {
        try {
            inquiryService.getInquiryDTOsByCustomer(anyString());
            verify(inquiryDao).getByCustomerName(anyString());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetInquiryDTOsByCustomerException() throws DaoException, ServiceException {
        when(inquiryDao.getByCustomerName(anyString())).thenThrow(new DaoException());
        inquiryService.getInquiryDTOsByCustomer(anyString());
    }

    @Test
    public void testGetInquiryDTOByIdByCustomerStub() throws DaoException, ServiceException {
        try {
            stub(inquiryService.getInquiryDTOByIdByCustomer(ONE, inquiryDTOI.getCustomerName()))
                    .toReturn(inquiryDTOI);
            assertEquals(inquiryDTOI, inquiryService.getInquiryDTOByIdByCustomer(ONE, inquiryDTOI
                    .getCustomerName()));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetInquiryDTOByIdByCustomerVerify() throws DaoException, ServiceException {
        try {
            inquiryService.getInquiryDTOByIdByCustomer(anyLong(), anyString());
            verify(inquiryDao).getByIdByCustomerName(anyLong(), anyString());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetInquiryDTOByIdByCustomerException() throws DaoException, ServiceException {
        when(inquiryDao.getByIdByCustomerName(anyLong(), anyString())).thenThrow(new DaoException());
        inquiryService.getInquiryDTOByIdByCustomer(anyLong(), anyString());
    }
}
