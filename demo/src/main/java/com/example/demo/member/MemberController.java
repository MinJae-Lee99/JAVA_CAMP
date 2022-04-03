package com.example.demo.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	Logger logger = LogManager.getLogger(MemberController.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//홈
	@GetMapping({"","/"})
	public @ResponseBody String home() {
		return "HOME";
	}
	
	//회원
	@GetMapping("/member")
	public @ResponseBody String member() {
		return "MEMBER";
	}
	
	//사업자
	@GetMapping("/biz")
	public @ResponseBody String biz() {
		return "BIZ";
	}
	
	//관리자
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "ADMIN";
	}
	
	//회원가입폼
	@GetMapping("/joinForm")
	public String joinForm() {
		return "/joinForm";
	}
	
	//사업자회원가입폼
	@GetMapping("/bizJoinForm") 
	public String bizJoinForm() {
		return "/bizJoinForm";
	}
		
	//회원가입
	@PostMapping("/join")
	public String join(Member member) {
		logger.info("MemberController join member : "+member);
		member.setMemCode(1);
		member.setMemRole("ROLE_MEMBER");
		String rawPassword = member.getMemPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setMemPw(encPassword);
		memberRepository.save(member);
		return "redirect:/login";
	}
	
	//사업자회원가입
	@PostMapping("/bizJoin")
	public String bizJoin(Member member) {
		logger.info("MemberController bizJoin member : "+member);
		member.setMemCode(2);
		member.setMemRole("ROLE_BIZ");
		String rawPassword = member.getMemPw();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setMemPw(encPassword);
		memberRepository.save(member);
		return "redirect:/login";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/info")
	public @ResponseBody String info() {
		return "INFO";
	}
	
	@PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_BIZ')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "DATA";
	}
	
}
