<template>
  <div id="accordion">
    <div class="d-flex flex-shrink-1 justify-content-md-center row row-cols-auto g-10">

    <div class="card border-primary mb-3 " v-for="trail in trails" v-bind:class="trail" v-bind:key="trail.id" style="width: 18rem;">
        <div class="card-body">
          <h5 class="card-title">{{ trail.name }}</h5>
            <p class="card-description" v-bind:id="'desc_' + trail.name">{{ trail.description }}</p>
              <h5 class="mb-0">
                <button class="btn btn-outline-dark" v-on:click="toggleDescription($event)" v-bind:id="'btn_' + trail.name">See more details</button>
              </h5>

        </div>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Difficulty: {{ trail.difficulty }}</li>
            <li class="list-group-item">Distance: {{ trail.distance }} miles</li>
          </ul>

      <div class="card-body">
        <a v-bind:href="trail.trailUrl" class="card-link" target="_blank">Singletracks Page</a>
      </div>
      </div>



    </div>
    </div>
</template>

<script>

export default {
  methods: {
    toggleDescription(evt) {

      let descId = "desc_" + evt.target.id.substring(4);
      const descBox = document.getElementById(descId);
      const descBoxClasses = descBox.classList;

      if (descBoxClasses.contains("card-description")) {
        descBoxClasses.remove("card-description");
        descBoxClasses.add("card-description-full")
      } else {
        descBoxClasses.remove("card-description-full")
        descBoxClasses.add("card-description");
      }
    }
  },
  name: "TrailApi",
  props:["trails"],
  data() {
    return {}
  },

}
</script>

<style>
.btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}

.card-link {
  color: rgb(51, 51, 51);
}

.card-link:hover {
  color: rgb(50, 243, 233);
}

#accordion{

  margin-top: 25px;

}
.card-description{
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  transition: max-height 0.3s cubic-bezier(0, 1, 0, 1);
  filter: blur(1px);

}
.card-description-full{
  max-height: 100rem;
  transition: max-height 0.3s cubic-bezier(0.9, 0, 0.8, 0.2);


}
.card{
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 5px;
  margin: 10px;
  max-height: fit-content;

}
.card:hover
{
  box-shadow: 10px 10px 20px black;
}
.card-body
{
  padding: 2px 16px;
}


</style>