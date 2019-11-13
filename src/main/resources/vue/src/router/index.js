import Vue from 'vue'
import VueCookie from 'vue-cookie'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import LoginSuccess from '@/components/LoginSuccess'

Vue.use(Router)
Vue.use(VueCookie)

var router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      props: true
      // meta: {authRequired: true}
    },
    {
      path: '/loginSuccess',
      name: 'LoginSuccess',
      component: LoginSuccess
    }
  ]
})

router.beforeEach(function(to, from, next) {
  console.log(to);
  console.log(from);
  
  next();
})

export default router