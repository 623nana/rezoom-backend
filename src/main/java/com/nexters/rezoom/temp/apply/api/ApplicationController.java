package com.nexters.rezoom.temp.apply.api;

import com.nexters.rezoom.domain.Question;
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
        return application;
    }

    @PostMapping
    public void saveApplication() {
        Coverletter coverletter = new Coverletter();
        Application application = new Application("이카운트", "Backend-Dev", ApplyType.JUNIOR, coverletter);



        repository.save(application);
    }
}
