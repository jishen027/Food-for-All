/*
 * @Author: Jipu Li 
 * @Date: 2022-03-17 17:44:29 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-17 17:59:07
 */


var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Login Page',
    }
  },
  methods: {
    loginAction() {
      const username = "gh"
      const pwd = "1233"

      const response = fetch("/login", {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        headers: {
          'Content-Type': 'application/json'
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify({ "username": username, "password": pwd }) // body data type must match "Content-Type" header
      }).then(res=>{
        console.log(res)
      }).catch(err=>{
        console.log(err)
      })
    }
  },

})