package com.au.prakash.tax;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.HibernateValidator;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.au.prakash.tax.bean.PaySlipRequest;
import com.au.prakash.tax.bean.PaySlipRequestList;
import com.au.prakash.tax.bean.PaySlipResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaySlipApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaySlipControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private static LocalValidatorFactoryBean localValidatorFactory;

	@BeforeClass
	public static void setup() {
		localValidatorFactory = new LocalValidatorFactoryBean();
		localValidatorFactory.setProviderClass(HibernateValidator.class);
		localValidatorFactory.afterPropertiesSet();
	}

	private PaySlipRequestList createRequest(String firstName, String lastName, int annualSalary, double superRate,
			String paymentStartDate) {
		PaySlipRequestList requests = new PaySlipRequestList();
		List<PaySlipRequest> list = new ArrayList<>();
		list.add(new PaySlipRequest(firstName, lastName, annualSalary, superRate, paymentStartDate));
		requests.setRequests(list);
		return requests;
	}

	private String createResponseString(String firstName, String lastName, String paymentStartDate, int gross, int tax,
			int net, int superAmt) {
		try {
			List<PaySlipResponse> responses = new ArrayList<>();
			responses.add(new PaySlipResponse(firstName, lastName, paymentStartDate, gross, tax, net, superAmt));
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(responses);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Test
	public void testController_lowIncome() {
		String firstName = "David";
		String lastName = "Rudd";
		String paymentStartDate = "01 March – 31 March";
		int annualSalary = 17000;
		double superRate = 9;

		int gross = annualSalary / 12;
		int tax = 0;
		int net = gross - tax;
		int superAmt = (int) Math.round(gross * superRate / 100);

		HttpEntity<PaySlipRequestList> entity = new HttpEntity<PaySlipRequestList>(
				createRequest(firstName, lastName, annualSalary, superRate, paymentStartDate), headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/payslip/generate"), HttpMethod.POST,
				entity, String.class);

		try {
			String expected = createResponseString(firstName, lastName, paymentStartDate, gross, tax, net, superAmt);
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testController() {

		String firstName = "David";
		String lastName = "Rudd";
		String paymentStartDate = "01 March – 31 March";
		int annualSalary = 60050;
		double superRate = 9;

		int gross = annualSalary / 12;
		int tax = 922;
		int net = gross - tax;
		int superAmt = (int) Math.round(gross * superRate / 100);

		HttpEntity<PaySlipRequestList> entity = new HttpEntity<PaySlipRequestList>(
				createRequest(firstName, lastName, annualSalary, superRate, paymentStartDate), headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/payslip/generate"), HttpMethod.POST,
				entity, String.class);

		try {
			String expected = createResponseString(firstName, lastName, paymentStartDate, gross, tax, net, superAmt);
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testController_invalidInput() {

		String firstName = "D";
		String lastName = "R";
		String paymentStartDate = "";
		int annualSalary = -60050;
		double superRate = 9.632;
		PaySlipRequest req = new PaySlipRequest(firstName, lastName, annualSalary, superRate, paymentStartDate);

		Set<ConstraintViolation<PaySlipRequest>> constraintViolations = localValidatorFactory.validate(req);

		// should have 5 validation errors
		assertTrue(constraintViolations.size() == 5);
	}
}
