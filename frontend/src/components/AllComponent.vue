<template>
  <div id="app">
    <PageHeader current="all"></PageHeader>
    <div>
      <ul class="list-group">
        <li v-for="(quotes, name) in quotes" :key="name" class="list-group-item">
          {{name}}
          <ul class="">
            <li v-for="quote in quotes" :key="quote" class="">{{quote.text}}</li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import {defineComponent, ref} from "vue";
import PageHeader from "@/components/composition/PageHeader";

const axios = require('axios')

const allQuotes = () => axios.get("/api/v1/allQuotes")
    .then((res) => res.data)

export default defineComponent({
  name: 'AllComponent',
  components: {
    PageHeader
  },
  data() {
    return {
      publicPath: process.env.BASE_URL
    }
  },
  setup() {
    const quotes = ref([])

    allQuotes()
        .then(data => quotes.value = data)

    return { quotes }
  }
})

</script>

<style>
.logo {
  max-height: 25px;
}
</style>


