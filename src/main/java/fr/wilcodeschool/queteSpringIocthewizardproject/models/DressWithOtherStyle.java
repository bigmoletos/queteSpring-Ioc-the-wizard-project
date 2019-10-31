/**
 * 
 *
 */
package fr.wilcodeschool.queteSpringIocthewizardproject.models;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
public class DressWithOtherStyle implements DressWithOtherStyleInterface {
	@Override
	public String otherStyle() {
		return "change ton style mec, t'es has-been!";
	}
}
