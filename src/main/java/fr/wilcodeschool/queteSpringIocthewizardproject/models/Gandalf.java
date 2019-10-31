/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.models;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class Gandalf implements WizardInterface {

	@Override
	public String giveAdvice() {
		return "Gandalf give us advice";

	}

	@Override
	public String changeDress() {
		return "Gandalf change dress by...";

	}

}
