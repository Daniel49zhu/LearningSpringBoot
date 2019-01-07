- Thymeleaf模板引擎

    Spring Boot支持大量模板引擎，包括FreeMarker,Groovy,Thymeleaf,Velocity和Mustache,Spirng Boot
    推荐使用Thymeleaf，因为其对Spring MVC提供了完美的支持。
    
    Thymeleaf是一个Java类库，可以作为MVC的View层。
    
    - 引入Thymeleaf
    ```
        <html xmlns:th="http://www.thymeleaf.org" lang="zh_CN">
        <head>
            <meta charset="UTF-8" />
            <link th:href="@{plugin/bootstrap/css/bootstrap.css}" rel="stylesheet" />
            <link th:href="@{plugin/bootstrap/css/bootstrap-theme.css}" rel="stylesheet" />
            <title>主页</title>
        </head>
    ```
    通过`xmlns:th="http://www.thymeleaf.org"`命名空间将页面转换为动态的视图。需要进行动态处理的元素将使用
    `th:`作为前缀；
    
    通过`@{}`引用静态资源；
    
    - 访问model中的数据
    
    通过`@{}`访问model中的属性
    ```
        <div class="panel-body">
            <span th:text="${singlePerson.name}"></span>
        </div>
    ```
    
    - model中数据迭代
    ```
        <li class="list-group-item" th:each="person:${people}">
            <span th:text="${person.name}"></span>
            <span th:text="${person.age}"></span>
            <button class="btn" th:onclick="'getName(\''+${person.name}+'\');'">获得名字</button>
        </li>
    ```
  