// Requete 2 - Params : $username = nom de l'utilisateur,
//                      $num_follows = Nombre de cercle de follower sur lesquels faire la recherche
//                      $product_name = Nom du produit
MATCH (u:User{name:$username})-[:Follows*1..$num_follows]->()-[p:Purchased]->(product:Product{name:$product_name})
RETURN sum(p.quantity) AS total_quantity, count(*) AS num_purchases;
