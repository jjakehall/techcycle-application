<template>
  <div class="activity-container">
    <div>
      <img src="@/assets/newDistance.png" alt="bike-logo" class="assets"/>
<!--      <h2>{{totalDistance()}}</h2>-->
    </div>
    <div>
      <img src="@/assets/newHours.png" alt="clock-logo" class="assets"/>
<!--      <h2>{{totalTime()}}</h2>-->
    </div>
    <div>
      <img src="@/assets/newElevation.png" alt="mountain-logo" class="assets"/>
<!--      <h2>{{totalElevation()}}</h2>-->
    </div>
    <!--Conditionally(when clicked) expand to display list of activities-->
    <!--need to pass in activity array-->
    <button v-on:click="toggleShowForm()">Add new activity</button>
    <activity-form v-show="showForm === true"/>
  </div>
</template>

<script>

import ActivityForm from "@/components/ActivityForm";
export default {
  name: "Activities",
  components: {ActivityForm},
  props: ['activities'],
  // computed: {
  //   totalDistance() {
  //     return this.activities.distance.reduce(
  //         (acc, currentVal) =>
  //           acc + currentVal, 0
  //     )},
  //   totalTime() {
  //     return this.activities.time.reduce(
  //         (acc, currentVal) =>
  //           acc + currentVal, 0
  //     )},
  //   totalElevation() {
  //     return this.activities.elevation.reduce(
  //         (acc, currentVal) =>
  //             acc + currentVal, 0
  //     )
  //   }
  // },
  data() {
    return {
      showForm: false,
    }
  },
  methods : {
    toggleShowForm() {
      if (this.showForm === true) {
        this.showForm = false;
      } else {
        this.showForm = true;
      }
    }
  }
}
</script>

<style scoped>
p {
  line-height: 500px;
}
.assets {
  height: 98%;
  width: 98%;
  padding: 15px;
  border-radius: 10px;
}

.activity-container {
  /* height: 50vh;
  width: 50vh; */
  /* padding-top: 60px;
  padding-bottom: 10px; */
  height: 75%;
  width: 75%;
  /* background-color: gray; */
  border-radius: 10px;
  display: flex;
  align-items: stretch;
  justify-content: space-evenly;
}

</style>