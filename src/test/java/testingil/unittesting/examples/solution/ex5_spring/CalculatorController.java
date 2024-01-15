package testingil.unittesting.examples.solution.ex5_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/calculator")
public class CalculatorController {
	@Autowired private CalculatorDisplay cd;
	
	@PostMapping(value ="/press")
	public ResponseEntity<?> press(
			@RequestParam(value = "key") String key) {
		cd.press(key);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping(value = "/display") 
	public ResponseEntity<String> getDisplay() {
		
		return new ResponseEntity<String>(cd.getDisplay(),
				HttpStatus.OK);
	}

	@PostMapping(value = "/reset")
	public ResponseEntity<?> reset(){
		cd.press("C");
		return ResponseEntity.ok(null);
	}
	
}
