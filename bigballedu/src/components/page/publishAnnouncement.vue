<template>
    <div >
        <h1>发布消息页面</h1>
        <div>
            <table>
                <tr>
                    <td id="clumn1">
                        <div title="点击添加图片"> 
                            <div id="preview_div" style="width: 200px; height: 200px; border: 1px solid #b6ff00; cursor: pointer;" @click="previewFunc();">
                            <img id="preview_img" style="width:100%;height:200px;"/>
                            <input id="upload_img" type="file" style="width:0px;height:0px;" />
                        </div>
                        </div>
                    </td>
                    <td class="btm">
                        <div>类型选择：
                            <select v-model="type">
                                <option v-for=" op in options" :key="op">{{op}}</option>
                            </select>
                        </div>
                       
                        <h1>标题</h1>
                        <input type="text" id="title1" v-model="title" style="width:100%"  placeholder="请输入标题"/>
                    </td>
                </tr>

            </table>
        </div>
      <div>
          <h1>正文内容</h1>
          <el-input
            style="width:100%"
            type="textarea"
            :rows="20"
            placeholder="请输入内容"
            v-model="content">
        </el-input>
      </div>
        <el-button type="success" @click="publish()" class="btn" round>成功按钮</el-button>
    </div>
</template>
<style  scoped>
.btn
{
    margin-top: 10px;
    width: 100%;
}
table
{
    width: 100%;
    text-align: left;
    vertical-align: bottom;
}
#clumn1
{
    width: 20%;
}
.title1
{
    width: 100%;
}
.btm
{
    width: 80%;
    vertical-align: bottom;

    margin-bottom: 0px;
}
</style>

<script>
  var mpreviewFunc,mcreateFileObj;
export default {
    data()
    {
        return {options:['校园公告','学校新闻'],title:'', content:'',type:''}
    },
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
        },
        publish()
        {

            var file= document.getElementById("upload_img").files[0]
        if(file==null)
        {
            alert("还没有选择图片！");
            return
        }
      var api = this.baseUrl;
      let url = api + "/addAnnouncement/";
      var announcement = {};
      announcement.phoneNumber = '123456';
      announcement.title = this.title;
      announcement.content = this.content;
    if(this.title=='发布新闻')
    {
        announcement.type = 'new';
    }
    else
    {
        announcement.type = 'announce';
    }
            var data=new FormData;
			
			
			let stringify = JSON.stringify(announcement);
			data.append("file",document.getElementById("upload_img").files[0]);
			data.append('announce',stringify);



         var title='';
        this.axios.post(url, data,{headers: {'Content-Type': 'multipart/form-data'}})
        .then(function (response) {
          if(response.data.code==100)
          {
              
              title='发布成功';

              alert(title);
          }
          else
          {
               title='发布失败';

                alert(title);

          }


        })
        .catch(function (error) {
         
            alert(error);
        });
 

        }

    },
    mounted(){
        mpreviewFunc=this.previewFunc;
        mcreateFileObj=this.createFileObj;
        this.init();
    }

}
</script>