<template>
    <div>



        <el-card class="box-card">
         <el-input v-model="name" type="text" placeholder="请输入名字"></el-input>
        <el-input v-model="subject" type="text" placeholder="请输入科目"></el-input> 
         <el-input v-model="number" type="text" placeholder="请输入编号"></el-input>       
        <el-input v-model="tel" type="tel" placeholder="请输入手机号"></el-input>
        <el-input  type="password" v-model="pwd" placeholder="请输入密码"></el-input>
        <el-input  type="password" v-model="secondPwd" placeholder="请输入确认密码"></el-input>

        <el-button type="success" class="btn" round>申请</el-button>
      
        </el-card>




  </div>
      
</template>

<style scoped>

.btn
{
    width: 100%;
}
 .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 100%;

  }
</style>

<script>
export default {
  data() {
    return {
        number:'',
     name:'',
     subject:'',
     tel:'',
     pwd:'',
     secondPwd:''
    }
  }
}
</script>