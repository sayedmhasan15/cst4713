package edu.citytech.cst.webdev.counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;

import static java.awt.SystemColor.window;


@Controller
public class CounterController {

    @Autowired
    CounterService service;

        @RequestMapping ("/design-counter")
        public String getdesign(Model model) {
            return "design-counter.html";
        }

    @RequestMapping ("/counter")
    public String counter() {
        return "counter.jsp";

    }
    @RequestMapping ("/spring-counter")
    public String springcounter(@ModelAttribute CounterInput counterInput, Model model) {
// var coount = window.getAlpha();

        List <Counter> data = new ArrayList<>();
       // var countTo =Integer.parseInt( counterInput.getCountToNumber());


             //var countTo = Integer.parseInt( counterInput.getCountToNumber());

if (counterInput.getMode().contains("123")) {
    data = service.count(CounterEnumerator.N123, 1, 100,1);
}
       else if (counterInput.getMode().contains("321")) {
            data = service.count(CounterEnumerator.N321, 1, 100,1);
        }
else if (counterInput.getMode().contains("abc")) {
            data = service.count(CounterEnumerator.ABC, 1,27,1);
        }
else if (counterInput.getMode().contains("cba")) {
    data = service.count(CounterEnumerator.CBA, 1,27,1);
}

        model.addAttribute("input", counterInput);
            model.addAttribute("currentDate", new Date());
            model.addAttribute("numbers", data);


        return ("spring-counter.jsp") ;

    }

    private void collect(Collector<Object,?, List<Object>> toList) {
    }

}


