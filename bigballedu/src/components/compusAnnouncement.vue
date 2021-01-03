<template>
    <div>
            <div  class="announce">
                        <div class="annoucement">校园公告 </div>
                        <div v-for="(a,i) in this.announces" :key="i">
                            <a :href="'#/newpage/'+a.id">
                            <announcemnetItem :item='a' class="item"></announcemnetItem>
                            </a>
                        </div>
            </div>
        <div class="news">
                    <div class="annoucement">学校新闻 </div>
                    <div v-for="(a,i) in this.news " :key="i" >
                        <a :href="'#/newpage/'+a.id">
                        <announcemnetItem :item='a' class="item"></announcemnetItem>
                        </a >
                    </div>
               
        </div>
    </div>
</template>

<style scoped>
.announce
{
    margin-top: 30px;
    border: gray solid 1px;
}
.annoucement
{
text-align: left;
padding-left: 3px;
border:ghostwhite solid 1px;
border-bottom: none;
border-right: none;
border-left: none;
background: #adada9;
}
.item
{
    margin-top: 3px;
    background:#f7f8f9;
}
.news
{
     margin-top: 30px;
     border: gray solid 1px;
}
hr
{
    color: grey;
    opacity:0.4;
}
</style>

<script>
import announcemnetItem from '@/components/announcementItem'
export default {
    data () {
        return {
           announces:[],news:[]
        }
    },
    mounted()
    {
                this.$http.get(this.baseUrl+'/getAllAnnounces')
                    .then(function(res){
                        this.announces=res.data.t;
                    },function(){
                        alert('请求失败');
                });


                   this.$http.get(this.baseUrl+'/getAllNews')
                    .then(function(res){
                       this.news=res.data.t;
                    },function(){
                        alert('请求失败')
                });





    },
    components:{announcemnetItem},
    methods:
    {
        goLink()
        {
            
        }
    }

}
</script>