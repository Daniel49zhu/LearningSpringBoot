- 安全控制Spring Security
    - 快速入门
    
    Spring Security是专门针对基于Spring的项目的安全框架，充分利用了依赖注入和AOP来实现安全的功能。
    
    在早期的Spring Security版本，使用Spring Security需要使用大量XML的配置，本节将全部基于Java配置
    来实现Spring Security的功能。
    
    安全框架有两个重要的概念，即认证（Authentication）和授权（Authorization）。认证即确认用户可以访问
    当前系统；授权即用户在当前系统下的功能权限。本节将围绕认证和授权展开。
    
    - Spring Security的配置
    
    （1） DelegatingFilterProxy
    
     Spring Security为我们提供了多个过滤器来实现所有的安全的功能，我们只需注册一个特殊的DelegatingFilterProxy
     过滤器到WebApplicationInitializer即可。
     
     （2）配置
     
     SPring Security的配置和Spring MVC的配置类似，只需在一个配置类上注解@EnableWebSecurity，并让这个类继承
     WebSecurityConfigurerAdapter即可。
     
     - 用户认证
     
     认证需要我们有一套用户数据的来源，而授权则是对于某个用户有相应的角色权限，在Spring Security里我们通过
     重写`protected void configure(AuthenticationManagerBuilder auth)`方法来实现
     
     （1） 内存中的用户
     
     使用AuthenticationManagerBuilder的inMemoryAuthentication方法即可添加在内存中的用户，并可以给用户
     制定角色权限
     
     （2） JDBC中的用户
     
     JDBC中的用户直接指定dataScource即可
     
     （3） 通用的用户
     
     上面的两种用户和权限的获取方式只限于内存或者JDBC，我们的数据访问方式可以是多种多样的，可以是非关系数据库，也可以是
     常用的JPA等。
     
     - 请求授权
     
     Spring Security是通过重写`protected void configure(HttpSecurity http)`方法来实现请求拦截的。
     Spring Security使用以下匹配器来匹配请求路径：antMatchers、regexMatchers
     
    - 实战
    
    [EnterpriseSecurityStart](security/src/main/java/com/zjc/EnterpriseSecurityStart.java)
    
    [WebMvcConfig](security/src/main/java/com/zjc/config/WebMvcConfig.java)
    
    [WebSecurityConfig](security/src/main/java/com/zjc/config/WebSecurityConfig.java)
    
- 批处理Spring Batch

    Spring Batch是用来处理大量数据操作的一个框架，主要用来读取大量数据，然后进行一定处理后输出成指定的形式。
    
    - Spring Batch的主要组成
    
    ![SpringBatch组成部分](images/batch.jpg "SpringBatch组成部分")
    
    如果要开启批处理还需要在配置类上使用@EnableBatchProcessing
    
    - Job监听
    
    如果需要监听我们的Job的执行情况，则定义一个类实现JobExecutionListener，并在定义Job 的Bean上绑定监听器。
    
    - 数据读取
    
    Spring Batch为我们提供了大量的ItemReader的实现，用来读取不同的数据来源
    
    - 数据处理及校验
    
    数据处理和校验都要通过ItemProcessor接口实现来完成，数据处理只需要ItemProcessor接口，重写其process方法。
    方法输入的参数是从ItemReader读取到的数据，返回给ItemWriter。
    
    我们可以JSR-303的注解，来校验ItemReader读取到的数据是否满足需求。我们可以让我们的ItemProcessor实现ValidatingItemProcessor接口。
    
    - 数据输出
    
    Spring Batch为我们提供了大量的ItemWriter的实现，用来将数据输出到不同的目的地
    
    - 计划任务
    
    Spring Batch的任务是通过JobLauncher的run方法来执行的，因此我们只需在普通的计划任务方法中执行JobLauncher的run方法即可。
    
    - 参数后置绑定
    
    我们在ItemReader和ItemWriter的Bean定义的时候，参数已经硬编码在Bean的初始化中。
    
    - 实战
    
    [EnterpriseBatchStart](batch/src/main/java/com/zjc/EnterpriseBatchStart.java)
    