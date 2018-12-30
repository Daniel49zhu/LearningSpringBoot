package example1.web.controller;

import example1.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    /**
     * // 返回数据的媒体类型为json。
     * @param obj
     * @return
     */
    @RequestMapping(value="/getjson",produces="application/json;charset=UTF-8")
    public DemoObj getjson(DemoObj obj){
        // 直接返回对象，对象会自动转换成json。
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }

    /**
     * // 返回数据的媒体类型为xml。
     * @param obj
     * @return
     */
    @RequestMapping(value="/getxml",produces="application/xml;charset=UTF-8")
    public DemoObj getjxml(DemoObj obj){
        // 直接返回对象，对象会自动转换为xml。
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");
    }
}