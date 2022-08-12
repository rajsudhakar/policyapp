package com.policyapp.client;


import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {

		IPolicyService policyService= new PolicyServiceImpl();
		policyService.getAll().forEach(System.out::println);
		System.out.println();

		try {
			System.out.println("By Type");
			policyService.getByType("term").forEach(System.out::println);
			System.out.println();
			System.out.println("By Category");
			policyService.getByCategory("motor").forEach(System.out::println);
			System.out.println();
			System.out.println("by sumAssured");
			policyService.getByHighSumAssured(350000).forEach(System.out::println);
			System.out.println();
			System.out.println("by Coverage");
			policyService.getByCoverage("accident").forEach(System.out::println);
			System.out.println();
			System.out.println("by Premium");
			policyService.getBYLessPremium(2500).forEach(System.out::println);
			System.out.println();
			System.out.println("By ID");
			System.out.println(policyService.getById(1003));
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No policy available");
		}
		
		catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ID Not Available");
		}	
		
		}
		}



