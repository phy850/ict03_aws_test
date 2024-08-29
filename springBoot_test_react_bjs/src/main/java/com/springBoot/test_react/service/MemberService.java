package com.springBoot.test_react.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.springBoot.test_react.dto.MemberDTO;

public interface MemberService {
	
	//전체 목록 
	public List<MemberDTO> listAll() throws ServletException, IOException;
	
	//회원 등록
	public int insertMember(MemberDTO dto) throws ServletException, IOException;

	//회원 1명 검색[상세정보]
	public MemberDTO selectOneMember(int id) throws ServletException, IOException;
	
	//회원 한명 정보 수정
	public int updateMember(MemberDTO dto) throws ServletException, IOException;
	
	//회원 삭제
	public int deleteMember(int id) throws ServletException, IOException;
}
