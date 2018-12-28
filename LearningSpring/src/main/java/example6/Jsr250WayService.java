package example6;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Jsr250WayService {

    @PostConstruct
    public void init() {
        System.out.println("jsr250-init-method");
    }

    public Jsr250WayService() {
        System.out.println("初始化构造函数-Jsr250WayService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsr250-destroy-method");
    }
}
