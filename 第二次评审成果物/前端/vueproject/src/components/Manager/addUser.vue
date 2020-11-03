<script>
  export default {
    name: 'addUser',
    data() {
      return {
        formInline: {
          username: '',
          password:''
        }
      }
    },
    methods: {
      onAdd() {
        console.log('submit!');
      }
    }
  }
</script>
<template>
  <el-card>
  <el-breadcrumb separator="/">
    <el-breadcrumb-item>首页</el-breadcrumb-item>
    <el-breadcrumb-item>用户信息管理</el-breadcrumb-item>
  </el-breadcrumb>
  <div class="searchForm">
    <el-form  :model="formInline" class="demo-form-inline">
      <el-form-item label="用户名">
        <el-input v-model="formInline.username" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="formInline.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="formInline.memorandum" placeholder="备注"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onAdd">添加</el-button>
      </el-form-item>
    </el-form>
  </div>
  </el-card>
</template>



<style scoped>
.searchForm{
  margin-top: 40px;
}
</style>
