package com.nexters.rezoom.temp.apply.controller;

import com.nexters.rezoom.temp.apply.domain.Application;
import com.nexters.rezoom.temp.apply.domain.ApplyType;
import com.nexters.rezoom.temp.apply.domain.Coverletter;
import com.nexters.rezoom.temp.apply.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    ApplicationRepository repository;

    @GetMapping(value = "/{id}")
    public Application getApplication(@PathVariable long id) {
        Application application = repository.findById(id);
        System.out.println(application);
        return application;
    }

    @PostMapping
    public void saveApplication() {
        //        Question q1 = new Question("지원 동기는?", "그냥");
//		Question q2 = new Question("성장 과정은?", "잘컷음");
//		List<Question> questions = Arrays.asList(q1, q2);
        Coverletter coverletter = new Coverletter();
        Application application = new Application("이카운트", "Backend-Dev", ApplyType.JUNIOR, coverletter);

        repository.save(application);
    }
}
