import Vue from 'vue'
import VueCookie from 'vue-cookie'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Main from '@/components/Main'

Vue.use(Router)
Vue.use(VueCookie)

var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main,
      props: true
      // meta: {authRequired: true}
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})

router.beforeEach(function(to, from, next) {  
  next()
})

export default router