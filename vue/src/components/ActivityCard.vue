<template>
  <div class="activity-details">
    <ul>
      <li class="activity"><strong>{{activity.activityName}}</strong><br><p class="type">Activity name</p></li>
      <li class="username"><strong>{{activity.username}}</strong><br><p class="type">Username</p></li>
<!--      <li class="desc"></li>-->
      <li class="date"><strong>{{activity.activityDate}}</strong><br><p class="type">Date</p></li>
      <li class="dist"><strong>{{activity.activityDistance}} miles</strong><br><p class="type">Distance</p></li>
      <li class="elev"><strong>{{activity.activityElevation}} feet</strong><br><p class="type">Elevation</p></li>
      <li class="time"><strong>{{activity.elapsedTime}} minutes<br></strong><p class="type">Elapsed time</p></li>
      <li id="delete" v-show="!(this.$store.state.token ==='')"><button class="btn" v-on:click="deleteActivity()" >Delete activity</button></li>
      <li id="edit" v-show="!(this.$store.state.token ==='')" v-on:click="toggleShowForm()"><button class="btn" >Edit activity</button></li>
    </ul>
    <edit-activity-form id="form" v-show="showForm === true" v-bind:activity="activity"></edit-activity-form>

  </div>
</template>

<script>

import activityService from "@/services/ActivityService";
import EditActivityForm from "@/components/EditActivityForm";


export default {
  name: "ActivityCard",
  components: {EditActivityForm},
  props: ["activity"],
  data() {
    return {
      showForm: false
    }
  },
  methods : {
    deleteActivity() {
      if (confirm("Are you sure you want to delete this activity?")) {
        this.$router.go(this.$router.currentRoute)
        activityService.deleteActivity(this.activity.activityId).then(response => {
          if (response.status === 200) {
            alert("Activity successfully deleted");
            this.$store.commit("DELETE_ACTIVITY")

          }
        })
    }

    },
    toggleShowForm() {
      if(this.showForm === true) {
        this.showForm = false
      } else {
        this.showForm = true
      }
    }
  }
}
</script>

<style scoped>

#desc {
  grid-area: desc;
  background-color: #B0BEC5;
  max-height: 60px;
  border-radius: 5px;
  font-weight: bold;
}

.activity {
  grid-area: activity;
}

#toggleDesc:hover {
  cursor: pointer;
}

ul {
  /*display: flex;*/
  /*justify-content: space-between;*/
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr .5fr .5fr;
  grid-template-areas: "activity username date distance elevation time edit delete";
  max-height: 5rem;
}

.username {
  grid-area: username;
}

li {
  margin-top:20px;
  margin-right: 20px;
  list-style: none;
  font-family: Tahoma,serif;
  color: white;
}

b-col {
  color: #B0BEC5;
}

.type {
  font-size: 12px;
  padding-top: 2px;
}

.elev {
  grid-area: elevation;
}

.dist {
  grid-area: distance;
}

.desc {
  grid-area: description;
  font-weight: bold;
  text-align: left;

}

#edit {
  grid-area: edit;
  background-color: #B0BEC5;
  max-height: 60px;
  border-radius: 5px;
  font-weight: bold;
}

#delete {
  grid-area: delete;
  background-color: #B0BEC5;
  max-height: 60px;
  border-radius: 5px;
  color: white;

}

.date {
  grid-area: date;
}

.btn {
  color: black;
  box-shadow: 2px 2px black;
  font-weight: bold;
}

.btn:hover {
  box-shadow: 4px 4px black;
  font-weight: bolder;
  color: #FAFAFA;
}

#form {
  margin-left: 30%;
  margin-bottom: 1%;
}

</style>

<!--<b-card-->
<!--    no-body-->
<!--    style="max-width: 20rem; min-width: 15rem"-->
<!--&gt;-->
<!--<template #header>-->
<!--  <h4 class="mb-0">Activity</h4>-->
<!--</template>-->

<!--<b-card-body>-->
<!--  <b-card-text>-->
<!--    {{activity.activityDescription}}-->

<!--  </b-card-text>-->
<!--</b-card-body>-->

<!--<b-list-group flush>-->
<!--  <b-list-group-item>-->
<!--    Elevation: {{activity.activityElevation}}-->
<!--  </b-list-group-item>-->
<!--  <b-list-group-item>-->
<!--    Distance: {{activity.activityDistance}}-->
<!--  </b-list-group-item>-->
<!--  <b-list-group-item>-->
<!--    Time: {{activity.elapsedTime}}-->
<!--  </b-list-group-item>-->
<!--</b-list-group>-->
<!--</b-card>-->