<template>
  <div class="activity-container">
    <div>
      <img src="@/assets/newDistance.png" alt="bike-logo" class="assets"/><br>
      <h5><strong>{{totalDistance.toFixed(2)}} miles ridden</strong></h5>
    </div>
    <div>
      <img src="@/assets/newHours.png" alt="clock-logo" class="assets"/><br>
      <h5><strong>{{minutesToHours(totalTime)}} hours ridden</strong></h5>
    </div>
    <div>
      <img src="@/assets/newElevation.png" alt="mountain-logo" class="assets"/><br>
      <h5><strong>{{totalElevation}} feet climbed</strong></h5>
    </div>
  </div>
</template>

<script>


export default {
  name: "ActivitySummary",
  props: ["activities"],
  methods: {
    minutesToHours(minutes) {
      return (minutes / 60).toFixed(2)
    }
  },
  computed: {
    totalDistance() {
      const numArray = this.activities.map(activity => activity.activityDistance)
      return numArray.reduce(
          (acc, currentVal) =>
            acc + currentVal, 0
      )},
    totalTime() {
      const numArray = this.activities.map(activity => activity.elapsedTime)
      return numArray.reduce(
          (acc, currentVal) =>
            acc + currentVal, 0
      )},
    totalElevation() {
      const numArray = this.activities.map(activity => activity.activityElevation)
      return numArray.reduce(
          (acc, currentVal) =>
              acc + currentVal, 0
      )
    }
  },
}
</script>

<style scoped>
.assets {
  width: 8rem;
  height: 8rem;
  margin-top: 40%;
  border-radius: 30px;
  box-shadow: 5px 5px;
}

.activity-container {

  border-radius: 10px;
  display: flex;
  flex-direction: column;

}

h5 {
  text-align: center;
  margin-top: 10px;
  color: white;
  font-weight: bolder;
  text-shadow: 3px 3px black;
}

</style>