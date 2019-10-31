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
	private DressWithOtherStyle dressWithOtherStyle;

	/**
	 * 
	 */
	public Dumbledore() {
		// TODO Auto-generated constructor stub
	}

	// Constructor with the cosyDrinkAdvice object passed as an argument
	public Dumbledore(DressWithOtherStyle theNewStyle) {
		this.dressWithOtherStyle = theNewStyle;
	}

	@Override
	public String giveAdvice() {
		return "Dumbledore " + dressWithOtherStyle.otherStyle();
//		return "Dumbledore give us advice";

	}

	@Override
	public String changeDress() {
		return "Dumbledore change dress by...";
	}

}
