<template>
  <div>
    <el-card class="box-card">
      <el-input v-model="tel" type="tel" placeholder="请输入手机号"></el-input>
      <el-input type="password" v-model="pwd" placeholder="请输入密码"></el-input>
      <el-input type="password" v-model="secondPwd" placeholder="请输入确认密码"></el-input>
      <el-input type="nick" v-model="nick" placeholder="请输入昵称"></el-input>

      <el-button type="success" class="btn" round @click="register()">注册</el-button>
    </el-card>
  </div>
</template>

<style scoped>
.btn {
  width: 100%;
}
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 100%;
}
</style>

<script>
export default {
  data() {
    return {
      tel: "",
      pwd: "",
      secondPwd: "",
      nick: "",
    };
  },
  methods: {
    register() {
      if (this.pwd != this.secondPwd) {
        this.$alert("密码不一致", "警告", {
          confirmButtonText: "确定",
          callback: (action) => {
            this.$message({
              type: "info",
              message: `action: ${action}`,
            });
          },
        });
      }
      var api = this.baseUrl;
      let url = api + "/addUser";
      var user = {};
      user.phoneNumber = this.tel;
      user.pwd = this.pwd;
      user.nick = this.nick;
      user.name = "大球";

      
        this.axios.post(url, user)
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>