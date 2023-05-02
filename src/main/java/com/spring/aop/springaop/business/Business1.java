package com.spring.aop.springaop.business;

import com.spring.aop.springaop.aspect.TrackTime;
import com.spring.aop.springaop.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    @TrackTime
    public String calculateSomething() {
        //Business logic that looks at the data and checks
        return dao1.retrieveSomething();
    }
}
