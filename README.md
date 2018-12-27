### LearningSpringBoot
-----
demo [app.groovy](src/main/java/app.groovy "app.groovy")，运行`spring run app.groovy` ,浏览器中打开localhost:8080，然后你应该看到以下输出：
`Hello World!`

第一个例子 [Example.java](firstexample/src/main/java/Example.java "Example"),
运行main方法即可启动服务器,浏览器中打开localhost:8080，然后你应该看到以下输出： `Hello World!`
运行 `mbv package`可将项目打包成可执行的jar文件，通过java -jar xxxx 来启动

#### 构建系统
-----
MAVEN
*  配置你的项目继承 spring-boot-starter-parent
```
<!-- Inherit defaults from Spring Boot -->
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>1.3.0.BUILD-SNAPSHOT</version>
</parent>
```
* 导入依赖 如果你不使用 spring-boot-starter-parent  ，通过使用一个 scope=import  的依赖
```
<dependencyManagement>
<dependencies>
<dependency>
<!-- Import dependency management from Spring Boot -->
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-dependencies</artifactId>
<version>1.3.0.BUILD-SNAPSHOT</version>
<type>pom</type>
<scope>import</scope>
</dependency>
</dependencies>
</dependencyManagement>
```
* 如果要将项目打包成可执行jar，需要引入
```
<build>
<plugins>
<plugin>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
</plugins>
</build>
```
    
GRADLE
 * Gradle用户可以直接在它们的 dependencies  节点处导入”starter POMs“
 `````
apply plugin: 'java'
repositories { jcenter() }
dependencies {
compile("org.springframework.boot:spring-boot-starter-web:1.3.0.BUILD-SNAPSHOT")
}
`````
* spring-boot-gradle-plugin插件也是可以使用的，它提供创建可执行jar和从source运行项目的任务
```
buildscript {
repositories { jcenter() }
dependencies {
classpath("org.springframework.boot:spring-boot-gradle-plugin:1.3.0.BUILD-SNAPSHOT")
}
}
apply plugin: 'java'
apply plugin: 'spring-boot'
repositories { jcenter() }
dependencies {
compile("org.springframework.boot:spring-boot-starter-web")
testCompile("org.springframework.boot:spring-boot-starter-test")
}
```
------
* SpringApplication类
   
   
    SpringApplication类提供了一种从main()方法启动Spring应用的便捷方式。在很多情况下，你只需委托给
    SpringApplication.run这个静态方法：
````
public static void main(String[] args){
    SpringApplication.run(MySpringConfiguration.class, args);
}
````
如果默认的SpringApplication不符合你的口味，你可以创建一个本地的实例并自定义它。例如，关闭banner你可以这样写：
````
public static void main(String[] args){
    SpringApplication app = new SpringApplication(MySpringConfiguration.class);
    app.setShowBanner(false);
    app.run(args);
}
````
如果你需要创建一个分层的ApplicationContext（多个具有父子关系的上下文），或你只是喜欢使用流畅的构建API，你可以
使用SpringApplicationBuilder。
```
new SpringApplicationBuilder()
    .showBanner(false)
    .sources(Parent.class)
    .child(Application.class)
    .run(args);
```

* Application事件和监听器

你可以使用多种方式注册事件监听器，最普通的是使用SpringApplication.addListeners(…)方法。在你的应用运行时，应用事
件会以下面的次序发送：
1. 在运行开始，但除了监听器注册和初始化以外的任何处理之前，会发送一个ApplicationStartedEvent。
2. 在Environment将被用于已知的上下文，但在上下文被创建前，会发送一个ApplicationEnvironmentPreparedEvent。
3. 在refresh开始前，但在bean定义已被加载后，会发送一个ApplicationPreparedEvent。
4. 启动过程中如果出现异常，会发送一个ApplicationFailedEvent。


JavaEE颠覆者 SpringBoot实战学习笔记
- [第一章 Spring](LearningSpring/Node.md)




    


