<template>
    <div>
        <table class="Announcetable">
            <tr>
                <td>
                  <img v-if="item.imgurl==null" :src="defalutImg"/>
                  <img v-else :src="item.imgurl"/>
                  <!-- <h1 v-if="item.imgurl==null">Vue is awesome!</h1>
                  <h1 v-else>{{item.imgurl}}Oh no 😢</h1> -->
                  <!-- <div v-if="item.imgurl==''"><img :src="defalutImg"/></div>
                  <div v-else><img :src="item.imgurl"/></div> -->
                     
                </td>
                <td>
                    {{item.title}}
                </td>
            </tr>
        </table>
        <hr>
    </div>
</template>
<style scoped>

.Announcetable
{
    text-align: left;
    vertical-align: top;
}
img
{
  width: 100px;
  height: 100px;
}

</style>

<script>
export default {
  name: 'announcemnetItem',
  props:
  {
    item:Object
  },
  data () {
    return {
      defalutImg:require('../../static/imgs/nav0.png')
     // item:{imgurl:require('../../static/imgs/nav0.png'), title:'学校公告'}
    }
  }
}
</script>