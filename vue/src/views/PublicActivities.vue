<template>
  <div class="activity-container">

    <activity-card-list v-bind:activities="activities" id="card-list"/>
    <div class="sidebar">
      <activity-summary id="card-summary" v-bind:activities="activities"></activity-summary>
      <div id="filter-form"></div>
    </div>
  </div>


</template>

<script>


import ActivityCardList from "@/components/ActivityCardList";
import activityService from "@/services/ActivityService";
import ActivitySummary from "@/components/ActivitySummary";

export default {
  name: "Activities",

  components: {ActivitySummary, ActivityCardList},
  data() {
    return {
      showForm: false,
      activities : [],
    }
  },
  methods : {
    toggleShowForm() {
      if (this.showForm === true) {
        this.showForm = false;
      } else {
        this.showForm = true;
      }
    },
    retrieveActivities() {
      if (this.$store.state.token === '') {
        this.activities = this.$store.state.publicActivities
        // activityService.getPublicActivities().then(response => {
        //   this.activities = response.data
        // })
      } else {
        activityService.getUserActivities().then(response => {
          this.activities = response.data
        })
      }
    }
  },
  created() {
    this.retrieveActivities();
  },
}
</script>

<style scoped>

#card-summary {
  display: flex;
}
body{
  height: 100vh;
  background: linear-gradient(to bottom, rgb(50, 243, 233), black);
}

#card-list {
  grid-area: card-list;
  background: linear-gradient(to bottom, rgb(50, 243, 233), black);

}
.sidebar {
  grid-area: side-bar;
  border-right: 1px solid black;
  background: linear-gradient(to bottom, rgb(50, 243, 233), black);
  padding: 40px;


}

#filter-form {
  text-align: center;
}

.activity-container {
  display: grid;
  grid-template-columns: 1fr 8fr;

  grid-template-areas:
    "side-bar card-list"
    "side-bar card-list";

}








</style>