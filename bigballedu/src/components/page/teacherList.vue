<template>
    <div>
        <div class="roll3">
			<img class="roll3" :src="imgurl" alt=""/>
		</div>
			<input  id="search" class="bar7" type="text" placeholder="搜索...">
            <teacherBlock></teacherBlock>
    </div>

</template>
<style scoped>
.bar7 {
		height: 40px;
		margin: 0 auto;
		width:90%;
		border-radius:42px;
		border:2px solid #324B4E;
		background:#F5F5F5;
		padding-left: 20px;
		}
        .roll3
        {
            width: 100%;
        }
</style>
<script>
import teacherBlock from '@/components/teacherBlock'
export default {
    data()
    {
      return{
         imgurl:require('../../../static/imgs/img_04test.png')
      }  
    },
    components:{teacherBlock}
}
</script>