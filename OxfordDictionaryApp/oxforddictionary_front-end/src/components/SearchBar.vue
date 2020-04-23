<template>
<div class="form">
    <form v-on:submit.prevent="handleWordSearch">
        <input type="text" placeholder="Find definition for..." v-model='word'><button>Search For Word</button>
    </form>
</div>     
</template>

<script>
export default {
    name: 'search-bar',
    data() {
        return {
            word: ''
        };
    },
    methods: {
        handleWordSearch(){
            this.$emit('wordSearch', this.word);
            this.$emit('turnOffForm');
        }
    }
}
</script>

 <style scoped>
@import url('https://fonts.googleapis.com/css2?family=IM+Fell+English&display=swap');
form {
    display: flex;
    justify-content: flex-end;
    padding: 0.5em;
    font-size: 14px;
    height: 75px;
}


form * {
    padding: 0.5em;
    margin: 1em;
}

form input {
    flex: 2;
    font-size: 1em;
}

form button {
    width: 10%;
    font-family:'IM Fell English', serif;
    font-size: 14px;
    transition: background 0.5s linear 0.1s , color 0.5s linear 0s;
    cursor: pointer;
} 
form button:hover{
    background: rgb(121, 109, 42);
    color: #FFF;
}
input{
    font-family:'IM Fell English', serif;
}
</style>
