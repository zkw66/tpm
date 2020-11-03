<template>
  <el-container>
    <el-header height="60px">
      <div>
        <span>轻量级培养方案管理系统</span>
      </div>
      <div>
        <el-button type="danger" @click="logout" round icon="el-icon-refresh-right" plain>退出登录</el-button>
      </div>
    </el-header>
    <el-container>
      <el-header width="100%">
        <el-menu
          class="el-menu--horizontal"
          @open="handleOpen"
          @close="handleClose"
          background-color="white"
          text-color="black"
          active-text-color="black"
          unique-opened
          router
          :collapse-transition="true">

              <el-menu-item index="/Check_user"><i class="el-icon-user"></i>用户信息管理</el-menu-item>
              <el-menu-item index="/Check_course"><i class="el-icon-date"></i>课程大纲</el-menu-item>
              <el-menu-item index=""><i class="el-icon-date"></i>培养方案</el-menu-item>


        </el-menu>
      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>


<script>
  export default {
    name: 'home',
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      logout(){
        window.sessionStorage.clear();
        this.$router.push({ path: "/login"});
      }
    }
  }
</script>


<style scoped>
  .el-header{
    background: lightslategray;
    color: white;
    font-size: 25px;
    align-items: center;
    justify-content: space-between;
    display: flex;
  }
  .el-aside{
    background-color: lightslategray;
    height: 800px;
  }
  .el-main{
    background-color: whitesmoke;
  }
  .el-menu{
    border-right: 0;
  }
</style>
