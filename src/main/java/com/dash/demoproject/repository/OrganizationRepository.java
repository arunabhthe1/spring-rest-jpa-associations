package com.dash.demoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dash.demoproject.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
	
	public Organization findByOrgName(String orgName);
	public Organization findByOrgNameAndOrgCode(String orgName,Long orgCode);
	
	public Organization findByOrgNameOrOrgCode(String orgName,Long orgCode);

	public Organization findDistinctByOrgCode(Long orgCode);

	public List<Organization> findByNumberOfEmpGreaterThan(Long orgCode);	
	
	public List<Organization> findByNumberOfEmpBetween(Long startRange,Long endRange);
	
	public List<Organization> findByOrgCodeIn(List<Long> orgCodes);
	
	
	@Query(value="select org from Organization org where org.orgName like %?1% and org.orgHeadName like %?2% and org.status='ACTIVE'", nativeQuery=false)
	public List<Organization> findLikeOrgNameAndOrgHead(String orgName, String orgHeadName);
	
	@Query(value="select *  from ORGANIZATION org where org.org_name like %?1% and org.org_head_name like %?2% and org.status='ACTIVE'", nativeQuery=true)
	public List<Organization> findLikeOrgNameAndOrgHeadNative(String orgName, String orgHeadName);

		
}
