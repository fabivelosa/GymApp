package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.MembersList;

class MemberListTest {

	private Member member;
	private Member member2;
	private MembersList memberList;
	private ArrayList<Member> members;

	@BeforeEach
	void setUp() throws Exception {
		members = new ArrayList<Member>();
		memberList = new MembersList();

		member = new Member("John");
		member.setUserName("john@gmail.com");
		member.setPassword("1234");

		member2 = new Member("Paul");
		member2.setUserName("paul@gmail.com");
		member2.setPassword("1234");

		members.add(member);
		members.add(member2);
		memberList.setMembers(members);
	}

	@Test
	void testGetEmployeeByUserName() {
		assertEquals(member, memberList.getMemberByUserName("john@gmail.com"));
		assertEquals(member2, memberList.getMemberByUserName("paul@gmail.com"));
	}

}
