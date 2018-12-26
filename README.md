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


