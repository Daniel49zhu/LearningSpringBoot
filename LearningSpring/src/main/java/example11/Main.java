package example11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
        SchedulerTaskService schedulerTaskService = context.getBean(SchedulerTaskService.class);
    }
}
