/*
 * @Author: Abhishek Muttanahalli Nagesh
 * @Date: 2022-03-2
 * @Last Modified by: Abhihek Muttanahalli Nagesh
 * @Last Modified :
 */

var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: true,
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