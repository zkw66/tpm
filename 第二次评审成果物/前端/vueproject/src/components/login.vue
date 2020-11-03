<template>
    <div class="login_container">
        <div class="login_box">
          <div class="login_form">
            <el-form ref="Ref" :model="form" :rules="rules">
              <el-form-item prop="username">
                <el-input v-model="form.username" type="text" placeholder="用户名" clearable prefix-icon="el-icon-user"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input v-model="form.password" type="password" placeholder="密码" clearable prefix-icon="el-icon-lock"></el-input>
              </el-form-item>

              <el-form-item class="btn_sub">
                <el-button type="primary" plain @click="login"  style="width: 100px">登录</el-button>
              </el-form-item>
              <a href="http://localhost:8080/#/welcome" class="normal">访客页面</a>
            </el-form>
          </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      form: {
        username: '',
        password: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 6, max: 11, message: '长度在 6 到 11个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ],
      }
    }
  },
  methods: {
    async login () {
      this.$refs.Ref.validate(async valid =>{
        if (!valid) return;
        const { data: res } = await this.$http.post("login",this.form);
        if(res ==="manager"){
          this.$message.success('欢迎您，管理员' + this.form.username);
          window.sessionStorage.setItem('token',"manager_home")
          this.$router.push({ path: "/Manager_home"});
        }
        else if(res ==="teacher"){
          this.$message.success('欢迎您，课程负责人' + this.form.username);
          window.sessionStorage.setItem('token',"teacher_home")
          this.$router.push({ path: "/Teacher_home"});
        }
        else if(res ==="professor"){
          this.$message.success('欢迎您，专业负责人' + this.form.username);
          window.sessionStorage.setItem('token',"professor_home")
          this.$router.push({ path: "/Professor_home"});
        }else {
          this.$message.error('登录失败');
        }

      })
    },
    register () {
      console.log('register!')
    }
  }
}
</script>

<style scoped>
  .login_container{
    background: linear-gradient(45deg,#F9C058 25%,#FA7560 0,#FA7560 50%,#F9C058 0,#F9C058 75%,#FA7560 0);
    width: 80%;
    height: 100%;
    max-width: 1000px; margin: 0 auto;
  }
  .login_box{
    background-color: #ffffff;
    width: 500px;
    height: 290px;
    left: 50%;
    margin-left: -230px;
    border-radius: 20px;
    box-shadow: 0 0 30px rgba(0,0,0,.1);
    padding: 60px 0 30px 0;
    position: fixed;
    top: 15%;
  }

  .login_form{
    position: absolute;
    top: 80px;
    left: 13%;
    width: 366px;
  }
  .login_form .btn_sub{
    position: absolute;
    right: 0;
  }
  .login_form .forget{
    font-size: 10px;
    position: absolute;
    bottom: -75px;
    right: 0px;
    text-decoration: none;
    color: #acacad;
  }
  .login_form .normal{
    font-size: 10px;
    position: absolute;
    bottom: -75px;
    left: 0px;
    text-decoration: none;
    color: #acacad;
  }
</style>
