package com.word.counter.controller;

import com.word.counter.services.CountWords;
import com.word.counter.services.ReadWords;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/words")
@SecurityRequirement(name="Authentication")
@Validated
public class WordCountController {
    private ReadWords readWords;
    private CountWords countWords;
    public WordCountController(ReadWords readWords,CountWords countWords){
       this.readWords = readWords;
       this.countWords = countWords;
    }
    /*
    This method take list of words that need to be added and increase count if word already persisted.
     */
    @PostMapping( path= "/add")
    public ResponseEntity createWordsCount(@RequestBody @NotNull List<String> wordsList){
        readWords.readWords(wordsList);
       return ResponseEntity.status(HttpStatus.CREATED).body("Request List Successfully Added: "+ wordsList.toString());
    }
    /*
    This method return the count occurrence of words stored
     */
    @GetMapping(path ="/count/{word}")
    public ResponseEntity countWords(@PathVariable("word") @NotNull @NotBlank String word){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Word count for "+word+" : "+countWords.countWord(word));
    }
}
