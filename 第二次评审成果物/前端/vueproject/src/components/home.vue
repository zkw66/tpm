<template>
  <el-container>
    <el-header >
      <div>
        <span>轻量级培养方案管理系统</span>
      </div>
      <div>
        <el-button type="goon" @click="logout" round icon="el-icon-refresh-right" >退出</el-button>
      </div>
    </el-header>
    <el-container>
      <el-aside width="300px">
        <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="white"
        text-color="black"
        active-text-color="black"
        unique-opened
        router>
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-search"></i>
            <span>查询</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/User_stu" ><i class="el-icon-tickets"></i>课程信息</el-menu-item>
            <el-menu-item index="/User_foster"><i class="el-icon-date"></i>培养方案</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
      </el-aside>
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
  .whole_container{
    max-width: 1000px; margin: 0 auto;
  }
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
