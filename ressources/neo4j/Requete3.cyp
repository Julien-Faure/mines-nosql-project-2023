// Requete 3 - Params : $product_name = nom du produit,
//                      $num_follows = Nombre de cercle de follower sur lesquels faire la recherche
// La requete doit être executees plusieurs fois (1 fois pour chaque niveau)
MATCH (product:Product {name: $product_name})
WITH product
MATCH path=(user:User)-[:Follows*..$num_follows]->()-[:Purchased]->(product)
WITH product, count(DISTINCT user) as num_users
RETURN product.name as product, num_users
