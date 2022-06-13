@import url(https://fonts.googleapis.com/css2?family=Inter&family=Nunito&display=swap)
<template>
  <div id="loginbackground" class="text-center" :style="{'backgroundImage': 'url(' + require('./../assets/mountainbackground.jpg') + ')' }">
    <form class="form-signin" @submit.prevent="login" id="form">
      <h1 id="loginText">Login</h1>
      <br>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid credentials!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >You're all set!<br>Please sign in.</div>
      <br>
      <label for="username" class="sr-only">Username</label><br>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label><br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br><br>
      <button id="letsGo" type="submit">Let's go!</button><br><br><br>
      <router-link id="loginLink" :to="{ name: 'register' }">Need an account?</router-link><br><br><br>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

.alert {
  font-weight: bold;
}

h1 {
  font-size: 44px;
}

#loginbackground {
  display: grid;
  place-content: center;

  background-size: cover;
  align-items: center;
  justify-items: center;
}

#form {
  font-family: 'Nunito', sans-serif;
  display: block;
  padding: 100px 70px 100px 70px;
  text-align: center;
  border: 1px solid black;
  background-color: rgb(50, 243, 233);
  border-radius: 7px;
  box-shadow: 5px 5px black;
}

#username {
  margin: 5px;
}

#password {
  margin: 5px;
}

#letsGo {
  background-color: rgb(0, 0, 0);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  border-radius: 5px;
}

#letsGo:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);

}

#loginLink {
  color: black;
  font-weight: bold;
  text-decoration: none;
}

#loginLink:hover {
  color: gray;
}

#loginText {
  text-shadow: 3px 3px #ffffff;
}

</style>


