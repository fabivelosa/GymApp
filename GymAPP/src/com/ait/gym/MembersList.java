package com.ait.gym;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MembersList {

	private ArrayList<Member> members = new ArrayList<Member>();

	public MembersList() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public int getMembersCount() {
		return members.size();
	}

	public void addMemberList(Member member) {
		members.add(member);
	}

	public void removeMember(String memberID) {
		members.remove(new Member(memberID));
	}
}
