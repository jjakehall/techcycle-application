<template>
  <div>
    <trail-api v-bind:trails="trails"></trail-api>
  </div>
</template>

<script>
import TrailApi from "../components/TrailApi";
import trailAPIService from "../services/TrailAPIService";
export default {
  name: "Trails",
  components:{TrailApi},
  data() {
    return{
      trails: [],
    }
  },
  created()
  {
        trailAPIService
        .getTrails(this.$route.params.address)
        .then(response => {
            console.log(response.data)
            this.trails = response.data;
          })

  },
}
</script>

<style scoped>
div {
background: linear-gradient(to bottom, rgb(50, 243, 233), black);
height: 100vh;
}

</style>