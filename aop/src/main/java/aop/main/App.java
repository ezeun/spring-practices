package aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.domain.Product;
import aop.service.ProductService;

public class App {

	public static void main(String[] args) {
		// @After, @Before, @AfterReturning, @Around
		test01();
		
		// @After, @Before, @AfterThrowing, @Around
		// test02();
	}

	public static void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		Product p = ps.find("TV");
		System.out.println(p);
		
		((AbstractApplicationContext)ac).close();
	}

	public static void test02() {
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
			
			ProductService ps = ac.getBean(ProductService.class);
			Product p = ps.find("");
			System.out.println(p);
			
			((AbstractApplicationContext)ac).close();
		} catch(RuntimeException ex) {
			/* nothing */
		}
	}
}
