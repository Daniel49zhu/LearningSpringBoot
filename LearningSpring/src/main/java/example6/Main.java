package example6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrepostConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);

        Jsr250WayService jsr250WayService = context.getBean(Jsr250WayService.class);

        context.close();
    }
}
