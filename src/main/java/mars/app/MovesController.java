package mars.app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovesController {
    @RequestMapping(value="/rest/mars")
    public String pos() {
        return "lala";
    }

    @RequestMapping(value="/rest/mars/{cmd}", method = RequestMethod.POST)
    public String move(@PathVariable("cmd") String cmd) {
        return cmd;
    }
}
