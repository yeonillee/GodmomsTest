<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <h1>{{title}}</h1>
    <router-view/>
  </div>
</template>

<script>
import Vue from 'vue'

export default {
  name: 'App',
  data() {
    return {
      title: 'Godmoms'
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
