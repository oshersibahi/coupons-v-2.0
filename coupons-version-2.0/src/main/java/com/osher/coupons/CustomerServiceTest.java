package com.osher.coupons;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.osher.coupons.entities.Category;
import com.osher.coupons.entities.Coupon;
import com.osher.coupons.entities.Customer;
import com.osher.coupons.exceptions.CouponSystemException;
import com.osher.coupons.loginManager.ClientType;
import com.osher.coupons.loginManager.LoginManager;
import com.osher.coupons.services.AdministratorService;
import com.osher.coupons.services.CustomerService;

@SpringBootApplication
public class CustomerServiceTest {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(CustomerServiceTest.class, args);){
			LoginManager manager = ctx.getBean(LoginManager.class);
			AdministratorService admin = (AdministratorService) manager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
			Customer customer3 = admin.getOneCustomer(3);
			Customer customer1 = admin.getOneCustomer(1);
			
			Coupon coupon1 = admin.getOneCoupon(4);
			Coupon coupon2 = admin.getOneCoupon(5);
			Coupon coupon3 = admin.getOneCoupon(6);
			
			CustomerService service3 = (CustomerService) manager.login(customer3.getEmail(), customer3.getPassword(), ClientType.CUSTOMER);
			CustomerService service1 = (CustomerService) manager.login(customer1.getEmail(), customer1.getPassword(), ClientType.CUSTOMER);
			
			List<Coupon> list = service3.getCustomerCoupons();
			System.out.println(list);
	
			service1.purchaseCoupon(coupon1.getId());
			service1.purchaseCoupon(coupon2.getId());
			service3.purchaseCoupon(coupon3.getId());
			
			System.out.println(service3.getCustomerDetails());
			System.out.println(service1.getCustomerDetails());
			System.out.println(service3.getCustomerCoupons(Category.ALL));
			System.out.println(service1.getCustomerCoupons(Category.ALL));
			System.out.println(service3.getCustomerCoupons(120));
			System.out.println(service1.getCustomerCoupons(120));
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
