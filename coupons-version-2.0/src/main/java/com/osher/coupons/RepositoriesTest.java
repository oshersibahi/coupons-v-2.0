package com.osher.coupons;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.osher.coupons.repositories.Repositories;

/**
 *  Additional test. 
 * */

@SpringBootApplication
public class RepositoriesTest {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(RepositoriesTest.class, args)){
			Repositories repositories = ctx.getBean(Repositories.class);
			
//			Optional<Integer> id = repositories.getCompanyRepository().findIdByEmailAndPassword("cc@mail", "cc");
//			if(id.isPresent()) {
//				System.out.println(id.get());
//			}else {
//				System.out.println("no company found");
//			}
//
//			id = repositories.getCustomerRepository().findIdByEmailAndPassword("dd@mail", "dd");
//			if(id.isPresent()) {
//				System.out.println(id.get());
//			}else {
//				System.out.println("no customer found");
//			}
//		Company c1 = new Company("aa", "aa@mail", "aa");
//		Company c2 = new Company("bb", "bb@mail", "bb");
//		Company c3 = new Company("cc", "cc@mail", "cc");		
//		repositories.getCompanyRepository().save(c1);
//		repositories.getCompanyRepository().save(c2);
//		repositories.getCompanyRepository().save(c3);
//		repositories.getCompanyRepository().deleteById(2);
//		List<Company> companies = repositories.getCompanyRepository().findAll();
//		System.out.println(companies);
//		Optional<Company> curr = repositories.getCompanyRepository().findById(1);
//		if(curr.isPresent()) {
//			System.out.println(curr.get());
//		}
//		Company company = repositories.getCompanyRepository().findByEmailAndPassword(c1.getEmail(), c1.getPassword());
//		System.out.println(company);
//		Integer id = repositories.getCompanyRepository().findIdByEmail(c3.getEmail());
//		System.out.println(id);
//		System.out.println(repositories.getCompanyRepository().existsByEmail(c3.getEmail()));
//		System.out.println(repositories.getCompanyRepository().existsByEmailAndPassword(c2.getEmail(), c2.getPassword()));
//		System.out.println(repositories.getCompanyRepository().existsByIdAndName(2, c1.getName()));
//		System.out.println(repositories.getCompanyRepository().existsByName(c2.getName()));
			
//	
//		Customer c1 = new Customer("dd", "dd", "dd@mail", "dd");
//		Customer c2 = new Customer("ee", "ee", "ee@mail", "ee");
//		Customer c3 = new Customer("ff", "ff", "ff@mail", "ff");
//		
//		repositories.getCustomerRepository().save(c1);
//		repositories.getCustomerRepository().save(c2);
//		repositories.getCustomerRepository().save(c3);
//		repositories.getCustomerRepository().deleteById(2);
//		List<Customer> customers = repositories.getCustomerRepository().findAll();
//		System.out.println(customers);
//		Optional<Customer> customer = repositories.getCustomerRepository().findById(1);
//		if(customer.isPresent()) {
//			System.out.println(customer.get());			
//		}
//		Customer customer = repositories.getCustomerRepository().findByEmailAndPassword(c3.getEmail(), c3.getPassword());
//		System.out.println(customer);			
//		Integer id = repositories.getCustomerRepository().findCustomerIdByEmail(c3.getEmail());
//		System.out.println(id);
//		System.out.println(repositories.getCustomerRepository().existsById(1));
//		System.out.println(repositories.getCustomerRepository().existsByEmailAndPassword(c2.getEmail(), c2.getPassword()));
//		System.out.println(repositories.getCustomerRepository().existsByEmail(c3.getEmail()));
//	
//		Coupon coupon1 = new Coupon(null, null, "newnewnenwenw", "bnenenene", LocalDate.now().minusDays(20), LocalDate.now().minusDays(10), 0, 0, null); 
//		Coupon coupon2 = new Coupon(null, null, "asfasfasf", "bneneneasfasfasfne", LocalDate.now().minusDays(30), LocalDate.now().minusDays(10), 0, 0, null); 
//		Coupon coupon3 = new Coupon(null, null, "zbzcxbzxcb", "bnenasfasfasenene", LocalDate.now().minusDays(50), LocalDate.now().minusDays(20), 0, 0, null); 
//		
//		repositories.getCouponRepository().save(coupon1);
//		repositories.getCouponRepository().save(coupon2);
//		repositories.getCouponRepository().save(coupon3);
//	
//		boolean b =repositories.getCouponRepository().existsByIdAndCompanyId(4, 3);
//		System.out.println(b);
//		Optional<Integer> id = repositories.getCouponRepository().findCouponIdByTitleAndCompanyId("ddddd", 3);
//		if(id.isPresent()) {
//			System.out.println(id.get());
//		};
//		Optional<Coupon> optional = repositories.getCouponRepository().findById(8);
//		if(optional.isPresent()) {
//			Coupon coupon = optional.get();
//			System.out.println(coupon);
//		}
//		Optional<Integer> opt = repositories.getCouponRepository().findIdByTitleAndCompanyId("ggggg", 4);
//		if(opt.isPresent()) {
//			System.out.println(opt.get());
//		}
			
//		repositories.getCouponRepository().deleteAllByEndDateBefore(LocalDate.now());
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		};
	}

}
