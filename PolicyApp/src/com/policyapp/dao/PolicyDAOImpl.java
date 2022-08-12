package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImpl implements IPolicyDAO {
	

	public PolicyDAOImpl() {
		super();
	}

	@Override
	public List<Policy> findAll() {
		return showAllPolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		
		
		return showAllPolicies().stream().filter(type1->type1.getType().equals(type)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		List<Policy> byCategory=showAllPolicies().stream().filter(cat->cat.getCategory().equals(category))
				.sorted((c1,c2)->c1.getPolicyName()
						.compareTo(c2.getPolicyName())).collect(Collectors.toList());
		return byCategory;
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		return showAllPolicies().stream().filter(assure->assure.getSumAssured()>=sumAssured)
//				.sorted((s1,s2)->(s1.getSumAssured()==s2.getSumAssured())
						.collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(cover->cover.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findBYLessPremium(double premium) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllPolicies().stream().filter(amount->amount.getPremium()<=premium).collect(Collectors.toList());
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return (Policy) showAllPolicies().stream().filter(policy->policy.getPolicyNumber()==policyId).
				findFirst().orElseThrow(IdNotFoundException::new);
	}
	
	private List<Policy> showAllPolicies(){
		return Arrays.asList(
				new Policy("Jeevan sathi", 1001, 3500, "term", 5, "marriage", "general", 300000),
				new Policy("Bajaj Allianz ", 1002, 1200, "Single", 2, "accident", "motor", 200000),
				new Policy("Jeevan Anand", 1003, 3000, "endowment", 5, "sickness", "general", 350000),
				new Policy("Jeevan Nidhi", 1004, 2500, "Pension", 5, "retirement", "life", 500000),
				new Policy("Tata Allianz", 1005, 5000, "term", 5, "accident", "motor", 150000),
				new Policy("ClickToProtect", 1006, 6000, "endowment", 5, "sickness", "life", 400000)
				);
		
	}

}