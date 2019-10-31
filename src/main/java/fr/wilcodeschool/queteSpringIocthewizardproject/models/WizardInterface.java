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
@Component
public interface WizardInterface {
	String giveAdvice();

	String changeDress();
}
