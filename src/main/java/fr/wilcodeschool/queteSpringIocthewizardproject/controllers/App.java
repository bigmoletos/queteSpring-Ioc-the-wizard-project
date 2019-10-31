/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.wilcodeschool.queteSpringIocthewizardproject.models.Dumbledore;
import fr.wilcodeschool.queteSpringIocthewizardproject.models.Outfit;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class App {
	// version avec IOC et injection de dependance de
	// DressWithOtherStyle.otherStyle()
	public void start1() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:ApplicationBeanInContainer.xml");
//		"theOutfit" fait le lien avec le fichier xml applicationContext.xml,
//		c'est l'id du bean
		Dumbledore myDumbledore = context.getBean("dumbledore", Dumbledore.class);

		context.close();
		// Outfit ourDress = new Outfit();
		System.out.println("");
		System.out.println("******************");
		System.out.println(myDumbledore.changeDress());
		System.out.println(myDumbledore.giveAdvice());
		System.out.println("******************");
	}

	// version sans IOC et dependance forte
	public void start2() {

		Outfit ourDress = new Outfit();
		System.out.println("");
		System.out.println("******************");
		System.out.println(ourDress.changeDress());
		System.out.println("******************");

		Dumbledore dumbledore = new Dumbledore();
		System.out.println("");
		System.out.println("******************");
		System.out.println(dumbledore.changeDress());
		System.out.println("******************");

	}
}
