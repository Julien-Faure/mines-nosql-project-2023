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
      </tr>
      </thead>
      <tbody>
      <tr v-for="p of persons">
        <td>{{ p.id }}</td>
        <td>{{ p.name }}</td>
        <td>{{ p.email }}</td>
        <td>{{ p.password }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script lang="ts" src="./person-list.component.ts"></script>

<style scoped>

</style>
