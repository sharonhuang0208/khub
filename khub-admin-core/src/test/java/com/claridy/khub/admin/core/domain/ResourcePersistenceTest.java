package com.claridy.khub.admin.core.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.ApplicationRepository;
import com.claridy.khub.admin.core.repository.ResourceRepository;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourcePersistenceTest {
    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
    }


}
