package com.osher.coupons;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.osher.coupons.entities.Category;
import com.osher.coupons.entities.Company;
import com.osher.coupons.entities.Coupon;
import com.osher.coupons.exceptions.CouponSystemException;
import com.osher.coupons.loginManager.ClientType;
import com.osher.coupons.loginManager.LoginManager;
import com.osher.coupons.services.AdministratorService;
import com.osher.coupons.services.CompanyService;

@SpringBootApplication
public class CompanyServiceTest {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext ctx = SpringApplication.run(CompanyServiceTest.class, args);) {

			LoginManager manager = ctx.getBean(LoginManager.class);
			AdministratorService admin = (AdministratorService) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
			Company company3 = admin.getOneCompany(3);
			Company company1 = admin.getOneCompany(2);

			CompanyService service3 = (CompanyService) manager.login(company3.getEmail(), company3.getPassword(), ClientType.COMPANY);
			CompanyService service1 = (CompanyService) manager.login(company1.getEmail(), company1.getPassword(), ClientType.COMPANY);
			
			Coupon coupon1 = new Coupon(null, Category.FOOD, "ggggg", "ggggg", null, null, 2, 10, null);
			Coupon coupon2 = new Coupon(null, Category.ALL, "aaaaa", "aaaaaa", LocalDate.now(), LocalDate.now().plusDays(12), 5, 10, null);
			Coupon coupon3 = new Coupon(null, Category.SPORT, "ccccccc", "ccccccc", LocalDate.now().minusDays(5), LocalDate.now(), 6, 12, null);
			Coupon coupon4 = new Coupon(null, Category.FOOD, "ggggg", "ggggg", null, null, 2, 10, null);
			Coupon coupon5 = new Coupon(null, Category.ALL, "aaaaa", "aaaaaa", LocalDate.now(), LocalDate.now().plusDays(12), 5, 10, null);
			Coupon coupon6 = new Coupon(null, Category.SPORT, "ccccccc", "ccccccc", LocalDate.now().minusDays(5), LocalDate.now(), 6, 12, null);

			service3.addCoupon(coupon1);
			service3.addCoupon(coupon2);
			service3.addCoupon(coupon3);
			service1.addCoupon(coupon4);
			service1.addCoupon(coupon5);
			service1.addCoupon(coupon6);
			service3.deleteCoupon(3);
			System.out.println(service3.getCompanyCoupons());
			System.out.println(service3.getCompanyCoupons(Category.ALL));
			System.out.println(service3.getCompanyCoupons(10));
			System.out.println(service3.getCompanyDetails());
		
			coupon1.setId(1);
			coupon1.setCategory(Category.RESTURANT);
			coupon1.setAmount(20);
			coupon1.setDescription("amazing amazing");
			service3.updateCoupon(coupon1);
			
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (CouponSystemException e) {
			e.printStackTrace();
		}

	}

}
