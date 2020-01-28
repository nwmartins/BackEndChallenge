package com.wealthsystems.challenge;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.datasource.model.Manufacturer;
import com.wealthsystems.challenge.datasource.model.Product;
import com.wealthsystems.challenge.repository.ConsumerRepository;
import com.wealthsystems.challenge.repository.ManufacturerRepository;
import com.wealthsystems.challenge.repository.ProductRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Id = null, DB Controla ID;
		Consumer consumer = new Consumer(null, "Carlos", "5594656546", "teste@gmail.com");
		Consumer consumer2 = new Consumer(null, "Maria", "5594656546", "testeMaria@gmail.com");
		consumerRepository.saveAll(Arrays.asList(consumer, consumer2));

		Product p1 = new Product(null, "Orange juice", "Delicious natural orange juice. No addition of apples to fool consumers", "8901072002478", 18.55);
		Product p2 = new Product(null, "Grape juice", "Natural grape juice", "7002085002679", 25.89);

		Manufacturer m1 = new Manufacturer(null, "Quality farm goods");
		m1.getProducts().addAll(Arrays.asList(p1, p2));

		p1.getManufacturers().addAll(Arrays.asList(m1));
		p2.getManufacturers().addAll(Arrays.asList(m1));

		productRepository.saveAll(Arrays.asList(p1, p2));
		manufacturerRepository.saveAll(Arrays.asList(m1));

	}
}
