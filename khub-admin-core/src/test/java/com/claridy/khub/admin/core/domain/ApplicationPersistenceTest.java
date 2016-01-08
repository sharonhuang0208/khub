package com.claridy.khub.admin.core.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.ApplicationRepository;


public class ApplicationPersistenceTest extends AnstractPersistence{
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

    @Override
    public void doBefore() {
    }

    @Override
    public void doAfter() {
    }


}
