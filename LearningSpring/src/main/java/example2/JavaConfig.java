package example2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    /**
     * // 使用@Bean注解声明当前方法FunctionService的返回值是一个Bean，Bean的名称是方法名。
     * @return
     */
    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        // 注入FunctionService的Bean时候直接调用functionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }
}
