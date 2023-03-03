<template>
  <div>
    <h1>Requête 2</h1>
    <p><b>Sujet : </b>
      Même requête mais avec spécification d’un produit particulier  cette requête
      permet d’observer le rôle d’influenceur d’un individu suite à un « post » mentionnant
      un article spécifique
    </p>

    <h2>Choose your database</h2>
    <database-selector></database-selector>
    <h2>Paramètres</h2>
    <label>
      Nom personne :
      <input id="userName" type="text">
    </label>

    <label>
      Nom produit :
      <input id="productName" type="text">
    </label>

    <label>
      Profondeur :
      <input id="depth" type="number">
    </label>

    <h2>Résultats</h2>
    <button id="load" @click="loadData">Load</button>

    <div v-if="payload">
      <p>Time : {{ elapsed }} ms</p>
      <table>
        <thead>
        <tr>
          <th>Total quantity</th>
          <th>Purchase count</th>
        </tr>
        </thead>
        <tbody>
          <td>{{ payload.totalQuantity }}</td>
          <td>{{ payload.purchasesCount }}</td>
        </tbody>
      </table>
    </div>
  </div>


</template>

<script lang="ts" src="./request-2.component.ts"></script>

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
