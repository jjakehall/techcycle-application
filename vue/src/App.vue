<template>

  <div class="container m-0 p-0">
    <!-- <div id="nav"> -->
      <!-- <router-link id="link" v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link id="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link> -->
    <!-- </div> -->
    <nav-bar class="nav-bar"/>
    <router-view class="routerView" />
    </div>
</template>

<script>
import NavBar from './components/NavBar.vue';

export default {
  components: {
    NavBar
  },
}
</script>

<style scoped>
.container {
  min-width: 100%;
  min-height: 100vh;

}

.routerView {
  height: 94.5%;
  position: absolute;
  bottom: 0;
  width: 100%;
}

.nav-bar {
  box-sizing: border-box;
}

</style>

