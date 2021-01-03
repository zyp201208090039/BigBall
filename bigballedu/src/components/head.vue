<template>
    <div>
      <div id="bgheader">
          <h1>{{title}}</h1>
        </div>
    </div>
</template>

<style scoped>
#bgheader
{
  width: 100%;
  background-color:silver;
}
</style>
<script>
export default {
  name: 'bghead',
  data () {
    return {
      title: '大球教育'
    }
  }
}
</script>