<template>
  <div class="form-container">
    <h3 class="header">Update activity</h3>
    <input class="name" type="text" placeholder="name" v-model="activityName">
<!--    <input class="description" type="text" placeholder="description" v-model="activityDescription"-->
<!--           id="description-input"/>-->
    <input class="date" type="date" placeholder="date" v-model="activityDate"/>
    <input class="distance" type="number" placeholder="distance" v-model="activityDistance"/>
    <input class="time" type="text" placeholder="time(in minutes)" v-model="elapsedTime"/>
    <input class="elevation" type="number" placeholder="elevation" v-model="activityElevation"/>
    <div class="isPublic">
      <label for="isPublic">make ride public?</label>
      <input type="checkbox" name="isPublic" v-model="activityPublic">
    </div>
    <b-button class=button v-on:click="updateActivity()">Send it!</b-button>
  </div>
</template>

<script>
import activityService from "@/services/ActivityService";


export default {
  name: "EditActivityForm",
  props: ["activity"],
  data() {
    return {
        activityName: '',
        activityDescription: '',
        activityDate: '',
        elapsedTime: '',
        activityDistance: '',
        activityElevation: '',
        activityPublic: '',

    }
  },
  methods: {
    updateActivity() {
      const newActivity = {
        activityName: this.activityName,
        // activityDescription:  this.activityDescription,
        activityDate: this.activityDate,
        elapsedTime: this.elapsedTime,
        activityDistance: this.activityDistance,
        activityElevation: this.activityElevation,
        activityPublic: this.activityPublic,
      }
      activityService.updateActivity(newActivity, this.activity.activityId).then(response => {
        this.$store.commit("ADD_USER_ACTIVITY");
        console.log(response.status)
        this.$router.go(this.$router.currentRoute)

      })
    }
  },
  created() {
    this.activityDate = this.activity.activityDate
    // this.activityDescription = this.activity.activityDescription
    this.activityName = this.activity.activityName
    this.elapsedTime = this.activity.elapsedTime
    this.activityDistance = this.activity.activityDistance
    this.activityElevation = this.activity.activityElevation
    this.activityPublic = this.activity.activityPublic
  }
}
</script>

<style scoped>

div > input,*,b-button {
  margin: 10px
}

div > input {
  border-radius: 5px;
  border : none;
  text-align: center;
}

.form-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
      "header header"
      "name date"
      "description description"
      "time distance"
      "elevation public"
      "button button";
  align-items: center;
  border-radius: 10px;
  padding: 30px;
  margin: 10px;
  width: 35%;
  text-align: center;
}

.name {
  grid-area: name;
}

.header {
  grid-area: header;
  color: white;
  margin-bottom: 20px;
}

.date {
  grid-area: date;
}

.description {
  grid-area: description;
}

.time {
  grid-area: time;
}

.distance {
  grid-area: distance;
}

.elevation {
  grid-area: elevation;
}

.button {
  grid-area: button;
}

.isPublic {
  grid-area: public;
  color: white;
}

#description-input {

}

</style>