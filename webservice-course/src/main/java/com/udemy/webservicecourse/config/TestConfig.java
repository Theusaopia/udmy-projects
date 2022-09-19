package com.udemy.webservicecourse.config;

import com.udemy.webservicecourse.entities.Category;
import com.udemy.webservicecourse.entities.Order;
import com.udemy.webservicecourse.entities.User;
import com.udemy.webservicecourse.entities.enums.OrderStatus;
import com.udemy.webservicecourse.repositories.CategoryRepository;
import com.udemy.webservicecourse.repositories.OrderRepository;
import com.udemy.webservicecourse.repositories.UserRepository;
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

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        User u1 = new User(null, "Matheus Dias", "matheus@email.com", "999631025", "corinthians");
        User u2 = new User(null, "Cassio Ramos", "casio@email.com", "995631475", "goleiro_casio");

        Order o1 = new Order(null, Instant.parse("2022-09-10T21:15:09Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2022-09-11T07:35:12Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2022-09-12T10:47:00Z"), u1, OrderStatus.WAITING_PAYMENT);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
