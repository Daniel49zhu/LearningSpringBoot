- 依赖注入

    控制反转（Inversion Of Control）和依赖注入（Dependency injection）是等同的概念，控制反转通过依赖注入
    实现。所谓依赖注入就是容器负责创建和维护对象之间的关系，而不是通过对象来创建自己的依赖。
    依赖注入实现了解耦，Spring中的ApplicationContext负责创建Bean，并通关过容器将功能类的Bean注入到你需要的Bean中;    
    
    spring提供了XML，注解，java配置，groovy配置来实现Bean的创建和注入，这些被称为元数据，及描述数据的数据。
    //声明Bean的注解： @Component，@Service，@Repository，@Controller
    
    //注入Bean的注解： @AutoWired  //Spring提供，@Inject     //JSR-330提供，@Resource   //JSR-250提供


   - 示例1

        [FunctionService](src/main/java/example1/FunctionService.java),@Service说明这个Bean交由Spring的容器管理
        
        [UseFunciotnService](src/main/java/example1/UseFunciotnService.java),@Service说明这个Bean交由Spring的容器管理,@Autowired
        将FunctionService的实体Bean注入到UseFunctionService中
        
        [Config](src/main/java/example1/Config.java),@Configuration声明当前类是一个配置类，@ComponentScan会自动扫描指定包下所有有
        @Service,@Component,@Repository,@Controller的类，并注册到容器中
        
        [Main](src/main/java/example1/Main.java),使用AnnotationConfigApplicationContext作为具体的容器类，并能接受一个配置类
        
        java配置是spring4.x推荐的方式，也是Spring Boot推荐的配置方式

 - 示例2

    [FunctionService](src/main/java/example2/FunctionService.java)，无任何注解
    
    [UseFunciotnService](src/main/java/example2/UseFunctionService.java)，无任何注解
    
    [Config](src/main/java/example2/JavaConfig.java)


  - 示例3 AOP
    Spring AOP的存在目的是为了解耦
    Spring支持AspectJ的注解式切面编程
    
    (1) 使用@Aspect声明一个切面
    
    (2)使用@After @Before @Around定义建言（advice）
    
    (3) 其中@After @Before @Around参数的拦截规则为切点（PointCut）
    
    (4) 其中符合条件的每一个被拦截处为连接点（JoinPoint）
    
    Spring在处理@Transcational和@Cacheable都使用了此种形式的拦截
    
    [Action](src/main/java/example3/Action.java) 定义拦截规则的注解
    
    [DemoAnnotationService](src/main/java/example3/DemoAnnotationService.java)编写使用注解的被拦截类
    
    [DemoMethodService](src/main/java/example3/DemoMethodService.java)编写使用方法规则被拦截类
    
    [LogAspect](src/main/java/example3/LogAspect.java)编写切面
    (1)通过@Aspect注解声明切面
    (2)通过@Component让此切面由Spring容器管理
    (3)通过@PointCut声明切点
    (4)通过@After声明一个建言，并使用@PointCut定义的切点
    (5)通过反射获得注解上的属性，然后做日志记录相关的操作
    (6)通过@Before声明一个建言，此建言直接使用拦截规则作为参数
    
    [AopConfig](src/main/java/example3/AopConfig.java) 使用@EnableAspectJAutoProxy开启堆AspectJ代理的支持




    
