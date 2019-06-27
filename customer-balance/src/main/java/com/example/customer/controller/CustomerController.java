package com.example.customer.controller;

import com.example.customer.dto.CustomerCreateDto;
import com.example.customer.dto.CustomerDto;
import com.example.customer.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("getAll/")
	@ApiOperation("Lista todos os clientes")
	public List<CustomerDto> getAll() {
		return service.listAll();
	}

	@GetMapping("getAllEnabled/")
	@ApiOperation("Lista somente os clientes habilitados")
	public List<CustomerDto> getAllEnabled() {
		return service.listAllEnabled();
	}

	@PostMapping("save/")
	@ApiOperation("Salva um novo cliente")
	public CustomerDto save(@RequestBody CustomerCreateDto customerDto){
		return service.save(customerDto);
	}

	@DeleteMapping("delete/")
	@ApiOperation("Desabilita um cliente")
	public void delete(@RequestBody CustomerDto customerDto){
		service.disable(customerDto);
	}

	@GetMapping("findById/")
	@ApiOperation("Busca um cliente pelo id")
	public CustomerDto findById(@RequestParam String id) {
		return service.findById(id);
	}

	@GetMapping("getAmount/")
	@ApiOperation("Retorna o saldo do cliente pelo id")
	public double getAmount(@RequestParam String customerId) {
		return service.getAmount(customerId);
	}
}