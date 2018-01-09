package com.github.zhangkaitao.shiro.chapter16.service;

import com.github.zhangkaitao.shiro.chapter16.entity.TranslateInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface TranslateService {
	public void deleteById(Long id);
	
	public TranslateInfo insert(TranslateInfo t);
	
	public TranslateInfo selectById(Long id);
	
	public TranslateInfo update(TranslateInfo t);
	
	Pagination<TranslateInfo> findAllByParam(String params,int pageCount);
}
