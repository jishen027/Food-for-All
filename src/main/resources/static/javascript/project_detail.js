/*
 * @Author: Jipu Li 
 * @Date: 2022-03-20 21:28:28 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-26 19:31:54
 */

var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: false,
      project: {
        title: 'Donate food for UK people',
        content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
        img: '',
        progress: 60,
        positionName: 'UK',
        positionLatLng: '',
        charity: 'UK-Charity',
        price: 8.99
      }
    }
  },
  methods: {
  }
})

