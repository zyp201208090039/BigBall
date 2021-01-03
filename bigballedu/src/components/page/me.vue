<template>
<div id="bg">

<div id="header">
    <div class="lf1">
        <img :src="imgulr"/>
    </div>
    <div class="lf">
        <label>{{name}}</label>
        <label :hidden='!islogin'><a :herf="href">{{login}}</a></label>
    </div>

</div>

<div class="say">
    <h2>个人名言：</h2>
</div>
<div class="say1">
    {{say}}
</div>
  <div class="button" @click="loginFunc">登  录</div>
</div>
</template>

<style scoped>

.button {
    margin-top: 30px;
  width: 100%;
  height: 50px;
  background-color: #2ebd51;
  font-size: rem(15);
  margin-top: rem(20);
  border-radius: rem(2);
  text-align: center;
  vertical-align: middle;
  line-height: 50px;
}
 #header
 {
     background-image: url('../../../static/imgs/default-mem-top_bg1.png');
     background-repeat:no-repeat;
     width: 100%;
     height: 100px;
 }
    img
    {
        width: 100%;
        height: 100%;
        border-radius:50% 
    }
    #bg
    {
        background-color:white;
    }
    .say,.say1
    {

        clear: both;
        text-align: left;
    }
    .say1
    {
         width: 100%;
        height: 100px;
        border: solid 1px grey;
    }
.lf,.lf1
{
    float: left;
}
.lf1
{
    width: 100px;
    height: 100px;
}
</style>

<script>
export default {
    data()
    {
        //
        return{
            imgulr:'../../../static/imgs/melogin.PNG',
            name:'',
            login:'登录',
            islogin:false,
            href:'',
            say:''
        }
    },
    methods:
    {
        loginFunc()
        {
            location.href="#/login"
        }
    }
}
</script>