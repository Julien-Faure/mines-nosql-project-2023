<template>
  <div>
    <h1>Requête 1</h1>
    <p><b>Sujet : </b>
      Obtenir la liste et le nombre des produits commandés par les cercles de followers
      d’un individu (niveau 1, …, niveau n) cette requête permet d’observer le rôle
      d’influenceur d’un individu au sein du réseau social pour le déclenchement d’achats.
    </p>

    <h2>Choose your database</h2>
    <database-selector></database-selector>
    <h2>Paramètres</h2>
    <label>
      Nom personne :
      <input id="name" type="text">
    </label>

    <label>
      Profondeur :
      <input id="depth" type="number">
    </label>

    <h2>Résultats</h2>
    <button @click="loadData()">Load</button>

    <div v-if="results">
    <p>Time : $ {{results.elapsedTime}}</p>
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>EMAIL</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="p of persons">
          <td>{{ p.id }}</td>
          <td>{{ p.name }}</td>
          <td>{{ p.email }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>


</template>

<script lang="ts" src="./request-1.component.ts"></script>

<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  font-size: 14px;
  font-family: Arial, sans-serif;
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
  margin : 0
}

</style>
