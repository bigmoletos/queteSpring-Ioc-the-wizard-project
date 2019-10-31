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
@Component("gandalfId")
public class Gandalf implements WizardInterface {
	private DressWithOtherStyle changeDeStyleGandalf;

	/**
	 * @param changeDeStyle
	 */
	@Autowired
	public Gandalf(@Qualifier("dressWithOtherStyleId") DressWithOtherStyle changeDeStyle) {
		this.changeDeStyleGandalf = changeDeStyle;
	}

	@Override
	public String giveAdvice() {
		return "Gandalf " + changeDeStyleGandalf.otherStyle();
//		return "Gandalf give us advice";

	}

	@Override
	public String changeDress() {
		return "Gandalf change dress by...";

	}

}
