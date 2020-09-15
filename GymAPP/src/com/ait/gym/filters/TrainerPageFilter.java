package com.ait.gym.filters;

import java.io.IOException;

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

@WebFilter(filterName="trainerFilter",urlPatterns="/trainer/*") 
public class TrainerPageFilter implements Filter {
 
	 
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
        String loginURL = req.getContextPath() + "/AccessDenied.xhtml";      
        
    	String loggedUser = (String) session.getAttribute("isUserLogged");
		String userType = (String) session.getAttribute("userType");
		
		if (loggedUser != null && loggedUser.equals("true") && userType != null && userType.contentEquals("P")) {
			chain.doFilter(request, response); // So, just continue request.
         }else {
            resp.sendRedirect(loginURL);
         }

	}
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
		
	  
	}

}