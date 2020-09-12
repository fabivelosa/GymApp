package com.ait.gym.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	List<String> allowedUrl;
	List<String> allowedMemberUrl;
	List<String> allowedTrainerUrl;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String loginURL = req.getContextPath() + "/login.xhtml";

		boolean loggedIn = (session != null) && (session.getAttribute("loggedUser") != null);
		boolean loginRequest = req.getRequestURI().equals(loginURL);

		boolean resourceRequest = req.getRequestURI()
				.startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
		String page = req.getRequestURI().replace(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/", "");

		boolean pageAllowed = allowedUrl.contains(page);

		if (loginRequest || resourceRequest || pageAllowed) {

			if (loggedIn) {
				if (session.getAttribute("userType") != "M") {
					pageAllowed = allowedMemberUrl.contains(page);
				} else if (session.getAttribute("userType") != "P") {
					pageAllowed = allowedTrainerUrl.contains(page);
				}
			} else {
				chain.doFilter(request, response);
			}
		} else {
			resp.sendRedirect(loginURL);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		allowedUrl = new ArrayList<String>();
		allowedUrl.add("/GymAPP/mbregistration.xhtml");
		allowedUrl.add("/GymAPP/employee.xhtml");
		allowedUrl.add("/GymAPP/index.xhtml");
		allowedUrl.add("/GymAPP/login.xhtml");
		allowedUrl.add("/GymAPP/onesession.xhtml");
		allowedUrl.add("/GymAPP/payPalSuccess.xhtml");
		allowedUrl.add("/GymAPP/sessionsuccess.xhtml");
		allowedUrl.add("/GymAPP/buyMembership.xhtml");
		allowedUrl.add("/GymAPP/");
		allowedUrl.add("/GymAPP/welcome");
		allowedUrl.add("GymAPP/PaypalSuccessmb");

		allowedMember();
		allowedTrainer();

		System.out.println("request filtering init");

	}

	public void allowedMember() {
		// Allowed for Members
		allowedMemberUrl = new ArrayList<String>();
		allowedMemberUrl.add("/GymAPP/member.xhtml");
		allowedMemberUrl.add("/GymAPP/bookingclass.xhtml");
		allowedMemberUrl.add("/GymAPP/bookingtrainersession.xhtml");
		allowedMemberUrl.add("/GymAPP/buyOnceOffEnrollment.xhtml");
		allowedMemberUrl.add("/GymAPP/member.xhtml");
		allowedMemberUrl.add("/GymAPP/payPalSuccess.xhtml");
		allowedMemberUrl.add("/GymAPP/buyOnceOffEnrollment.xhtml");
	}

	public void allowedTrainer() {
		// Allowed for Trainers
		allowedTrainerUrl = new ArrayList<String>();
		allowedTrainerUrl.add("/GymAPP/trainershomepage.xhtml");
		allowedTrainerUrl.add("/GymAPP/trainerPlanPage.xhtml");
		allowedTrainerUrl.add("/GymAPP/WebContent/planoutput.xhtml");
		allowedTrainerUrl.add("/GymAPP/WebContent/timetable.xhtml");
	}

}
