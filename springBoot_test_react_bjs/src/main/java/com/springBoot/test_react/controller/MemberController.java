package com.springBoot.test_react.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.test_react.dto.MemberDTO;
import com.springBoot.test_react.service.MemberServiceImpl;

@CrossOrigin(origins="**",maxAge=3600)
@RestController
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberServiceImpl service;
	
	//selectALL
	@GetMapping
	public List<MemberDTO> memberList()
		throws ServletException, IOException{
		logger.info("MemberController - memberList");
		
		return service.listAll();
	}
	
	//insert
	@PostMapping
	public Map<String,Object> insertMember(@RequestBody MemberDTO dto)
		throws ServletException, IOException{
		logger.info("MemberController - insertMember");
		String resultCode = "";
		String resultMsg = "";
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			int insertCnt = service.insertMember(dto);
			if(insertCnt == 1) {
				resultCode = "200";
				resultMsg = "memberInsert Success!!";
			}
		}catch(Exception e) {
			resultCode ="400";
			resultMsg = e.getMessage();
			e.printStackTrace();
		}
		
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		
		System.out.println("[ memberInsert 성공 !! ]");
		return map;
	}
	
	//회원 1명 정보 검색
	@GetMapping("/{id}")
	public MemberDTO selectOneMember(@PathVariable int id)
		throws ServletException, IOException{
		logger.info("<<< MemberController - selectOneMember || id : "+id+">>>");
		return service.selectOneMember(id);
	}
	
	//update[회원정보 수정]
	@PutMapping("/{id}")
	public Map<String, Object> updateMember(@PathVariable int id, @RequestBody MemberDTO dto)
		throws ServletException, IOException{
		logger.info("<<< MemberController - updateMember || id : "+id+">>>");
		
		String resultCode = "";
		String resultMsg = "";
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			int updateCnt = service.updateMember(dto);
			if(updateCnt == 1) {
				resultCode = "200";
				resultMsg = "updateMember Success!!";
			}
		}catch(Exception e) {
			resultCode = "400";
			resultMsg = e.getMessage();
			e.printStackTrace();
		}
		
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		
		System.out.println("[ updateMember 성공 !! ]");
		
		
		return map;
	}
	
	//delete [ 회원삭제 ]
	@DeleteMapping("/{id}")
	public Map<String,Object> delectMember(@PathVariable int id)
		throws ServletException, IOException{
		logger.info("<<< MemberController - delectMember || id : "+id+">>>");

		String resultCode = "";
		String resultMsg = "";
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			int deleteCnt = service.deleteMember(id);
			if(deleteCnt == 1) {
				resultCode ="200";
				resultMsg = "deleteMember Success!!";
			}
		}catch(Exception e) {
			resultCode = "400";
			resultMsg = e.getMessage();
			e.printStackTrace();
		}
		
		map.put("resultCode", resultCode);
		map.put("resultMsg", resultMsg);
		
		System.out.println("[ deleteMember 성공 ~~~ ]");
		
		return map;
	}
	
}
