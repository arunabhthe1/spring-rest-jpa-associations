package com.dash.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dash.demoproject.model.Organization;
import com.dash.demoproject.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl {

	@Autowired
	private  OrganizationRepository organizationRepository;
	
	public List<Organization> getAllOrganization(){
		return organizationRepository.findAll();
	}
	
	public Organization getOrganization(Long orgId){
		return organizationRepository.findById(orgId).get();
	}
	
	public Organization saveOrUpdateOrganization(Organization org){
		return organizationRepository.save(org);
	}
	
	public void deleteOrganization(Long orgId) {
		 organizationRepository.deleteById(orgId);
	}
	
	public void deleteAllOrganizations(List<Long> orgId) {
		organizationRepository.deleteAllById(orgId);
	}
	
	public List<Organization> saveAllOrganization(List<Organization> orgs){
		return organizationRepository.saveAll(orgs);
	}
	
	public Organization getOrganizationByNameAndCode(String orgName, Long orgCode){
		return organizationRepository.findByOrgNameAndOrgCode(orgName, orgCode);
	}
	
	public Organization getOrganizationByNameOrCode(String orgName, Long orgCode){
		return organizationRepository.findByOrgNameOrOrgCode(orgName, orgCode);
	}
	
	public List<Organization> getOrganizationGreaterThanOrgCode( Long orgCode){
		return organizationRepository.findByNumberOfEmpGreaterThan(orgCode);
	}

	public List<Organization> getOrganizationBetweenNumberOfEmp(Long startRange, Long endRange) {
		return organizationRepository.findByNumberOfEmpBetween(startRange, endRange);
	}

	public List<Organization> getOrganizationInOrgCode(Long orgCode1, Long orgCode2, Long orgCode3) {
			
		return organizationRepository.findByOrgCodeIn(List.of(orgCode1,orgCode2,orgCode3));
	}
	
	
	public List<Organization> findLikeOrgNameAndOrgHead(String orgName, String orgHeadName){
		return organizationRepository.findLikeOrgNameAndOrgHead(orgName, orgHeadName);
		//return organizationRepository.findLikeOrgNameAndOrgHeadNative(orgName, orgHeadName);
	}
	
	
}
