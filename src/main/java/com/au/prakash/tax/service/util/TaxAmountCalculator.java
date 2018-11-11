package com.au.prakash.tax.service.util;

import java.util.ArrayList;
import java.util.List;

import com.au.prakash.tax.bean.TaxSlab;

public final class TaxAmountCalculator {

	private static List<TaxSlab> slabs = new ArrayList<>();
	private static final int TAX_FREE_AMNT = 18200;

	private TaxAmountCalculator() {
		// do nothing
	}

	/*
	 * Reference Data Setup - Adding Tax Limits
	 */
	static {
		// ideally get this from reference db
		slabs.add(new TaxSlab(TAX_FREE_AMNT + 1, 37000, 0, 0.19));
		slabs.add(new TaxSlab(37001, 87000, 3572, 0.325));
		slabs.add(new TaxSlab(87001, 180000, 19822, 0.37));
		slabs.add(new TaxSlab(180001, Integer.MAX_VALUE, 54232, 0.45));
	}

	/**
	 * calculates Tax for the given annual salary using the defined tax slabs
	 */
	public static int calc(int gross) {
		int tax = 0;
		if (gross <= TAX_FREE_AMNT)
			return tax;

		for (TaxSlab item : slabs) {
			if (gross >= item.getMinAmt() && gross <= item.getMaxAmt()) {
				tax = (int) Math.round((item.getBaseAmt() + (gross - item.getMinAmt()) * item.getRate()) / 12);
				break;
			}
		}
		return tax;
	}
}
