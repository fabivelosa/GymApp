package com.ait.gym.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class PaypalRespMb {
	
	
	private String amount;
	private String txId;
	private String txStatus;
	private String currency;
	private String memPackage;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMemPackage() {
		return memPackage;
	}

	public void setMemPackage(String memPackage) {
		this.memPackage = memPackage;
	}

	public void  success() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		amount=(String) request.getAttribute("amount");;
		txId = (String) request.getAttribute("txId");
		txStatus = (String) request.getAttribute("txStatus");
		currency = (String) request.getAttribute("currency");
		memPackage = (String) request.getAttribute("package");
		
	}

}
