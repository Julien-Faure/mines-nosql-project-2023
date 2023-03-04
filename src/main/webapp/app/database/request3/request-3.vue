<template>
  <div>
    <h1>Requête 3</h1>
    <p><b>Sujet : </b>
      Pour une référence de produit donné, obtenir le nombre de personnes l’ayant
      commandé dans un cercle de followers « orienté » de niveau n (à effectuer sur
      plusieurs niveaux : 0, 1, 2 …) permet de rechercher les produits « viraux », c’est-à-
      dire ceux qui se vendent le plus au sein de groupes de followers par opposition aux
      achats isolés pour lesquels le groupe social n’a pas d’impact.
    </p>

    <h2>Choose your database</h2>
    <database-selector></database-selector>
    <h2>Paramètres</h2>

    <h2>Résultats</h2>
    <button id="load" @click="loadData">Load</button>

    <div v-if="payload">
      <p>Time : {{ elapsed }} ms</p>
      <table>
        <thead>
        <tr>
          <th>Level</th>
          <th>User count</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="sub of payload">
          <td>{{ sub.level }}</td>
          <td>{{ sub.usersCount }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>


</template>

<script lang="ts" src="./request-3.component.ts"></script>

<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  font-size: 14px;
  font-family: Arial, sans-serif;
  margin-bottom : 50px;
}

th,
td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}

th:first-child,
td:first-child {
  background-color: #007bff;
  color: #fff;
}

p {
  margin: 0
}

</style>
