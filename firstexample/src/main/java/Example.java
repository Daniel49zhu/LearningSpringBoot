import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RequestMapping  注解提供路由信息。它告诉Spring任何来自"/"路径的HTTP请求都应该被映射到 home  方法。
// @RestController  注解告诉Spring以字符串的形式渲染结果，并直接返回给调用者。
//这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
//由于 spring-boot-starter-web  添加了Tomcat和Spring MVC，所以auto-configuration将假定你正在开发一个web应用并相应地
//对Spring进行设置
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!--from Example";
    }

    public static void main(String[] args) throws Exception{
        //我们的main方法通过调用run，将业务委托给了Spring Boot的SpringApplication类。
        SpringApplication.run(Example.class,args);
    }
}
