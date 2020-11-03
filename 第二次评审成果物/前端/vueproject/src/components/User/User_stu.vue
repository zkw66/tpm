<template>
  <div class="breadcrumb">
    <el-card class="box-card">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>查询</el-breadcrumb-item>
        <el-breadcrumb-item>查询课程信息</el-breadcrumb-item>
      </el-breadcrumb>
      <div style="margin-top: 40px;">
        <el-select v-model="select_year" slot="prepend" placeholder="学年" >
          <el-option label="2016-2017" value="1"></el-option>
          <el-option label="2017-2018" value="2"></el-option>
          <el-option label="2018-2019" value="3"></el-option>
        </el-select>
        <el-select v-model="select_term" slot="prepend" placeholder="学期" style="margin-left: 20px">
          <el-option label="第一学期" value="first_year"></el-option>
          <el-option label="第二学期" value="second_year"></el-option>
        </el-select>
        <el-select v-model="select_profess" slot="prepend" placeholder="专业" style="margin-left: 20px">
          <el-option label="软件工程" value="software"></el-option>
          <el-option label="计算机科学与技术" value="computer"></el-option>
          <el-option label="信息安全" value="infosafe"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" type="primary" style="margin-left: 20px">查询</el-button>

      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'User_stu',
    data(){
      return{
        select_year:'',
        select_term:'',
        select_profess:''
      }
    }
  }
</script>

<style scoped>

</style>
