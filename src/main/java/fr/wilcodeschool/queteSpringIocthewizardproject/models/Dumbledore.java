/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
@Component("dumbledoreId")
public class Dumbledore implements WizardInterface {
	private DressWithOtherStyle dressWithOtherStyle;

	/**
	 * 
	 */
	public Dumbledore() {
		// TODO Auto-generated constructor stub
	}

	// Constructor with the cosyDrinkAdvice object passed as an argument
	@Autowired
	public Dumbledore(@Qualifier("dressWithOtherStyleId") DressWithOtherStyle theNewStyle) {
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
