<template>
    <div class = "records">
        <div class='prInfo' v-for="record in personalRecords" :key="record.id">
          <h3 v-show="!editReview"> {{record.workout}} </h3>
          <ul v-show="!editReview">
              <li> Achieved on {{record.date}}</li>
              <li> Reps: {{record.reps}}</li>
              <li> Weight: {{record.weight}} pounds</li>
          </ul>
           <form v-if="editReview && currentId == record.id">
                Movement name: <input id='name' v-model='record.workout' /> <br>
                Date:  <input id='date' v-model='record.date' /> <br>
                Reps:  <input id='reps' v-model='record.reps'>   <br>
                Weight: <input id='weight' v-model='record.weight'> <br>     
                <button id='editBtn' v-on:click.prevent='updateRecord'>Update PR!</button>
                <button id='editBtn' v-on:click.prevent='editReview = false'> Cancel </button>
            </form> 
          <button v-show="!editReview" id="editBtn" v-on:click='deleteRecord, currentId=record.id'> Delete </button>
          <button v-show="!editReview" id = "editBtn" v-on:click='updateRecord, currentId=record.id, editReview = true'> Update </button>
        </div>  
        
        <button v-show="!showAddForm && !editReview" v-on:click="showAddForm = !showAddForm"> Add PR </button>
            <form v-if="showAddForm">
                Movement name: <input id='name' v-model='record.workout' /> <br>
                Date:  <input id='date' v-model='record.date' /> <br>
                Reps:  <input id='reps' v-model='record.reps'>   <br>
                Weight: <input id='weight' v-model='record.weight'> <br>     
                <button id='addRecordBtn' v-on:click.prevent='saveRecord'>Add PR!</button>
            </form> 
    {{this.record.id}};
    {{this.record.workout}};
    {{this.record.rate}};
    {{this.record.reps}};
    {{this.record.weight}}
    </div>

</template>

<script>
export default {
    data(){
        return{
            personalRecords : [],
            showAddForm: false,
            editReview: false,
            urlApi: 'https://5e89ea48b4252f0016a622d8.mockapi.io/personalrecords',
            currentId: 0,
            record:{
                id: 0,
                workout: '',
                date: '',
                reps: '',
                weight: ''
            }      
        }
    },
    methods: {
        saveRecord(){
            let maxId = 0;
            this.personalRecords.forEach((record) => { if(record.id > maxId){
                maxId = record.id;
            }});
            this.record.id = maxId+1;
            fetch(this.urlApi,
                {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.record)
            })
            .then (
                () => {window.alert('PR added!');}
            )
            .catch(
                (err) => {console.error(err + ' problem adding PR!'); }
            )
            this.personalRecords.unshift(this.record);
            this.showAddForm = false;
            },

        updateRecord(){
           //this.record.id= this.currentId;
             fetch(
        `${this.urlApi}/${this.currentId}`,
        {
          method: 'PUT',
          headers: {
            "Content-Type" : "application/json"
          },
          body : JSON.stringify(this.record)
        }
      )
      .then(
        (response) => {
          if (response.ok) {  window.alert('PR updated!');       
          }
        }
        )
      .catch(
        (err) => {console.error(err);}
      );
            this.editReview = false;  
        },
        deleteRecord(){

        }  
    },
    created(){
        fetch(this.urlApi)
        .then(
            (response) => {return response.json();}
        )
        .then( (data) => { this.personalRecords = data;})
        .catch((err) => {console.err(err + 'no records found');})
    }
}
</script>

<style>

</style>