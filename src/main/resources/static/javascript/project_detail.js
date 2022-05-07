/*
 * @Author: Jipu Li 
 * @Date: 2022-03-20 21:28:28 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-05-07 17:16:02
 */
var app = new Vue({
    el: '#app',
    data() {
        return {
            title: 'Food For All',
            loginState: session.SPRING_SECURITY_CONTEXT.authentication.authenticated,
            project: project
        }
    },
    methods: {}
})

