/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.wilcodeschool.queteSpringIocthewizardproject.models.Outfit;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class App {
	// version avec IOC
	public void start() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:applicationContext.xml");
		Outfit myOutfit = context.getBean("theOutfit", Outfit.class);

		context.close();
		// Outfit ourDress = new Outfit();
		System.out.println("");
		System.out.println("******************");
		System.out.println(myOutfit.changeDress());
		System.out.println("******************");
	}

	// version sans IOC
	public void start1() {

		Outfit ourDress = new Outfit();
		System.out.println("");
		System.out.println("******************");
		System.out.println(ourDress.changeDress());
		System.out.println("******************");
	}
}
