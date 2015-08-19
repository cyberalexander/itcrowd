package com.leonovich.itcrowd.dao;

import com.leonovich.itcrowd.dao.configuration.DaoConfiguration;
import com.leonovich.itcrowd.dao.exception.DaoException;
import com.leonovich.itcrowd.domain.Topic;
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
public class TopicDaoTest extends UnitilsJUnit4 {

    @SpringBeanByName
    private ITopicDao topicDao;

    private Topic topicI;
    private Topic topicII;
    private Topic topicIII;

    @SpringApplicationContext
    public ConfigurableApplicationContext createAppContext() {
        return new AnnotationConfigApplicationContext(DaoConfiguration.class);
    }

    @Before
    public void setUp() throws Exception {
        topicI = new Topic(ONE, "topicName1");
        topicII = new Topic(TWO, "topicName2");
        topicIII = new Topic(THREE, "topicName3");
    }

    @Test
    public void testGetTopic() throws DaoException {
        Topic result = topicDao.get(topicI.getTopicId());
        assertNotNull(result);
        assertEquals(topicI, result);
    }

    @Test
    public void testGetAllTopics() throws DaoException {
        List<Topic> result = topicDao.getAll();
        assertNotNull(result);
        assertTrue(result.size() > ZERO);
    }

    @Test
    public void testAddTopic() throws DaoException {
        Long result = topicDao.add(topicIII);
        assertNotNull(result);
    }

    @Test
    public void testUpdateTopic() throws DaoException {
        topicI.setTopicName(topicII.getTopicName());
        topicDao.update(topicI);
        Topic result = topicDao.get(topicI.getTopicId());
        assertNotNull(result);
        assertEquals(topicI, result);
    }

    @Test
    public void testDeleteTopic() throws DaoException {
        topicDao.delete(topicII);
        Topic result = topicDao.get(topicII.getTopicId());
        assertNull(result);
    }

    @Test
    public void testGetByTopicName() throws DaoException {
        Topic result = topicDao.getByTopicName(topicI.getTopicName());
        assertNotNull(result);
        assertEquals(topicI, result);
    }
}
