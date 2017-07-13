package fnb.coin.dispenser.resful.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody LoginCredentials response(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	return new LoginCredentials("admin", "admin");
    }

}
