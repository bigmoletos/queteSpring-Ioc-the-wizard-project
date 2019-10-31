/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.models;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Dumbledore implements WizardInterface {

	@Override
	public String giveAdvice() {
		return "Dumbledore give us advice";

	}

	@Override
	public String changeDress() {
		return "Dumbledore change dress by...";
	}

}
