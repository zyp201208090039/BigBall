// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import echarts from 'echarts'  //引入Echarts，
import VueResourse from 'vue-resource'
import axios from 'axios'
Vue.prototype.axios = axios; 
import qs from 'qs';
Vue.prototype.qs = qs 
	
Vue.use(VueResourse);
Vue.prototype.$echarts = echarts  //定义为全局变量

Vue.use(ElementUI)
Vue.config.productionTip = false

Vue.prototype.baseUrl='http://192.168.2.100:8082'



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
