<template>
  <div v-if="databases">
    <select>
      <option v-for="db of databases">{{ db }}</option>
    </select>
    <button @click="select()">Select</button>
    <img src=""></img>
  </div>
</template>

<script lang="ts" src="./injection-database-selector.component.ts"></script>

<style scoped>
img {
  height : 35px;
  width : 35px;
  visibility: hidden;
}
</style>
