package com.claridy.khub.admin.core.domain;

import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.claridy.khub.admin.core.repository.LanguageRepository;

public class LanguagePersistenceTest extends AnstractPersistence {

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Language language = new Language();
        language.setId(Locale.JAPAN);
        languageRepository.saveAndFlush(language);
    }

    @Override
    public void doBefore() {
    }

    @Override
    public void doAfter() {
    }

}
