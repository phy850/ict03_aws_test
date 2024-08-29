package com.springBoot.test_react.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.test_react.dao.MemberMapper;
import com.springBoot.test_react.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper dao;
	
	@Override
	public List<MemberDTO> listAll() throws ServletException, IOException {
		System.out.println("MemberServiceImpl - listAll");
		List<MemberDTO> list = dao.memberList();
		return list;
	}

	@Override
	public int insertMember(MemberDTO dto) throws ServletException, IOException {
		System.out.println("MemberServiceImpl - insertMember");
		int insertCnt = dao.insertMember(dto);
		System.out.println("insertCnt : "+insertCnt);
		return insertCnt;
	}

	@Override
	public MemberDTO selectOneMember(int id) throws ServletException, IOException{
		System.out.println("MemberServiceImpl - selectOneMember");
		MemberDTO dto = dao.selectMemberOne(id);
		return dto;
	}

	@Override
	public int updateMember(MemberDTO dto) throws ServletException, IOException {
		System.out.println("MemberServiceImpl - updateMember");
		int updateCnt = dao.updateMember(dto);
		return updateCnt;
	}

	@Override
	public int deleteMember(int id) throws ServletException, IOException {
		System.out.println("MemberServiceImpl - updateMember");
		int deleteCnt = dao.deleteMember(id);
		return deleteCnt;
	}

	
}
