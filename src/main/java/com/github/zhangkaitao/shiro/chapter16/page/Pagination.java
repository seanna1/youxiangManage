package com.github.zhangkaitao.shiro.chapter16.page;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.github.zhangkaitao.shiro.chapter16.entity.User;

public class Pagination<T>{
	public static final int NUMBERS_PER_PAGE = 20;  
    private int totalPages; // 总页数  
    private int page;   // 当前页码  
    private int totalNumber;//总条数
    private List<T> resultList;    // 结果集存放List  
    
    /**
     * 
     * @param sql sql语句
     * @param currentPage 当前页
     * @param numPerPage 每页几条数据
     * @param jTemplate 
     * @param Class<T> 类
     * @param orderby 排序字段 
     */
    public Pagination(String sql, int currentPage,List<Object> params, int numPerPage,JdbcTemplate jTemplate,Class<T> cl,String orderby) {  
        if (jTemplate == null) {  
            throw new IllegalArgumentException(  
                    "com.starhub.sms.util.Pagination.jTemplate is null,please initial it first. ");  
        } else if (sql == null || sql.equals("")) {  
            throw new IllegalArgumentException(  
                    "com.starhub.sms.util.Pagination.sql is empty,please initial it first. ");  
        }  
          
        String countSQL = getSQLCount(sql);  
        setPage(currentPage);
        int startIndex = (currentPage - 1) * numPerPage;    //数据读取起始index  
      //setTotalPages(numPerPage,jTemplate.queryForInt(countSQL));
            
        StringBuffer paginationSQL = new StringBuffer(" ");  
        paginationSQL.append(sql);
        if(params.size()==0){
        	setTotalNumber(jTemplate.queryForInt(countSQL));
        }else{
        	setTotalNumber(jTemplate.query(paginationSQL.toString(),params.toArray(),new BeanPropertyRowMapper<T>(cl)).size());
        }
        setTotalPages(numPerPage,totalNumber);
        if(orderby!=null&&!"".equals(orderby))paginationSQL.append(" ORDER BY "+ orderby +" DESC");       
        paginationSQL.append(" limit "+ startIndex+","+numPerPage);       
        setResultList(jTemplate.query(paginationSQL.toString(),params.toArray(),new BeanPropertyRowMapper<T>(cl)));
        //setResultList(jTemplate.queryForList(paginationSQL.toString()));  
        
    }  
      
    public String getSQLCount(String sql){  
        String sqlBak = sql.toLowerCase();  
        String searchValue = " from ";  
        String sqlCount = "select count(*) from "+ sql.substring(sqlBak.indexOf(searchValue)+searchValue.length(), sqlBak.length());  
        return sqlCount;  
    }  
      
    public int getTotalPages() {  
        return totalPages;  
    }  
    public void setTotalPages(int totalPages) {  
        this.totalPages = totalPages;  
    }  
    public int getPage() {  
        return page;  
    }  
    public void setPage(int page) {  
        this.page = page;  
    }    
    
    public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public List<T> getResultList() {  
        return resultList;  
    }  
    public void setResultList(List<T> resultList) {  
        this.resultList = resultList;  
    }  
    // 计算总页数  
    public void setTotalPages(int numPerPage,int totalRows) {  
        if (totalRows % numPerPage == 0) {  
            this.totalPages = totalRows / numPerPage;  
        } else {  
            this.totalPages = (totalRows / numPerPage) + 1;  
        }  
    }  
}
