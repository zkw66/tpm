<script>
  export default {
    name: 'User_stu',
    data(){
      return{
        select_year:'',
        select_term:'',
        select_profession:''
      }
    }
  }
</script>
<template>
  <div class="breadcrumb">
    <el-card class="box-card">
      <el-breadcrumb separator="/">
      <el-breadcrumb-item>管理员</el-breadcrumb-item>
      <el-breadcrumb-item>查看课程大纲</el-breadcrumb-item>
    </el-breadcrumb>
      <div style="margin-top: 40px;">
        <el-select v-model="select_year" slot="prepend" placeholder="学年" >
          <el-option label="2018-2019" value="3"></el-option>
          <el-option label="2019-2020" value="3"></el-option>
          <el-option label="2020-2021" value="3"></el-option>
        </el-select>
        <el-select v-model="select_term" slot="prepend" placeholder="学期" style="margin-left: 20px">
          <el-option label="第一学期" value="first_year"></el-option>
          <el-option label="第二学期" value="second_year"></el-option>
          <el-option label="第三学期" value="third_year"></el-option>
        </el-select>
        <el-select v-model="select_profession" slot="prepend" placeholder="专业" style="margin-left: 20px">
          <el-option label="英语" value="software"></el-option>
          <el-option label="政治" value="computer"></el-option>
          <el-option label="马克思主义基本原理" value="infosafe"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" type="" style="margin-left: 20px">查询</el-button>

      </div>
    </el-card>
  </div>
</template>




