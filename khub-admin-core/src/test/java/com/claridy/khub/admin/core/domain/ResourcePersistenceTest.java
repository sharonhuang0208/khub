package com.claridy.khub.admin.core.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.ResourceRepository;

public class ResourcePersistenceTest  extends AnstractPersistence {
    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
    }

    @Override
    public void doBefore() {
    }

    @Override
    public void doAfter() {
    }


}
