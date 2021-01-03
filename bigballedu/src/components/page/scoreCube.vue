<template>
       <div class="MyAchievement">
            <div class="MyAchievement-echart">
                <div id="leftClass">
                     <input  id="search" class="bar7" type="text" placeholder="请输入身份证或学号..."/><el-button type="primary" id="sbtn" icon="el-icon-search">搜索</el-button>
                     <div id='myName'>姓名：{{name}}</div>
                </div>
                   <div class="echart-title">我的成绩</div>
                   <div class="echart-content">
                        <div id="myChart" :style="{width: '1500px', height: '460px'}"></div>
                   </div>
            </div>
       </div>
</template>
<style scoped>
#myName
{
    clear: both;
}
.bar7 {
		height: 40px;
		margin: 0 auto;
		width:70%;
		border-radius:42px;
		border:2px solid #324B4E;
		background:#F5F5F5;
		padding-left: 20px;
}
#sbtn
{
    width: 20%;
    border-radius:42px;
}
#leftClass >*
{
    float: left;
     
}


</style>
<script>
export default {
    data() {
        return {
           name:'显示实例'
        }
    },
    mounted(){
        this.drawLine();
    },
    methods: {
        drawLine(){
            var myChart = this.$echarts.init(document.getElementById('myChart'));//获取容器元素
            var option = {
                tooltip : {
                    trigger: 'axis'
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                legend: {
                    data:['数学','语文'],
                    left: '6%',
                    top: 'top',
                    itemWidth: 15,//图例图标的宽
                    itemHeight: 15,//图例图标的高
                    textStyle: {
                        color: '#3a6186',
                        fontSize:20,
                    }
                },
                toolbox: {
                    show : true,
                    feature : {
                        magicType : {show: true, type: ['line', 'bar']},
                    },
                    right: '6%',
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['01-01','01-02','01-03','01-04','01-05','01-06','01-07'],
                        splitLine: {show: false},//去除网格分割线
                        axisTick: {//刻度
                            show: false//不显示刻度线
                        },
                        axisLine: {//坐标线
                            lineStyle: {
                                type: 'solid',
                                color: '#e7e7e7',//轴线的颜色
                                width:'2'//坐标线的宽度
                            }
                        },
                        axisLabel: {
                            textStyle: {
                                color: '#3a6186',//坐标值的具体的颜色
                            }
                        },
                        splitLine: {
                            show: false//去掉分割线
                        },
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLine: {//线
                            show: false
                        },
                        axisTick: {//刻度
                            show: false
                        },
                        axisLabel: {
                            textStyle: {
                                color: '#3a6186',//坐标值的具体的颜色
                            }
                        },
                        splitLine: {
                            lineStyle: {
                                color: ['#e7e7e7'],//分割线的颜色
                            }
                        }
                    }
                ],
                series : [
                    {
                        name:'数学',
                        type:'bar',
                        barWidth: 20,
                        data:[20, 35, 55, 60, 120, 150, 140],
                        itemStyle: {
                            normal: {
                                color: '#00abf7',//设置柱子颜色
                                label: {
                                    show: true,//柱子上显示值
                                    position: 'top',//值在柱子上方显示
                                    textStyle: {
                                        color: '#00abf7',//值的颜色
                                        fontSize:16,
                                    }
                                }
                            }
                        },
                    },
                    {
                        name:'语文',
                        type:'bar',
                        barWidth: 20,
                        data:[40, 50, 90, 110, 130, 160, 150],
                        itemStyle: {
                            normal: {
                                color: '#ff4f76',//设置柱子颜色
                                label: {
                                    show: true,//柱子上显示值
                                    position: 'top',//值在柱子上方显示
                                    textStyle: {
                                        color: '#ff4f76',//值的颜色
                                        fontSize:16,
                                    }
                                }
                            }
                        },
                    }
                ]
            };
            //防止越界，重绘canvas
            window.onresize = myChart.resize;
            myChart.setOption(option);//设置option
        }
    }
}
</script>

<style  scoped>
        .MyAchievement{
          display: flex;
          flex-direction: column;
          padding:0px 0px;
        }
        .MyAchievement .MyAchievement-echart{
            width: 100%;
            height: 570px;
            border-radius: 10px;
            border:1px solid #d3d9e9;
            box-shadow: 4px 6px 10px -2px #d3d9e9;
            background-color: #fff;
            display: flex;
            flex-direction: column;
        }
        .MyAchievement[data-v-39e9a4f7]
        
        .MyAchievement-echart .echart-title{
            width: 100%;
            height: 70px;
            background-color: #00abf7;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            font-size: 26px;
            color: #fff;
            text-align: center;
            line-height: 75px;
        }
        .MyAchievement-echart .echart-content{
            width: 100%;
            height: 500px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .echart-content #myChart{
            margin-top: 35px;
        }
</style>