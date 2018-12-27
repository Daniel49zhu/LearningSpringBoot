- 依赖注入

    控制反转（Inversion Of Control）和依赖注入（Dependency injection）是等同的概念，控制反转通过依赖注入
    实现。所谓依赖注入就是容器负责创建和维护对象之间的关系，而不是通过对象来创建自己的依赖。
    依赖注入实现了解耦，Spring中的ApplicationContext负责创建Bean，并通关过容器将功能类的Bean注入到你需要的Bean中;    
    
    spring提供了XML，注解，java配置，groovy配置来实现Bean的创建和注入，这些被称为元数据，及描述数据的数据。
```
//声明Bean的注解
    @Component
    @Service
    @Repository
    @Controller
//注入Bean的注解
    @AutoWired  //Spring提供
    @Inject     //JSR-330提供
    @Resource   //JSR-250提供
```
示例

[FunctionService](src/main/java/example1/FunctionService.java),@Service说明这个Bean交由Spring的容器管理

[UseFunciotnService](src/main/java/example1/UseFunciotnService.java),@Service说明这个Bean交由Spring的容器管理,@Autowired
将FunctionService的实体Bean注入到UseFunctionService中

[Config](src/main/java/example1/Config.java),@Configuration声明当前类是一个配置类，@ComponentScan会自动扫描指定包下所有有
@Service,@Component,@Repository,@Controller的类，并注册到容器中

[Main](src/main/java/example1/Main.java),使用AnnotationConfigApplicationContext作为具体的容器类，并能接受一个配置类

    
