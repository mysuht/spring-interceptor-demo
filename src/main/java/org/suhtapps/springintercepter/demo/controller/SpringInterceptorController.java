package org.suhtapps.springintercepter.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suhtapps.springintercepter.demo.exception.InvalidFieldException;
import org.suhtapps.springintercepter.demo.model.Student;

@RestController
@RequestMapping("student")
public class SpringInterceptorController {

	
	@PostMapping
	public String saveStudentInformation(
			@RequestHeader("student-auth-key") String authorization,
			@RequestBody Student student) {
		if(StringUtils.isBlank(student.getLastName())) {
			throw new InvalidFieldException("Last NAME is a required field");
		}
		return String.format("Authorization %s is valid, and Data is saved", authorization);
	}
}
