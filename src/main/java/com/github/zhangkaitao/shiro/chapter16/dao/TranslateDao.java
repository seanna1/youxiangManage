package com.github.zhangkaitao.shiro.chapter16.dao;

import com.github.zhangkaitao.shiro.chapter16.entity.TranslateInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface TranslateDao {
	public TranslateInfo selectById(Long id);
	
	public void deleteById(Long id);
	
	public TranslateInfo insertT(TranslateInfo t);
	
	public TranslateInfo updateT(TranslateInfo t);
	
	Pagination<TranslateInfo> findAllByParam(String params,int pageCount);
}
