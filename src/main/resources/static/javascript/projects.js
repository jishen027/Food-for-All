/*
 * @Author: Jipu Li 
 * @Date: 2022-03-20 21:32:20 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-29 00:53:59
 */

console.log(session)

var app = new Vue({
    el: '#app',
    data() {
        return {
            title: 'Food For All',
            loginState: session.SPRING_SECURITY_CONTEXT.authentication.authenticated,
            term: '',
            projects: projects,
            filteredProjects: projects,
        }
    },
    methods: {},
    watch: {
        term: function (term) {
            if (term == '') {
                this.filteredProjects = this.projects
                return
            }
            var sterm = term.toLowerCase()
            var fproject = []
            this.projects.forEach(project => {
                console.log(sterm, project.title.toLowerCase())
                if (project.title.toLowerCase().indexOf(sterm) != -1)
                    fproject.push(project)
            });
            this.filteredProjects = fproject
        }
    }

})