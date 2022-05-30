package com.word.counter.dao;

import java.util.List;

public interface WordStorageDao {
    void addWord(String word);
    long getWordCount(String word);
}
