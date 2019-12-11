<template>
  <div>

    <el-row class="login-wrapper">

      <el-form :model="loginForm" label-width="auto">
        <el-form-item label="用户名">
          <el-input
            v-model="loginForm.userName"
            placeholder="请输入用户名"
            prefix-icon="el-icon-user"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="密码">
          <el-input
            v-model="loginForm.userPassword"
            placeholder="请输入密码"
            show-password
            prefix-icon="el-icon-unlock"
            autocomplete="off"></el-input>
        </el-form-item>

        <el-col :span="12">
          <el-form-item>
            <el-button @click="submitLogin()">登录</el-button>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-button @click="register">注册</el-button>
        </el-col>

      </el-form>

    </el-row>


    <el-row>
      <el-button @click="login">登录</el-button>
      <el-button @click="test">测试</el-button>
    </el-row>

    <div>
      <!--    <div class="open-button">-->
      <!--      <el-button circle="ture" @click="change"></el-button>-->
      <!--    </div>    -->

      <!--    <el-row>-->
      <!--      &lt;!&ndash;底部图片&ndash;&gt;-->
      <!--      <div>-->
      <!--        <img :src="imgUrl" class="img-bottom">-->
      <!--      </div>-->

      <!--      <el-row>-->
      <!--        <transition name="el-zoom-in-top">-->
      <!--          <div v-show="show2">-->
      <!--            <img :src="imgUrlTop" class="img-door-top">-->
      <!--          </div>-->
      <!--        </transition>-->
      <!--      </el-row>-->

      <!--      <el-row>-->
      <!--        <transition name="el-zoom-in-bottom">-->
      <!--          <div v-show="show2">-->
      <!--            <img :src="imgUrlBottom" class="img-door-bottom">-->
      <!--          </div>-->
      <!--        </transition>-->
      <!--      </el-row>-->
      <!--    </el-row>-->
    </div>


  </div>
</template>


<script>
  import {test} from '@/request/api';

  export default {
    name: "Login",
    data() {
      return {
        loginForm: {
          userName: '',
          userPassword: ''
        },

        show2: true,
        imgUrl: require("@/assets/images/皮卡丘1.jpg"),
        imgUrlTop: require("@/assets/images/喷火龙.jpg"),
        imgUrlBottom: require("@/assets/images/火球鼠.jpg"),

      }
    },
    methods: {

      login() {
        this.$router.push({path: '/index'})
      },
      change() {
        this.show2 = !this.show2
      },
      submitLogin() {
        test.requestList(this.loginForm).then(res => {
          console.log(res.re)
        })
      },
      register() {

      },
      test() {
        var id = 1;
        test.requestList({id}).then(res => {
          console.log(res.re)
        })
      },

    }
  }
</script>


<style scoped>
  .login-wrapper {
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }

  .img-door-top {
    width: 100%;
    height: 50vh;
    vertical-align: middle;
    top: 0px;
    z-index: 2;

  }

  .img-door-bottom {
    width: 100%;
    height: 50vh;
    vertical-align: middle;
    bottom: 0px;
    z-index: 2;

  }

  .open-button {
    position: absolute;
    top: -50vh;
    z-index: 3;
  }

  .img-bottom {
    width: 100vh;
    height: 100vh;
    left: 0px;
    position: absolute;
    z-index: 1;
  }

  .father {
    position: fixed;
    z-index: 0;
  }
</style>
