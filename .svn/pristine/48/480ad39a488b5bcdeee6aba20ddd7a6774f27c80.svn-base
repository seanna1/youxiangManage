package com.github.zhangkaitao.shiro.chapter16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.zhangkaitao.shiro.chapter16.dao.TranslateDao;
import com.github.zhangkaitao.shiro.chapter16.entity.TranslateInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;
@Service
public class TranslateServiceImpl implements TranslateService{
	@Autowired
	private TranslateDao translateDao;
	
	@Override
	public void deleteById(Long id) {
		translateDao.deleteById(id);
	}

	@Override
	public TranslateInfo insert(TranslateInfo t) {
		return translateDao.insertT(t);
	}

	@Override
	public TranslateInfo selectById(Long id) {
		return translateDao.selectById(id);
	}

	@Override
	public TranslateInfo update(TranslateInfo t) {
		return translateDao.updateT(t);
	}

	@Override
	public Pagination<TranslateInfo> findAllByParam(String params, int pageCount) {
		return translateDao.findAllByParam(params, pageCount);
	}

}
