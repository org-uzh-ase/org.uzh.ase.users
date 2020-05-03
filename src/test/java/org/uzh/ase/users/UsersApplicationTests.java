package org.uzh.ase.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.users.restservice.ScoreController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsersApplicationTests {

	@Autowired
	ScoreController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
