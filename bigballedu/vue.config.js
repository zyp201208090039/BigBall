devServer: {
    proxy: {  //配置跨域
      '/api':{
        target: 'http://192.168.0.102:8082/',  //这里后台的地址模拟的;应该填写你们真实的后台接口
        changOrigin: true,  //允许跨域
        pathRewrite: {
          '^/api': '' 
        }
      }
    }
  }