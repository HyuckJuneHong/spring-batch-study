package kr.co.springbatchstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

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

                    //이 방식을 주로 사용.
                    JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
                    jobParameters.getString("name");
                    jobParameters.getLong("seq");
                    jobParameters.getDate("date");
                    jobParameters.getDouble("price");

                    //동일한 값을 얻을 수는 있지만 Map으로 받는다. (즉, 값으로만 얻을 수 있음)
                    Map<String, Object> mapJobParameters = chunkContext.getStepContext().getJobParameters();

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
