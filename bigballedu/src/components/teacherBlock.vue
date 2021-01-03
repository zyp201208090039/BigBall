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
                     {{number}}
                </td>
                <td>
                </td>
                  <td>
                      <div><a :href="href">详情>></a></div>
                </td>
            </tr>
             <tr>
                <td>
                    名字：
                </td>
                 <td>
                     {{name}}
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
                      {{subject}}
                </td>
                <td>
                    电话：
                </td>
                 <td>
                     {{tel}}
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
.teachertable
{
    font-size: 12px;
    text-align: right;
    width: 100%;
    height: 100px;
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
.setleft
{
    float: left;
    width: 30%; 
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
     tel:'12345678998',
     href:'#/teacherinfor'
    }
  }
}
</script>