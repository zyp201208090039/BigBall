<template>
<div>
     	<input  id="search" class="bar7" type="text" placeholder="搜索..."/>
    <div id="myChart"></div>
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

</style>
<script>
import echarts from 'echarts'	// 引入echarts
export default {
    name: 'LineChart',
    data () {
        return {
            echartsOption: {	// echarts选项，所有绘图数据和样式都在这里设置
                legend: {	//图表上方的图例
                    data: ['腾讯', '阿里巴巴', '华为', '字节跳动']
                },
                xAxis: {
                    type: 'category',
                    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],   // x轴数据
                    name: '日期',   // x轴名称
                    nameTextStyle: {	// x轴名称样式
                        fontWeight: 600,
                        fontSize: 18
                    }
                },
                yAxis: {
	                type: 'value',
	                name: '市值',   // y轴名称
	                nameTextStyle: {	// y轴名称样式
	                    fontWeight: 600,
	                    fontSize: 18
	                }
                },
                tooltip: {   //鼠标放到图上的数据展示样式
                    trigger: 'axis'
                },
                series: [	//每条折线的数据系列
                    {
                        name: '腾讯',
                        data: [820, 932, 901, 934, 1290, 1330, 1320],
                        type: 'line'
                    },
                    {
                        name: '阿里巴巴',
                        data: [620, 711, 823, 934, 1445, 1456, 1178],
                        type: 'line'
                    },
                    {
                        name: '华为',
                        data: [612, 920, 1140, 1160, 1190, 1234, 1321],
                        type: 'line'
                    },
                    {
                        name: '字节跳动',
                        data: [234, 320, 453, 567, 789, 999, 1200],
                        type: 'line'
                    }
                ],
            }
        }
    },
    mounted () {
        let myChart = echarts.init(document.getElementById('myChart'), 'light')	// 初始化echarts, theme为light
        myChart.setOption(this.echartsOption)	// echarts设置选项
    }
}
</script>

<style>
#myChart{
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}
</style>