package com.example.demo.freeboard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FreeBoardLogic {
	Logger logger = LogManager.getLogger(FreeBoardLogic.class);
	
	@Autowired
	private FreeBoardDao freeBoardDao = null;
		
	public List<Map<String, Object>> getFreeBoardList(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic getFreeBoardList 호출 성공");				
		return freeBoardDao.getFreeBoardList(pMap);
	}
	
	public List<Map<String, Object>> searchFreeBoard(String keyword) {
		logger.info("FreeBoardLogic searchFreeBoard 호출 성공");
		logger.info("FreeBoardLogic searchFreeBoard keyword"+keyword);
		List<Map<String,Object>> list = null;
		list = freeBoardDao.searchFreeBoard(keyword);
		return list;		
	}
	
	public List<Map<String, Object>> getFreeBoardDetail(int free_num) {
		logger.info("FreeBoardLogic getFreeBoardDetail 호출 성공");
		logger.info("FreeBoardLogic getFreeBoardDetail free_num"+free_num);
		List<Map<String,Object>> freeBoardDetail = null;
		freeBoardDetail = freeBoardDao.getFreeBoardDetail(free_num);		
		return freeBoardDetail;
	}
	
	public void updateFreeBoardViews(int free_num) {
		logger.info("FreeBoardLogic updateFreeBoardViews 호출 성공");
		freeBoardDao.updateFreeBoardViews(free_num);		
	}

	@Transactional //트랜잭션
	public void insertFreeBoard(Map<String, Object> pMap) throws Exception {
		logger.info("FreeBoardLogic insertFreeBoard 호출 성공");
		logger.info("FreeBoardLogic insertFreeBoard pMap : "+pMap);			
		freeBoardDao.insertFreeBoard(pMap);
	}
	
	public void insertImageFileList(List<Map<String, Object>> list) {
		freeBoardDao.insertImageFileList(list);		
	}

	public int updateFreeBoard(Map<String, Object> pMap) {
		logger.info("FreeBoardLogic updateFreeBoard 호출 성공");
		logger.info("FreeBoardLogic updateFreeBoard pMap : "+pMap);
						
		int result = 0;
		result = freeBoardDao.updateFreeBoard(pMap);
		return result;
	}

	public int deleteFreeBoard(int free_num) {
		logger.info("FreeBoardLogic deleteFreeBoard 호출 성공");
		int result = 0;
		result = freeBoardDao.deleteFreeBoard(free_num);
		return result;		
	}

}


