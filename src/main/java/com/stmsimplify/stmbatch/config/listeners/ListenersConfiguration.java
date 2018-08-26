package com.stmsimplify.stmbatch.config.listeners;

import com.stmsimplify.stmbatch.stepslisteners.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenersConfiguration {

    @Bean
    public StepAgencyListener stepAgencyListener(){
        return new StepAgencyListener();
    }

    @Bean
    public StepCalendarDatesListener stepCalendarDatesListener(){
        return new StepCalendarDatesListener();
    }

    @Bean
    public StepFareAttributesListener stepFareAttributesListener(){
        return new StepFareAttributesListener();
    }

    @Bean
    public StepFareRulesListener stepFareRulesListener(){
        return new StepFareRulesListener();
    }

    @Bean
    public StepFrequenciesListener stepFrequenciesListener(){
        return new StepFrequenciesListener();
    }

    @Bean
    public StepRoutesListener stepRoutesListener(){
        return new StepRoutesListener();
    }

    @Bean
    public StepShapesListener stepShapesListener(){
        return new StepShapesListener();
    }

    @Bean
    public StepStopsListener stepStopsListener(){
        return new StepStopsListener();
    }

    @Bean
    public StepStopTimesListener stepStopTimesListener(){
        return new StepStopTimesListener();
    }

    @Bean
    public StepTripsListener stepTripsListener(){
        return new StepTripsListener();
    }
}
