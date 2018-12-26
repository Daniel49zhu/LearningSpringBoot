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
   1. 配置你的项目继承` spring-boot-starter-parent`
    ```
    <!-- Inherit defaults from Spring Boot -->
    <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.3.0.BUILD-SNAPSHOT</version>
    </parent>
    ```
    2.导入依赖 如果你不使用 spring-boot-starter-parent  ，通过使用一个 scope=import  的依赖
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

