package com.au.prakash.tax.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.au.prakash.tax.bean.PaySlipRequest;
import com.au.prakash.tax.bean.PaySlipResponse;
import com.au.prakash.tax.service.PaySlipService;
import com.au.prakash.tax.service.util.SuperAmountCalculator;
import com.au.prakash.tax.service.util.TaxAmountCalculator;

@Service
public class PaySlipServiceImpl implements PaySlipService {

	/*
	 * Generates payslip components for the given request
	 * */
	private PaySlipResponse generatePaySlip(PaySlipRequest req) {
		PaySlipResponse res = new PaySlipResponse(req.getFirstName(), req.getLastName(), req.getPaymentStartDate());

		int gross = req.getAnnualSalary() / 12;
		int tax = TaxAmountCalculator.calc(req.getAnnualSalary());

		res.setGrossSalary(gross);
		res.setIncomeTax(tax);
		res.setNetSalary(gross - tax);
		res.setSuperAmount(SuperAmountCalculator.calc(gross, req.getSuperRate()));

		return res;
	}

	@Override
	public List<PaySlipResponse> generatePaySlips(List<PaySlipRequest> reqs) {
		List<PaySlipResponse> res = new ArrayList<>();
		for (PaySlipRequest req : reqs) {
			res.add(generatePaySlip(req));
		}
		return res;
	}

}
