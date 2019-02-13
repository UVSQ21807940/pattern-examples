# pattern-examples
Quelques exemples d'application des design patterns.

## Annuaire des personnels d'une organisation (_Builder_, _Composite_, _Iterator_)
Un personnel possède un nom, un prénom, une date de naissance, des numéros de téléphone (fixe pro, fixe perso, portable, ...) et des fonctions (par exemple directeur de XXX, chargé de mission XXX, ...).

L’annuaire reflétera la structure hiérarchique de l’organisation (par exemple, département/service/é-
quipe).
Chaque niveau peut comporter des individus ou des sous-hiérarchies.
Les différents niveaux de structuration ne sont pas connus à priori.

On veut pouvoir afficher les personnels de l’organisation de deux manières : hiérarchiques (en profondeur) et par groupe (en largeur).

1. Représentez les personnels par une classe immuable `Personnel`.
Le nom, le prénom et les fonctions seront implémentés par des chaînes de caractères, la date de naissance par `java.time.LocalDate` et les numéros de téléphone par une collection d’un type que vous définirez.
L’initialisation d’un personnel respectera le pattern **Builder**.
1. Définissez la notion de groupe de personnels en vous appuyant sur le pattern **Composite**.
3. Implémentez les deux types d’affichage en définissant deux stratégies de parcours de la structure.
Ces dernières se baseront sur le pattern _Iterator_.
Plus précisément, vous vous appuierez sur les interfaces
[`java.util.Iterator`](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html) et [`java.lang.Iterable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html).

## Construction du projet
### Build
```bash
./gradlew build
```

### Exécution de l'application
```bash
./gradlew run
```

### Création du projet
Ce projet a été initialisé avec les commandes suivantes.
```bash
gradle init --type java-application --dsl kotlin
gradle wrapper --gradle-version 5.2.1
```
