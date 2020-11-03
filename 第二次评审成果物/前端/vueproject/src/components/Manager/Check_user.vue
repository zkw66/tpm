<template>
  <el-card>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item>管理员</el-breadcrumb-item>
      <el-breadcrumb-item>用户信息管理</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="searchForm">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="queryInfo.query" placeholder="请输入用户名" clearable @clear="getUserList"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="" @click="getUserList" icon="el-icon-search">查询</el-button>
        </el-form-item>
        <el-button style="position: absolute; right: 720px" type="" @click="addDialogVisible=true">添加用户</el-button>
      </el-form>



      <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="40%" @close="addDialogClose">
        <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="100px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="addForm.username" ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
              <el-input v-model="addForm.password"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="memorandum">
            <el-input v-model="addForm.memorandum"></el-input>
          </el-form-item>
          <el-form-item label="身份" prop="pid">
            <el-select v-model="addForm.pid" placeholder="请选择">
              <el-option label="课程负责人" value="课程负责人"></el-option>
              <el-option label="专业负责人" value="专业负责人"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addUser">确 认</el-button>
        </div>
      </el-dialog>
      <el-dialog title="修改用户信息" :visible.sync="editDialogVisible" width="50%" @close="editDialogClose">
        <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="100px">
          <el-form-item label="密码" prop="password">
            <el-input v-model="editForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="备注" prop="memorandum">
            <el-input v-model="editForm.memorandum" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="editUserInfo">修 改</el-button>
        </div>
      </el-dialog>
    </div>
    <el-table :header-cell-style="{background:'#808080',color:'#FFFFFF'}" border stripe :data="List" style="width: 100%">
      <el-table-column type="index"  width="180" label="序号" align="center">
      </el-table-column>
      <el-table-column prop="username" label="用户名" width="180" align="center">
      </el-table-column>
      <el-table-column prop="password" label="密码" width="180" align="center">
      </el-table-column>
      <el-table-column prop="pid" label="身份" align="center">
      </el-table-column>
      <el-table-column prop="memorandum" label="备注" align="center">
      </el-table-column>
      <el-table-column label="修改  /  删除" align="center">
        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="编辑信息" placement="top-start">
            <el-button  icon="el-icon-edit" circle @click="showEditDialog(scope.row.username)"></el-button>
          </el-tooltip>
          <el-tooltip class="item" effect="dark" content="删除用户" placement="top-start">
            <el-button type="" icon="el-icon-delete" circle @click="deleteUser(scope.row.username)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageNum"
        :page-sizes="[4]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </el-card>
</template>


<script>
  export default {
    name: 'addUser',
    create(){
      this.getUserList();
    },
    data() {
      return {
        queryInfo:{
          query:'',//查询信息
          pageNum:1,
          pageSize:4
        },
        List:[],
        total:0,
        addDialogVisible:false,
        editDialogVisible:false,
        addForm:{
          username:'',
          password:'',
          memorandum:'',
          pid:''
        },
        editForm:{
          password:'',
          memorandum:''
        },
        addFormRules: {
          username: [
            { required: true, message: '请输入正确用户名', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],
          pid:[
            { required: true, message:'请选择身份', trigger: 'blur' }
          ]
        },
        editFormRules: {
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ]
        },

      }
    },
    methods: {
      async getUserList () {
        const { data: res } = await this.$http.get("findallUser", { params: this.queryInfo })
        this.List = res.data;
        this.total = res.numbers;
      },

      async deleteUser (username) {

        const confirmResult = await this.$confirm('是否永久删除该用户？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).catch(err => err)
        if (confirmResult !== 'confirm') {
          return ;
        }
        const { data: res } = await this.$http.delete("deleteUser?username=" + username);
        if (res !== "success") {
          return this.$message.error("删除失败");
        }
        this.$message.success("删除成功");
        this.getUserList();
      },
      handleSizeChange (newSize) {
        this.queryInfo.pageSize = newSize;
        this.getUserList();
      },
      handleCurrentChange (newPage) {
        this.queryInfo.pageNum = newPage;
        this.getUserList();
      },
      addDialogClose () {
        this.$refs.addFormRef.resetFields();
      },
      editDialogClose () {
        this.$refs.editFormRef.resetFields();
      },
      addUser () {
        this.$refs.addFormRef.validate(async valid => {
          if (!valid) return;
          const { data: res } = await this.$http.post("addUser", this.addForm);
          if (res !== "success") {
            return this.$message.error("添加失败!")
          }
          this.$message.success("添加成功！")
          this.addDialogVisible = false;
          this.getUserList();
        })
      },
      async showEditDialog(username){
        const {data:res} = await this.$http.get("getUpdate?username="+username);
        this.editForm = res;
        this.editDialogVisible = true;
      },
      editUserInfo () {
        this.$refs.editFormRef.validate(async valid => {
          console.log(valid);
          if (!valid) return;

          const { data: res } = await this.$http.put("updateUser", this.editForm);
          console.log(res);
          if (res !== "success") return this.$message.error("修改失败");
          this.$message.success("修改成功");

          this.editDialogVisible = false;
          this.getUserList();
        });
      }
    }
  }
</script>




<style scoped>
  .searchForm{
    margin-top: 40px;
  }
</style>
