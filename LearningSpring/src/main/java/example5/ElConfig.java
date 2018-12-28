package example5;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("example5")
@PropertySource("classpath:test.properties")
public class ElConfig {

    /**
     * 注入普通字符串
     */
    @Value("Hello Example5!")
    private String normal;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 注入表达式
     */
    @Value("#{T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    /**
     * 注入其他Bean的属性
     */
    @Value("#{demoService.another}")
    private String fromAnother;

    /**
     * 注入文件资源
     */
    @Value("classpath:test.txt")
    private Resource testFile;

    /**
     * 注入网址资源
     */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    /**
     * 注入配置文件
     */
    @Value("${book.name}")
    private String bookName;

    /**
     * 注入配置文件
     */
    @Autowired
    private Environment environment;

    /**
     * 注入配置文件
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println("测试注入字符串："+normal);
            System.out.println("测试操作系统属性："+osName);
            System.out.println("测试表达式结果："+randomNumber);
            System.out.println("测试其他Bean属性："+fromAnother);
            System.out.println("测试注入文件资源");
            System.out.println(IOUtils.toString(testFile.getInputStream(),"UTF-8"));
            System.out.println("测试注入网址资源");
            System.out.println(IOUtils.toString(testUrl.getInputStream(),"UTF-8"));
            System.out.println("测试注入配置文件："+bookName);
            System.out.println("测试注入配置文件："+environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
