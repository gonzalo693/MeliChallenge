package com.meli.demo;

import com.meli.demo.controller.CouponController;
import com.meli.demo.domain.Response;
import com.meli.demo.domain.ResponseProduct;
import com.meli.demo.services.bean.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private CouponController couponController;
	@Test
	void contextLoads() {
	}

	@Test
	void checkApiIsStarted(){
		List<Product> result = couponController.GetCouponStats();
		assertTrue(result != null);
	}

	@Test
	void executeMain(){
		assertDoesNotThrow(() -> DemoApplication.main(new String[0]));
	}

}
