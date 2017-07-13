package fnb.coin.dispenser.resful.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fnb.coin.dispenser.util.Greeting;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting response(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	return new Greeting("admin", "admin");
    }

}
