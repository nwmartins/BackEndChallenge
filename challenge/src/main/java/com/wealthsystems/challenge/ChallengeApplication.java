package com.wealthsystems.challenge;

import com.wealthsystems.challenge.model.*;
import com.wealthsystems.challenge.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

	@Autowired
	private ConsumerRepository consumerRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ManufacturerRepository manufacturerRepository;
	@Autowired
	DeliveryRepository deliveryRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	RequestRepository requestRepository;
	@Autowired
	ItemRequestRepository itemRequestRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Manufacturer m1 = new Manufacturer(null, "Quality farm goods");
		Manufacturer m2 = new Manufacturer(null, "Wealth Systems");
		manufacturerRepository.saveAll(Arrays.asList(m1, m2));

//		//Id = null, DB Controla ID;
//		Consumer consumer = new Consumer(null, "Carlos", "5594656546", "teste@gmail.com");
//		Consumer consumer2 = new Consumer(null, "Maria", "5594656546", "testeMaria@gmail.com");
//		consumerRepository.saveAll(Arrays.asList(consumer, consumer2));
//
//		Product p1 = new Product(null, "Orange juice", "Delicious natural orange juice. No addition of apples to fool consumers", "8901072002478", 18.55);
//		Product p2 = new Product(null, "Grape juice", "Natural grape juice", "7002085002679", 25.89);
//		Product p3 = new Product(null, "Apple juice", "Natural apple juice", "7002065423178", 34.87);
//
//		Manufacturer m1 = new Manufacturer(null, "Quality farm goods");
//		Manufacturer m2 = new Manufacturer(null, "Quality farm bad");
//		m1.getProducts().addAll(Arrays.asList(p1, p2, p3));
//
//		p1.setManufacturer(m1);
//		p2.setManufacturer(m1);
//		p3.setManufacturer(m1);
//

//		productRepository.saveAll(Arrays.asList(p1, p2, p3));
//
//		Delivery d = new Delivery(null, "in-store withdrawal");
//		Delivery d2 = new Delivery(null, "Sent by Correios");
//
//		deliveryRepository.saveAll(Arrays.asList(d, d2));
//
//		Payment payment = new Payment(null, "bank slip", 91.52, 3, 30.51);
//
//		paymentRepository.saveAll(Arrays.asList(payment));
//
//		Request r = new Request(null, "pending confirmation", consumer, payment, d);
//
//		requestRepository.saveAll(Arrays.asList(r));
//
//		ItemRequest ir1 = new ItemRequest(r, p1, 2.00);
//		ItemRequest ir2 = new ItemRequest(r, p2, 2.25);
//		ItemRequest ir3 = new ItemRequest(r, p3, 1.00);
//
//		r.getItems().addAll(Arrays.asList(ir1, ir2, ir3));
//
//		p1.getItems().addAll(Arrays.asList(ir1));
//		p2.getItems().addAll(Arrays.asList(ir2));
//		p3.getItems().addAll(Arrays.asList(ir3));
//
//		itemRequestRepository.saveAll(Arrays.asList(ir1, ir2, ir3));

	}
}
