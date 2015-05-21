#!/bin/bash

# l'argument de ce script est le nom du projet sous la forme: "nomProjet"

echo "Debut du script"
echo

if [ -z "$1" ];
then
	echo
	echo "ERREUR: Vous devez specifier un argument pour indiquer le nom du nouveau projet."
else
	nom="$1"
	nomFichier="$(tr '[:lower:]' '[:upper:]' <<< ${nom:0:1})${nom:1}" # nom du fichier avec premiere lettre majuscule
	
	if [ -d "opusProjectModel" ]; 
	then
		#change le nom "opusProjectModel" par le nom du projet
		mv opusProjectModel "$nom" 	#dossier parent du projet
		
		cd "$nom"
		rm -rf .git
		rm -rf clone-opus-model.sh
		sed -i -e "s/opusProjectModel/$nom/g" pom.xml
		
		cd src/test/java/ca/uSherbrooke/gegi
		mv opusProjectModel "$nom" 	#dossier parent des tests du projet
		
		cd "$nom"/test/client
		sed -i -e "s/opusProjectModel/$nom/g" SandboxGwtTest.java
		sed -i -e "s/opusProjectModel/$nom/g" SandboxJukitoTest.java
		
		cd ../utils
		sed -i -e "s/opusProjectModel/$nom/g" OpusProjectModelTests.java
		sed -i -e "s/opusProjectModel/$nom/g" DataSetsForOpusProjectModelTests.java
		sed -i -e "s/OpusProjectModel/$nomFichier/g" OpusProjectModelTests.java
		sed -i -e "s/OpusProjectModel/$nomFichier/g" DataSetsForOpusProjectModelTests.java
		mv OpusProjectModelTests.java $nomFichier"Tests.java"
		mv DataSetsForOpusProjectModelTests.java "DataSetsFor"$nomFichier"Tests.java"
		
		cd ../../../../../../../../main/webapp
		sed -i -e "s/opusProjectModel/$nom/g" WEB-INF/web.xml
		sed -i -e "s/opusProjectModel/$nom/g" opusProjectModel.jsp
		mv opusProjectModel.jsp "$nom.jsp"
		mkdir "$nom"
		
		cd ../java/META-INF
		sed -i -e "s/opusProjectModel/$nom/g" persistence.xml

		cd ../ca/uSherbrooke/gegi
		mv opusProjectModel "$nom"
		
		cd $nom
		sed -i -e "s/opusProjectModel/$nom/g" opusProjectModel.gwt.xml
		mv opusProjectModel.gwt.xml "$nom.gwt.xml"
		
		mkdir -p shared/dispatch
		
		cd client/gin
		sed -i -e "s/opusProjectModel/$nom/g" ClientModule.java
		
		cd ../place
		sed -i -e "s/opusProjectModel/$nom/g" NameTokens.java
		rm -rf NameTokens.java-e

		cd ../application
		sed -i -e "s/opusProjectModel/$nom/g" ApplicationModule.java
		sed -i -e "s/opusProjectModel/$nom/g" ApplicationPresenter.java
		sed -i -e "s/opusProjectModel/$nom/g" ApplicationView.java
		sed -i -e "s/opusProjectModel/$nom/g" ApplicationView.ui.xml
		
		cd home
		sed -i -e "s/opusProjectModel/$nom/g" HomeModule.java
		sed -i -e "s/opusProjectModel/$nom/g" HomePagePresenter.java
		sed -i -e "s/opusProjectModel/$nom/g" HomePageView.java
		sed -i -e "s/opusProjectModel/$nom/g" HomePageView.ui.xml	
		
		cd ../../../server
		mkdir dispatch
		
		cd guice
		sed -i -e "s/opusProjectModel/$nom/g" ServerModule.java
		sed -i -e "s/opusProjectModel/$nom/g" GuiceServletConfig.java
		sed -i -e "s/opusProjectModel/$nom/g" DispatchServletModule.java
		
		cd ../../../../../../../../../
        find . -name '*-e' -exec rm {} \;
	else
		echo
		echo "ERREUR : un probleme est survenu lors du clonage d'opusProjectModel."
	fi
fi

echo
echo "fin du script"
