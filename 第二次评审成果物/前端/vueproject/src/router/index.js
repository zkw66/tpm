import Vue from 'vue'
import VueRouter from 'vue-router'
import login from '../components/login.vue'
import home from '../components/home'
import welcome from '../components/welcome'
import User_stu from '../components/User/User_stu'
import Course_home from '../components/Teacher_home'
import Profess_home from '../components/Professor_home'
import addCourse from '../components/Course/addCourse'
import editCourse from '../components/Course/editInfo'
import exportCourse from '../components/Course/ouputCourse'
import User_develop from '../components/User/User_develop'
import Manager_home from '../components/Manager_home'
import addUser from '../components/Manager/addUser'
import Check_user from '../components/Manager/Check_user'
import Check_course from '../components/Manager/Check_course'


Vue.use(VueRouter)

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: login,meta:{title:'轻量级培养方案管理系统'}},
  { path: '/Manager_home',component: Manager_home,
    children: [
      { path: '/welcome', component: welcome},
      { path: '/addUser', component: addUser},
      { path: '/Check_user', component: Check_user},
      { path: '/Check_course',component: Check_course}
      ]},
  { path: '/Teacher_home',component: Course_home,
    children: [
      { path: '/welcome', component: welcome},
      { path: '/addCourse',component: addCourse},
      { path: '/editCourse',component: editCourse},
      { path: '/exportCourse',component: exportCourse}
    ]
  },
  { path: '/home', component: home ,
    redirect: '/welcome',
    children: [
      { path:'/welcome' ,component:welcome},
      { path: '/User_stu',component: User_stu},
      { path: '/User_develop',component: User_develop}
    ]},
  { path: '/Professor_home',component: Profess_home,
    children: [
      { path: '/welcome', component: welcome}
    ]
  }
]

const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  //项目标题
  if(to.meta.title){
    document.title = to.meta.title
  }

  if(to.path==='/login'||to.path==='/welcome')return next();

  //有问题
  const tokenStr1=window.sessionStorage.getItem('token')
  if (!tokenStr1){
    return next('/login');
  }
  next()
})
export default router
