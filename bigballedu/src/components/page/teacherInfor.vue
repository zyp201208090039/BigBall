<template>
    <div>
        <teacherBlock></teacherBlock>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">个人简介</div>
            </div>
            <div id='conetent'>
                {{conetent}}
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">教学经历</div>
            </div>
            <div id='conetent'>
                {{educationInfo}}
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">成功案例</div>
            </div>
            <div id='conetent'>
                {{secusscase}}
            </div>
        </el-card>

    </div>
</template>

<style scoped>
  .text {
    font-size: 14px;
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
    margin-left: 3px;
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
</style>

<script>
import teacherBlock from '@/components/teacherBlock'
export default {
    data()
    {
        return{conetent:'这是简介内容',educationInfo:'这是教学经历',secusscase:'这是成功案例'}
    },
    components:{teacherBlock}
}
</script>