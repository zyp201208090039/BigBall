<template>
    <div class="footItem">
    <div v-for="item in imgsOld" :key="item.id">
        <div class="item" >
          <a :href='item.href'>
              <table>
                <tr> <img @click="itemClick(item)"  :src="item.imgUrl"/></tr>
            </table>

          </a>   
        </div>
       
    </div>
    </div>
</template>

<style scoped>
.item
{
  margin: 0 auto;
  width: 20%;
  float: left;
 margin-top: 3px;
 
}
.item img{
    width:90%;
}
.footItem
{
  background-color: white;
   position: fixed;
   bottom: 0px;
    border-top:lightgray;
    border: 1px;
    width: 100%;
    height:60px;
    overflow:hidden;
}
</style>
<script>
export default {
  name: 'footItem',
  data () {
    return {
     imgs:[
          {  imgUrl: require('../../static/imgs/home.png'),   id: '1' },
            {  imgUrl: require('../../static/imgs/fenlei.png'),   id: '2' },
              {  imgUrl: require('../../static/imgs/time.png'),   id: '3'  },
                {  imgUrl: require('../../static/imgs/fuli.png'),   id: '4' },
                 {  imgUrl: require('../../static/imgs/me.png'),   id: '5' }
     ],
       imgsOld:[
          {  imgUrl: require('../../static/imgs/home.png'),  href:'#/', id: '1' ,active:true },
            {  imgUrl: require('../../static/imgs/fenlei1.png'), href:'#/classification',   id: '2' ,active:false },
              {  imgUrl: require('../../static/imgs/time1.png'),   href:'#/time', id: '3'  ,active:false },
                {  imgUrl: require('../../static/imgs/fuli1.png'),   href:'#/time', id: '4'  ,active:false },
                 {  imgUrl: require('../../static/imgs/me1.png'),   href:'#/me', id: '5' ,active:false }
     ],
      imgsOld1:[
          {  imgUrl: require('../../static/imgs/home1.png'),   id: '1' ,active:false },
            {  imgUrl: require('../../static/imgs/fenlei1.png'),   id: '2' ,vactive:false },
              {  imgUrl: require('../../static/imgs/time1.png'),   id: '3'  ,vactive:false },
                {  imgUrl: require('../../static/imgs/fuli1.png'),   id: '4'  ,vactive:false },
                 {  imgUrl: require('../../static/imgs/me1.png'),   id: '5' ,vactive:false }
     ]
    }
  },
  methods:
  {
      itemClick(item)
      {
          if(!item.active)
          {
            item.active=true;
            var index= this.imgsOld.indexOf(item);
            item.imgUrl=this.imgs[index].imgUrl;
          }
          for(var i=0;i< this.imgsOld.length;i++)
          { let each=this.imgsOld[i];
            if(each!=item&&each.active==true)
            {
              each.active=false;
              var index= this.imgsOld.indexOf(each);
              each.imgUrl=this.imgsOld1[index].imgUrl;
            }
          }
      }
  }
}
</script>