import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/page/Home'
import login from '@/components/page/login'
import register from '@/components/page/register'
import teacherList from '@/components/page/teacherList'
import teacherinfor from '@/components/page/teacherInfor'
import editTeacherInfo from '@/components/page/editTeacherInfo'
import scorePage from '@/components/page/scorePage'
import scoreCube from '@/components/page/scoreCube'
import recruit from '@/components/page/recruit'
import normalQuestion from '@/components/page/normalQuestion'
import publishAnnouncement from '@/components/page/publishAnnouncement'
import publishTeachinformation from '@/components/page/publishTeachinformation'
import applyTeacher from '@/components/page/applyTeacher'
import studentlist from '@/components/page/studentlist'
import classification from '@/components/page/classification'
import schoolIntroduce from '@/components/page/schoolIntroduce'
import time from '@/components/page/time'
import me from '@/components/page/me'
import welfare from '@/components/page/welfare'
import NewPage from '@/components/page/NewPage'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/register',
      name: 'register',
      component: register
    },
    {
      path: '/register',
      name: 'register',
      component: register
    } ,
    {
      path: '/teacherList',
      name: 'teacherList',
      component: teacherList
    },
    {
      path: '/teacherinfor',
      name: 'teacherinfor',
      component: teacherinfor
    },
    {
      path: '/scorePage',
      name: 'scorePage',
      component: scorePage
    },
    {
      path: '/scoreCube',
      name: 'scoreCube',
      component: scoreCube
    },
    {
      path: '/recruit',
      name: 'recruit',
      component: recruit
    },
    {
      path: '/normalQuestion',
      name: 'normalQuestion',
      component: normalQuestion
    },
    {
      path: '/publishAnnouncement',
      name: 'publishAnnouncement',
      component: publishAnnouncement
    },
    {
      path: '/editTeacherInfo',
      name: 'editTeacherInfo',
      component: editTeacherInfo
    },
    {
      path: '/publishTeachinformation',
      name: 'publishTeachinformation',
      component: publishTeachinformation
    },
    {
      path: '/applyTeacher',
      name: 'applyTeacher',
      component: applyTeacher
    },
    {
      path: '/studentlist',
      name: 'applyTeacher',
      component: studentlist
    },
    {
      path: '/classification',
      name: 'classification',
      component: classification
    },
    {
      path: '/schoolIntroduce',
      name: 'schoolIntroduce',
      component: schoolIntroduce
    },
    {
      path: '/time',
      name: 'time',
      component: time
    },
    {
      path: '/me',
      name: 'me',
      component: me
    },
    ,
    {
      path: '/welfare',
      name: 'welfare',
      component: welfare
    }
    ,
    {
      path: '/NewPage/:id',
      name: 'NewPage',
      component: NewPage
    }


  ]
})
