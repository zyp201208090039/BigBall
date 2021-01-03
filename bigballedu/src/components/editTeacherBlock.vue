<template>
    <div class="teacherDiv">
    <div class="setleft">
       <el-image class="teachImg" :src='imgurl'></el-image>
    </div>
    <div  class="setleft2">
        <table class="teachertable">
            <tr>
                <td>
                    教师编号：
                </td>
                 <td>
                    <input class="myinput" v-model="number" placeholder="请输入教师编号">
                </td>
                <td>
                </td>
                  <td>
                   
                </td>
            </tr>
             <tr>
                <td>
                    名字：
                </td>
                 <td>
                    <input class="myinput" v-model="name" placeholder="请输入名字">
                </td>
                  <td>
                </td>
                  <td>
                </td>
            </tr>
             <tr>
                <td>
                    科目：
                </td>
                  <td>
                      <input class="myinput" v-model="subject" placeholder="请输入科目">
                </td>
                <td>
                    电话：
                </td>
                 <td>
                   <input v-model="tel" class="mytel" type="tel" placeholder="请输入电话">
                </td>
                <td>
                     <img class="telImg" src="../../static/imgs/me_kfphone.png" alt="">
                </td>
            </tr>
        </table>
    </div>
    </div>
</template>

<style scoped>
.mytel
{
    width: 90px;
}
.myinput
{
   width: 50px
}
.teachertable
{
    font-size: 10px;
    text-align: right;
    width: 100%;
    height: 100px;
}
.el-upload-dragger
{
    width: 100px !important;
    height: 100px !important;
}
.el-card__body
{
    padding: 2px!important;
}
.teacherDiv
{
    overflow: hidden;
}
.teachImg
{
    width: 100%;
    height: 100px;
}
.upload-demo
{
    width: 100%;
    height: 100%;
}
.setleft
{
    float: left;
    width: 25%; 
}
.setleft2
{
    background-color:lightcyan;
    float: left;
    width: 70%;
   
}
.telImg
{
    width: 20px;
    height: 20px;
}
.setRight
{
    /* float: right; */
}
a
{
    text-decoration: none;
}

</style>


<script>
export default {
  name: 'teacherBlock',
  data () {
    return {
     imgurl:require('../../static/imgs/detail03.png'),
     number:'123',
     name:'大球',
     subject:'英语',
     tel:'12345678998'
    }
  }
}
</script>