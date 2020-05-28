package org.hung;

import javax.servlet.ServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@GetMapping("/echo")
	public String echo(ServletRequest request) {
		return "echo\n"+request.getRemoteAddr()+"\n";
	}
}
