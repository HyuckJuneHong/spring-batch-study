package kr.co.springbatchstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/** ApplicationRunner
 * 스프링 부트가 제공하는 인터페이스로 스프링 부트가 초기화되고 완료 시 가장 먼저 호출하는 타입의 클래스이다.
 */
//@Component
//@RequiredArgsConstructor
//public class JobRunner implements ApplicationRunner {
//
//    //JobLauncher는 스프링 배치가 초기화될 때 빈으로 생성이 되어 있기 때문에 주입을 할 수 있다.
//    private final JobLauncher jobLauncher;
//
//    private final Job job;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("name", "user1")
//                .toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
//    }
//}
