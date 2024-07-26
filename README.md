# Gestion RH

## Description

Gestion RH est une application de gestion des ressources humaines, composée d'un frontend React, d'un backend Java Spring Boot, et d'une base de données MySQL. L'application permet de gérer les employés et les candidats au sein de l'entreprise.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Structure du Projet

- **Frontend** : Application React utilisant Vite.
- **Backend** : API REST développée avec Spring Boot.
- **Base de données** : MySQL.

## Configuration et Lancement

### 1. Préparer les Images Docker

Assurez-vous que vous avez les fichiers Docker nécessaires :

- **Frontend** : `gestionRhFront/Dockerfile`
- **Backend** : `gestionRhBack/Dockerfile`
- **Base de données** : `data/Dockerfile`

### 2. Lancer les Conteneurs

À la racine du projet, où se trouve le fichier `docker-compose.yml`, exécutez la commande suivante pour construire et lancer les conteneurs :

```sh
docker-compose up -d
```


