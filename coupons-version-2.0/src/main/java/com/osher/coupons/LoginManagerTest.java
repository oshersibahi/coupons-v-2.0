package com.osher.coupons;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.osher.coupons.entities.Company;
import com.osher.coupons.exceptions.CouponSystemException;
import com.osher.coupons.loginManager.ClientType;
import com.osher.coupons.loginManager.LoginManager;
import com.osher.coupons.services.AdministratorService;
import com.osher.coupons.services.CompanyService;
import com.osher.coupons.services.CustomerService;

/**
 *  Additional test. 
 * */

@SpringBootApplication
public class LoginManagerTest {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(LoginManagerTest.class, args);){
			
			String adminEmail = "admin@admin.com";
			String adminPassword = "admin";
			
			String company1Email = "aa@mail";
			String company1Password = "aa";
			
			String company2Email = "bb@mail";
			String company2Password = "bb";
			
			String customer1Email = "cc@mail";
			String customer1Password = "cc";
			
			String customer2Email = "bb@mail";
			String customer2Password = "bb";
			
			ClientType admin = ClientType.ADMINISTRATOR;
			ClientType company = ClientType.COMPANY;
			ClientType customer = ClientType.CUSTOMER;
			
			LoginManager manager = ctx.getBean(LoginManager.class);
			
			AdministratorService adminService = (AdministratorService) manager.login(adminEmail, adminPassword, admin);
			boolean login = adminService.login(adminEmail, adminPassword);
			System.out.println(login);
			
			List<Company> companies = adminService.getAllCompanies();
			Iterator<Company> it = companies.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			
			CompanyService companyService = (CompanyService) manager.login(company1Email, company1Password, company);
			System.out.println(companyService);
			
			companyService = (CompanyService) manager.login(company2Email, company2Password, company);
			System.out.println(companyService);

			CustomerService customerService = (CustomerService) manager.login(customer1Email, customer1Password, customer);
			
			customerService = (CustomerService) manager.login(customer2Email, customer2Password, customer);

			
			
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (CouponSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
