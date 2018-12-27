package example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UseFunciotnService useFunciotnService = context.getBean(UseFunciotnService.class);
        System.out.println(useFunciotnService.sayHello("World"));
        context.close();
    }
}
