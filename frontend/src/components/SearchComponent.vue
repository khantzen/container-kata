<template>
  <div id="app">
    <PageHeader current="search"></PageHeader>
    <br/>
    <div class="container">
      <div class="row">
        <div class="col">
          <form class="" @submit.prevent="pickValue">
            <label class="form-label">Category</label>
            <div class="input-group">
              <select class="form-select" v-model="selectedCategory" aria-label="Category select">
                <option v-for="category in categories" :key="category" :value="`${category.title}`">{{
                    category.title
                  }}
                </option>
              </select>
            </div>
            <div class="input-group">
              <button class="btn btn-primary" type="submit">Get Random Fortune</button>
            </div>
          </form>
        </div>

        <div class="col">
          <div class="card" style="width: 18rem;" v-if="pickedQuote !== ''">
            <div class="card-body">
              <p class="card-text">{{ pickedQuote }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import {defineComponent, ref} from "vue";
import PageHeader from "@/components/composition/PageHeader";
import axios from "axios";

const allCategories = () => axios.get("/api/v1/categories")
    .then((res) => res.data)

const quoteFor = (category) => axios.get("/api/v1/randomQuoteIn/" + category)
    .then((res) => res.data)

export default defineComponent({
  name: 'SearchComponent',
  components: {
    PageHeader
  },
  data() {
    return {
      publicPath: process.env.BASE_URL,
      selectedCategory: "art",
      pickedQuote: ""
    }
  },
  methods: {
    pickValue(e) {
      console.log(this.selectedCategory);
      quoteFor(this.selectedCategory)
          .then(data => this.pickedQuote = data.text)
      e.preventDefault();
    }
  },
  setup() {
    const categories = ref([])

    allCategories()
        .then(data => categories.value = data.sort((a, b) => (a.title > b.title ? 1 : -1)))

    return {categories}
  }
})

</script>

<style>
.logo {
  max-height: 25px;
}
</style>


