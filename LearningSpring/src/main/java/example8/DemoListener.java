package example8;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /**
     * 使用onApplicationEvent方法对消息进行接受处理。
     * @param event
     */
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我(bean-demoListener)接收到了bean-demoListener发布的消息：" + msg);
    }

}