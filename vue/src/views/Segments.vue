<template>
  <div>
    <strava-segments v-bind:segments="segments"></strava-segments>
  </div>
</template>

<script>
import stravaService from "../services/StravaService";
import StravaSegments from "../components/StravaSegments";
export default {
  name: "Segments",
  components: {StravaSegments},
  data(){
    return {
      segments: [],
    }
  },
  created()
  {
    stravaService
        .getSegments(this.$route.params.address)
        .then(response =>
        {
          this.segments = response.data;
        })
  }
}
</script>

<style scoped>

</style>