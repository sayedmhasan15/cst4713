package edu.citytech.cst.webdev.helloworld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorldController {

        @RequestMapping ("/salutation")


        public String helloworld(Model model) {
model.addAttribute("author","Sayed Hasan");
            return "HelloWorld.jsp";

        }



    }


