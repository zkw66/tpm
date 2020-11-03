<script>
  export default {
    name: 'User_stu',
    data(){
      return{
        formInline:{
          number:''
        }
      }
    },
    methods:{
      onSearch(){
        console.log("1111")
      }
    }
  }
</script>



<template>
  <div class="breadcrumb">
    <el-card class="box-card">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>首页</el-breadcrumb-item>
        <el-breadcrumb-item>查询</el-breadcrumb-item>
        <el-breadcrumb-item>编辑维护课程</el-breadcrumb-item>
      </el-breadcrumb>
      <div style="margin-top: 40px;">
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item>
            <el-input v-model="formInline.number" placeholder="请输入课程编号" style="width: 300px"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSearch">查询</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>


