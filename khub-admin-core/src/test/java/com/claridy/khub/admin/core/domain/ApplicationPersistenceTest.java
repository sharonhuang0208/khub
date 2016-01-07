package com.claridy.khub.admin.core.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.ApplicationRepository;

@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationPersistenceTest {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Application application = new Application();
        application.setName("app name");

        applicationRepository.save(application);

        String uuid = application.getId();

        Assert.assertEquals(application, applicationRepository.findOne(uuid));

    }


}
