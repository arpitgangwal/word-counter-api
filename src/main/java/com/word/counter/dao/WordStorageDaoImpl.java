package com.word.counter.dao;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
@Component
public class WordStorageDaoImpl implements WordStorageDao {
    private static ConcurrentHashMap<String, Long> map;
    static {
        map = new ConcurrentHashMap<>();
    }
    @Override
    public void addWord(String word) {
        if (map.containsKey(word))
            map.put(word, map.get(word) + 1);
        else
            map.put(word, 1l);
    }

    @Override
    public long getWordCount(String word) {
        Long count = map.get(word);
        return count != null ? count: 0;
    }
}
