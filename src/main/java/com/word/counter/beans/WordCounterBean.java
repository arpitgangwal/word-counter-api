package com.word.counter.beans;

import com.word.counter.dao.WordStorageDao;
import com.word.counter.dao.WordStorageDaoImpl;
import com.word.counter.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterBean {
  /*  public Translator translator;
    public WordStorageDao wordStorageDao;
    @Bean
   public Translator getTranslator(){
       return new TranslatorImpl() ;
    }

    @Bean
    public WordStorageDao getWordStorageDao(){
        return new WordStorageDaoImpl();
    }
    @Bean
    public ReadWords getReadWords(){
        return new ReadWordsImpl(translator,wordStorageDao);
    }

    @Bean
    public CountWords getCountWords(){
        return new CountWordsImpl(wordStorageDao);
    }
*/
}
