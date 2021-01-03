<template>
    <div>
        

    <div class="teacherDiv">
    <div class="setleft">
                        <div title="点击添加图片"> 
                            <div id="preview_div" style="width: 100%; height: 100px; border: 1px solid #b6ff00; cursor: pointer;" @click="previewFunc();">
                            <img id="preview_img" style="width:100%;height:100%;"/>
                            <input id="upload_img" type="file" style="width:0px;height:0px;" />
                            </div>
                         </div>
    </div>
    <div  class="setleft2">
        <table class="teachertable">
            <tr>
                <td>
                    教师编号：
                </td>
                 <td>
                    <input class="myinput" v-model="number" placeholder="请输入教师编号">
                </td>
                <td>
                </td>
                  <td>
                   
                </td>
            </tr>
             <tr>
                <td>
                    名字：
                </td>
                 <td>
                    <input class="myinput" v-model="name" placeholder="请输入名字">
                </td>
                  <td>
                </td>
                  <td>
                </td>
            </tr>
             <tr>
                <td>
                    科目：
                </td>
                  <td>
                      <input class="myinput" v-model="subject" placeholder="请输入科目">
                </td>
                <td>
                    电话：
                </td>
                 <td>
                   <input v-model="tel" class="mytel" type="tel" placeholder="请输入电话">
                </td>
                <td>
                     <img class="telImg" src="../../../static/imgs/me_kfphone.png" alt="">
                </td>
            </tr>
        </table>
    </div>
    </div>






        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">个人简介</div>
            </div>
            <div id='conetent'>
                <el-input
                class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="conetent">
                </el-input>
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">教学经历</div>
            </div>
            <div id='conetent'>
               <el-input
               class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="educationInfo">
                </el-input>
            </div>
        </el-card>

        <el-card class="box-card">
            <div slot="header" class="clearfix">
            <div id="profile">成功案例</div>
            </div>
            <div id='conetent'>
                 <el-input
                 class="myInput"
                type="textarea"
                :autosize="{ minRows: 2, maxRows: 4}"
                placeholder="请输入内容"
                v-model="secusscase">
                </el-input>
            </div>
        </el-card>
  <el-button class="mybtn" type="success" round>成功按钮</el-button>
    </div>
</template>

<style scoped>


.mytel
{
    width: 90px;
}
.myinput
{
   width: 50px
}
.teachertable
{
    font-size: 10px;
    text-align: right;
    width: 100%;
    height: 100px;
}
.el-upload-dragger
{
    width: 100px !important;
    height: 100px !important;
}
.el-card__body
{
    padding: 2px!important;
}
.teacherDiv
{
    overflow: hidden;
}
.teachImg
{
    width: 100%;
    height: 100px;
}
.upload-demo
{
    width: 100%;
    height: 100%;
}
.setleft
{
    float: left;
    width: 25%; 
}
.setleft2
{
    background-color:lightcyan;
    float: left;
    width: 70%;
   
}
.telImg
{
    width: 20px;
    height: 20px;
}
a
{
    text-decoration: none;
}




  .text {
    font-size: 14px;
  }
  .myInput
  {
      width: 100%;
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
     width: 100%;
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
  .mybtn
  {
      width: 100%;
  }
</style>

<script>
import teacherBlock from '@/components/editTeacherBlock'
 var mpreviewFunc,mcreateFileObj;
export default {
    data()
    {
    return{conetent:'这是简介内容',educationInfo:'这是教学经历',secusscase:'这是成功案例', number:'',
     name:'',
     subject:'',
     tel:''}
    },
    components:{teacherBlock},
    methods:{

 previewFunc()
    {
        document.getElementById("upload_img").click();
    },
    createFileObj(filePath)
    {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(filePath);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(filePath);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(filePath);
        }
        else {
 
        }
        return url;
    },
    init()
    {
             //值改变的话
        document.getElementById("upload_img").onchange = function () {
            var sender = this;
            if (!sender.value.match(/.jpg|.gif|.png|.bmp/i)) {
                alert('图片格式无效！');
                return false;
            }
    
            var objPreviewImg = document.getElementById('preview_img');
            var objPreviewDiv = document.getElementById('preview_div');
    
            if (navigator.userAgent.indexOf("MSIE") > -1) {
                //IE浏览器的话
                try {
                    objPreviewImg.src = this.createFileObj(this.files[0]);
                }
                catch (e) {
                        //ie7中不兼容出错跳到这里
                    this.select();                                  //选择的时候
                    top.parent.document.body.focus();                //如果要嵌套到iframe中进行显示的话，需要加这个将焦点聚到iframe里面
                    this.blur();                                   //必须要加这个
                    var src = document.selection.createRange().text;          //IE 11中改为如下:document.selection ---》  window.getSelection  
                    document.selection.empty();
                    objPreviewImg.style.display = "none";                 //隐藏img控件
                    objPreviewDiv.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    objPreviewDiv.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                }
            } else {
                //chrome firfox都可以
                objPreviewImg.src = mcreateFileObj(this.files[0]);
            }
        }
        }
    
   
    },
    mounted(){
        mpreviewFunc=this.previewFunc;
        mcreateFileObj=this.createFileObj;
        this.init();
    }
}
</script>