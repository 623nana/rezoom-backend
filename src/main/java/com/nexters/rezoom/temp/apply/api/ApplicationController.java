package com.nexters.rezoom.temp.apply.api;

import com.nexters.rezoom.temp.apply.domain.*;
import com.nexters.rezoom.temp.apply.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    ApplicationRepository repository;

    @GetMapping(value = "/{id}")
    public Application getApplication(@PathVariable long id) {
        Application application = repository.findById(id);
        return application;
    }

    @PostMapping
    public void saveApplication() {

        Set<Hashtag> hashtags = new HashSet<>();
        hashtags.add(new Hashtag("jaeeon", "태그1"));
        hashtags.add(new Hashtag("jaeeon", "태그2"));

        Set<Hashtag> hashtags1 = new HashSet<>();
        hashtags1.add(new Hashtag("jaeeon", "태그3"));
        hashtags1.add(new Hashtag("jaeeon", "태그4"));

        Question question = new Question("질문1", "답변1");
        question.setHashtags(hashtags);

        Question question1 = new Question("질문2", "답변2");
        question1.setHashtags(hashtags1);

        Coverletter coverletter = new Coverletter();
        coverletter.setQuestions(Arrays.asList(question, question1));

        Application application = new Application("이카운트", "Backend-Dev", ApplyType.JUNIOR, coverletter);

        repository.save(application);
    }
}
