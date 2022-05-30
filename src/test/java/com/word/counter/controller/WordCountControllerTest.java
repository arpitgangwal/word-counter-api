package com.word.counter.controller;

import com.word.counter.services.CountWords;
import com.word.counter.services.ReadWords;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
@SpringBootTest
class WordCountControllerTest {
    @InjectMocks
    private WordCountController wordCountController;
    @Mock
    private ReadWords readWords;
    @Mock
    private CountWords countWords;
    private List<String> wordsList;
    @BeforeEach
    void setUp() {
        wordsList= Arrays.asList("12&", "abc12", "abc", "abc");
    }

    @Test
    void createWordsCount() {
        Assert.assertNotNull(wordCountController.createWordsCount(wordsList));
    }

    @Test
    void countWords() {
        when(countWords.countWord("abc")).thenReturn(0l);
        Assert.assertNotNull(wordCountController.countWords("abc"));

    }
}