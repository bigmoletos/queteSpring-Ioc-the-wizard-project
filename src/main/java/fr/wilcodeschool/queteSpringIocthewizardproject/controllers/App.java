/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.wilcodeschool.queteSpringIocthewizardproject.models.Dumbledore;
import fr.wilcodeschool.queteSpringIocthewizardproject.models.Gandalf;
import fr.wilcodeschool.queteSpringIocthewizardproject.models.Outfit;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class App {

//	version annotation avec IOC et DI
	public void start3() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:ApplicationBeanInContainer.xml");
		Dumbledore myDumbledore = context.getBean("dumbledoreId", Dumbledore.class);
		Gandalf myGandalf = context.getBean("gandalfId", Gandalf.class);
		Outfit myOutfit = context.getBean("outfitId", Outfit.class);
		System.out.println("");
		System.out.println("******************");
		System.out.println(myDumbledore.changeDress());
		System.out.println(myDumbledore.giveAdvice());
		System.out.println("******************");
		System.out.println("");
		System.out.println("******************");
		System.out.println(myGandalf.changeDress());
		System.out.println(myGandalf.giveAdvice());
		System.out.println("******************");
		System.out.println(myOutfit.changeDress());
		System.out.println("******************");
	}

//	// version fichier xml ApplicationBeanInContainer avec IOC et injection de
//	// dependance de
//	// DressWithOtherStyle.otherStyle()
//	public void start1() {
//
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath*:ApplicationBeanInContainer.xml");
////		"theOutfit" fait le lien avec le fichier xml applicationContext.xml,
////		c'est l'id du bean
//		Dumbledore myDumbledore = context.getBean("dumbledore", Dumbledore.class);
//		Gandalf myGandalf = context.getBean("gandalf", Gandalf.class);
//		Outfit myOutfit = context.getBean("outfit", Outfit.class);
//		context.close();
//		// Outfit ourDress = new Outfit();
//		System.out.println("");
//		System.out.println("******************");
//		System.out.println(myDumbledore.changeDress());
//		System.out.println(myDumbledore.giveAdvice());
//		System.out.println("******************");
//		System.out.println("");
//		System.out.println("******************");
//		System.out.println(myGandalf.changeDress());
//		System.out.println(myGandalf.giveAdvice());
//		System.out.println("******************");
//		System.out.println(myOutfit.changeDress());
//		System.out.println("******************");
//
//	}

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
