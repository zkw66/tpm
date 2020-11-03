<script>
  export default {
    name: 'addCourse',
    data(){
      return {
        form: {
          number:'',
          name: '',
          credit: '',
          time: '',
          delivery: false,
          type: [],
          desc: '',
          num:''
        }
      }
    },
    methods:{
      create(){
        console.log("create")
      }
    }
  }
</script>



<template>
  <el-card>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>课程管理</el-breadcrumb-item>
      <el-breadcrumb-item>创建课程</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="searchForm">
      <el-form ref="form" :model="form" label-width="100px" style="margin-top:80px">
        <el-form-item label="课程编号">
          <el-input v-model="form.number" style="width: 100px"></el-input>
        </el-form-item>
        <el-form-item label="课程名称">
          <el-input v-model="form.name" style="width: 200px"></el-input>
        </el-form-item>
        <el-form-item label="学分">
          <el-input-number v-model="form.num"  :min="1" :max="6" label="content"></el-input-number>
        </el-form-item>
        <el-form-item label="总学时">
          <el-col :span="10">
            <el-input v-model="form.time" style="width: 100px"></el-input>
          </el-col>
        </el-form-item>


        <el-form-item label="课程性质">
          <el-select v-model="form.type">
            <el-option label="理论课" name="type"></el-option>
            <el-option label="实验课" name="type"></el-option>
          </el-select>

        </el-form-item>
        <el-form-item label="课程描述">
          <el-input type="textarea" v-model="form.desc" style="width: 600px"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="create">确认创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>


