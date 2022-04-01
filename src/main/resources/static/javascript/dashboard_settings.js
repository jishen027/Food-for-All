/*
 * @Author: Jipu Li 
 * @Date: 2022-03-29 16:57:50 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-29 16:58:58
 */

var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: true,
      tagActives: {
        projects: false,
        graphs: false,
        settings: true,
        profiles: false,
      }
    }
  },
  methods: {
  }
})