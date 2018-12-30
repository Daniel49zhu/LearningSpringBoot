package example1.web.controller;

import example1.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    /**
     * // 此方法未标识注路径，因此使用类级别的路径/anno；produces可定制返回的response的媒体类型和字符集，或需要返回值是json对象，
     * // 则设置produces="application/json;charset=UTF-8"，在后面的章节我们会演示此项特性。
     * // 演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletResponse作为参数。此处的@ResponseBody用在返回值前面。
     * @param request
     * @return
     */
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request){
        return "url:" + request.getRequestURI() + " can access";
    }

    /**
     * // 演示接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx。
     * // @ResponseBody也可以用在方法上。
     * @param str
     * @param request
     * @return
     */
    @RequestMapping(value="/pathvar/{str}",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String demoPathVar(@PathVariable String str, HttpServletRequest request){
        return "url:" + request.getRequestURI() + " can access,str: "+str;
    }

    /**
     * // 演示常规的request参数获取，访问路径为/anno/requestParam?id=1。
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value="/requestParam",produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String passRequestParam(Integer id,HttpServletRequest request){
        return "url:" + request.getRequestURI() + " can access,id: "+id;
    }

    /**
     * // 演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx。
     * @param obj
     * @param request
     * @return
     */
    @RequestMapping(value="/obj",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request){
        return "url:" + request.getRequestURI() + " can access,obj.id: "+obj.getId()+" obj.name:"+obj.getName();
    }

    /**
     * // 演示映射不同的路径到相同的方法，访问路径为/anno/name1或/anno/name2。
     * @param request
     * @return
     */
    @RequestMapping(value={"/name1","/name2"},produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String remove(HttpServletRequest request){
        return "url:" + request.getRequestURI() + " can access";
    }

}