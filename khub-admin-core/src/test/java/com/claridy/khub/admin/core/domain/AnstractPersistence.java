package com.claridy.khub.admin.core.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.claridy.khub.admin.core.config.DBType;
import com.claridy.khub.admin.core.config.JpaConfiguration;
import com.claridy.khub.admin.core.config.TestConfiguration;

@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(DBType.H2)
public abstract class AnstractPersistence {

    @BeforeClass
    public static void setUp() {
    }

    @Before
    public final void before() {
        doBefore();
    }

    public abstract void doBefore();

    @After
    public final void after() {
        doAfter();
    }

    public abstract void doAfter();

    @AfterClass
    public static void tearDown() {
    }

}
