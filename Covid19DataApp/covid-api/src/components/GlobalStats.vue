<template>
  <div id=current-stats> 
    <h3> Current Statistics </h3>
    <div v-if="loaded" id=stats>
    <p> Total Confirmed Cases {{globalData.totalConfirmed}} </p>
    <p> New Confirmed Cases {{globalData.newConfirmed}} </p>
    <p> Total Deaths {{globalData.totalDeaths}} </p>
    <p> New Deaths {{globalData.newDeaths}}* </p>
    <p> * Based on the most current daily data available </p>
    </div>
  </div>
</template>

<script>
export default {
data() {
  return {
    globalData: {},
    loaded: false
  }
},
created() {
     this.fetchCurrentData();
  },
  methods: {
    fetchCurrentData(){
    fetch("https://api.covid19api.com/summary")
    .then(response => response.json())
    .then(summaryData => {
      let data = summaryData.Global;
      this.globalData.totalDeaths = data.TotalDeaths;
      this.globalData.newDeaths = data.NewDeaths;
      this.globalData.totalConfirmed = data.TotalConfirmed;
      this.globalData.newConfirmed = data.NewDeaths;
      this.loaded = true;
    })
      .catch(error => console.log('error', error));
    },
    }
  }
</script>

<style scoped>

</style>
