import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'

import Login from '@/pages/Login'
import Index from '@/pages/Index'
import _404 from '@/pages/404'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name:'login',
      component: Login
    },
    {
      path: '/index',
      name: 'index',
      component: Index
    },
    {
      path: '/404',
      name: '404',
      component: _404
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '*',
      redirect: '/404',
      name: 'notFound',
      hidden: true
    },
  ]
})

// router.beforeEach((to, from, next) => {
//   if (to.name !== 'login') {
//     store.dispatch('_userInfo/getUserInfo').then(res => {
//       store.dispatch('_permissions/getMenus')
//       if (to.name !== 'mock') {
//         next()
//       } else {
//         if (store.getters['_userInfo/checkAdmin']) {
//           next()
//         } else {
//           next(from.path)
//         }
//       }
//     })
//   } else {
//     next()
//   }
// })
