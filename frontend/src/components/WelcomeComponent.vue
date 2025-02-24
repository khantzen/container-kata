<template>
  <div id="app">
    <PageHeader current="welcome"></PageHeader>
    <div class="container-fluid">
      <div class="row">
        <h2>Welcome to Fortue Cookie Picker</h2>
      </div>
      <div class="row">
        Ce site est un site démo pour l'Arolla Academy servant de base
        pour apprendre comment déployer une application, la rendre disponible au grand public et
        configurer la communication avec une api backend.
      </div>
      <br>
      <div class="row col-6">
        <img :src="`${publicPath}cookies.gif`" alt="cookie">
      </div>
    </div>
  </div>
</template>

<script>
import PageHeader from '@/components/composition/PageHeader.vue'
import {defineComponent} from "vue";

export default defineComponent({
  name: 'Welcome',
  data () {
    return {
      publicPath: process.env.BASE_URL
    }
  },
  components: {
    PageHeader
  }
})

</script>