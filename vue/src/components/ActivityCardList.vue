<template>
  <div>
    <div id="page-header">
      <h1 id="header">{{getActivityHeader()}}</h1>
      <h4 id="sub-header" v-show="this.activities.length === 0">You have no activities to display!</h4>
      <button id="btn" v-on:click="toggleShowForm()" v-show="!(this.$store.state.token === '')">Add new activities</button>
    </div>
    <div id="form-container">
      <activity-form v-show="showForm === true" id="form"></activity-form>
    </div>
    <div class="activity-detail">
      <activity-card v-for="activity in activities" v-bind:key="activity.id" v-bind:activity="activity" class="cards"/>
    </div>
  </div>
</template>

<script>
import ActivityCard from "@/components/ActivityCard";
import ActivityForm from "@/components/ActivityForm";

export default {
  name: "ActivityCardList",
  components: {ActivityForm, ActivityCard},
  props: ["activities"],
  data() {
    return {
      showForm: false
    }
  },
  methods: {
    toggleShowForm() {
      if(this.showForm === true){
        this.showForm = false;
      } else {
        this.showForm = true;
      }
    },
    getActivityHeader() {
      if (this.$store.state.token === '') {
        return "Public Activities"
      } else {
        return "My Activities"
      }
    }
  }
}
</script>

<style scoped>



#sub-header {
  margin-top: 20%;
  margin-right: 14%;
}

#page-header {
  display: flex;
  justify-content: space-between;
}

#form-container {
  display: flex;
  justify-content: center;

}

#btn {
  height: 3rem;
  margin: 30px;
  border: none;
  box-shadow: 5px 5px 20px black;
  background-color: #334147;
  border-radius: 10px;
  color: white;
}

#header {
  font-size: 40px;
  font-weight: 600;
  color: white;
  background-color: #334147;
  border-radius: 10px;
  padding: 15px;
  margin-right: 5px;
  box-shadow: 5px 5px 20px black;

}

.activity-detail {
  display: flex;
  flex-direction: column;
  margin-left: 20px;


}

.cards {
  margin: 10px;
  border-radius: 10px;
  background-color: #334147;
  box-shadow: 5px 5px 20px black;
}

.cards:hover {
  box-shadow: 10px 10px 20px black;
}

h1 {
  margin-top: 20px;
  margin-left: 30px;
  margin-bottom: 20px;
  font-family: Tahoma, serif;
  font-weight: lighter;
  max-height: 80px;
  
}

</style>