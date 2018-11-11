package com.au.prakash.tax.bean;

import java.util.List;

import javax.validation.Valid;

public class PaySlipRequestList {

	@Valid
	List<PaySlipRequest> requests;

	public PaySlipRequestList() {
		super();
	}

	public PaySlipRequestList(List<PaySlipRequest> requests) {
		super();
		this.requests = requests;
	}

	public List<PaySlipRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<PaySlipRequest> requests) {
		this.requests = requests;
	}

}
