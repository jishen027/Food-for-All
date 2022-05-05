/*
 * @Author: Jipu Li 
 * @Date: 2022-03-20 21:28:28 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-28 23:50:46
 */
var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: true,
      project: {
        id: 1,
        title: 'Donate food for UK people',
        content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
        img: '',
        progress: 60,
        positionName: 'UK',
        positionLatLng: '',
        charity: 'UK-Charity',
        price: 8.99,
        currency: 'USD'
      }
    }
  },
  methods: {
  }
})

