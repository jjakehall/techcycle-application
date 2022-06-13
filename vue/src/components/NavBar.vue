<template>
<!--  <div id="sidenav">-->
<!--    <div class="buttons">-->
<!--      <div class="button" id="master-btn">TEch Cycle</div>-->
<!--      <router-link id="link" v-bind:to="{ name: 'home' }"><div class="button">PROFILE</div></router-link>-->
<!--      <router-link id="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><div class="button">  LOGOUT</div></router-link>-->
<!--    </div>-->
<!--  </div>-->
<!--  <div>-->
  <div class="m-0">
    <div>
      <b-navbar type="dark" variant="dark">
        <b-navbar-nav>
          <b-nav-item v-bind:to="{name : 'landing-page'}">TEchCycle</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ms-auto">
          <b-nav-item v-bind:to="{name : 'activities'}">Activities</b-nav-item>
          <b-nav-item v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</b-nav-item>
          <b-nav-item v-bind:to="{ name: 'login'}" v-if="$store.state.token === ''">Login</b-nav-item>
          <b-nav-item v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</b-nav-item>
        </b-navbar-nav>
      </b-navbar>
    </div>
  </div>
</template>

<script>
export default {
  name: 'nav-bar'
}
</script>

<style scoped>
/*.button{*/
/*  width: 100%;*/
/*  height: 40px;*/
/*  margin: 0;*/
/*  text-align: center;*/
/*  flex: 1;*/
/*  background-color: rgb(50, 243, 233);*/
/*  !*text-justify: center;*!*/
/*  padding-right: 20px;*/

/*  cursor: pointer;*/
/*}*/

/*.buttons{*/
/*  font-family: 'Nunito', sans-serif;*/
/*  display: flex;*/
/*  align-items: center;*/
/*  justify-content: center;*/
/*  font-weight: bolder;*/

/*}*/

/*#master-btn {*/
/*  text-decoration: none;*/
/*  justify-self: center;*/
/*  font-size: 30px;*/
/*  color: black;*/
/*  text-shadow: 1px 1px #ffffff;*/

/*}*/

/*#sidenav {*/
/*  border: 2px solid black;*/
/*  height: 5%;*/
/*  width: 100%;*/
/*  position: fixed;*/
/*  z-index: 1;*/
/*  background-color: rgb(50, 243, 233);*/
/*  !*padding-top: 20px;*/
/*  padding-bottom: 20px;*!*/
/*  top: 0;*/
/*}*/

/*.button:hover {*/
/*  color: white;*/
/*  text-decoration: none;*/

/*}*/

/*#link {*/
/*  text-decoration: none;*/
/*  justify-self: flex-end;*/
/*  font-size: 20px;*/
/*  color: black;*/
/*  text-shadow: 1px 1px #ffffff;*/
/*}*/
</style>
