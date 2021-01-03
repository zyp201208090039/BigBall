<template>
    <div>
    <div v-for="item in imgs" :key="item.id">
        <div class="item">
          <center>
             <a :href="item.hre">
               <table>
                <tr> <img  :src="item.imgUrl"/></tr>
                <tr> <label>{{item.title}}</label></tr>
            </table>
            </a>
          </center>       
        </div>
       
    </div>
    </div>
</template>

<style scoped>
.item
{
  float: left;
  width: 25%;;
  margin-top: 3px;
}
</style>
<script>
export default {
  name: 'listItem',
  data () {
    return {
     imgs:[
          {  imgUrl: require('../../static/imgs/nav0.png'),   id: '1'  ,title:'招生简章',hre:'#/scoreCube' },
            {  imgUrl: require('../../static/imgs/nav1.png'),   id: '2'   ,title:'师资力量',hre:'#/teacherList'},
              {  imgUrl: require('../../static/imgs/nav2.png'),   id: '3' ,title:'招聘信息' ,hre:'#/recruit' },
                {  imgUrl: require('../../static/imgs/nav3.png'),   id:'5',title:'集训报名',hre:'#/scoreCube'},
                 {  imgUrl: require('../../static/imgs/nav4.png'),   id:'6',title:'分数查询',hre:'#/scoreCube'},
                  {  imgUrl: require('../../static/imgs/nav5.png'),   id:'7',title:'学校简介',hre:'#/schoolIntroduce'},
                   {  imgUrl: require('../../static/imgs/nav6.png'),   id:'8',title:'高考问答',hre:'#/normalQuestion'},
                    {  imgUrl: require('../../static/imgs/nav7.png'),   id:'9',title:'报名须知',hre:'#/scoreCube'},
     ]
    }
  }
}
</script>