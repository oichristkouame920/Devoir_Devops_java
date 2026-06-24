##Generateur de mot passe

## Description

Ce projet est une application Java 21 en ligne de commande (CLI) permettant de générer des mots de passe robustes selon différents paramètres définis par l'utilisateur.

L'application permet également d'évaluer la robustesse des mots de passe générés en s'appuyant sur un service de validation exécuté dans un conteneur Docker.

## Fonctionnalités

* Génération de mots de passe personnalisés
* Choix de la longueur
* Inclusion des majuscules
* Inclusion des minuscules
* Inclusion des chiffres
* Inclusion des caractères spéciaux
* Génération multiple (mode rafale)
* Évaluation de la robustesse du mot de passe
* Architecture Java + Docker

---

## Technologies utilisées

* Java 21
* Maven
* Docker
* Git

---

## Structure du projet

```text
password-generator
│
├── docker
│   ├── Dockerfile
│   └── validator.js
│
├── src
│   └── main
│       └── java
│           └── ci
│               └── univ
│                   ├── Main.java
│                   ├── PasswordGenerator.java
│                   ├── PasswordValidator.java
│                   ├── PasswordStrength.java
│                   └── ValidationResult.java
│
└── pom.xml
```

---

## Compilation

```bash
mvn clean compile
```

## Exécution

```bash
mvn exec:java
```

Ou :

```bash
java -cp target/classes ci.univ.Main
```

---

## Docker

### Construction de l'image

```bash
docker build -t password-validator .
```

### Démarrage du conteneur

```bash
docker run -d --name password-validator password-validator
```

### Test du validateur

```bash
docker exec password-validator node /app/validator.js Test123!
```

---

## Architecture

```text
Utilisateur
     |
     v
Application Java (CLI)
     |
     v
PasswordValidator
     |
     v
Docker Container
     |
     v
Outil de validation
