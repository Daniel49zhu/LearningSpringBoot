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
    
- WebSocket

    WebSocket为浏览器和服务器提供了双工异步通信的功能，即浏览器可以向服务器发送消息，服务器端也可以向
    浏览器发送消息。
    WebSocket通过一个socket来实现双工异步通信。
    
    - 广播式
    
    当服务器端有消息时，会发送给所有当前建立连接的浏览器
    
    (1)配置WebSocket,需要在配置类上使用@EnableWebSocketMessageBroker开启WebSocket支持，并继承AbstractWebSocketMessageBorkerConfigure类，重写其他方法来配置
    WebSocket。[WebSocketConfig](websocket/src/main/java/com/zjc/websocket/config/WebSocketConfig.java)
    
    (2)浏览器向服务端发送的消息用此类接收 
    [WiselyMessage](websocket/src/main/java/com/zjc/websocket/domain/WiselyMessage.java)
    
    (3) 服务器向浏览器发送的此类消息 
    [WiselyResponse](websocket/src/main/java/com/zjc/websocket/domain/WiselyResponse.java)
    
    (4)演示控制器
    [WsController](websocket/src/main/java/com/zjc/websocket/web/controller/WsController.java)
    
    (5) 添加脚本 将stomp.min.js（STOMP协议的客户端脚本）、sockjs.min.js(SockJS的客户端脚本)以及jQuery放置在
    src/main/resources/static下。
  
    (6) 演示页面。在src/main/resources/template下新建[ws.html](websocket/src/main/resources/templates/ws.html)
    
    (7) 配置viewController，为ws.html提供便捷的路径映射
    
    - 点对点式
    
    广播式并不是一个常见的场景，本例中演示一个简单的聊天室程序，两个用户发送消息给彼此。
    
    (1) 在pom.xml中引入spring security相关内容
    
    (2) 对Spring Security进行简单的配置 [WebSecurityConfig](websocket/src/main/java/com/zjc/websocket/config/WebSecurityConfig.java)
    
    (3) 配置WebSocket
    
    (4) 控制器 在[WsController](websocket/src/main/java/com/zjc/websocket/web/controller/WsController.java)内添加handleChat方法
    
    (5) 登陆页面 [login.html](websocket/src/main/resources/templates/login.html)
    
    (6) 聊天页面 [chat.html](websocket/src/main/resources/templates/chat.html)
    
    (7) 增加页面的viewController [WebMvcConfig](websocket/src/main/java/com/zjc/websocket/config/WebMvcConfig.java)
    
 
- 基于Bootstrap和AngularJS的现代Web应用

    现代的B/S软件有下面几个特色 1.单页面应用(SPA) 2.响应式设计，能设计不同的设备和窗口大小 3.数据导向 
    页面上的数据获得通过消费后台的REST服务来实现，而不是通过服务器渲染的动态页面(如JSP这类模板)来实现，一般数据交换使用JSON
    
    本节针对Bootstrap和AngularJS进行快速入门式引导
    
    - Bootstrap 
    
    是一个开发响应式和移动优先的HTML,CSS,JavaScript框架，实现了只使用一套代码就可以在不同设备显示你的视图。Bootstrap提供了
    大量美观的HTML元素前端组件和jQuery插件。
    
    [bootstrap.html](angularjs/src/main/resources/static/bootstrap.html) Bootstrap提供了大量的页面组件，包括字体图标，
    下拉框、导航条、进度条等。