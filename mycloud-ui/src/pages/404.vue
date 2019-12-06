<template>

  <div class="app-404">

    <el-row>
      <el-col :span="24">
        <div class="api-404-img">
        </div>
      </el-col>

      <el-col :span="24">
        <h1>Emmmm、迷路了</h1>
      </el-col>

      <el-col :span="24">
        <el-button @click="back">返回首页</el-button>
      </el-col>

    </el-row>

  </div>

</template>

<script>
  export default {
    name: "404"
  }
</script>

<style scoped>
  .app-404 {
    height: 100vh;
    width: 100%;
    background-color: darkorange;
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .api-404-img {
    height: 10vh;
    width: 10vh;
    background-image: url("../assets/images/禁止.png");
    background-size: cover;
  }

  .app-404 h1 {
    margin: 0;
    font-size: 64px;
    font-weight: bolder;
  }
</style>
