package com.tsijee01.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsijee01.service.SuperAdminService;

import ma.glasnost.orika.MapperFacade;

@RestController
public class SuperAdminController {

	@Autowired
	private SuperAdminService administradorService;
	
	@Autowired
	private MapperFacade mepper;

	@RequestMapping(path = "/loginAdministradorTenant/", method = RequestMethod.GET)
	public ResponseEntity<?> loginAdministradorTenant(HttpServletRequest request,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "password", required = true) String password) {

		if (administradorService.login(email, password)) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
		}

	}

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> test(HttpServletRequest request) {

		return new ResponseEntity<String>("esto es un test ", HttpStatus.OK);

	}

}
