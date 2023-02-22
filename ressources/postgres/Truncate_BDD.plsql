BEGIN
    -- Supprimer toutes les données de la table "Purchases"
    DELETE FROM Purchases;
    -- Réinitialiser la séquence de la table "Purchases"
    ALTER SEQUENCE Purchases_purchase_id_seq RESTART WITH 1;

    -- Supprimer toutes les données de la table "Products"
    DELETE FROM Products;
    -- Réinitialiser la séquence de la table "Products"
    ALTER SEQUENCE Products_product_id_seq RESTART WITH 1;

    -- Supprimer toutes les données de la table "Followers"
    DELETE FROM Followers;

    -- Supprimer toutes les données de la table "Users"
    DELETE FROM Users;
    -- Réinitialiser la séquence de la table "Users"
    ALTER SEQUENCE Users_user_id_seq RESTART WITH 1;
END;
