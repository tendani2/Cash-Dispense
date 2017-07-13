package fnb.coin.dispenser.resful.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fnb.coin.dispenser.service.DispenserService;
import fnb.coin.dispenser.util.DenominatorCombination;

@Controller
@RequestMapping("/coin-dispenser")
public class CoinDispenserServiceController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<DenominatorCombination> dispense(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	return new DispenserService().getResponse("25.50");
    
    }

}
