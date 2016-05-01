package com.seavus.webcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculation")
public class CalculationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.calculate(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.calculate(req, resp);
	}

	public void calculate(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Calculate> operations = (ArrayList<Calculate>) session.getAttribute("operation");

		if (operations == null) {
			operations = new ArrayList<Calculate>();
		}

		Integer op1 = Integer.valueOf(req.getParameter("firstOperand"));
		Integer op2 = Integer.valueOf(req.getParameter("secondOperand"));
		String operator = req.getParameter("operation");
		Calculate calc = new Calculate(op1, op2, operator);
		session.setAttribute("calculations", calc);
		operations.add(calc);
		

		try {
			resp.getWriter().println(calc.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
