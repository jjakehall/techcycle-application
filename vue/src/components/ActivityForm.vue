<template>
  <div class="form-container">
    <h3 class="header">Add new activity</h3>
    <input class="name" type="text" placeholder="name" v-model="activity.activityName" required>
<!--    <input class="description" type="text" placeholder="description" v-model="activity.activityDescription"-->
<!--           id="description-input"/>-->
    <input class="date" type="date" placeholder="date" v-model="activity.activityDate" required/>
    <input class="distance" type="number" placeholder="distance" v-model="activity.activityDistance" required/>
    <input class="time" type="text" placeholder="time(in minutes)" v-model="activity.elapsedTime"/>
    <input class="elevation" type="number" placeholder="elevation" v-model="activity.activityElevation"/>
    <div class="isPublic">
      <label for="isPublic">make ride public?</label>
      <input type="checkbox" name="isPublic" v-model="activity.activityPublic">
    </div>
    <b-button class=button v-on:click="submitNewActivity()" :disabled="activity.activityName === ''">Send it!</b-button>
  </div>
</template>

<script>
import activityService from "@/services/ActivityService";


export default {
  name: "ActivityForm",
  data() {
    return {
      activity: {
        activityName: '',
        activityDescription: '',
        activityDate: '',
        elapsedTime: '',
        activityDistance: '',
        activityElevation: '',
        activityPublic: '',
      }
    }
  },
  methods: {
    submitNewActivity() {
      activityService.createNewActivity(this.activity).then(response => {
        this.$store.commit("ADD_USER_ACTIVITY");
          console.log(response.status)
          // this.$router.push({ name : "activities"})
        this.$router.go(this.$router.currentRoute)
        if(response.status === 200) {
          window.location.reload();

        }
      })
    }
  },
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
  background-color: #334147;
  box-shadow: 5px 5px 20px black;
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

</style>

--><!--    <b-form @submit="onSubmit" @reset="onReset">
      <b-form-group
          id="input-group-1"
          label="Description:"
          label-for="input-1"
      >
        {{activity}}
        <b-form-input
            id="input-1"
            v-model="activity.activityDescription"
            type="text"
            placeholder="Enter description"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Date: " label-for="input-2">
        <b-form-input
            id="input-2"
            v-model="activity.activityDate"
            placeholder="Enter date"
            type="date"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Time(in minutes):" label-for="input-3">
        <b-form-input
            id="input-3"
            v-model="activity.elapsedTime"
            type="text"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
            v-model="activity.isPublic"
            id="checkboxes-4"
            :aria-describedby="ariaDescribedby"
        >
          <b-form-checkbox value="me">Make ride data public?</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>-->
