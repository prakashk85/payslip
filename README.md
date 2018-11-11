How to run:
Run the jar from dist folde, in command prompt to start spring boot application.

Fire REST request using api client like Postman.

URL: http://localhost:8080/payslip/generate

Valid Request:
{
	"requests":
	[{
	    "firstName": "David",
	    "lastName": "Rudd",
	    "annualSalary": 60050,
	    "superRate":9,
	    "paymentStartDate":"01March-31March"
	},
	{
	    "firstName": "Ryan",
	    "lastName": "Chen",
	    "annualSalary": 120000,
	    "superRate":10,
	    "paymentStartDate":"01March-31March"
	}]
}

OR


{
	"requests":
	[{
	    "firstName": "David",
	    "lastName": "Rudd",
	    "annualSalary": 60050,
	    "superRate":9,
	    "paymentStartDate":"01March-31March"
	}]
}

INVALID Request:
Validation error returned
{
	"requests":
	[{
	    "firstName": "David",
	    "lastName": "Rudd",
	    "annualSalary": -60050,
	    "superRate":9.786,
	    "paymentStartDate":"01March-31March"
	}]
}
