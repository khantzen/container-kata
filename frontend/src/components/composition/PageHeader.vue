<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img :src="`${publicPath}logo.png`" alt="cookie"  class="logo d-inline-block align-text-top">
        Fortune Cookie Picker
      </a>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" :class="{ active: isActive('welcome') }" aria-current="page" href="/">Welcome</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" :class="{ active: isActive('search') }" aria-current="page" href="/search">Search for fortune</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" :class="{ active: isActive('all') }" aria-current="page" href="/all">All fortune</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
import {defineComponent} from "vue";
export default defineComponent({
  name: 'PageHeader',
  data () {
    return {
      publicPath: process.env.BASE_URL
    }
  },
  props: {
    current: String
  },
  setup(props) {
    const isActive = (page) => props.current === page
    return { isActive: isActive }
  }
})

</script>

<style>
.logo {
  max-height: 25px;
}
</style>


