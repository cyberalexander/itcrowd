package com.leonovich.itcrowd.service;

import com.leonovich.itcrowd.dao.IAttributeDao;
import com.leonovich.itcrowd.dao.IInquiryDao;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.AttributeOfInquiry;
import com.leonovich.itcrowd.model.AttributeOfInquiryDTO;
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
public class AttributeServiceTest {
    private static Logger logger = Logger.getLogger(AttributeServiceTest.class);

    @Mock
    private IAttributeDao attributeDao;
    @Mock
    private IInquiryDao inquiryDao;
    @Mock
    private DtoConverter converter;
    @InjectMocks
    private IAttributeService attributeService = new AttributeService();

    private AttributeOfInquiryDTO attributeDTOI;
    private AttributeOfInquiryDTO attributeDTOII;
    private List<AttributeOfInquiryDTO> attributeDTOs;

    @Before
    public void setUp() throws Exception {
        attributeDTOI = new AttributeOfInquiryDTO(ONE, "AttributeName_1", "AttributeValue_1");
        attributeDTOII = new AttributeOfInquiryDTO(TWO, "AttributeName_2", "AttributeValue_2");
        attributeDTOs = Arrays.asList(attributeDTOI, attributeDTOII);
    }

    @Test
    public void testSaveInquiryVerify() throws DaoException, ServiceException{
        try {
            attributeService.saveAttributeOfInquiry(attributeDTOII);
            verify(inquiryDao).get(attributeDTOII.getId());
            verify(attributeDao).add(any(AttributeOfInquiry.class));
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }
    @Test
    public void testGetInquiryDTOStub() throws DaoException, ServiceException {
        try {
            stub(attributeService.getByInquiryId(anyLong()))
                    .toReturn(attributeDTOs);
            assertEquals(attributeDTOs, attributeService.getByInquiryId(ONE));
        } catch (ServiceException e) {
            logger.error(e);
        }
    }

    @Test
    public void testGetInquiryDTOVerify() throws DaoException, ServiceException {
        try {
            attributeService.getByInquiryId(anyLong());
            verify(attributeDao).getByInquiryId(anyLong());
        } catch (DaoException | ServiceException e) {
            logger.error(e);
        }
    }

    @Test(expected = ServiceException.class)
    public void testGetInquiryDTOException() throws DaoException, ServiceException {
        when(attributeDao.getByInquiryId(anyLong())).thenThrow(new DaoException());
        attributeService.getByInquiryId(anyLong());
    }

}
