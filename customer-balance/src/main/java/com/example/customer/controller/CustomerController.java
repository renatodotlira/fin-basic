package com.example.customer.controller;

import com.example.customer.dto.CustomerDto;
import com.example.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/")
	@ApiOperation("Lista todos os clientes")
	public List<CustomerDto> getAll() {
		return service.listAll();
	}

	@GetMapping("/enabled")
	@ApiOperation("Lista somente os clientes habilitados")
	public List<CustomerDto> getAllEnabled() {
		return service.listAllEnabled();
	}

	@PostMapping
	public CustomerDto save(@RequestBody CustomerDto customerDto){
		return service.save(customerDto);
	}

	@DeleteMapping
	public void delete(@RequestBody CustomerDto customerDto){
		service.disable(customerDto);
	}
}