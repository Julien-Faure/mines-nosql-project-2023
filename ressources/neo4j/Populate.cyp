// Créer des utilisateurs
CALL apoc.periodic.iterate(
"UNWIND range(1, 1000000) AS i RETURN i",
"CREATE (:User {
name: 'User' + i,
email: 'user' + i + '@example.com',
password: 'password'
})",
{batchSize:1000, parallel:false}
);

// Créer des produits
CALL apoc.periodic.iterate(
"UNWIND range(1, 10000) AS j RETURN j",
"CREATE (:Product {
name: 'Product' + j,
description: 'This is Pruduct ' + j,
price: toInteger(rand() * 100)
})",
{batchSize:1000, parallel:false}
);

// Créer des relations "suit"
CALL apoc.periodic.iterate(
  "MATCH (u:User) RETURN u",
  "WITH u, toInteger(rand() * 20) AS followCount
   UNWIND range(1, followCount) AS r
   WITH u, toInteger(rand() * 100000) AS randomUser
   MATCH (u2:User) WHERE id(u2) = randomUser AND u <> u2
   WITH u, u2, datetime() - duration({days: toInteger(rand() * 365)}) AS date
   CREATE (u)-[:Follows {date: date}]->(u2)",
  {batchSize:1000, parallel:false}
);

// Créer des relations "achète"
CALL apoc.periodic.iterate(
  "MATCH (u:User) RETURN u",
  "WITH u, toInteger(rand() * 5) AS purchaseCount
   UNWIND range(1, purchaseCount) AS r
   WITH u, rand() AS randomProduct, datetime() - duration({days: toInteger(rand() * 365)}) AS date, toInteger(rand() * 5) + 1 AS quantity
   MATCH (p:Product)
   WHERE id(p) = toInteger(rand() * 10000) + 1000000
   CREATE (u)-[:Purchased {quantity: quantity, date: date}]->(p)",
  {batchSize:1000, parallel:false}
);

