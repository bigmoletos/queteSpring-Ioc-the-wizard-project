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
	private DressWithOtherStyle changeDeStyleGandalf;

	/**
	 * @param changeDeStyle
	 */
	public Gandalf(DressWithOtherStyle changeDeStyle) {
		this.changeDeStyleGandalf = changeDeStyle;
	}

	@Override
	public String giveAdvice() {
		return "Gandalf " + changeDeStyleGandalf.otherStyle();

	}

	@Override
	public String changeDress() {
		return "Gandalf change dress by...";

	}

}
