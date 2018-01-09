package com.github.zhangkaitao.shiro.chapter16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.AnswerInfoDao;
import com.github.zhangkaitao.shiro.chapter16.entity.AnswerInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

@Service
public class AnswerInfoServiceImpl implements AnswerInfoService{
	@Autowired
	private AnswerInfoDao answerInfoDao;
	@Override
	public void deleteById(Long id) {
		answerInfoDao.deleteById(id);
	}

	@Override
	public AnswerInfo insert(AnswerInfo a) {
		return answerInfoDao.insert(a);
	}

	@Override
	public AnswerInfo selectById(Long id) {
		return answerInfoDao.selectById(id);
	}

	@Override
	public AnswerInfo update(AnswerInfo a) {
		return answerInfoDao.update(a);
	}

	@Override
	public AnswerInfo findAnswerByUidAndQidAndCtime(Long uid, Long qid,String ctime) {
		return answerInfoDao.findAnswerByUidAndQidAndCtime(uid, qid,ctime+"%");
	}

	@Override
	public Pagination<AnswerInfo> findAllByParam(String params, int pageCount) {
		return answerInfoDao.findAllByParam(params, pageCount);
	}

}
