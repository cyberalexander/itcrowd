package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.configuration.DaoConfiguration;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.AttributeOfInquiry;
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
public class AttributeDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private IAttributeDao attributeDao;

    private AttributeOfInquiry attributeI;
    private AttributeOfInquiry attributeII;
    private AttributeOfInquiry attributeIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        attributeI = new AttributeOfInquiry(ONE, "attributeName1", "attributeValue1");
        attributeII = new AttributeOfInquiry(TWO, "attributeName2", "attributeValue2");
        attributeIII = new AttributeOfInquiry(THREE, "attributeName3", "attributeValue3");
    }

    @Test
    public void testGetAttributeOfInquiry() throws DaoException {
        AttributeOfInquiry result = attributeDao.get(attributeI.getId());
        assertNotNull(result);
        assertEquals(attributeI, result);
    }

    @Test
    public void testGetAllAttributeOfInquiries() throws DaoException {
        List<AttributeOfInquiry> result = attributeDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddAttributeOfInquiry() throws DaoException {
        Long result = attributeDao.add(attributeIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateAttributeOfInquiry() throws DaoException {
        attributeI.setValue(attributeII.getValue());
        attributeDao.update(attributeI);
        AttributeOfInquiry result = attributeDao.get(attributeI.getId());
        assertNotNull(result);
        assertEquals(attributeI, result);
    }

    @Test
    public void testDeleteAttributeOfInquiry() throws DaoException {
        attributeDao.delete(attributeII);
        AttributeOfInquiry result = attributeDao.get(attributeII.getId());
        assertNull(result);
    }
}
