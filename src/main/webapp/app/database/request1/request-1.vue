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

    <h2>Résultats</h2>
    <button @click="loadData()">Load</button>
  </div>


</template>

<script lang="ts" src="./request-1.component.ts"></script>

<style scoped>

</style>
