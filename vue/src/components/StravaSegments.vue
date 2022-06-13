<template>
  <div id="accordion">
    <div class="d-flex flex-shrink-1 justify-content-md-center row row-cols-auto g-10">

    <div class="card border-primary mb-3 " v-for="segment in segments" v-bind:class="segment" v-bind:key="segment.id" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">{{ segment.name }}</h5>
      </div>
      <ul class="list-group list-group-flush">
        <li class="list-group-item">Elevation Gain: {{ segment.elevationGain }} feet</li>
        <li class="list-group-item">Distance: {{ ((segment.distance)/5280).toFixed(2) }} miles</li>
        <li class="list-group-item">Average grade: {{ segment.grade }} %</li>
      </ul>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "StravaSegments",
  props:["segments"],
  data() {
    return {}
  }
}
</script>

<style scoped>

</style>