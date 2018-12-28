package example13;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 组合@Configuration元注解。
@Configuration
// 组合@ComponentScan元注解。
@ComponentScan
public @interface ChangConfiguration {

    // 覆盖value参数。
    String[] value() default {};
}