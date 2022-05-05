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
      
  }

})