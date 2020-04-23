<template>
  <div id="app">
  <Title/>
  <SearchBar v-on:wordSearch="handleSearch"/>
  <SearchResults v-if="showResults" v-bind:wordSearch="wordSearch" v-on:turnOnForm="showResults = true"/>
  </div>
</template>

<script>

import SearchBar from '@/components/SearchBar';
import Title from '@/components/Title';
import SearchResults from '@/components/SearchResults'


export default {
  name: 'App',
  data() {
    return {
      wordSearch: "",
      showResults: false
    }
  },
  methods: {
    handleSearch(word){
      this.showResults = true;
      this.wordSearch = word;
        }
  },
  components: {
    SearchResults,
    SearchBar,
    Title
  }
}
</script>

<style>
body {
  padding: 30px;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-image: url('~@/assets/dictionarypage.jpg'); 
  }
  p{
    background-color: white;
  }
</style>
