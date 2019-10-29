CHALLENGE    C'est pas sorcier
Énoncé :


Afin de mettre en pratique tes nouvelles connaissances de Spring et les montrer au reste du monde, il te faudra suivre les étapes suivantes.

NB : Pour ce projet, tu devras créer deux branches au sein de ton dépôt distant : une branche pour la solution 1 (cf. plus bas) et une branche pour la solution 2 (cf. plus bas).

NB bis : Tout comme dans l'exemple de la quête, toutes les méthodes devront être implémentées sous forme de code visible dans la console, c'est-à-dire utilisant des System.out.println.

1.
Génère un projet Spring Boot « Web » à partir de https://start.spring.io (group : fr.wildcodeschool, artifact : the-wizard-project).

2.
Crée une interface WizardInterface comportant une méthode giveAdvice() et une méthode changeDress(). Conçois ensuite deux classes (Dumbledore et Gandalf) implémentant cette interface. La méthode giveAdvice() doit remplir son rôle directement, via un simple retour de String. La méthode changeDress(), elle, doit remplir son rôle en recourant à un objet de type Outfit (cela signifie qu'il te faut créer la classe correspondante ; cette classe devra contenir une méthode retournant un String, par exemple "The wizard's dress is blue"), et ce via une injection de dépendance.

3.
Créer une classe App comportant une méthode start() appelée depuis la classe TheWizardProjectApplication. La classe App devra passer par ClassPathXmlApplicationContext pour récupérer un objet de type WizardInterface (instancié à partir de la classeDumbledore ou de la classe Gandalf), à partir duquel elle invoquera les méthodes giveAdvice() et changeDress().

4.
Configure le bean correspondant à l'objet de type WizardInterface mentionné plus haut, ainsi que sa dépendance, en passant par un fichier XML. Une fois cela fait, envoie les modifications vers ton dépôt distant et partage le lien en solution (ce sera ta solution 1).

5.
Configure le bean correspondant à l'objet de type WizardInterface mentionné plus haut, ainsi que sa dépendance, en passant par les annotations Java. Une fois cela fait, envoie les modifications vers ton dépôt distant et partage le lien en solution (ce sera ta solution 2).

MeasureMeasure

#######################################################################

ressources

#######################################################################
Spring : IOC, DI... késako ?
Dans cette quête, tu vas explorer des concepts fondamentaux du framework Spring : l'inversion de contrôle et l'injection de dépendances.

Tu vas découvrir différentes manières de contrôler une (petite) partie du framework.

En voiture Simone !

Objectifs

•
Comprendre les principes fondamentaux de Spring : inversion de contrôle et injection de dépendances

Challenge ️🕹️
Pour valider cette quête tu devras résoudre le challenge: C'est pas sorcier. Le principe du challenge est détaillé dans l’onglet Challenge.

voir le challenge
Créé un projet Spring Boot
Spring Initializr

Spring Boot propose plusieurs façons de générer un squelette de projet web utilisable out of the box. Un moyen de le faire est de passer par Spring Initializr : https://start.spring.io.


Crée un nouveau projet avec un group « com.wildcodeschool », ainsi qu'un artefact « myLibrary » (rappel : l'artefact est le nom de ton futur projet ; de plus, group + artefact => le nom du package que Spring Boot va générer pour ton projet par défaut).

Côté dependencies, choisis « web », puis clique sur « Generate ». Télécharge le zip généré, extrais-le et importe-le dans ton IDE.

Dans src/main/java, créé un package com.wildcodeschool.myLibrary.controllers. Ici, tu mettras toutes tes classes participant au contrôle de ton programme. Crée également un package com.wildcodeschool.myLibrary.models, où tu placeras toutes tes classes modélisant des objets concrets (on parle aussi d'objets « métier » ; par exemple, une classe Book que tu vas fabriquer dans la suite de cette quête).

Inversion de contrôle et injection de dépendances : pour quoi faire ?
Les concepts d'inversion de contrôle et d'injection de dépendances sont au cœur du fonctionnement de Spring.

Comme c'est souvent le cas pour les frameworks modernes, il est tout à fait possible d'utiliser Spring d'une façon « magique », sans connaître ces deux concepts. Néanmoins, étant donné qu'il s'agit de concepts fondateurs, ces deux notions constituent souvent des sujets de choix pour des questions d'entretiens techniques (voir ressources).

Entre autres bénéfices, l'inversion de contrôle et l'injection de dépendances permettent de :

•
Minimiser la quantité de code à écrire

•
Rendre une application plus simple à tester grâce à l'utilisation de bouchons (mocks).

•
Rendre une application plus flexible. Par exemple, en cas de migration d'une base de données utilisée par ton application Java vers une autre (R : une base de données SQL vers une base de données NoSQL), il n'y aura pas besoin de modifier le code lui-même - seulement la configuration liée à l'inversion de contrôle et à l'injection de dépendances.

Tout cela peut te paraître très théorique pour le moment... N'hésite pas à revenir consulter les ressources de cette partie une fois que tu auras terminé de lire la quête, pour approfondir. Cela s'éclairera aussi lorsque tu pratiqueras Spring plus avant.

Benefits of IoC
Consulte les parties *Benefits of inversion of control* et *IoC testing*.
https://www.theserverside.com/feature/Meaning-of-inversion-of-control-in-Spring-and-Java-IoC-explained
What are the benefits of IOC ?
Va lire les questions 3 et 5.
http://www.developersbook.com/spring/interview-questions/spring-interview-questions-faqs.php
Spring interview questions
Pour voir comment l'inversion de contrôle et l'injection de dépendances peuvent être traités dans le cadre d'un entretien de recrutement technique
https://www.journaldev.com/2696/spring-interview-questions-and-answers#dependency-injection
Inversion de contrôle : le principe
Partons d'un exemple simplifié pour comprendre l'inversion de contrôle !

Imaginons que tu souhaites, en plus d'apprendre à manipuler Spring, élargir ta culture littéraire. Pour cela, tu vas confectionner un petit programme te permettant de récupérer un extrait d'un livre d'un genre donné (fantasy, science-fiction, etc.).

Dans ton projet Spring Boot, au sein du package com.wildcodeschool.myLibrary.models, commence par créer une classe FantasyBook, dont la méthode readExtract t'envoie un extrait du Seigneur des Anneaux.

package com.wildcodeschool.myLibrary.models;

public class FantasyBook {

    public String readExtract() {
        return "When Mr. Bilbo Baggins of Bag End announced that...";
    }
}
Java
NB : Dans la vraie vie, ton petit programme pourrait aussi bien être une application qui va récupérer un texte à partir d'une base de données. La classe FantasyBook serait alors une classe chargée d'aller chercher le texte dans cette base.

Tu peux voir FantasyBook comme un bouchon (mock) : comme on ne sait pas encore comment aller chercher des informations dans une base de données à partir d'une application Java, on écrit les informations en dur dans la classe (ici, return "When Mr. Bilbo Baggins of Bag End announced that...").

Afin que le reste du monde puisse lire cette phrase, tu vas devoir modifier la classe MyLibraryApplication, qui est générée automatiquement dans ton squelette de projet web. Comportant la méthode main, elle est la porte d'entrée de ton programme.

Voici sa structure initiale, lorsque ton projet vient d'être généré :

package com.wildcodeschool.myLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLibraryApplication.class, args);
    }
}
Java
Une bonne pratique étant de ne pas surcharger la logique de cette classe, tu vas créer (dans le package com.wildcodeschool.myLibrary.controllers) une autre classe, App, qui définira les instructions que devra exécuter ton programme une fois entré dans le main.

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.FantasyBook;

public class App {

    public void start() {
        FantasyBook myBook = new FantasyBook();
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
Afin que les instructions contenues dans App soient exécutées lors du lancement de ton projet, tu dois instancier la classe App dans MyLibraryApplication et invoquer sa méthode start() :

package com.wildcodeschool.myLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wildcodeschool.myLibrary.controllers.App;

@SpringBootApplication
public class MyLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLibraryApplication.class, args);
        App myApp = new App();
        myApp.start();
    }
}
Java
En l'état, ton programme est d'ores et déjà fonctionnel. Tu peux le voir en te rendant dans ton Terminal. Place-toi dans le dossier correspondant à ton projet, puis exécute la commande mvn spring-boot:run. Ton application Spring se lancera et s'exécutera jusqu'à l'affichage de l'output suivant (attention, lorsque tu fais tourner ton programme à partir du Terminal, tous les outputs s'afficheront dans le Terminal, et non dans la console de ton IDE !) :

******************
When Mr. Bilbo Baggins of Bag End announced that...
******************
Shell
L'exemple que tu viens de réaliser illustre un cas de couplage fort : la logique de ta classe App est fortement liée à la classe FantasyBook.

Nous allons affaiblir ce couplage.

Supposons que tu souhaites obtenir un extrait d'un livre de science-fiction, et non plus de fantasy. Par exemple, l'excellent Fondation d'Isaac Asimov. Tu crées donc la classe ScienceFictionBook.

package com.wildcodeschool.myLibrary.models;

public class ScienceFictionBook {

    public String readExtract() {
        return "His name was Gaal Dornick...";
    }
}
Java
Tu disposes maintenant de deux livres, youhou ! Le problème, c'est qu'il te faudrait changer à la main le code de App à chaque fois que tu veux lire un extrait de tel ou tel genre littéraire. Autrement dit, pour FantasyBook, tu devras écrire :

FantasyBook myBook = new FantasyBook();
Java
Pour ScienceFictionBook, ce sera :

ScienceFictionBook myBook = new ScienceFictionBook();
Java
Pour fluidifier cela, tu peux tirer profit du polymorphisme que permettent les interfaces. Créé une nouvelle interface Book dans le package com.wildcodeschool.myLibrary.models.

Dans cette dernière, tu vas pouvoir inscrire la signature de readExtract() (c'est-à-dire seulement son modifier [ici, public], le type de la valeur retournée [ici, void] et son nom [ici, readExtract]), qui est une méthode commune à FantasyBook et ScienceFictionBook.

package com.wildcodeschool.myLibrary.models;

public interface Book {

    public String readExtract();

}
Java
N'oublie pas de préciser que tes deux classes de livres (FantasyBook et ScienceFictionBook) implémentent maintenant ton interface Book en utilisant le mot-clé « implements ».

package com.wildcodeschool.myLibrary.models;

public class FantasyBook implements Book {

    @Override
    public String readExtract() {
        return "When Mr. Bilbo Baggins of Bag End announced that...";
    }
}
Java
package com.wildcodeschool.myLibrary.models;

public class ScienceFictionBook implements Book {

    @Override
    public String readExtract() {
        return "His name was Gaal Dornick...";
    }
}
Java
Grâce au polymorphisme de tes classes, tu peux écrire cette nouvelle version de App :

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.Book;
import com.wildcodeschool.myLibrary.models.FantasyBook;

public class App {

    public void start() {
        Book myBook = new FantasyBook();
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
Comme tu peux le constater, il est maintenant possible de remplacer FantasyBook par n'importe quel autre livre (par exemple, ScienceFictionBook... mais cela pourrait être n'importe quelle classe écrite par n'importe quel développeur, du moment que cette classe implémente l'interface Book), en changeant simplement la classe dans Book myBook = new [classeInterchangeable].

Essaie avec ScienceFictionBook :

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.Book;
import com.wildcodeschool.myLibrary.models.ScienceFictionBook;

public class App {

    public void start() {
        Book myBook = new ScienceFictionBook();
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
Si tu exécutes ton programme, tu peux observer que l'output dans le Terminal change en conséquence : c'est maintenant His name was Gaal Dornick... qui s'affiche.

Seulement voilà : plutôt que de définir si tu veux utiliser FantasyBook ou ScienceFictionBook en dur dans ton code, il serait bien pratique de pouvoir plutôt le faire via une source de configuration externe...

C'est ce qu'on appelle l'inversion de contrôle (Inversion Of Control, ou IoC, en anglais).

Et c'est là que Spring entre en jeu !

Au sein du framework, cette source de configuration externe peut prendre 3 formes :

•
Un fichier XML (pratique un peu datée aujourd'hui, mais que tu risques de retrouver dans beaucoup de projets legacy à maintenir)

•
Des annotations dans le code Java (moderne)

•
Une classe de configuration écrite en Java (moderne)

Dans la suite de cette quête, tu vas découvrir les deux premières formes citées.

D'un point de vue théorique, il faut que tu comprennes que, quand un programme Java classique démarre, le main est lancé, puis les instructions comprises dans celui-ci sont exécutées (par exemple, la création d'un nouvel objet à partir d'une classe). Dans le cadre de l'IoC, l'inverse se produit : c'est le framework (on parle aussi de container) qui crée tous les objets annexes qui sont, dans un second temps seulement, injectés - tout prêts - dans le main. Le main ne s'occupe donc plus de fabriquer l'objet lui-même - il ne fait que le retirer du container.

Soit dit en passant, un objet fabriqué au sein d'un container s'appelle un bean, et c'est la terminologie qu'utilise Spring dans sa documentation.

L'IoC est parfois surnommée the Hollywood Principle, car elle illustre une phrase célèbre dans le milieu du cinéma américain : « Don't call us, we'll call you ».


Explanation of dependency injection/inversion of control
https://www.javaworld.com/article/2071914/excellent-explanation-of-dependency-injection--inversion-of-control-.html
Injection de dépendances : le principe
L'injection de dépendances est une sous-partie de l'IoC. Il s'agit d'un processus durant lequel le container prend en charge la création d'un objet que tu prévois d'utiliser en tant qu'argument dans une méthode d'une autre classe.

Imaginons un instant que l'IoC n'existe pas.

Dans une situation où tu voudrais implémenter, dans ta classe FantasyBook, une méthode sayWhatever(), qui utiliserait elle-même une autre méthode, speak(), appartenant à un objet myServiceWhatever, tu devrais procéder comme suit :

1) Créer un attribut myServiceWhatever et définir une méthode setServiceWhatever(ServiceWhatever theServiceWhatever) :

package com.wildcodeschool.myLibrary.models;

public class FantasyBook {

    private ServiceWhatever myServiceWhatever;

    public String readExtract() {
        return "When Mr. Bilbo Baggins of Bag End announced that...";
    }

    public void setServiceWhatever(ServiceWhatever theServiceWhatever) {
        myServiceWhatever = theServiceWhatever;
    }

    public String sayWhatever() {
        return myServiceWhatever.speak();
    }

}
Java
2) Créer une classe ServiceWhatever :

package com.wildcodeschool.myLibrary.models;

public class ServiceWhatever {

    public String speak() {
        return "Whatever !";
    }   
}
Java
3) Instancier la classe ServiceWhatever et la passer en argument de la méthode setServiceWhatever() de myBook, puis - enfin - appeler la méthode sayWhatever() (ouf !) :

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.FantasyBook;
import com.wildcodeschool.myLibrary.models.ServiceWhatever;

public class App {

    public void start() {
        FantasyBook myBook = new FantasyBook();
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
        ServiceWhatever myServiceWhatever = new ServiceWhatever();
        myBook.setServiceWhatever(myServiceWhatever);
        System.out.println(myBook.sayWhatever());
    }
}
Java
L'output obtenu dans le Terminal est :

******************
When Mr. Bilbo Baggins of Bag End announced that...
******************
Whatever !
Shell
Grâce à l'injection de dépendances, il n'y aura plus besoin de l'avant-dernière et de l'antépénultième (autrement dit, l'avant-avant-dernière) lignes de App. Le container s'occupera tout seul de créer l'objet myServiceWhatever et de l'injecter en tant qu'argument dans la méthode setServiceWhatever() de FantasyBook. On pourra alors dire que FantasyBook et ServiceWhatever auront un couplage faible.

Pour apprendre comment réaliser concrètement une injection de dépendances dans Spring, saute sur l'étape suivante !

A quick intro to Dependency Injection: what it is, and when to use it
https://medium.freecodecamp.org/a-quick-intro-to-dependency-injection-what-it-is-and-when-to-use-it-7578c84fa88f
Spring : utiliser un fichier de configuration XML
Inversion de contrôle

Repars de la classe App que tu as précédemment écrite :

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.Book;
import com.wildcodeschool.myLibrary.models.FantasyBook;

public class App {

    public void start() {
        Book myBook = new FantasyBook();
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
Comme nous l'avons dit, il est possible, pour créer l'objet myBook, de remplacer FantasyBook par n'importe quelle classe, du moment qu'elle implémente l'interface Book.

Plutôt que d'indiquer une classe en dur dans ton code, tu peux le faire via un fichier XML externe.

Pour cela, crée un fichier applicationContext.xml dans src/main/resources.

Le fichier est initialement vide. Copie-colle les lignes données ci-dessous.

Il s'agit d'une structure XML type utilisée par les développeurs pour définir des beans (c'est-à-dire des objets créés par un container).

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

</beans>
XML
Ensuite, place-toi entre les balises <beans> pour ajouter un nouveau bean :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- We will define our beans here : -->
    <bean id="theBook" class="com.wildcodeschool.myLibrary.models.FantasyBook">
    </bean>

</beans>
XML
Deux éléments définissent notre bean : son id (ici, theBook, mais cela pourrait être n'importe quoi) et sa classe, qui correspond au nom complet (c'est-à-dire package + nom) de la classe de l'objet qu'on souhaite utiliser (ici, FantasyBook, mais comme nous l'avons déjà dit, cela pourrait être n'importe quelle autre classe implémentant l'interface Book).

Maintenant que ton bean est défini, tu dois modifier ta classe App de façon à exploiter la configuration issue de ton fichier XML :

package com.wildcodeschool.myLibrary.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wildcodeschool.myLibrary.models.Book;

public class App {

    public void start() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        Book myBook = context.getBean("theBook", Book.class);
        context.close();
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
ClassPathXmlApplicationContext permet d'accéder au container abritant les beans générés en suivant les spécifications de ton fichier XML.

De plus, remarque l'absence de new pour la définition de l'objet myBook. C'est l'inversion de contrôle dans toute sa splendeur : là où, avant, ton programme s'occupait de créer un objet, c'est maintenant Spring qui le fait. Ton programme n'a plus qu'à récupérer l'objet, et l'utiliser !

L'output dans la console est :

******************
When Mr. Bilbo Baggins of Bag End announced that...
******************
Shell
Si tu changes le XML en remplaçant la valeur de class comme suit :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- We will define our beans below : -->
    <bean id="theBook" class="com.wildcodeschool.myLibrary.models.ScienceFictionBook">
    </bean>

</beans>
XML
Tu obtiens l'output correspondant au readExtract() de la classe ScienceFictionBook :

******************
His name was Gaal Dornick...
******************
Shell
Et ce sans avoir touché à la moindre ligne de code dans App.java.

Bienvenue dans le monde merveilleux de l'IoC !

Injection de dépendances

En ce qui concerne l'injection de dépendances, deux façons de faire sont possibles dans Spring : via un constructeur ou via un setter. Dans la suite de cette quête, nous allons examiner uniquement la première manière (pour creuser la seconde, tu peux consulter les ressources).

Imagine que tu souhaites que ton application, en plus de te fournir des extraits de livres, te conseille également quelle boisson siroter en accompagnement de ta lecture.

Pour mettre en place cela, tu vas créer une nouvelle classe, CosyDrinkAdvice, comportant une méthode sendDrinkAdvice() qui retourne une recommandation de boisson.

package com.wildcodeschool.myLibrary.models;

public class CosyDrinkAdvice {

    public String sendDrinkAdvice() {
        return "With this book, you should try a mug of nice hot chocolate !";
    }
}
Java
Suppose que tu souhaites que cette recommandation de boisson soit donnée à l'utilisateur lorsqu'il consulte un extrait d'un livre de science-fiction. Autrement dit, ta classe ScienceFictionBook va invoquer la méthode sendDrinkAdvice() d'un objet créé à partir de la classe CosyDrinkAdvice.

Commence par modifier l'interface Book en ajoutant une méthode displayDrinkAdvice() :

package com.wildcodeschool.myLibrary.models;

public interface Book {

    public String readExtract();
    public String displayDrinkAdvice();

}
Java
Tu peux lier CosyDrinkAdvice à ScienceFictionBook en passant le premier en tant qu'argument du constructeur du second :

package com.wildcodeschool.myLibrary.models;

public class ScienceFictionBook implements Book {

    private CosyDrinkAdvice cosyDrinkAdvice;

    // Constructor with the cosyDrinkAdvice object passed as an argument
    public ScienceFictionBook(CosyDrinkAdvice theCosyDrinkAdvice) {
        cosyDrinkAdvice = theCosyDrinkAdvice;
    }

    @Override
    public String displayDrinkAdvice() {
        return this.cosyDrinkAdvice.sendDrinkAdvice();
    }

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }
}
Java
Ton App devrait alors avoir cette tête :

package com.wildcodeschool.myLibrary.controllers;

import com.wildcodeschool.myLibrary.models.Book;
import com.wildcodeschool.myLibrary.models.CosyDrinkAdvice;
import com.wildcodeschool.myLibrary.models.ScienceFictionBook;

public class App {

    public void start() {
        // the cosyDrinkAdvice is created
        CosyDrinkAdvice cosyDrinkAdvice = new CosyDrinkAdvice();

        // the cosyDrinkAdvice object is passed to myBook constructor
        Book myBook = new ScienceFictionBook(cosyDrinkAdvice);
        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");

        // displayDrinkAdvice() will call the sendDrinkAdvice() method of cosyDrinkAdvice 
        System.out.println(myBook.displayDrinkAdvice());
    }
}
Java
En l'état, l'output dans le Terminal serait :

******************
His name was Gaal Dornick...
******************
With this book, you should try a mug of nice hot chocolate !
Shell
Cet exemple illustre à nouveau un cas de couplage fort, mais cette fois entre une classe (ScienceFictionBook) et sa dépendance (CosyDrinkAdvice).

Encore une fois, affaiblissons ce couplage.

Imaginons que tu ne souhaites pas que ton application suggère systématiquement de boire un chocolat chaud en lisant de la science-fiction... Tu vas faire la même manipulation que ce que tu as déjà fait dans l'étape qui traitait de l'inversion de contrôle, c'est-à-dire passer par une interface afin de pouvoir utiliser n'importer quelle classe implémentant celle-ci.

package com.wildcodeschool.myLibrary.models;

public interface DrinkAdviceInterface {

    public abstract String sendDrinkAdvice();   
}
Java
N'oublie pas de modifier la classe CosyDrinkAdvice afin qu'elle implémente l'interface :

package com.wildcodeschool.myLibrary.models;

public class CosyDrinkAdvice implements DrinkAdviceInterface {

    @Override
    public String sendDrinkAdvice() {
        return "With this book, you should try a mug of nice hot chocolate !";
    }
}
Java
Tu peux maintenant réécrire ta classe ScienceFictionBook afin d'augmenter le degré d'abstraction de sa dépendance (ce qui affaiblira le couplage).

package com.wildcodeschool.myLibrary.models;

public class ScienceFictionBook implements Book {

    private DrinkAdviceInterface drinkAdvice;

    public ScienceFictionBook(DrinkAdviceInterface theDrinkAdvice) {
        drinkAdvice = theDrinkAdvice;
    }

    @Override
    public String displayDrinkAdvice() {
        return this.drinkAdvice.sendDrinkAdvice();
    }

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }
}
Java
L'objet theDrinkAdvice peut être instancié à partir de n'importe quelle classe, dès lors que celle-ci implémente l'interface DrinkAdviceInterface.

On va, comme on l'a déjà fait auparavant, utiliser un fichier XML pour décider de la classe à utiliser pour créer l'objet theDrinkAdvice. Pour cela, rends-toi dans applicationContext.xml et ajoute un bean correspondant à cette classe. Admettons qu'ici tu veuilles qu'il s'agisse de CosyDrinkAdvice.

Tu devras également paramétrer le constructeur du bean d'id theBook.

Tout cela donnera au final :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Bean of the dependency -->
    <bean id="myDrinkAdvice" class="com.wildcodeschool.myLibrary.models.CosyDrinkAdvice">
    </bean>

    <!-- Bean of the book -->
    <bean id="theBook" class="com.wildcodeschool.myLibrary.models.ScienceFictionBook">
        <!-- Injection in the constructor : -->
        <constructor-arg ref="myDrinkAdvice"/>
    </bean>

</beans>
XML
Décryptons ensemble !

Le bean suivant permet d'associer la classe CosyDrinkAdvice à l'id myDrinkAdvice.

<bean id="myDrinkAdvice" class="com.wildcodeschool.myLibrary.models.CosyDrinkAdvice">
</bean>
XML
Tu peux aussi voir qu'on configure le constructeur du bean d'id theBook via XML, grâce à la balise <constructor-arg ref="myDrinkAdvice"/>, où ref correspond à l'id de la dépendance.

<bean id="theBook" class="com.wildcodeschool.myLibrary.models.ScienceFictionBook">
    <!-- Injection in the constructor : -->
    <constructor-arg ref="myDrinkAdvice"/>
</bean>
XML
Maintenant que ta configuration XML est faite, ton App peut être réécrit. Le paramétrage externe s'occupe de l'injection de dépendances, qui ne figure plus dans le code :

package com.wildcodeschool.myLibrary.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wildcodeschool.myLibrary.models.Book;

public class App {

    public void start() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        Book myBook = context.getBean("theBook", Book.class);

        context.close();

        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
        System.out.println(myBook.displayDrinkAdvice());
        System.out.println("******************");
    }
}
Java
L'output sera :

******************
His name was Gaal Dornick...
******************
With this book, you should try a mug of nice hot chocolate !
******************
Shell
Admettons qu'au lieu d'un conseil de boisson à siroter dans un contexte cosy (CosyDrinkAdvice), tu souhaites avoir une recommandation de boisson plus aventureuse. Tu vas donc créer une nouvelle classe, AdventurousDrinkAdvice:

package com.wildcodeschool.myLibrary.models;

public class AdventurousDrinkAdvice implements DrinkAdviceInterface {

    @Override
    public String sendDrinkAdvice() {
        return "With this book, drink a glass of Bloody Mary. Hurrah !";
    }

}
Java
Une fois les caractéristiques du bean correspondant à la dépendance modifiées dans le XML...

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Bean of the dependency -->
    <bean id="myDrinkAdvice" class="com.wildcodeschool.myLibrary.models.AdventurousDrinkAdvice">
    </bean>

    <!-- Bean of the book -->
    <bean id="theBook" class="com.wildcodeschool.myLibrary.models.ScienceFictionBook">
        <!-- Injection in the constructor : -->
        <constructor-arg ref="myDrinkAdvice"/>
    </bean>

</beans>
XML
... l'output sera :

******************
His name was Gaal Dornick...
******************
With this book, drink a glass of Bloody Mary. Hurrah !
******************
Shell
Comme tu le vois, la dépendance injectée a changé, sans que tu aies eu besoin de toucher à quoi que ce soit en dehors de ton fichier applicationContext.xml. C'est le container qui s'est chargé de tout.

Dependency injection via constructor and setter
https://examples.javacodegeeks.com/enterprise-java/spring/beans-spring/spring-3-dependency-injection-via-constructor-and-setter/
Spring : utiliser les annotations Java
En Java, les annotations sont des métadonnées (metadata) fournissant des informations sur le code auquel elles sont liées. Une annotation que tu connais probablement déjà est @Override.

Si l'on prend un exemple de la vie réelle, on pourrait dire qu'elles sont l'équivalent d'une étiquette sur un vêtement (celle-ci comprend des métadonnées telles que la taille, les consignes de lavage, le prix, etc.).

Dans cette partie, on va reprendre les exemples que nous avons déjà vus avec la configuration XML (inversion de contrôle et injection de dépendances), mais cette fois en utilisant des annotations.

Inversion de contrôle

Reprenons le cas où tu souhaites créer une application qui te renvoie un extrait de texte d'un genre littéraire donné.

À ce stade, nous te recommandons de commenter le code que tu as écrit jusqu'ici, afin d'en garder une trace.

Pour indiquer à Spring que tu vas utiliser des annotations, tu dois préciser le contexte dans applicationContext.xml :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.wildcodeschool.myLibrary.models">
    </context:component-scan>

</beans>
XML
Indiquer base-package="com.wildcodeschool.myLibrary.models revient à dire à Spring qu'il doit scanner toutes les classes appartenant au package com.wildcodeschool.myLibrary.models, à la recherche de classes spécialement annotées par @Component.

En effet, l'équivalent de la configuration XML utilisée pour le bean d'id theBook tout à l'heure (<bean id="theBook" class="com.wildcodeschool.myLibrary.models.ScienceFictionBook">) sera incarné ici par l'annotation @Component("theBook").

Par exemple, pour la classe ScienceFictionBook :

package com.wildcodeschool.myLibrary.models;

import org.springframework.stereotype.Component;

@Component("theBook")
public class ScienceFictionBook implements Book {

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }

    @Override
    public String displayDrinkAdvice() {
        // TODO Auto-generated method stub
        return null;
    }
}
Java
Ton App ne varie pas par rapport aux exemples que tu as déjà réalisés précédemment :

package com.wildcodeschool.myLibrary.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wildcodeschool.myLibrary.models.Book;

public class App {

    public void start() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        Book myBook = context.getBean("theBook", Book.class);

        context.close();

        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
L'output est :

******************
His name was Gaal Dornick...
******************
Shell
Si tu ajoutes une annotation à la classe FantasyBook...

package com.wildcodeschool.myLibrary.models;

import org.springframework.stereotype.Component;

@Component("fantasyBookId")
public class FantasyBook implements Book {

    @Override
    public String readExtract(){
        return "When Mr. Bilbo Baggins of Bag End announced that...";
    }

    @Override
    public String displayDrinkAdvice() {
        // TODO Auto-generated method stub
        return null;
    }
}
Java
... et que tu modifies l'id passé dans context.getBean, comme suit...

package com.wildcodeschool.myLibrary.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wildcodeschool.myLibrary.models.Book;

public class App {

    public void start() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        Book myBook = context.getBean("fantasyBookId", Book.class);

        context.close();

        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
    }
}
Java
... tu auras comme output :

******************
When Mr. Bilbo Baggins of Bag End announced that...
******************
Shell
Le choix de la classe dont l'objet est récupéré par App à partir du container se fait uniquement via les annotations et l'utilisation de tel ou tel id.

Note qu'il est aussi possible de ne pas spécifier d'id dans @Component(). Dans ce cas, l'id est créé automatiquement : il correspond au nom de la classe, mais avec une minuscule pour première lettre (par exemple, FantasyBook donnera l'id fantasyBook).

Injection de dépendances

Pour l'injection de dépendances, on va tirer profit de la fonctionnalité d'autowiring qu'offre Spring.

Reprenons le cas où tu veux que ton application te fournisse un extrait d'un genre littéraire précis et une recommandation de boisson en accompagnement de ta lecture. En l'occurrence, nous allons employer la classe ScienceFictionBook avec la classe CosyDrinkAdvice.

Tu vas repartir de ton fichier applicationContext.xml tel qu'il a été défini précédemment :

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.wildcodeschool.myLibrary.models">
    </context:component-scan>

</beans>
XML
Pour lier une fonctionnalité affichant un conseil de boisson, tu vas (en suivant la même méthode que dans l'étape concernant la gestion des injections de dépendances via XML) commencer par ajouter un attribut drinkAdvice à ta classe ScienceFictionBook, ainsi qu'un constructeur :

package com.wildcodeschool.myLibrary.models;

import org.springframework.stereotype.Component;

@Component("scienceFictionId")
public class ScienceFictionBook implements Book {

    private DrinkAdviceInterface drinkAdvice;

    public ScienceFictionBook(DrinkAdviceInterface theDrinkAdvice) {
        drinkAdvice = theDrinkAdvice;
    }

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }

    @Override
    public String displayDrinkAdvice() {
        return this.drinkAdvice.sendDrinkAdvice();
    }
}
Java
Afin de signaler à Spring qu'il doit automatiquement aller chercher une classe implémentant l'interface DrinkAdviceInterface, il faut utiliser l'annotation @Autowired. Celle-ci signale à Spring qu'il doit, pour un argument du constructeur donné, aller chercher un Component qui implémente l'interface DrinkAdviceInterface, créer un objet à partir de la classe trouvée et l'injecter dans le constructeur.

package com.wildcodeschool.myLibrary.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("scienceFictionId")
public class ScienceFictionBook implements Book {

    private DrinkAdviceInterface drinkAdvice;

    @Autowired
    public ScienceFictionBook(DrinkAdviceInterface theDrinkAdvice) {
        drinkAdvice = theDrinkAdvice;
    }

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }

    @Override
    public String displayDrinkAdvice() {
        return this.drinkAdvice.sendDrinkAdvice();
    }
}
Java
N'oublie pas d'inclure la classe CosyDrinkAdvice dans les components à scanner, via l'annotation @Component :

package com.wildcodeschool.myLibrary.models;

import org.springframework.stereotype.Component;

@Component
public class CosyDrinkAdvice implements DrinkAdviceInterface {

    @Override
    public String sendDrinkAdvice() {
        return "With this book, you should try a mug of nice hot chocolate !";
    }
}
Java
Enfin, il te faut modifier l'App afin d'invoquer la méthode displayDrinkAdvice() :

package com.wildcodeschool.myLibrary.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wildcodeschool.myLibrary.models.Book;

public class App {

    public void start() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        Book myBook = context.getBean("scienceFictionId", Book.class);

        context.close();

        System.out.println("");
        System.out.println("******************");
        System.out.println(myBook.readExtract());
        System.out.println("******************");
        System.out.println(myBook.displayDrinkAdvice());
    }
}
Java
L'output obtenu est :

******************
His name was Gaal Dornick...
******************
With this book, you should try a mug of nice hot chocolate !
Shell
Si tu supprimes l'annotation @Component sur la classe CosyDrinkAdvice et que tu la places sur AdventurousDrinkAdvice, l'output devient :

******************
His name was Gaal Dornick...
******************
With this book, drink a glass of Bloody Mary. Hurrah !
Shell
NB : Si tu laisses l'annotation @Component sur les deux classes implémentant l'interface DrinkAdviceInterface (AdventurousDrinkAdvice et CosyDrinkAdvice), Spring ne saura pas laquelle choisir dans le cadre de sa fonctionnalité d'@Autowired et tu écoperas de la magnifique erreur suivante dans le compilateur :

Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.wildcodeschool.myLibrary.models.DrinkAdviceInterface' available: expected single matching bean but found 2: adventurousDrinkAdvice,cosyDrinkAdvice.

Comment gérer cette situation sans enlever @Component à la main sur la classe que tu ne souhaites pas utiliser ? La réponse est toute simple : il faut utiliser une autre annotation, @Qualifier !

Celle-ci se place après l'annotation @Autowired. Afin que Spring sache quelle classe tu veux utiliser pour l'injection de dépendances, tu dois passer l'id de la classe voulue en paramètre du @Qualifier (rappel : l'id est égal au nom de la classe, mais commence par une minuscule).

package com.wildcodeschool.myLibrary.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wildcodeschool.myLibrary.models.DrinkAdviceInterface;

@Component("scienceFictionId")
public class ScienceFictionBook implements Book {

    private DrinkAdviceInterface drinkAdvice;

    @Autowired
    public ScienceFictionBook(@Qualifier("adventurousDrinkAdvice") DrinkAdviceInterface theDrinkAdvice) {
        drinkAdvice = theDrinkAdvice;
    }

    @Override
    public String readExtract(){
        return "His name was Gaal Dornick...";
    }

    @Override
    public String displayDrinkAdvice() {
        return this.drinkAdvice.sendDrinkAdvice();
    }
}
Java
Tu peux maintenant laisser @Component sur toutes tes classes implémentant l'interface : pour ScienceFictionBook, la dépendance injectée sera toujours formée à partir de la classe AdventurousDrinkAdvice.

Cette dernière prouesse achève le chapitre inaugural de tes aventures au pays de l'inversion de contrôle et de l'injection de dépendances.

Bravo à toi !


Doc officielle de Spring
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation-qualifiers
Challenge ️🕹️
Pour valider cette quête tu devras résoudre le challenge: C'est pas sorcier. Le principe du challenge est détaillé dans l’onglet Challenge.

voir le challenge
MeasureMeasure
