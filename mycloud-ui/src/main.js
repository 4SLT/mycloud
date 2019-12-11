// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-red/index.css'

//不显示生产者消息
Vue.config.productionTip = false
Vue.prototype.axios = axios

Vue.use(ElementUI)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,//注册router
  components: {App},
  template: '<App/>'
})
