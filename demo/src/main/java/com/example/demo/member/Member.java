package com.example.demo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@DynamicInsert
@Entity
@Data
@SequenceGenerator (
			name="SEQ_MEMBER_GEN",
			sequenceName = "SEQ_MEMBER",
			initialValue = 1,
			allocationSize = 1
		)
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MEMBER_GEN")
	@Column(name="mem_num")
	private int memNum;
	
	@Column(name="mem_code")
	private int memCode;
	
	@Column(name="mem_id")
	private String memId;
	
	@Column(name="mem_pw")
	private String memPw;
	
	@Column(name="mem_nick")
	private String memNick;
	
	@Column(name="mem_name")
	private String memName;
	
	@Column(name="mem_email")
	private String memEmail;
	
	@Column(name="mem_biznum")
	private String memBizNum;
	
	@Column(name="mem_bizname")
	private String memBizName;
	
	@Column(name="mem_tel")
	private String memTel;
	
	@Column(name="mem_join")
	private String memJoin;
	
	@Column(name="mem_role")
	private String memRole;
	
}
