package com.example.javaserver.languages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Service
public class LanguagesService {
    private final LanguagesRepository languagesRepository;
    //done
    @Autowired
    public LanguagesService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    List<Languages> getAllLanguages() {
        return languagesRepository.findAll();
    }

    public List<Languages> findLanguage(String language) {
        return languagesRepository.findLanguage(language);
    }

    public List<Languages> findLanguagesByType(String type) {
        return languagesRepository.findLanguagesByType(type);
    }


    public List<Languages> getTop100Languages(){//??to remove??
        return languagesRepository.findTop100ByOrderByIdAsc();
    };
}
