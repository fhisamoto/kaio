package mars.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovesController {

    @RequestMapping(value="/rest/mars/{cmd}", method = RequestMethod.POST)
    public ResponseEntity<String> move(@PathVariable("cmd") String cmd) {
        try {
            return new ResponseEntity<>(CmdProcessor.process(cmd).toString(), HttpStatus.OK);
        } catch (InvalidCmdException e) {
            return new ResponseEntity<>("Invalid cmd", HttpStatus.BAD_REQUEST);
        } catch (OutOfBoundsException e) {
            return new ResponseEntity<>("Invalid position", HttpStatus.BAD_REQUEST);
        }
    }
}
