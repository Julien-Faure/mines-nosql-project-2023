
# Rapport projet NoSQL

> Paul ACHARD, Julien FAURE

### Lancer le code 

#### Installation

```
npm install
```

#### Lancement

```
./gradlew -x webapp
npm start
```

#### Dockers

* `src/main/docker/neo4j.yml`
* `src/main/docker/posgresql.yml`

### Points d'accès

* FRONT : http://localhost:9000
* BACK : http://localhost:8080

___

### Création et génération des données

| Base de données | Temps |
|-----------------|-------|
| Neo4j           | 5 min et 12 sec |
| PostgreSQL      | 5h              |

On peut observer une grosse différence notable entre le temps de génération de données pour Neo4j et PostgreSQL.

Script de génération :
- ressources/neo4j/Populate.cyp
- ressources/postgresql/BDD.plsql (création)
- ressources/postgresql/Generate_data.plsql

### Exécution des requêtes

Procédure de test : 100k Users et 10k Produits

Chaque requête est lancée 12 fois au total : 3 fois pour PostgresSQL et 3 fois pour Neo4J à chaque batterie de test.
Les requêtes sont testées une fois avec une faible profondeur (2), une fois avec une profondeur moyenne (4) et une fois avec une grande profondeur (6).
À chaque nouveau test, on modifie aléatoirement les paramètres comme les produits ou les utilisateurs sélectionnés.

Les durées d'exécution sont données en millisecondes.

#### Affichage des personnes avec les followers et les purchases

##### Requête 1

| Profondeur | Neo4j | PostgreSQL |
|------------|-------|------------|
| 2          | 160   | 590        |
| 4          | 846   | 1324       |
| 6          | 1342  | 31439      |
| Moyenne    | 115,67| 514        |

##### Requête 2

| Profondeur | Neo4j | PostgreSQL |
|------------|-------|------------|
| 4          | 79,33 | 119,33     |
| 6          | 338   | 7015,67    |

La profondeur 2 est peu significative et donc ignorée.

##### Requête 3

Non renseignée

### Conclusion

En termes de vitesse d'insertion, nous remarquons que Neo4j peut être plus lent que PostgreSQL pour les données simples et non connectées. En effet, Neo4j est optimisé pour les données hautement connectées, ce qui peut ralentir l'insertion de données tabulaires simples. Alors que l'insertion des Users et des Products est plus rapide sur PostgreSQL, l'insertion des relations est beaucoup plus rapide sur Neo4j.

En termes de vitesse de sélection, Neo4j est constamment plus rapide que PostgreSQL pour les données hautement connectées (ce qui était le cas pour nos requêtes). En effet, Neo4j étant optimisé pour les requêtes basées sur les graphes, qui semblent beaucoup plus efficaces pour ces types de relations de données. Cependant, PostgreSQL est plus rapide pour les requêtes SQL d'affichage de table (telles que la liste des Utilisateurs ou des Produits).

En résumé, Neo4j peut être plus lent pour l'insertion de données traditionnelles, mais peut être plus rapide pour les données hautement connectées. PostgreSQL, quant à lui, est plus rapide pour les données traditionnelles et les requêtes SQL simples.
