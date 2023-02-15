<template>
  <div>
    <h1>test</h1>
    <router-view>
      <div v-if="info">
        <p>{{ info.toto }}</p>
      </div>
    </router-view>
  </div>
</template>

<script lang="ts" src="./user.component.ts"></script>
