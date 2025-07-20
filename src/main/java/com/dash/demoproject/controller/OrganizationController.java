package com.dash.demoproject.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dash.demoproject.model.Organization;
import com.dash.demoproject.service.OrganizationServiceImpl;

@RestController
public class OrganizationController {

	private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrganizationServiceImpl organizationServiceImpl;
	
	@GetMapping(value="/organizations")
	public List<Organization> getAllOrganization(){
		LOGGER.info("Getting all the org ");
		return organizationServiceImpl.getAllOrganization();
		
	}
	
	@GetMapping(value="/organizations/{orgid}")
	public Organization getOrganization(@PathVariable Long orgid){
		LOGGER.info("Getting  the org by id"+orgid);
		return organizationServiceImpl.getOrganization(orgid);
		
	}
	
	@GetMapping(value="/organizationsbynameandcode/{orgName}/{orgCode}")
	public Organization findOrganizationsByNameAndCode(@PathVariable String orgName,@PathVariable Long orgCode ){
		LOGGER.info("Getting save the orgName and orgCode "+orgCode +" : "+orgName);
		return organizationServiceImpl.getOrganizationByNameAndCode(orgName, orgCode);
		
	}
	
	@GetMapping(value="/organizationsbynameorcode/{orgName}/{orgCode}")
	public Organization findOrganizationsByNameOrCode(@PathVariable String orgName,@PathVariable Long orgCode ){
		LOGGER.info("Getting save the orgName and orgCode "+orgCode +" : "+orgName);
		return organizationServiceImpl.getOrganizationByNameOrCode(orgName, orgCode);
		
	}
	
	@GetMapping(value="/organizations/greaterthan")
	public List<Organization> getOrganizationGreaterThan(@RequestParam Long numberOfEmp){
		LOGGER.info("Getting  the org by numberOfEmp greater than : "+numberOfEmp);
		return organizationServiceImpl.getOrganizationGreaterThanOrgCode(numberOfEmp);
	}
	
	
	@GetMapping(value="/organizations/numberOfEmp")
	public List<Organization> getOrganizationBetweenNumberOfEmp(@RequestParam Long startRange, @RequestParam Long endRange){
		LOGGER.info("Getting  the org between startRange:"+startRange +" end range:");
		return organizationServiceImpl.getOrganizationBetweenNumberOfEmp( startRange, endRange);
	}
	
	@GetMapping(value="/organizations/inOrgCode")
	public List<Organization> getOrganizationInOrgCode(@RequestParam Long orgCode1,@RequestParam Long orgCode2,@RequestParam Long orgCode3){
		LOGGER.info("Getting  the org in orgCodes :"+orgCode1 +" :: "+orgCode2+" :: "+orgCode3);
		return organizationServiceImpl.getOrganizationInOrgCode(orgCode1,orgCode2,orgCode3);
	}
	
	@GetMapping(value="/organizations/organizationslike")
	public List<Organization> getOrganizationLikeOrgNameAndOrgHeadName(@RequestParam String orgName,@RequestParam String orgHeadName){
		LOGGER.info("Getting  the name is :"+orgName +" :: orgHeadName "+orgHeadName);
		return organizationServiceImpl.findLikeOrgNameAndOrgHead(orgName, orgHeadName);
	}
	
	
	@PostMapping(value="/organizations")
	public Organization createOrganization(@RequestBody Organization org){
		LOGGER.info("Getting save the org "+org);
		return organizationServiceImpl.saveOrUpdateOrganization(org);
		
	}
	@PostMapping(value="/saveallorganizations")
	public List<Organization> createOrganizations(@RequestBody List<Organization> org){
		LOGGER.info("Getting save the org "+org);
		return organizationServiceImpl.saveAllOrganization(org);
		
	}

	@PutMapping(value="/organizations")
	public Organization updateOrganization(@RequestBody Organization org){
		LOGGER.info("Getting update the org "+org);
		return organizationServiceImpl.saveOrUpdateOrganization(org);
		
	}
	
	@DeleteMapping(value="/organizations/{orgid}")
	public String deleteOrganization(@PathVariable Long orgid){
		LOGGER.info("Delete the org with orgId:"+orgid);
		organizationServiceImpl.deleteOrganization(orgid);
		return "SUCCESS";
		
	}
	
	@DeleteMapping(value="/organizations/deleteAll")
	public String deleteOrganizationAll(@RequestParam List<Long> orgids){
		LOGGER.info("Delete the org with orgIds:"+orgids);
		organizationServiceImpl.deleteAllOrganizations(orgids);
		return "SUCCESS";
	}
}
