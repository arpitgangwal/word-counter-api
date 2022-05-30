package com.word.counter.services;

import com.word.counter.dao.WordStorageDao;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class CountWordsImplTest {
   @InjectMocks
   private CountWordsImpl countWords;
   @Mock
   private WordStorageDao wordStorageDao;
   private String word = "word";

    @Test
    void testCountWord() {
        when(wordStorageDao.getWordCount(word)).thenReturn(1l);
        assertEquals(countWords.countWord(word), 1l);
    }
    @Test
    void testCountWordNotExisting() {
        when(wordStorageDao.getWordCount("word")).thenReturn(0L);
        assertEquals(countWords.countWord("word"), 0);
    }
}