package com.ait.gym.bean.lists;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.gym.bean.Member;

@ManagedBean(name="membersList",eager=true)
@SessionScoped
public class MembersList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Member> members =new ArrayList<Member>();  

	public MembersList() {   
		
	}
	

	@PostConstruct
	public void init() {
		
		Member member1 = new Member("Ann","ann@email.com","123");
		Member member2 = new Member("Tom","tom@email.com","123"); 
		
		getMembers().add(member1);
		getMembers().add(member2); 
		
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
	
	public Member getMemberByUserName(String userName) {
		
		Member memberFound = null; 
		System.out.println("member count -->"+this.getMembersCount());
		
		for(Member member:this.getMembers() ) {
			if(member != null && member.getUserName().equals(userName)) {
				memberFound = member;
				System.out.println("member found -->"+member.getFirstName());
			}
		}
		return memberFound;		
	}
}
