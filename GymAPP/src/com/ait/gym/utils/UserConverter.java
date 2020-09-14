package com.ait.gym.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.MembersList;

@ManagedBean
@RequestScoped
public class UserConverter implements Converter {
	
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return "";
        }

        try {
        	MembersList memberList = Helper.getBean("membersList", MembersList.class);
            return  memberList.getMemberById(submittedValue);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null || modelValue == "") {
            return "";
        }

        if (modelValue instanceof Member) {
            return String.valueOf(((Member) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", modelValue)));
        }
    }

}
