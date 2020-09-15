package com.ait.gym.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Member;

public class PaypalResponse extends HttpServlet {

	private static final long serialVersionUID = -1641096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Member member = null; 
		String destination = null;
		HttpSession session = (HttpSession) request.getSession();
		String loggedUser = (String) session.getAttribute("isUserLogged");
		String userType = (String) session.getAttribute("userType");
		Member userNew = (Member) session.getAttribute("isUserNew");

		if (loggedUser != null && loggedUser.equals("true") && userType != null && userType.equals("M")) {
			member = (Member) session.getAttribute("loggedUser"); 
			destination = "member/payPalSuccess.xhtml";

		}else if (userNew != null ) {
			member = userNew;
			destination = "payPalSuccessmb.xhtml";
			session.removeAttribute("isUserNew");
		}
		double amount = Double.parseDouble(request.getParameter("amt"));
		String membership = null;
		if (amount == 149.00) {
			membership = CreditTypes.TREE_MONTHS.getValue() + " paid";
			member.setOneToOneCredit(member.getOneToOneCredit()+CreditTypes.TREE_MONTHS.getCreditQtd());
			member.setMembershipType(CreditTypes.TREE_MONTHS);
		} else if (amount == 299.00) {
			membership = CreditTypes.SIX_MONTHS.getValue() + " paid";
			member.setOneToOneCredit(member.getOneToOneCredit()+CreditTypes.SIX_MONTHS.getCreditQtd());
			member.setMembershipType(CreditTypes.SIX_MONTHS);
		} else if (amount == 599.00) {
			membership = CreditTypes.TWELVE_MONTHS.getValue() + " paid";
			member.setOneToOneCredit(member.getOneToOneCredit()+CreditTypes.TWELVE_MONTHS.getCreditQtd());
			member.setMembershipType(CreditTypes.TWELVE_MONTHS);
		}else if (amount == 19.00) {
			membership = CreditTypes.ONCE_OFF.getValue() + " done";
			member.setOneToOneCredit(member.getOneToOneCredit() + CreditTypes.ONCE_OFF.getCreditQtd());
		}
		

		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		request.setAttribute("amount", Double.toString(amount));
		request.setAttribute("txId", request.getParameter("tx"));
		request.setAttribute("txStatus", request.getParameter("st"));
		request.setAttribute("currency", request.getParameter("cc"));
		request.setAttribute("package", membership);
		requestDispatcher.forward(request, response);

	}
}
