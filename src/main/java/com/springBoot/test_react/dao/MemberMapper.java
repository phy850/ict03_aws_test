package com.springBoot.test_react.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springBoot.test_react.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	//회원목록
	public List<MemberDTO> memberList();
	
	//회원 등록
	public int insertMember(MemberDTO dto);
	
	//회원 수정
	public int updateMember(MemberDTO dto);
	
	//회원 삭제
	public int deleteMember(int id);
	
	//회원정보 상세
	public MemberDTO selectMemberOne(int id);
	

}
