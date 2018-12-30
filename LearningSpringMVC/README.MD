#### Spring MVC学习

- 示例1
    项目快速搭建，Servlet2.5及以下需要在web.xml中配置Servlet，Sevlet3.0以上可以使用无web.xml的配置，
    在Spring MVC里实现WebApplicationinitializer接口便可实现等同于web.xml 的配置
    
    [MyMvcConfig](src/main/java/example1/MyMvcConfig.java)
    
    ViewResolver是Spring MVC视图渲染的核心机制，Spring MVC里有一个接口叫做ViewResolver，实现这个接口
    要重写resolveViewName()，这个方法的返回值就是接口View，而View的职责就是使用model，request，response对象，
    并将渲染的视图返回给浏览器。
    
    [WebInitializer](src/main/java/example1/WebInitializer.java)
    
    WebApplicationInitializer是Spring提供的用来配置Servlet3.0+ 配置的接口，从而替代了web.xml，实现此接口会自动被
    SpringServletContainerInitializer（用来启动Servlet容器）获取到。
    新建WebApplicationContext，注册配置类，并将其和servletContext关联。注册Spring MVC的DispatcherServlet。
    
    
        Spring MVC常用注解
        
        (1) @Controller，将类声明为一个Spring的Bean，DispatcherServlet会自动扫描有该注解的类
        (2) @RequestMapping，用于映射web请求
        (3) @ResponseBody，将返回值写到response体中，而不是返回一个页面
        (4) @RequestBody，允许request的参数在request体中，而不是直接跟在地址后面
        (5) @PathVariable，用来接受路径参数
        (6) @RestController是一个组合注解，组合了@Controller和@ResponseBody

- 示例2
    [DemoObj](src/main/java/example1/domain/DemoObj.java)
    
    jackson对对象和json转换时需要一个空构造
    
    [DemoAnnoController](src/main/java/example1/web/controller/DemoAnnoController.java)
    
    produce可以设置返回的媒体类型和字符集，produces="application/json;charset=UTF-8"代表返回的是json对象
    
    [DemoRestController](src/main/java/example1/web/controller/DemoRestController.java)
    
    @RestController注解声明了一个控制器，其类中所有方法不需要加@ResponseBody注解
    
- 示例3

    [DemoInterceptor](src/main/java/example1/web/interceptor/DemoInterceptor.java)
    继承了HandlerInterceptorAdapter类来实现自定义的拦截器，重写preHandler放啊，在请求发生前执行，重写postHandle，在请求发生后执行
    
- 示例4

    [ExceptionHandlerAdvice](src/main/java/example1/web/advice/ExceptionHandlerAdvice.java)
    @ControllerAdvice声明一个控制器建言,@ControllerAdvice组合了@Component注解，所以自动注册为Spring的Bean。
    @ExceptionHandler在此处为定义全局处理
    
    -- --后面的部分就没有看了-- --
    
    
    
