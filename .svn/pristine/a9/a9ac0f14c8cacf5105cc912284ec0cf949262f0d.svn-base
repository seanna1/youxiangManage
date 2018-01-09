package com.github.zhangkaitao.shiro.chapter16.service;

import com.github.zhangkaitao.shiro.chapter16.dao.OrganizationDao;
import com.github.zhangkaitao.shiro.chapter16.entity.Organization;
import com.github.zhangkaitao.shiro.chapter16.page.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    
    public Organization createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }
    
    
    public Organization updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }

    
    public void deleteOrganization(Long organizationId) {
        organizationDao.deleteOrganization(organizationId);
    }
    
    
    public Organization findOne(Long organizationId) {
        return organizationDao.findOne(organizationId);
    }

    
    public List<Organization> findAll() {
        return organizationDao.findAll();
    }

    
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        return organizationDao.findAllWithExclude(excludeOraganization);
    }

    
    public void move(Organization source, Organization target) {
        organizationDao.move(source, target);
    }

    
	public Pagination<Organization> findOrgByParams(String param, int pageCount) {
		return organizationDao.findAllByParam(param, pageCount);
	}

	public Organization findByName(String name) {
		return organizationDao.findByName(name);
	}
}
