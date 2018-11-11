package com.au.prakash.tax.service;

import java.util.List;

import com.au.prakash.tax.bean.PaySlipRequest;
import com.au.prakash.tax.bean.PaySlipResponse;

public interface PaySlipService {

	public List<PaySlipResponse> generatePaySlips(List<PaySlipRequest> req);
}
