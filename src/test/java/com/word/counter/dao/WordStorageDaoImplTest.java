package com.word.counter.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WordStorageDaoImplTest {
@Autowired
private WordStorageDao wordStorageDao;
private String word = "Example";

    @Test
    void addWord() {
        wordStorageDao.addWord(word);
        assertEquals(1,wordStorageDao.getWordCount(word));
    }

    @Test
    void getWordCountNotExistent() {
        assertEquals(0,wordStorageDao.getWordCount("word"));
    }

    @Test
    void getWordCount() {
        wordStorageDao.addWord(word);
        wordStorageDao.addWord(word);
        assertEquals(3,wordStorageDao.getWordCount(word));
    }

}