package com.stmsimplify.stmbatch.config.listeners;

import com.stmsimplify.stmbatch.stepslisteners.*;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenersConfiguration {

    @Bean
    public StepExecutionListener stepAgencyListener(){
        return new StepAgencyListener();
    }

    @Bean
    public StepExecutionListener stepCalendarDatesListener(){
        return new StepCalendarDatesListener();
    }

    @Bean
    public StepExecutionListener stepFareAttributesListener(){
        return new StepFareAttributesListener();
    }

    @Bean
    public StepExecutionListener stepFareRulesListener(){
        return new StepFareRulesListener();
    }

    @Bean
    public StepExecutionListener stepFrequenciesListener(){
        return new StepFrequenciesListener();
    }

    @Bean
    public StepExecutionListener stepRoutesListener(){
        return new StepRoutesListener();
    }

    @Bean
    public StepExecutionListener stepShapesListener(){
        return new StepShapesListener();
    }

    @Bean
    public StepExecutionListener stepStopsListener(){
        return new StepStopsListener();
    }

    @Bean
    public StepExecutionListener stepStopTimesListener(){
        return new StepStopTimesListener();
    }

    @Bean
    public StepExecutionListener stepTripsListener(){
        return new StepTripsListener();
    }
}
