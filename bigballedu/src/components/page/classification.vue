<template>
    <div id='bg'>
        <div>
            <img :src="imgurl"/>
        </div>
        <div class="item" v-for=" (item , i) in items" :key="i">
            <a  :href="item.hre">
                 <img class="itemImg" :src="item.url"/>
                <div>{{item.title}}</div>
            </a>   
        </div>
        <div id='btm'>
        </div>
    </div>
   

</template>

<style scoped>
a{
    text-decoration: none;
}
#btm
{

    clear: both;
    height: 200px;
}

#bg{

    background-image: url('../../../static/imgs/bg_03.jpg');
}
.item
{
    float: left;
    width: 48%;
    border: gray dotted 1px;
    margin-top: 10px;
}
.itemImg
{
    width: 100px;
    height: 100px;
}

</style>

<script>
export default {
    
data()
{
    return{
        bgimg:'../../../static/imgs/bg_03.jpg',
        imgurl:'../../../static/imgs/img_02Pro Intro.jpg',
        items:[

                {url:'../../../static/imgs/Bro_Host_Icon01.png',hre:'#/publishAnnouncement',title:'发布公告'},
                  {url:'../../../static/imgs/Bro_Host_Icon02.png',hre:'#/publishAnnouncement',title:'发布新闻'},
                    {url:'../../../static/imgs/Bro_Host_Icon03.png',hre:'#/teacherList',title:'管理教师权限'},
                      {url:'../../../static/imgs/Bro_Host_Icon04.png',hre:'#/studentList',title:'学生列表'},
                        {url:'../../../static/imgs/Bro_Host_Icon05.png',hre:'#/',title:'成绩修改'},
                         {url:'../../../static/imgs/Bro_Host_Icon06.png',hre:'#/',title:'成绩添加'},
                          {url:'../../../static/imgs/Bro_Host_Icon06.png',hre:'#/applyTeacher',title:'教师权限申请'},
                             {url:'../../../static/imgs/Bro_Host_Icon06.png',hre:'#/scoreCube',title:'成绩查询'},
                              {url:'../../../static/imgs/Bro_Host_Icon06.png',hre:'#/publishTeachinformation',title:'发布教师信息'},
                            
        ]
    }
}

}
</script>