package com.seavus.webcalculator;

public class Calculate {

	private int firstOperand;
	private int secondOperand;
	private int result;
	private String operator;

	public Calculate(int firstOperand, int secondOperand, String operator) {
		super();
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operator = operator;
		if (operator.equals("addition")) {
			this.result = firstOperand+secondOperand;
		} else if (operator.equals("subtraction"))
			this.result = (firstOperand-secondOperand);	
	}


	@Override
	public String toString() {
		String response="";
		if(operator.equals("addition"))
		{
			response= "" + firstOperand + " + " + secondOperand + " = " + result;
		}
		else if (operator.equals("subtraction"))
		{
			response= "" + firstOperand + " - " + secondOperand + " = " + result;
		}
		return response;
	}

	public String getOperator() {
		if(operator.equals("addition"))
		{
			return "+";
		}
		else return"-";
	}
	
	public int getResult()
	{
		return this.result;
	}
	
	

}
