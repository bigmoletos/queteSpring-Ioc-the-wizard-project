/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.controllers;

import fr.wilcodeschool.queteSpringIocthewizardproject.models.Outfit;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class App {
	public void start() {
		Outfit ourDress = new Outfit();
		System.out.println("");
		System.out.println("******************");
		System.out.println(ourDress.changeDress());
		System.out.println("******************");
	}
}
