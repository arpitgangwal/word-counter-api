package com.word.counter.services;

import org.springframework.stereotype.Service;

@Service
public class TranslatorImpl implements Translator{
    @Override
    public String translateToEnglish(String word) {
        return word;
    }
}
