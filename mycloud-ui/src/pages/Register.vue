<template>

  <div>

    <el-row class="register-wrapper">

      <el-form :model="registerForm" :label-position="right" label-width="80px">

        <el-form-item label="用户名">
          <el-input
            v-model="registerForm.userName"
            placeholder="请输入用户名"
            prefix-icon="el-icon-user"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="密码">
          <el-input
            v-model="registerForm.userPassword"
            placeholder="请输入密码"
            show-password
            prefix-icon="el-icon-unlock"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="手机号">
          <el-input
            v-model="registerForm.phone"
            placeholder="请输入手机号"
            prefix-icon="el-icon-phone"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="邮箱">
          <el-input
            v-model="registerForm.email"
            placeholder="请输入邮箱"
            prefix-icon="el-icon-message"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button @click="submitRegister">注册</el-button>
        </el-form-item>

      </el-form>

    </el-row>


  </div>

</template>

<script>
  import {userLogin} from '@/request/api';

  export default {
    name: "Register",
    data() {
      return {
        registerForm: {
          userName: '',
          userPassword: '',
          email: '',
          phone: '',
        },

      }
    },
    methods: {

      submitRegister() {
        userLogin.register(this.registerForm).then(res => {
          console.log(res.re)

          if (res.status == 0) {
            this.$message(res.re);
            this.$router.push({path: '/login'});
          } else {
            this.$message({
              showClose: true,
              message: res.msg,
              type: 'error'
            });
          }
        })
      },

    }
  }
</script>

<style scoped>
  .register-wrapper {
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }
</style>
