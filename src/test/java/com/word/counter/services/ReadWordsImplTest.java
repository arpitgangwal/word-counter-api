package com.word.counter.services;

import com.word.counter.dao.WordStorageDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReadWordsImplTest {
   @InjectMocks
   ReadWordsImpl readWords;
   @Mock
   Translator translator;
   @Mock
    WordStorageDao wordStorageDao;
   private List<String> wordList;
    @BeforeEach
    void setUp() {
      wordList = Arrays.asList("12&", "abc12", "abc");
    }

    @Test
    void readWords() {
        readWords.readWords(wordList);
    }
}