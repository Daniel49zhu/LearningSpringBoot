开发的热部署

- 模板热部署

    在Spring Boot里，模板引擎的页面默认是开启缓存的，如果修改了页面的内容，则
    刷新页面是得不到修改后的页面，因此我们可在application.properties中关闭
    模板殷勤的缓存，例如：spring.thymeleaf.cache=false,spring.freemarker.cache=false,
    spring.groovy.template.cache=false,spring.velocity.cache=false
    
- Spring Loaded

    Spring Loaded可实现修改类文件的热部署。
    
- JRebel

    JRebel是Java开发热部署的最佳工具，对Spring Boot也提供了极佳的支持。JRebel为收费软件，可使用14天。
    
- Spring-boot-devtools
    
    在Spring Boot项目中添加spring-boot-devtools依赖即可实现面，即代码的热部署
    
- 常规部署

    jar包形式
    
    1.打包 
    
    可以直接执行 mvn package
    
    2.运行
    
    可以使用以下命令运行
    
    java -jar xx.jar
    
    3.注册为Linux服务
    
    Linux下运行的软件我们通常把它注册为服务，这样我们可以通过命令开启、关闭以及保持开机启动等功能
    
    war形式
    
    在新建Spring Boot项目时可选择打包方式是war形式，打包方式和jar包一致，mvc package，
    如果想要修改打包方式可以在pom.xml中将<packaging>jar</packaging>改为<packaging>war</packaging>
    
- 云部署--基于Docker的部署

    主流的云计算（PAAS）平台都支持发布Docker镜像。Docker是使用Dockerfile文件来编译自己的镜像的。
    
    - Dockerfile
    
    主要有如下的指令。
    （1）FROM指令 （2）MAINTAINER指令 （3）RUN指令 （4）CMD指令 （5）EXPOSE指令
    
    （6）ENV指令 （7）ADD指令 （8）ENTRYPOINT指令