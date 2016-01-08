package com.claridy.khub.admin.core.domain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.BackendUserRepository;

public class BackendUserPersistenceTest extends AnstractPersistence {
    @Autowired
    private BackendUserRepository backendUserRepository;

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
