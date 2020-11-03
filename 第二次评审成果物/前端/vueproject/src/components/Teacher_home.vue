<template>
  <el-container>
    <el-header height="60px">
      <div>
        <span>轻量级培养方案管理系统</span>
      </div>
      <div>
        <el-button type="danger" @click="logout" round icon="el-icon-refresh-right">退出</el-button>
      </div>
    </el-header>
    <el-container>
      <el-header width="100px">
        <el-menu
          class="el-menu--horizontal"
          @open="handleOpen"
          @close="handleClose"
          background-color="white"
          text-color="black"
          active-text-color="black"
          unique-opened
          router>
              <el-menu-item index="/addCourse" ><i class="el-icon-folder-add"></i>创建课程</el-menu-item>
              <el-menu-item index="/editCourse"><i class="el-icon-edit-outline"></i>编辑课程</el-menu-item>
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
  .el-main{
    background-color: whitesmoke;
  }

</style>
