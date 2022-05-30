package com.word.counter.services;

import com.word.counter.dao.WordStorageDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadWordsImpl implements ReadWords{
    private Translator translator;
    private WordStorageDao wordStorageDao;

    public ReadWordsImpl(Translator translator, WordStorageDao wordStorageDao) {
        this.translator= translator;
        this.wordStorageDao=wordStorageDao;
    }

   /*
     This method calls translator service to translate word in english and store word via DAO layer
    */
    @Override
    public void readWords(List<String> wordsList) {
            wordsList.parallelStream().filter(w-> w.matches("[a-zA-Z]+")).forEach(w -> wordStorageDao.addWord(translator.translateToEnglish(w)));
    }

}
