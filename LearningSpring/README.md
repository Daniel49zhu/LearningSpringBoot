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
    
    
 -----
 ##### Spring常用配置
 @org.springframework.context.annotation.Scope  
 用来描述Spring如何创建Bean的实例，
  (1)Singleton 一个容器中只有一个实例，(2)Prototype 每次调用创建一个实例，(3)Request 给每一个Request创建一个实例 ，(4)Session 给每一个Session创建一个实例
  - 示例4
  
      [DemoSingletonService](src/main/java/example4/DemoSingletonService.java)
        无需添加注解，默认为单例的
        
      [DemoPrototypeService](src/main/java/example4/DemoPrototypeService.java)
      @Scope("prototype")，每次通过容器获取时都会创建一次
      
      [Main](src/main/java/example4/Main.java) 启动方法
  
- 示例5

    Spring内置了EL-spring表达式，主要在@Value注解中使用该表达式，示例5主要实现以下几种情况
    (1)注入普通字符，(2)注入操作系统属性，(3)注入表达式运算结果，(4)注入其他Bean的属性，(5)注入文件内容，(6)注入网址内容，(7)注入属性文件
    
    [ElConfig](src/main/java/example5/ElConfig.java) 具体见类内注释
    
- 示例6
    Spring支持在Bean创建之前和之后做一些必要的操作，一是使用@Bean的initMethod和destroyMethod方法，
    而是利用JSR-250提供的@PostConstruct和@PreDestory
    
    [BeanWayService](src/main/java/example6/BeanWayService.java)
    
    [Jsr250WayService](src/main/java/example6/Jsr250WayService.java)
    @PostConstruct会在构造方法执行之后执行，@PreDestroy是在Bean销毁之前创建
    
    [PrepostConfig](src/main/java/example6/PrepostConfig.java)
    initMethod会在构造方法执行之后执行，destroyMethod是在Bean销毁之前创建
    
 - 示例7
 
    Profile为不同环境下使用不同配置提供支持（例如开发环境和生产环境中的数据库配置）
    
    (1)通过设定Environment的ActivrProfiles来设定当前context需要使用的配置环境。
    
    (2)通过设定jvm的spring.profiles.active参数来设置配置环境
    
    (3)Web项目设置在Servlet的context parameter
    
    [ProfileConfig](src/main/java/example7/ProfileConfig.java)
    
    @Profile为dev实例化devDemoBean，为prod实例化prodDemoBean
    
- 示例8
    Spring的事件（Application Event）为Bean与Bean之间的消息通信提供了支持，当一个Bean处理完一个任务之后，
    希望另一个Bean知道并做出相应处理，就需要另外一个Bean来监听当前Bean发出的事件。流程如下
    
    (1) 自定义事件，继承ApplicationEvent
    
    (2)定义事件监听器，实现ApplicationListener
    
    (3)使用容器发布事件
    
    [DemoEvent](src/main/java/example8/DemoEvent.java)自定义事件
    
    [DemoListener](src/main/java/example8/DemoListener.java)自定义监听器，通过实现onApplicationEvent方法对消息进行处理
    
    [DemoPublisher](src/main/java/example8/DemoPublisher.java)注入ApplicationContext用来发布事件，使用publishEvent方法来发布
    
- 示例9
    Spring Aware目的是维克让Bean能获取到管理它的Spring容器的服务，ApplicationContext接口继承了MessageSource，ApplicationEventPublisher和ResourceLoader接口，
    所以Bean继承了ApplicationContextAware可以获得Spring容器的所有服务。
    
    [AwareService](src/main/java/example9/AwareService.java)实现BeanNameAware和ResourceLoaderAware，获得Bean名称和资源的加载服务
    
    
- 示例10

    Spring通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用Thread'PoolTaskExecutor可实现一个基于线程池的TaskExecutor。通过@EnableAsync开启对异步任务
    的支持，并通过在实际执行的Bean
    
    [TaskExecutorConfig](src/main/java/example10/TaskExecutorConfig.java) @EnableAsync开启了异步任务的支持，通过getASyncExecutor来获得一个基于线程池的TaskExecutor
    
    [AsyncTaskService](src/main/java/example10/AsyncTaskService.java)  @Async加在方法上代表异步方法，加在类上代表类中所有方法都支持异步
    
    
- 示例11

    Spring对定时任务的支持
    
    [SchedulerTaskService](src/main/java/example11/SchedulerTaskService.java)通过@Scheduled声明该方法是定时任务，使用fixedRate属性每隔固定时间执行
    使用cron属性可按照指定时间执行
    
    [TaskSchedulerConfig](src/main/java/example11/TaskSchedulerConfig.java)通过@EnableScheduling注解开启对计划任务的支持
    
    
- 示例12
    
    示例7中我们通过Profile可以获得不同的Bean，Spring4提供了一个更通用的基于条件的Bean的创建，即使用@Conditional注解，
    @Conditional根据满足某一个特定条件创建一个特定的Bean。比方说，当某一个jar包在一个类路径下的时候，自动配置一个或多个
    Bean；或者只有某个Bean被创建才会创建另外一个Bean。总的来说就是根据特定条件来控制Bean的创建行为。
    
    在Spring Boot中大量使用到条件注解
    
    [ConditionConfig](src/main/java/example12/ConditionConfig.java) 通过@Contional注解，符合WindowsCondition就实例化windowListService，
    符合LinuxCondition就实例化LinuxListService
    
- 示例13
    
    通过组合注解来实现自定义的注解
    
    [ChangConfiguration](src/main/java/example13/ChangConfiguration.java) 将之前常用的@Configuration和@ComponentScan两个注解合并形成一个组合注解



-----
Enable* 注解的小结    
    
@EnableAspectJAutoProxy开启对AspectJ代理的支持，

@EnableAsync开启对异步任务的支持，

@EnableScheduling开启对定时任务的支持，

@EnableWebMvc开启对Web Mvc的支持，

@EnableConfigurationProperties开启对@ConfigurationProperties的支持，

@EnableJpaRepostiories开启对Spring Data JPA Repository的支持，

@EnableTransactionMangement开启注解式事务支持，

@EnableCaching开启注解式缓存支持   
 
-----

- 示例14

[DemoBeanIntegrationTests](src/test/java/example14/DemoBeanIntegrationTests.java) 

SpringJunit4ClassRunner 在Junit环境下提供Spring TestContext Framework的功能，@ContextConfiguration用来加载配置ApplicationContext，@ActiveProfiles用来声明活动的profile


    
    
    
    
    
  



    
