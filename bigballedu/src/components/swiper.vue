<template>
  <div class="block">
    <el-carousel trigger="click" height="300px">
      <el-carousel-item v-for="item in imgs" :key="item.id">
       <img class="swiper" :src="item.imgUrl"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<style scoped>
 .swiper
 {
     height: 300px;
    width: 100%;
 }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }
</style>

<script>
export default {
  name: 'homeSwiper',
  data () {
    return {
     imgs:[
          {  imgUrl: require('../../static/imgs/l1.jpg'),   id: '1'   },
            {  imgUrl: require('../../static/imgs/l2.jpg'),   id: '2'   },
              {  imgUrl: require('../../static/imgs/l3.jpg'),   id: '3'   },
                {  imgUrl: require('../../static/imgs/l4.jpg'),   id:'4'}
     ]
    }
  }
}
</script>