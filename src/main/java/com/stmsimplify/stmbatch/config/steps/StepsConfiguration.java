package com.stmsimplify.stmbatch.config.steps;

import com.stmsimplify.stmbatch.models.*;
import com.stmsimplify.stmbatch.reader.DefaultFlatItemReader;
import com.stmsimplify.stmbatch.stepslisteners.*;
import com.stmsimplify.stmbatch.writer.MongoBulkItemWriter;
import com.stmsimplify.stmbatch.writer.MongoBulkItemWriterDelete;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

@Configuration
public class StepsConfiguration {

    private static final int CHUNK = 100;

    @Resource
    private DefaultFlatItemReader defaultReader;

    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Resource
    private MongoTemplate mongoTemplate;

    //StepListener Wiring
    @Resource
    private StepAgencyListener stepAgencyListener;

    @Resource
    private StepCalendarDatesListener stepCalendarDatesListener;

    @Resource
    private StepFareAttributesListener stepFareAttributesListener;

    @Resource
    private StepFareRulesListener stepFareRulesListener;

    @Resource
    private StepFrequenciesListener stepFrequenciesListener;

    @Resource
    private StepRoutesListener stepRoutesListener;

    @Resource
    private StepShapesListener stepShapesListener;

    @Resource
    private StepStopsListener stepStopsListener;

    @Resource
    private StepStopTimesListener stepStopTimesListener;

    @Resource
    private StepTripsListener stepTripsListener;

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepAgency(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Agency.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("agency");
        return stepBuilderFactory.get("stepAgency").listener(stepAgencyListener).<Agency, Agency>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepAgencyDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Agency.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("agency");
        return stepBuilderFactory.get("stepAgencyDelete").listener(stepAgencyListener).<Agency, Agency>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepCalendarDates(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(CalendarDates.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("calendardates");
        return stepBuilderFactory.get("stepCalendarDates").listener(stepCalendarDatesListener).<CalendarDates, CalendarDates>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepCalendarDatesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(CalendarDates.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("calendardates");
        return stepBuilderFactory.get("stepCalendarDatesDelete").listener(stepCalendarDatesListener).<CalendarDates, CalendarDates>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFareAttributes(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(FareAttributes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("fareattributes");
        return stepBuilderFactory.get("stepFareAttributes").listener(stepFareAttributesListener).<FareAttributes, FareAttributes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFareAttributesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(FareAttributes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("fareattributes");
        return stepBuilderFactory.get("stepFareAttributesDelete").listener(stepFareAttributesListener).<FareAttributes, FareAttributes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFareRules(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(FareRules.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("farerules");
        return stepBuilderFactory.get("stepFareAttributes").listener(stepFareRulesListener).<FareRules, FareRules>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFareRulesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(FareRules.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("farerules");
        return stepBuilderFactory.get("stepFareAttributesDelete").listener(stepFareRulesListener).<FareRules, FareRules>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFrequencies(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Frequencies.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("frequencies");
        return stepBuilderFactory.get("stepFrequencies").listener(stepFrequenciesListener).<Frequencies, Frequencies>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepFrequenciesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Frequencies.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("frequencies");
        return stepBuilderFactory.get("stepFrequenciesDelete").listener(stepFrequenciesListener).<Frequencies, Frequencies>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepRoutes(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Routes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("routes");
        return stepBuilderFactory.get("stepRoutes").listener(stepRoutesListener).<Routes, Routes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepRoutesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Routes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("routes");
        return stepBuilderFactory.get("stepRoutesDelete").listener(stepRoutesListener).<Routes, Routes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepShapes(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Shapes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("shapes");
        return stepBuilderFactory.get("stepShapes").listener(stepShapesListener).<Shapes, Shapes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepShapesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Shapes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("shapes");
        return stepBuilderFactory.get("stepShapesDelete").listener(stepShapesListener).<Shapes, Shapes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepStops(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Stops.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("stops");
        return stepBuilderFactory.get("stepStops").listener(stepStopsListener).<Stops, Stops>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepStopsDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Stops.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("stops");
        return stepBuilderFactory.get("stepStopsDelete").listener(stepStopsListener).<Stops, Stops>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepStopTimes(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(StopTimes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("stoptimes");
        return stepBuilderFactory.get("stepStopTimes").listener(stepStopTimesListener).<StopTimes, StopTimes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepStopTimesDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(StopTimes.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("stoptimes");
        return stepBuilderFactory.get("stepStopTimesDelete").listener(stepStopTimesListener).<StopTimes, StopTimes>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepTrips(){
        MongoBulkItemWriter writer = new MongoBulkItemWriter<>(Trips.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("trips");
        return stepBuilderFactory.get("stepTrips").listener(stepTripsListener).<Trips, Trips>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Step stepTripsDelete(){
        MongoBulkItemWriterDelete writer = new MongoBulkItemWriterDelete<>(Trips.class);
        writer.setTemplate(mongoTemplate);
        writer.setCollection("trips");
        return stepBuilderFactory.get("stepTripsDelete").listener(stepTripsListener).<Trips, Trips>chunk(CHUNK)
                .reader(defaultReader)
                .writer(writer)
                .build();
    }
}
