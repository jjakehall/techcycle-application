<template>
  <div class="activity-container">
    <activity-card-list activities="activities"/>
    <button v-on:click="toggleShowForm()">Add new activity</button>
    <activity-form v-show="showForm === true"/>
  </div>
</template>

<script>

import ActivityForm from "@/components/ActivityForm";
import ActivityCardList from "@/components/ActivityCardList";

export default {
  name: "Activities",
  activities : [],
  components: {ActivityCardList, ActivityForm},
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
  },
  created() {
    this.activities = this.$store.state.userActivities
  }
}
</script>

<style scoped>

</style>