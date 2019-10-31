package fr.wilcodeschool.queteSpringIocthewizardproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.wilcodeschool.queteSpringIocthewizardproject.controllers.App;

@SpringBootApplication
public class QueteSpringIocTheWizardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueteSpringIocTheWizardProjectApplication.class, args);
		// appel de start(){} dans la classe App
		App myapp = new App();

		myapp.start2();
		myapp.start1();
	}

}
