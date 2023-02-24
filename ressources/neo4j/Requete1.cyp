// Requete 1.1 - Params : $username = nom de l'utilisateur, $num_follows = Nombre de cercle de follower sur lesquels faire la recherche
MATCH (u:User {name: $username})-[:Follows*1..$num_follows]->()-[p:Purchased]->(product:Product)
RETURN product.name AS product, sum(p.quantity) AS total_quantity, COUNT(*) AS num_purchases
    ORDER BY total_quantity DESC;

// Requete 1.2
MATCH (u:User{name:$username})-[:Follows*1..$num_follows]->()-[p:Purchased]->(product:Product)
RETURN COUNT(DISTINCT product) AS num_products, COUNT(p) AS num_purchases, SUM(p.quantity) AS total_quantity;

