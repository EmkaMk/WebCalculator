package com.seavus.webcalculator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

	ArrayList<Calculate> calculations=new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.history(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.history(req, resp);
	}

	public void history(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		ArrayList<Calculate> calculations=(ArrayList<Calculate>) session.getAttribute("calculations");
		if (calculations == null) {
			resp.getWriter().println("No stored calculations during this session! ");
			calculations=new ArrayList<>();
		} else {
			resp.getWriter().println("List of all calculations for this session: ");
			for (Calculate c : calculations) {
				resp.getWriter().println(c);
			}
		}
		
	}

}
