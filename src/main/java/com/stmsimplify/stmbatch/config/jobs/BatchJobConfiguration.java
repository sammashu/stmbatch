package com.stmsimplify.stmbatch.config.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


@Slf4j
@Configuration
@EnableBatchProcessing
public class BatchJobConfiguration extends DefaultBatchConfigurer {

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private Step stepAgency, stepAgencyDelete, stepCalendarDates, stepCalendarDatesDelete, stepFareAttributes, stepFareAttributesDelete,
            stepFareRules, stepFareRulesDelete, stepFrequencies, stepFrequenciesDelete, stepRoutes, stepRoutesDelete, stepShapes,
            stepShapesDelete, stepStops, stepStopsDelete, stepStopTimes, stepStopTimesDelete, stepTrips, stepTripsDelete;

    @Bean
    public Job batchJob(){
        return jobBuilderFactory.get("batchJob").incrementer(new RunIdIncrementer())
                .start(stepAgencyDelete)
                .next(stepAgency)
                .start(stepCalendarDatesDelete)
                .next(stepCalendarDates)
                .start(stepFareAttributesDelete)
                .next(stepFareAttributes)
                .start(stepFareRulesDelete)
                .next(stepFareRules)
                .start(stepFrequenciesDelete)
                .next(stepFrequencies)
                .start(stepRoutesDelete)
                .next(stepRoutes)
                .start(stepShapesDelete)
                .next(stepShapes)
                .start(stepStopsDelete)
                .next(stepStops)
                .start(stepStopTimesDelete)
                .next(stepStopTimes)
                .start(stepTripsDelete)
                .next(stepTrips)
                .build();
    }

}
