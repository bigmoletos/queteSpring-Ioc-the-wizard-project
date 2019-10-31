/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.models;

import org.springframework.stereotype.Component;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
@Component("dressWithOtherStyleId")
public class DressWithOtherStyle implements DressWithOtherStyleInterface {
	@Override
	public String otherStyle() {
		return "change ton style mec, t'es has-been!";
	}
}
