package example6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("example6")
public class PrepostConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    Jsr250WayService jsr250WayService() {
        return new Jsr250WayService();
    }
}
