/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mutabene.controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author stenlik
 */
@Controller("homeController")
public class HomeController {
    
    @RequestMapping(value="/index.htm", method=RequestMethod.GET)
    public String index() throws Exception{
        return "Home/index";
    }
    
    @RequestMapping(value="/about.htm", method=RequestMethod.GET)
    public String about() throws Exception{
        return "Home/about";
    }
}
