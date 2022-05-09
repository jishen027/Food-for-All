/*
 * @Author: Jipu Li 
 * @Date: 2022-03-17 15:36:48 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-05-09 18:23:46
 */
console.log(session)

var app = new Vue({
    el: '#app',
    data() {
        return {
            title: 'Food For All',
            loginState: session.SPRING_SECURITY_CONTEXT.authentication.authenticated ? true : false,
            projects: [
                projects[0], projects[1], projects[2]
            ]
        }
    },
    methods: {}
})