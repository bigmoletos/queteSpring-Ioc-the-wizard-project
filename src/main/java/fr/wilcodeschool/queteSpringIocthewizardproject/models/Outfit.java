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
@Component("outfitId")
public class Outfit {
//todo via injection de dependance retourner une 
//	methode String retournant par "the wizard's dress is blue"
	public String changeDress() {
		return "the wizard's dress is blue";
	}
}
