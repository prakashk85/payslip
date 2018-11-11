package com.au.prakash.tax.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.au.prakash.tax.bean.PaySlipRequestList;
import com.au.prakash.tax.bean.PaySlipResponse;
import com.au.prakash.tax.service.PaySlipService;

@Controller
@RequestMapping("/payslip")
public class PaySlipController {

	@Autowired
	PaySlipService service;

	@PostMapping(value = "/generate", consumes = "application/json")
	public ResponseEntity<List<PaySlipResponse>> calcuateTax(@Valid @RequestBody PaySlipRequestList taxRequests) {
		return ResponseEntity.ok(service.generatePaySlips(taxRequests.getRequests()));
	}
}
