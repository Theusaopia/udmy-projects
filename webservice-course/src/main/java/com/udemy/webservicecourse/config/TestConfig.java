package com.udemy.webservicecourse.config;

import com.udemy.webservicecourse.entities.*;
import com.udemy.webservicecourse.entities.enums.OrderStatus;
import com.udemy.webservicecourse.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The lord of the rings", "A hobbit, an elf and a mage against the evil", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "A TV. But it is smart.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Too much money for a laptop", 12250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Lots of led", 5875.90, "");
        Product p5 = new Product(null, "Java for dummies", "Now you're gonna learn", 100.0, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().addAll(Arrays.asList(cat1, cat3));
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User u1 = new User(null, "Matheus Dias", "matheus@email.com", "999631025", "corinthians");
        User u2 = new User(null, "Cassio Ramos", "casio@email.com", "995631475", "goleiro_casio");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2022-09-10T21:15:09Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2022-09-11T07:35:12Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2022-09-12T10:47:00Z"), u1, OrderStatus.WAITING_PAYMENT);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
