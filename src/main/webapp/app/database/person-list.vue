<template>

  <div v-if="persons">
    <button id="load" @click="loadData">Load</button>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>PASSWORD</th>
        <th>FOLLOWERS</th>
        <th>PURCHASES</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="p of persons">
        <td>{{ p.id }}</td>
        <td>{{ p.name }}</td>
        <td>{{ p.email }}</td>
        <td>{{ p.password }}</td>
        <td>
          <p v-for="f of p.followed">{{ f.name }}</p>
        </td>
        <td>
          <p v-for="pur of p.purchasedProducts">{{ pur.name }}</p>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts" src="./person-list.component.ts"></script>

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
