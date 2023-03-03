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
    <button id="load" @click="loadData">Load</button>

    <div v-if="result11">
      <p>Time : {{ elapsed }} ms</p>
      <table>
        <thead>
        <tr>
          <th>Total product</th>
          <th>Total quantity</th>
          <th>Purchase count</th>
        </tr>
        </thead>
        <tbody>
        <td>{{ result12.totalProduct }}</td>
        <td>{{ result12.totalQuantity }}</td>
        <td>{{ result12.numPurchases }}</td>
        </tbody>
      </table>
      <table>
        <thead>
        <tr>
          <th>Product name</th>
          <th>Total quantity</th>
          <th>Purchase count</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="sub of result11">
          <td>{{ sub.productName }}</td>
          <td>{{ sub.totalQuantity }}</td>
          <td>{{ sub.numPurchases }}</td>
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
