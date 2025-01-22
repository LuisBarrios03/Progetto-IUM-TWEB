package com.example.javaserver.languages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService {
    private final LanguagesRepository languagesRepository;
    //done
    @Autowired
    public LanguagesService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    List<Languages> getAllLanguages() {//to remove
        return languagesRepository.findAll();
    }

    public List<Languages> findLanguage(String language) {
        return languagesRepository.findLanguage(language);
    }

    public List<Languages> findLanguagesByType(String type) {
        return languagesRepository.findLanguagesByType(type);
    }
    public Languages save(Languages languages) { //to remove
        return languagesRepository.save(languages);
    }

    public List<Languages> getTop100Languages(){//to remove
        return languagesRepository.findTop100ByOrderByIdAsc();
    };
}
