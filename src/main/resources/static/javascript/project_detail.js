/*
 * @Author: Jipu Li 
 * @Date: 2022-03-20 21:28:28 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-05-09 17:43:13
 */

var app = new Vue({
    el: '#app',
    data() {
        return {
            title: 'Food For All',
            loginState: session.SPRING_SECURITY_CONTEXT.authentication.authenticated? true:false,
            project: project
        }
    },
    methods: {
        shareLink(id){
            const link = "https://api.whatsapp.com/send?text=http%3A%2F%2Flocalhost%3A8000%2Fprojects%2F"+id
            window.location.href = link
        },
    }
});

