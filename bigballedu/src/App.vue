<template>
  <div id="app">
  <bghead></bghead>
    <router-view/>
    <div id=blank></div>
  <footItem></footItem>
  </div>
</template>

<script>
import bghead from '@/components/head'
import footItem from '@/components/foot'
export default {
  name: 'App',
  components:{bghead,footItem}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
a{
    text-decoration: none;
}
#blank
{
  height: 200px;
}
</style>
