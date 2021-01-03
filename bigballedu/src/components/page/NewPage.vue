<template>
    <div id="newpage">
        <h1>{{news.title}}</h1>
        <div>发布时间：{{news.publish}}</div>
        <div>
            <h5>
                  {{news.content}}
            </h5>
        </div>
    </div>
</template>
<style scoped>
#newpage
{   margin-top: 0px;
    width: 100%;;
    height: 500px;
    background-image: url(../../../static/imgs/bg_03.jpg);
}

</style>

<script>
export default {
 data()
 {
     return {news:{}}
 },
 mounted()
 {
       let id = this.$route.params.id
       this.$http.get(this.baseUrl+'/getAnnouncementById/'+id)
                    .then(function(res){
                             this.news=res.data.t;
                    },function(){
                        alert('请求失败');
                });

 }
}
</script>