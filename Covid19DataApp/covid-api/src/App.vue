<template>
  <div id="app">
    <h1> Covid-19 Data </h1>
    <global-stats/>
    <DeathRateChart/>
  </div>
</template>

<script>
import GlobalStats from './components/GlobalStats.vue'
import DeathRateChart from './components/DeathRateChart.vue'
export default {
  name: 'App',
  components: {
    GlobalStats,
    DeathRateChart
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
