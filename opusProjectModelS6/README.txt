OpusProjectModel
11/05/2015

Auteur : Pascale Maillé
Adresse courriel : pascale.maille@usherbrooke.ca


INFORMATIONS GÉNÉRALES
---------------------------
Ce projet permet, grâce au script clone-opus-model.sh, de créer un projet Opus fonctionnel du nom de votre choix comprenant des dépendances minimales afin d'exécuter une application GWTP communicant avec une base de données Opus.


TUTORIEL
---------------------------
Voici un bref tutoriel afin de vous aider à comprendre les éléments essentiels d'un projet GWT-GWTP-JPA-Opus.
N.B. : Avant d'entreprendre ce tutoriel, une base de données Opus locale idéalement appelée opus, si vous ne désirez pas modifier le fichier persistence.xml du projet Java, doit être initialisée et populée grâce aux scripts fournis.

Partie 1

0. Réaliser le tutoriel d'initialisation de la base de données Opus.

1. Téléchargez le fichier clone-opus-model.sh .

2. Ouvrez une invite de commande Unix où git est installé. 
Le script clone-opsu-model.sh doit être dans le même dossier que celui contenant les sources du projet (opusProjectModel). Veuillez donc simplement extraire le contenu du fichier zip tel quel.
Exécutez la commande "cd <chemin où se trouve votre fichier clone-opus-model.sh>". 
Exécutez la commande "./clone-opus-model.sh <nom souhaité pour votre projet>".

3. Ouvrez Eclipse.
Importez, en tant que projet Maven existant, le projet que vous venez de créer grâce au script de clonage.

4. Effectuez un clic droit sur le nom de votre nouveau projet dans le Package Explorer. 
Dans le menu contextuel, cliquez sur Properties. 
Dans la fenêtre de propriétés de votre projet, cliquez sur le triangle situé à gauche de Google. 
Cliquez sur Web Toolkit sous Google.
Cochez l'option Use Google Web Toolkit.
Cliquez sur Web Application.
Cochez les deux options suivantes : This project has a WAR directory et Launch and deploy from this directory (disabled because this is a Maven project).

5. Effectuez un clic droit sur le nom de votre nouveau projet dans le Package Explorer.
Dans le menu contextuel, déplacez votre curseur au-dessus de Run As.
N.B. : Le mode de développement classique est supporté uniquement par Firefox 24 ou moins tandis que le superDevMode est supporté par la majorité des navigateurs web.
Si vous désirez lancer le mode de développement classique : Dans le sous-menu, cliquez sur Web Application (GWT Classic Dev Mode).
Si vous désirez lancer le Super Dev Mode : Dans le sous-menu, cliquez sur Web Application (GWT Super Dev Mode).

6. Rien ne se produit, c'est normal. Affichez la console d'Eclipse. Celle-ci présente le problème : Missing required argument 'module[s]'. La solution à celui-ci est de modifier les configurations d'exécution de votre projet.
Cliquez sur le triangle situé à droite du bouton Run dans la barre d'outils.
Dans le menu déroulant, cliquez sur Run Configurations.
Dans la fenêtre de configuration des exécutions, cliquez sur le nom de votre projet dans la catégorie Web Application de la section de gauche.
Cliquez sur l'onglet GWT.
Remarquez que la liste des modules disponibles (Available Modules) est vide. C'est la raison pour laquelle le projet ne peut être exécuté. Le point d'entrée du projet est inconnu de GWT.
La première ligne affichée à la console tantôt mentionnait un nom de module manquant.
Cliquez sur le bouton Add.
Dans la fenêtre de sélection d'un module GWT, cliquez sur l'option qui porte le nom de votre projet.
Cliquez sur le bouton Ok.
Cliquez sur Run.
Votre projet est maintenant compilé et déployé localement sur un serveur Jetty.

7. Cliquez sur l'onglet Development Mode situé près de celui de la console Eclipse.
Copiez l'adresse URL affichée et accédez-y via le navigateur web de votre choix, mais respectant les contraintes mentionnées plus haut.
Le projet est recompilé et Hello World s'affiche dans le navigateur.
Fermez l'application grâce au bouton Terminate, dont l'icône est un carré rouge, dans l'onglet Development Mode.

Partie 2

8. Ouvrez le fichier client HomePagePresenter.java . Une partie du code a été volontairement commentée.
Elle concerne le Gatekeeper. Celui-ci permet de restreindre l'accès d'un usager à un Presenter ou même une méthode. Dans les deux cas, le code diffère. Voir la page web suivante pour plus d'informations : http://dev.arcbees.com/gwtp/features/Presenter-Gatekeeper.html . Vous pouvez créer autant de Gatekeeper que vous le désirez.
Le cas présenté dans HomePagePresenter est celui qui restreint l'accès à tout le Presenter. Ainsi, un usager qui ne remplit pas les conditions mentionnées dans la fonction canReveal() du AuthenticationGatekeeper ne peut pas accéder au HomePagePresenter et entraîne la page de non autorisation à s'afficher. 
Affichez le code du fichier AuthenticationGatekeeper.java . Les conditions choisies pour la fonction canReveal() de cette classe sont les suivantes : la session de l'usager doit être active sur le serveur ET si un ou des identifiants uniques de privilèges sont envoyés au Gatekeeper, l'usager authentifié doit être membre d'un groupe Opus relié à l'application exécutée et au(x) privilège(s) mentionné(s). Voyons voir ce que cela signifie. Poursuivez votre lecture, le tout deviendra plus clair. (N.B. : Vous n'avez pas du tout besoin de connaître le fonctionnement des classes utilisées par ce Gatekeeper.)
Vous trouverez l'identifiant unique de votre application dans le fichier web.xml du dossier webapp > WEB-INF. Dans ce fichier, à l'intérieur du tag param-value associé au paramètre (context-param) dont le nom est applicationId, vous devez inscrire le même identifiant unique que celui de l'entrée correspondant à votre application dans la table application de la base de données Opus. Si une telle entrée n'existe pas, vous devez en créer une. Vous pouvez laisser le champ URL vide pour le moment.
Aussi, vous devez être membre d'un groupe associé, via la table application_privilege_group, à l'identifiant unique de votre application ainsi qu'à l'identifiant unique du privilège souhaité (celui qui est passé en paramètre au Gatekeeper).
Vous êtes maintenant prêt à décommenter le Gatekeeper du fichier HomePagePresenter, à sauvegarder les modifications de ce fichier et à exécuter l'application.
Voilà ! HelloWorld s'affiche dans le navigateur. Vous savez désormais comment utiliser un Gatekeeper avec GWTP.

9. Modifiez la valeur de la variable ACCES_PRIVILEGE_ID de la classe HomePagePresenter pour une autre valeur qui n'existe pas dans la table privilege de la base de données.
Rafraîchissez la page du navigateur où est affichée votre application.
La page de non autorisation s'affiche maintenant, c'est signe que le Gatekeeper fonctionne puisque vous ne possédez pas le privilège requis pour accéder à la page.

Aucune manipulation n'est requise pour les étapes suivantes.

10. Dans le fichier <nom de votre projet>.gwt.xml, situé dans le paquet ca.uSherbrooke.gegi.<nom de votre projet>, il est possible d'ajouter certaines configurations et dépendances envers des modules.
Afin de pouvoir utiliser les classes contenues dans le projet opusCommonsCore, il est essentiel que le fichier gwt.xml de votre projet inclut la ligne suivante : <inherits name='ca.uSherbrooke.gegi.commons.core.opusCommonsCore'/>. Elle s'y trouve déjà, vous n'avez pas besoin de l'y ajouter. Cette ligne indique à GWT que le fichier opusCommonsCore.gwt.xml situé dans le nom de paquet (attribut name) spécifié est le point d'entrée d'un projet GWT utilisé par le vôtre.
Un autre outil intéressant fourni par GWTP est le Bootstrapper, à ne pas confondre avec GWTBootstrap3 qui est un module permettant à votre application d'utiliser les widgets (objets de l'interface graphique utilisateur) de Bootstrap3 développé par Twitter. Il permet d'accomplir certaines instructions avant même que l'application soit lancée, ce qui est parfait pour initialiser certains éléments. Pour de plus amples informations à propos du Bootstrapper, suivez ce lien : http://dev.arcbees.com/gwtp/basicfeatures/Bootstrapping-or-Application-Initialization.html .
Dans la cas du BootstrapperImpl d'opusCommonsCore, il récupère le CIP de l'usager authentifié via le CAS (central authentication service) de l'UdeS et vérifie qu'il correspond bien à un usager Opus, il collecte ses privilèges en fonction de l'application exécutée, les stocke dans un singleton, récolte tous les paramètres de celle-ci et les stocke dans un autre singleton.
Afin que votre application utilise ce bootstrapper, la ligne de code suivante doit se trouver dans le fichier <nom de votre projet>.gwt.xml : <set-configuration-property name="gwtp.bootstrapper" value="ca.uSherbrooke.gegi.commons.core.client.gatekeeper.BootstrapperImpl"/> . Elle s'y trouve déjà, vous n'avez pas besoin de l'y ajouter.

11. Afin de bien utiliser les ActionHandler, il est fortement suggéré de naviguer parmi les tests du projet opusCommonsCore. 
Les noms des fonctions de tests sont assez explicites pour vous permettre de vous y retrouver sans trop de peine.
Le contenu des tests vous indique quels paramètres fournir à une requête. 
Il vous suffit ensuite de trouver dans quelle ActionHandler la requête de votre choix est utilisée et de vérifier quels sont les paramètres à fournir à l'action pour qu'elle lance la requête de votre choix. 
N.B. : le côté client de l'application, ce qui est affiché dans le navigateur, ne connaît JAMAIS l'identifiant unique de l'usager authentifié. Lorsque vous voyez, dans un test JUnit, que l'identifiant unique de l'usager est envoyé en paramètre à la requête, sachez que les ActionHandler présents dans opusCommonsCore l'envoient automatiquement, ne vous en préoccupez pas.
