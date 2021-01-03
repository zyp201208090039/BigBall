<template>
    <div>
        <div>
             <img :src="headerUrl"/>
        </div>
       <div >
           <div class="item" v-for="(item ,i) in Items " :key="i">
               <a href="#/">
                    <div class="lf">
                    <img :src="itemUrl"/>
            </div>
                <div class="lf">
                    <h1>{{item.price}} </h1> 
                    <br>
                    <span>可以领取的抵扣券</span>
                </div>
               </a>
            
           </div>
         
       </div>

    </div>

</template>

<style scoped>
span
{
    color: red;
    text-align: left;
    float: left;
    margin-top: 5px;
}
h1
{
    float: left;
    margin-top: 30px;
    color: red;
    text-align: left;
}
.item
{
    width: 100%;
    height: 150px;
    margin: 10px;
    border: dotted 1px gray;
}
.lf
{
    float: left;
}

</style>

<script>
export default {
    
    data()
    {
        return{

            headerUrl:'../../../static/imgs/coupon-ban.jpg',
            itemUrl:'../../../static/imgs/coupon.png',
            Items:[
                {price:20}

            ]
        }
    }
}
</script>