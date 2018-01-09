package com.github.zhangkaitao.shiro.chapter16.service;

import com.github.zhangkaitao.shiro.chapter16.entity.AnswerInfo;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

public interface AnswerInfoService {
	public void deleteById(Long id);

    public AnswerInfo insert(AnswerInfo a);

    AnswerInfo selectById(Long id);

    public AnswerInfo update(AnswerInfo a);
    
    //根据userid、questionid、createtime查询答案
    AnswerInfo findAnswerByUidAndQidAndCtime(Long uid,Long qid,String ctime);
    
  //更加、分页查询
    Pagination<AnswerInfo> findAllByParam(String params,int pageCount);
}
