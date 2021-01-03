<template>
    <div>
      <bgSwiper></bgSwiper>
      <listItem></listItem>
      <viewItem></viewItem>
      
     <!-- <teacher></teacher>
      <register></register> -->
      <!-- <login></login> -->
      <!-- <teacherBlock></teacherBlock> -->
      <div class="leftDay">高考剩余天数：{{leftTime}}</div>
      <announcement></announcement>
      <!-- <teacherList></teacherList> -->
        <!-- <i class="el-icon-edit"></i>
        <i class="el-icon-share"></i>
        <i class="el-icon-delete"></i>
        <el-button type="primary" icon="el-icon-search">搜索</el-button>     -->
    </div>
</template>

<style scoped>
.leftDay
{
  color: red;
  margin-top:10px;
  font-size: 18px;
  font-family: Arial, Helvetica, sans-serif;
  text-align: left;
}
</style>

<script>
import bgSwiper from '@/components/swiper'
import listItem from '@/components/listItem'
import viewItem from '@/components/viewItem'
import footItem from '@/components/foot'
import teacher from '@/components/teacher'
import teacherBlock from '@/components/teacherBlock'
import login from '@/components/page/login'
import register from '@/components/page/register'
import announcement from '@/components/compusAnnouncement'
import teacherList from '@/components/page/teacherList'
export default {
  name: 'Home',
  data () {
    return {
      title: '大球教育',
      leftTime:''
    }
  },
    mounted() {
        console.log('this is left time..');
      this.setTimer() // 挂载的时候就开始计时，3000ms后消失
    },
  components:{bgSwiper,listItem,viewItem,footItem,teacher,login,teacherBlock,register,announcement,teacherList},
  methods:{
       setTimer() {
        setInterval(() => {
         this.leftTime= this.leftTimer('2021-06-07 08:00:00') // 3000ms之后调用关闭方法
        }, 3000)
      },
    leftTimer(enddate)
    {

        var leftdate="";
        var leftTime = (new Date(enddate)) - new Date(); //计算剩余的毫秒数
        var days = parseInt(leftTime / 1000 / 60 / 60 / 24, 10); //计算剩余的天数
        var hours = parseInt(leftTime / 1000 / 60 / 60 % 24, 10); //计算剩余的小时
        var minutes = parseInt(leftTime / 1000 / 60 % 60, 10);//计算剩余的分钟
        var seconds = parseInt(leftTime / 1000 % 60, 10);//计算剩余的秒数
        days = this.checkTime(days);
        hours = this.checkTime(hours);
        minutes = this.checkTime(minutes);
        seconds = this.checkTime(seconds);
        if (days >= 0 || hours >= 0 || minutes >= 0 || seconds >= 0)
        {

        leftdate = days + "天" + hours + "小时" + minutes + "分" + seconds + "秒";
        } 
      return leftdate;
    },
  checkTime(i) 
  { //将0-9的数字前面加上0，例1变为01
      if (i < 10) {
      i = "0" + i;
      }
      return i;
    }

  }
}
</script>