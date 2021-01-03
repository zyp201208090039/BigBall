<template>
    <div id="zpxx">
			<div class="jd_header_box">
				招聘信息
			</div>
		    <div class="free"></div>
		<div class="content recruit">

            <h2> 因发展需要，大球教育机构诚聘高三各科优秀教师！</h2>
			  
			<br />
            招聘要求：
            <br />
            1、年龄45岁以下，学历本科以上，研究生或者海外留学背景，特别优秀者，可适当放宽年龄限制；
            <br />
            2、在公立高中、私立高中或者复读学校有3年以上或者至少1轮高三毕业班经验；
            <br />
            3、有中高级或者一级以上教师职称者优先；
            <br />
            4、县市级以上学科带头人、优秀教师或名师，可直接认定；
            <br />
            5、有所在学校学科带头人或者教研组长背景者优先；
            <br />
            6、普通话标准，形象气质好
            <br />
            7、上课模式：小班制教学（28人/班）和一对一教学.
            <br />
            8、工资待遇地方最高。
            <br />
            <p>地址：文化路与英博路交叉口西南角
             各大地图搜索【大球教育】即可导航：
            </p>
            <br />赵老师13033929268
             <br />
            孙老师15138326150（微信同号）
            <img @click="call()" class="tel" width="30px" src="../../../static/imgs/me_kfphone.png" />
        </div>

    </div>
</template>

<style scoped>


#zpxx{background:#fff url(../../../static/imgs/bg_01.jpg) no-repeat left top;  background-size:100%;background-attachment: fixed;}


	.recruit
	{
		height: auto!important;
	}
	.zp
	{   position: fixed;
		width:250px;
		height: 250px;
		margin-left: 10px;
        top: 10px;
	}
  
</style>

<script>
export default {
    methods:{

        call()
		{
			window.location.href = "tel:15138326150";
		}

    }
}
</script>