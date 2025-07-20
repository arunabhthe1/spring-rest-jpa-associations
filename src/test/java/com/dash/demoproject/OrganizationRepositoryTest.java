package com.dash.demoproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dash.demoproject.model.Organization;
import com.dash.demoproject.repository.OrganizationRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrganizationRepositoryTest {
	
	private final Logger LOGGER=LoggerFactory.getLogger(this.getClass());


	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Test
	public void testGetOrganizationByNameOrCode() {
		Organization org=organizationRepository.findByOrgNameOrOrgCode("Paytm", 100000l);
		LOGGER.info("Organation : "+org);
	}
	
	@Test
	public void testGetOrganizationByDistinctOrgCode() {
		Organization org=organizationRepository.findDistinctByOrgCode(100000l);
		LOGGER.info("Distinct Organation : "+org);
	}
	@Test
	public void testfindByOrganizationGreaterThanOrgCode() {
		List<Organization> orgs=organizationRepository.findByNumberOfEmpGreaterThan(100000l);
		LOGGER.info("Distinct Organation : "+orgs);
	}

	
	@Test
	public void testfindLikeOrgNameAndOrgHead() {
		List<Organization> orgs=organizationRepository.findLikeOrgNameAndOrgHead("Meta","Mark");
		LOGGER.info("Distinct Organation : "+orgs);
	}
}
