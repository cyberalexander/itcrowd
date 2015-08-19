package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.configuration.DaoConfiguration;
import com.leonovich.itcrowd.domain.Inquiry;
import com.leonovich.itcrowd.domain.Topic;
import com.leonovich.itcrowd.dao.exception.DaoException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

import java.util.List;

import static com.leonovich.itcrowd.util.TestConstants.TestConst.*;
import static org.junit.Assert.*;


/**
 * Test class for CRUD operations with CustomerType-entity.
 * Created 14.08.15.
 * @author Alexander Leonovich
 * @version 1.0
 */
@DataSet
@Transactional
public class InquiryDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IInquiryDao inquiryDao;

    private Inquiry inquiryI;
    private Inquiry inquiryII;
    private Inquiry inquiryIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        inquiryI = new Inquiry(ONE, "Description1",  "TestCustomer1", new Topic(ONE, "topicName1"));
        inquiryII = new Inquiry(TWO, "Description2",  "TestCustomer2", new Topic(TWO, "topicName2"));
        inquiryIII = new Inquiry(THREE, "Description3",  "TestCustomer3", new Topic(THREE, "topicName3"));
    }

    @Test
    public void testGetInquiry() throws DaoException {
        Inquiry result = inquiryDao.get(inquiryI.getInquiryId());
        assertNotNull(result);
        assertEquals(inquiryI, result);
    }

    @Test
    public void testGetAllInquiries() throws DaoException {
        List<Inquiry> result = inquiryDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddInquiry() throws DaoException {
        Long result = inquiryDao.add(inquiryIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateInquiry() throws DaoException {
        inquiryI.setDescription(inquiryII.getDescription());
        inquiryDao.update(inquiryI);
        Inquiry result = inquiryDao.get(inquiryI.getInquiryId());
        assertNotNull(result);
        assertEquals(inquiryI, result);
    }

    @Test
    public void testDeleteInquiry() throws DaoException {
        inquiryDao.delete(inquiryII);
        Inquiry result = inquiryDao.get(inquiryII.getInquiryId());
        assertNull(result);
    }

    @Test
    public void testGetByCustomerName() throws DaoException {
        List<Inquiry> result = inquiryDao.getByCustomerName(inquiryI.getCustomerName());
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testGetByIdByCustomerName() throws DaoException {
        Inquiry result = inquiryDao.getByIdByCustomerName(inquiryI.getInquiryId(), inquiryI.getCustomerName());
        assertNotNull(result);
        assertEquals(inquiryI, result);
    }
}
