/*
 * @Author: Jipu Li 
 * @Date: 2022-03-28 17:56:01 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-28 18:03:11
 */


var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: false,
      tagActives: {
        projects: false,
        graphs: true,
        settings: false,
        profiles: false,
      }
    }
  },
  methods: {
  }
})