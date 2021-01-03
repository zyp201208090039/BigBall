<template>
    <div>
        <teacherBlock></teacherBlock>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">个人简介</div>
            </div>
            <div id='conetent'>
                <el-input
                class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="conetent">
                </el-input>
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">教学经历</div>
            </div>
            <div id='conetent'>
               <el-input
               class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="educationInfo">
                </el-input>
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">成功案例</div>
            </div>
            <div id='conetent'>
                 <el-input
                 class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="secusscase">
                </el-input>
            </div>
        </el-card>
  <el-button class="mybtn" type="success" round>成功按钮</el-button>
    </div>
</template>

<style scoped>
  .text {
    font-size: 14px;
  }
  .myInput
  {
      width: 100%;
  }
#profile,#conetent
{
    text-align: left;
    margin-left: 3px;
}
#conetent
{
     font-size: 12px;
    text-align: left;
     width: 100%;
}
  .item {
    margin-bottom: 18px;
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin-top: 8px;
    width: 100%;
  }
  .mybtn
  {
      width: 100%;
  }
</style>

<script>
import teacherBlock from '@/components/editTeacherBlock'
export default {
    data()
    {
        return{conetent:'这是简介内容',educationInfo:'这是教学经历',secusscase:'这是成功案例'}
    },
    components:{teacherBlock}
}
</script>