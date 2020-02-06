# Skopal_Maginot_TD_3
TD3

Etant donné que Philippe Skopal n'a pas d'ordinateur personnel hormis un chromebook, son seul moyen de compiler du java est de passer par un ide en ligne: "Codeanywhere".Etant
Il faut donc compiler le programme via la ligne de commande, à l'ancienne.

Pour compiler et lancer il faut se rendre dans le dossier "/src".
Et Dans les commandes il faudra remplacer "/home/cabox/workspace/td3/Skopal_Maginot_TD_3" par le path sur sa machine.

Et lancer 3 commandes: 
1. find -name "*.java" > source.txt
2. javac -cp  ":/home/cabox/workspace/td3/Skopal_Maginot_TD_3/lib/junit-4.13.jar:/home/cabox/workspace/td3/Skopal_Maginot_TD_3/lib/mockito-all-1.10.19.jar" -d build @source.txt
3. java -cp ".:build:****/*.class:/home/cabox/workspace/td3/Skopal_Maginot_TD_3/lib/mockito-all-1.10.19.jar:/home/cabox/workspace/td3/Skopal_Maginot_TD_3/lib/junit-4.13.jar" main.EntryPoint

1 ==> Trouve et met dans un fichier texte toutes les sources pour faciliter la compilation
2 ==> Compile les source
3 ==> Lance les sources

Les test unitaires sont fictifs, ils devaient être implémenté.

Normalement l'ouput est :
-------> I. Test unitaires CRUD :
Test unitaire de la méthode: getList, de la classe: XmlCientDao: Réussi
Test unitaire de la méthode: getById, de la classe: XmlCientDao: Echoué
Test unitaire de la méthode: create, de la classe: XmlCientDao: Réussi
Test unitaire de la méthode: update, de la classe: XmlCientDao: Réussi
Test unitaire de la méthode: delete, de la classe: XmlCientDao: Réussi

-------> II. Travail demandé :
Id: 5 Nom: Noel Prénom: Père
Id: 5 Nom: Noel Prénom: Père
