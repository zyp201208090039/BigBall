<template>
    <div class="viewItem">
    <div v-for="item in imgs" :key="item.id">
      <a :href="item.hre">
        <div class="item">
              <table>
                <tr> <img  :src="item.imgUrl"/></tr>
                <tr> <label>{{item.title}}</label></tr>
            </table>
        
        </div>
       </a>
    </div>
    </div>
</template>

<style scoped>
.item
{
  width: 33%;
  float: left;
   margin-top: 3px;
}
.item img{
    width:90%;
}
.viewItem
{
    width: 100%;
    height: auto;
    overflow:hidden
}
</style>
<script>
export default {
  name: 'viewItem',
  data () {
    return {
     imgs:[
          {  imgUrl: require('../../static/imgs/detail01.png'),   id: '1'  ,title:'考生复习信息' ,hre:'#/normalQuestion'},
            {  imgUrl: require('../../static/imgs/detail02.jpg'),   id: '2'   ,title:'教师权限申请',hre:'#/applyTeacher'},
              {  imgUrl: require('../../static/imgs/detail03.png'),   id: '3' ,title:'大球教育教师信息',hre:'#/teacherList'  }
     ]
    }
  }
}
</script>