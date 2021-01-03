<template>
  <div>


    <el-card class="box-card">
       <input type="tel" v-model="tell" placeholder="请输入手机号">
        <input type="password" v-model="password" placeholder="请输入密码">
        <div class="button" @click="loginFunc">登  录</div>
        <p class="info">登录即代表同意《大球教育》相关规定</p>
        <p class="login-bottom">
        <span class="no" @click="register">没有账号？注册</span>
        </p>
    </el-card>



   
  </div>
</template>

<script>
export default {
  props: {},
  data () {
    return {
      tell: '',
      password: ''
    };
  },
  mounted () {

  },
  methods: {
    loginFunc () {
      let that = this;
      that.axios({
        url: '192.168.2.102:8082/',
        method: 'post',
        data: {
          phone: that.tell,
          password: that.password
        }
      })
        .then(res => {
          if (res.data.error_code === 0) {
            localStorage.setItem('zt_data', JSON.stringify(res.data.data));
            /* token加入localsion后需要重新配置一下发送头 */
            that.axios.defaults.headers.common['access-token'] = res.data.data.token;
            if (res.data.data.role_type === 1) {
              location.href = '#/user';
            } else {
              location.href = '#/teacher';
            }
          } else {
            alert(res.data.message);
          }
        });
    },
    register: function () {
      location.href = '#/register';
    }
  }
};
</script>

<style scoped >
.box-card {
    width: 100%;
    margin-top: 100px;
  }
input {
  width: 100%;
  height: 50px;
  border-top: 0px solid #fff;
  border-left: 0px solid #fff;
  border-bottom: 1px solid #eaeaea;
  outline: none;
  text-indent: rem(20);
  font-size: rem(15);
  background: #fff;
  box-sizing: border-box;
}
.button {
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
.info {
  font-size: rem(12);
  text-align: center;
  color: #bcbcbc;
  margin-top: rem(10);
}
.login-bottom {
  height: rem(20);
  margin-top: rem(15);
  width: 94%;
  margin-left: 3%;
}
.login-bottom span {
  text-decoration: underline;
  color: #666;
  font-size: rem(12);
  display: inline-block;
}
.forget {
  float: right;
}
.no {
  float: left;
}
</style>
