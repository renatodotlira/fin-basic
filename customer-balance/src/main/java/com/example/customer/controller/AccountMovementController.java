package com.example.customer.controller;

import com.example.customer.dto.AccountMovementDto;
import com.example.customer.service.AccountMovementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountMovementController {

	@Autowired
	private AccountMovementService service;

	@GetMapping("getAll/")
	@ApiOperation("Lista todos os eventos de um cliente")
	public List<AccountMovementDto> getAll(@RequestParam String customerId) {
		return service.listAllById(customerId);
	}

	@PostMapping("debitAccount/")
	@ApiOperation("Gera uma movimentação de débito em uma conta pelo id")
	public void debitAccount(@RequestParam String customerId, double amount){
		service.debitAccount(customerId, amount);
	}

	@PostMapping("creditAccount/")
	@ApiOperation("Gera uma movimentação de crédito em uma conta pelo id")
	public void creditAccount(@RequestParam String customerId, double amount){
		service.creditAccount(customerId, amount);
	}

}