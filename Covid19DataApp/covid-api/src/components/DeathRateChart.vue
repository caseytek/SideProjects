<template>
<div>
    <h3> Date Rate Percentage of Confirmed Covid-19 Cases </h3>
    <label for="highorlow"> Select countries with the highest or lowest rate </label>
    <select id="highOrLow" v-model="highOrLow">
      <option value="highest"> Highest </option>
      <option value="lowest" selected>Lowest</option>
    </select>
    <button type="button" v-on:click="handleToggle" > Toggle Graph </button>
  <pie-chart v-if="loaded" :chartdata="chartdata" :options="options" />
</div>
</template>

<script>
import PieChart from "./PieChart.vue";
export default {
  name: 'LineChartContainer',
  components: { PieChart },
  data: () => ({
    loaded: false,
    chartdata: null,
    options: null,
    highOrLow: "highest"
  }),
  methods: {
      handleToggle: function () {
        this.mountedFunction();
      },
      getRandomHex: function() {
      return "#" + Math.floor(Math.random() * 16777215).toString(16);
    },
    mountedFunction: function (){
      this.loaded = false
    try {
    fetch("https://api.covid19api.com/summary" , {
      headers : { 
        'Content-Type': 'application/json',
        'Accept': 'application/json'
       }}
    )
     .then(response => response.json())
     .then(summaryData => {
         let filteredData = summaryData.Countries.map((data) => {
             return {
                 Country: data.Country,
                 DeathRate: ((data.TotalDeaths / data.TotalConfirmed)*100).toFixed(2)
             };
         })
         .sort((a, b) =>{ return b.DeathRate - a.DeathRate});

         if(this.highOrLow == "highest"){
           filteredData = filteredData.slice(0,10);
         } else{
           filteredData = filteredData.filter((val) => {
             return val.DeathRate != 0;
           });
           filteredData = filteredData.slice(Math.max(filteredData.length - 10, 0));
         }

         this.chartdata = {
             labels: filteredData.map((data) => 
             data.Country),
             datasets: [
                 {
                     data: filteredData.map(data => (data.DeathRate)),
                     backgroundColor: filteredData.map(this.getRandomHex),
                 }
             ]
         };
         console.log("chart data:" + this.chartdata);
          this.options = {
            responsive: true,
            maintainAspectRatio: false,
            cutoutPercentage: .50
          };
         this.loaded = true;
     })
    } catch (e) {
      console.error(e);
        }
    }
  },
  async mounted () {
      this.mountedFunction();
    } 
  }
</script>
<style scoped>
 div{
     max-width: 60%;
     margin: 20px 25% 20px 25%;
 }
</style>