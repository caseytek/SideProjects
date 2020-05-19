<template>
<div id="word-search-results">
    <h1> Search Results </h1>
<div class="word" v-for= 'word in words' :key= 'word.name'>
  <p>{{word.name}} </p>
</div>
</div>
</template>

<script>
export default {
 data(){
     return {
         words: []
     }
 },
 props:{
     wordSearch: String
 },
 created(){
     console.log("created, searchedword: " + this.wordSearch )
     if(this.wordSearch != ""){
      fetch(`http://localhost:8080/oxforddictionaryapi/wordSearch/${this.wordSearch}`)
        .then( 
            (response) => {return response.json();} 
        )
        .then(
            (data) => {this.words = data;}
        )
        .catch((err)=>{console.log(err);})
    }
 }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=IM+Fell+English&display=swap');
#word-search-results{
    background-color: beige;
}
h1{
    font-family:'IM Fell English', serif;
}

</style>