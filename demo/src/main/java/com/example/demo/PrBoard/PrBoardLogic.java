package com.example.demo.PrBoard;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrBoardLogic {

	Logger logger = LogManager.getLogger(PrBoardLogic.class);
	
	@Autowired
	private PrBoardDao prBoardDao = null;
	
	public List<Map<String, Object>> PrBoardList(Map<String, Object> pMap) {
		logger.info("PrBoardLogic 호출 성공");
		List<Map<String, Object>> PrBoardList = null;
		PrBoardList = prBoardDao.PrBoardList(pMap);
		
		
		return PrBoardList;
	}
	public List<Map<String, Object>> PrBoardDetail(Map<String, Object> pMap) {
		logger.info("PrBoardDetailLogic 호출 성공");
		List<Map<String, Object>> PrBoardDetail = null;
		PrBoardDetail = prBoardDao.PrBoardDetail(pMap);
		
		
		return PrBoardDetail;
	}
	
	public List<Map<String, Object>> PrBoardTagList(Map<String, Object> pMap) {
		logger.info("PrBoardTagList Logic 호출 성공TAG_NAME==========>"+pMap.get("TAG_NAME"));
		List<Map<String,Object>> PrBoardTagList = null;
		PrBoardTagList = prBoardDao.PrBoardTagList(pMap);
		
		return PrBoardTagList;
	}
	
	public int PrBoardInsert(Map<String, Object> pMap) {
		logger.info("PrBoardInsert 호출 성공!!");
		int result = 0;
		result = prBoardDao.PrBoardInsert(pMap);
		
		return result;
	}

	public int PrBoardTInsert(Map<String, Object> prBoardTag) {
		logger.info("태그로직 태그 리스트 =====>"+prBoardTag.get("TAG_NAME"));
		int TResult = 0;
		TResult = prBoardDao.PrBoardTInsert(prBoardTag);
			
		return TResult;
	}
	
	public int PrBoardTngInsert(Map<String, Object> prBoardTag) {
		logger.info("태그로직 태그 리스트 =====>"+prBoardTag.get("TAG_NAME"));
		int TngResult = 0;
		TngResult = prBoardDao.PrBoardTngInsert(prBoardTag);
		return TngResult;
	}

	public int PrBoardImgInsert(Map<String, Object> PrBoardImg) {
		int TResult = 0;
		TResult = prBoardDao.PrBoardImgInsert(PrBoardImg);
		if(PrBoardImg.get("IMAGE_FILENAME")!=null && PrBoardImg.get("IMAGE_FILENAME").toString().length() >1) {
		}
		return TResult;
	}
	public int PrBoardUpdate(Map<String, Object> prBoardUpdate) {
		logger.info("PrBoardUpdate 호출 성공!!");
		int result = 0;
		result = prBoardDao.PrBoardUpdate(prBoardUpdate);
		
		return result;
	}
	public int PrBoardTaggingDelete(Map<String, Object> pMap) {
		logger.info("태깅 삭제 로직호출 성공!!==========>"+pMap);
		int result = 0;
		result = prBoardDao.PrBoardTaggingDelete(pMap);
		
		return result;
	}
	public int PrBoardTaggingInsert(Map<String, Object> prBoardTag) {
		logger.info("PrBoardInsert 호출 성공!!");
		int Tresult = 0;
		Tresult = prBoardDao.PrBoardTaggingInsert(prBoardTag);
		
		return Tresult;
	}
	public int PrBoardImgUpdate(Map<String, Object> prBoardImg) {
		logger.info("이미지업데이트 호출 성공!!");
		int Iresult = 0;
		Iresult = prBoardDao.PrBoardImgUpdate(prBoardImg);
		
		return Iresult;
	}
	public int PrBoardDelete(Map<String, Object> pMap) {
		logger.info("게시판 삭제로직 호출 성공!!");
		int result = 0;
		result = prBoardDao.PrBoardDelete(pMap);
		
		
		return result;
	}


}