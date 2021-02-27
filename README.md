# Hands-on Backend Series : Quarkus

Suite au succès des Hands-on front, on a décidé de poursuivre avec la partie Back.

Cette suite de hands-on sera sur les frameworks et outils que l’on pratique (ou pas) à Grenika (Zenika Grenoble) après la première session autour de Spring, on enchaîne sur Quarkus !

En repartant de l'application Météo développée pour le Hands-on front on fera une implémentation de l’API REST avec:

* Persistence
* Utilisation d’un client REST pour accéder aux données météo
* Ajout de la sécurité
* Mise en place de tests unitaires et d’intégrations
* Et bien d’autres choses encore

# Prerequisite

- maven ou gradle
- JDK 11 ou +

## Install

### avec Maven

```
./mvnw install
```

### avec Gradle

```
./gradlew assemble
```

## Usage

### avec Maven

```
./mvnw quarkus:dev
```

### avec Gradle

```shell script
./gradlew quarkusDev
```

### You can run your application in dev mode that enables live coding using:

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.




## Technologies

### Langage

- Kotlin ([guide](https://quarkus.io/guides/kotlin))

### Frameworks

- Quarkus ([guide](https://quarkus.io/))
- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more
- Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache))

## Découpage des steps

* Step 0 : Init projet (dépendances, ...)
* Step 1 : Création du controller REST des villes et test avec une implémentation en dur
* Step 2 : Ajout du repository JPA pour les villes
* Step 3 : Création du controller REST de la météo et test avec une implémentation en dur
* Step 4 : Ajout d'un service de météo pour récupérer les coordonnées d'une ville avec météo en dur
* Step 5 : Création d'un repository HTTP pour la météo

### Bonus

* Step 6 : Ajout d'un cache pour la météo
* Step 7 : Création d'un endpoint REST pour ajouter une ville
* Step 8 : Sécuriser l'application

## Other Hands-on

### Backend

* [Spring](https://github.com/Zenika/grenoble-hands-on-spring)

### Front

* [VueJS](https://github.com/Zenika/grenoble-hands-on-vuejs)
* [Angular](https://github.com/Zenika/grenoble-hands-on-angular)
* [React](https://github.com/Zenika/grenoble-hands-on-react)

## Contributing

<a href="https://github.com/glefloch">
  <img src="https://github.com/glefloch.png?size=50">
</a>
<a href="https://github.com/chocho01">
  <img src="https://github.com/chocho01.png?size=50">
</a>
<a href="https://github.com/flyingtof">
  <img src="https://github.com/flyingtof.png?size=50">
</a>
