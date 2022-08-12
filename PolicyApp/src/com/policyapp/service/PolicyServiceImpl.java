package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	
	IPolicyDAO policyDAO=new PolicyDAOImpl();

	@Override
	public List<Policy> getAll() {
		List<Policy> policies=policyDAO.findAll();
		List<Policy> policyList=policies
				.stream()
				.sorted((p1,p2)-> p1.getPolicyName().compareToIgnoreCase(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		return policyList;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy> byType = policyDAO.findByType(type);
		if(byType.isEmpty())
			throw new PolicyNotFoundException();
		return byType;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy> byCategory = policyDAO.findByCategory(category);
		if(byCategory.isEmpty())
			throw new PolicyNotFoundException();
		return byCategory;
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> byAssured = policyDAO.findByHighSumAssured(sumAssured);
		if(byAssured.isEmpty())
			throw new PolicyNotFoundException();
		return byAssured;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> byCoverage = policyDAO.findByCoverage(coverage);
		if(byCoverage.isEmpty())
			throw new PolicyNotFoundException();
		return byCoverage;
	}

	@Override
	public List<Policy> getBYLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> byPremium = policyDAO.findBYLessPremium(premium);
		if(byPremium.isEmpty())
			throw new PolicyNotFoundException();
		return byPremium;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy byId = policyDAO.findById(policyId);
		if(byId==null)
			throw new IdNotFoundException();
		
		return byId;
	}

}