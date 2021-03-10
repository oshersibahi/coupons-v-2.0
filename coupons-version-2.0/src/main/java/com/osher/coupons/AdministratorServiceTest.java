package com.osher.coupons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.osher.coupons.entities.Company;
import com.osher.coupons.entities.Customer;
import com.osher.coupons.exceptions.CouponSystemException;
import com.osher.coupons.loginManager.ClientType;
import com.osher.coupons.loginManager.LoginManager;
import com.osher.coupons.services.AdministratorService;

@SpringBootApplication
public class AdministratorServiceTest {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(AdministratorServiceTest.class, args);) {

			LoginManager manager = ctx.getBean(LoginManager.class);
			
			AdministratorService admin = (AdministratorService) manager.login("admin@admin.com","admin", ClientType.ADMINISTRATOR);

			Company c1 = new Company("aa", "aa@mail", "aa");
			Company c2 = new Company("bb", "bb@mail", "bb");
			Company c3 = new Company("cc", "cc@mail", "cc");

			admin.addCompany(c1);
			admin.addCompany(c2);
			admin.addCompany(c3);

			c1.setId(1);
			c1.setEmail("dd@mail");
			c1.setName("aa");
			c1.setPassword("ffdsaf");
			admin.updateCompany(c1);

			System.out.println(admin.getAllCompanies());
			System.out.println(admin.getOneCompany(3));

			Customer cus1 = new Customer("aa", "aa", "aa@mail", "aa");
			Customer cus2 = new Customer("bb", "bb", "bb@mail", "bb");
			Customer cus3 = new Customer("cc", "cc", "cc@mail", "cc");

			admin.addCustomer(cus1);
			admin.addCustomer(cus2);
			admin.addCustomer(cus3);

			cus1.setId(1);
			cus1.setEmail("dd@mail");
			cus1.setFirstName("dd");
			cus1.setLastName("dd");
			cus1.setPassword("dd");
			admin.updateCustomer(cus1);

			System.out.println(admin.getAllCustomers());
			System.out.println(admin.getAllCustomers());
			System.out.println(admin.getOneCustomer(3));

			admin.deleteCompany(1);
			admin.deleteCustomer(2);
			System.out.println(admin.getAllCustomers());
			System.out.println(admin.getAllCompanies());

			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (CouponSystemException e1) {
			e1.printStackTrace();
		}

	}

}
