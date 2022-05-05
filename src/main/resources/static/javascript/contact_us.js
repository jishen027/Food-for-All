/*
 * @Author: Abhishek Muttanahalli Nagesh
 * @Date: 2022-03-2
 * @Last Modified by: Abhihek Muttanahalli Nagesh
 * @Last Modified :
 */
console.log(session)

var app = new Vue({
    el: '#app',
    data() {
        return {
            title: 'Food For All',
            loginState: session.SPRING_SECURITY_CONTEXT.authentication.authenticated,
            tagActives: {
                projects: false,
                graphs: true,
                settings: false,
                profiles: false,
            }
        }
    },
    methods: {}
})