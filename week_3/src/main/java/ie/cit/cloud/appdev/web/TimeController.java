package ie.cit.cloud.appdev.web;

import java.text.SimpleDateFormat;

import ie.cit.cloud.appdev.service.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping("index")
    public String index(
	    @RequestParam(required = false, defaultValue = "dd.MM.yyyy") String format,
	    Model model) {
	SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
	model.addAttribute("time", dateFormatter.format(timeService.getTime()));
	return "index";
    }
}