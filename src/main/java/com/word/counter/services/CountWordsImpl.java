package com.word.counter.services;

import com.word.counter.dao.WordStorageDao;
import org.springframework.stereotype.Service;

@Service
public class CountWordsImpl implements CountWords{
  private WordStorageDao wordStorageDao;
    public CountWordsImpl(WordStorageDao wordStorageDao) {
        this.wordStorageDao = wordStorageDao;
    }

    @Override
    public long countWord(String word) {
        return wordStorageDao.getWordCount(word);
    }
}
