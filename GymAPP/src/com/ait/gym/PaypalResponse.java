package com.ait.gym;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PaypalResponse extends HttpServlet {

	private static final long serialVersionUID = -1641096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double amount=Double.parseDouble(request.getParameter("amt"));
		String membership = null;
		if(amount == 149.00) {
			membership = "Three months membership paid";
		}
		else if(amount == 299.00) {
			membership = "Six months membership paid";
		}
		else if(amount == 599.00) {
			membership = "Twelve months membership paid";
		}
		
		String destination = "payPalSuccess.xhtml";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		request.setAttribute("amount", Double.toString(amount));	
		request.setAttribute("txId", request.getParameter("tx"));	
		request.setAttribute("txStatus", request.getParameter("st"));	
		request.setAttribute("currency", request.getParameter("cc"));	
		request.setAttribute("package", membership);	
		requestDispatcher.forward(request, response);
		
	}
}
