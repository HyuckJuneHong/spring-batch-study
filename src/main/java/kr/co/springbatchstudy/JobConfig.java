package kr.co.springbatchstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob(){
        return jobBuilderFactory.get("Test Job")
                .start(testStep1())
                .next(testStep2())
                .build();
    }

    @Bean
    public Step testStep1() {
        return stepBuilderFactory.get("Test Step1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("=================");
                    System.out.println("Test Step1 Start");
                    System.out.println("=================");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step testStep2() {
        return stepBuilderFactory.get("Test Step2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("=================");
                    System.out.println("Test Step2 Start");
                    System.out.println("=================");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

}
