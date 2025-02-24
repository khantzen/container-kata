<template>
  <div id="app">
    <PageHeader></PageHeader>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import PageHeader from './components/composition/PageHeader.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    PageHeader
  }
}
</script>
