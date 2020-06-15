package org.hung;

import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimpleController {

	@GetMapping("/echo")
	public String echo( HttpServletRequest request, PushBuilder pushBuilder ) {
		for (Enumeration<String> eh=request.getHeaderNames();eh.hasMoreElements();) {
			String name = eh.nextElement();
			log.info("{}:[{}]",name,StringUtils.collectionToCommaDelimitedString(Collections.list(request.getHeaders(name))));
		}
		log.info("PushBuilder reference:" + pushBuilder);
		return "You are from " + request.getRemoteAddr() + " using " + request.getProtocol();
	}
}
