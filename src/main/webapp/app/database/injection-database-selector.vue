<template>
  <div v-if="databases">
    <select>
      <option v-for="db of databases">{{ db }}</option>
    </select>
    <button @click="select()">Select</button>
  </div>
</template>

<script lang="ts" src="./injection-database-selector.component.ts"></script>
