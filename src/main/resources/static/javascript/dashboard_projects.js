/*
 * @Author: Jipu Li 
 * @Date: 2022-03-27 15:58:53 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-28 17:14:15
 */
var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: false,
      tagActives: {
        projects: true,
        graphs: false,
        settings: false,
        profiles: false,
      },
      projects: [
        {
          id: 1,
          title: 'Donate food for UK people',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/Foodforall.jpeg',
          progress: 60,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 8.99
        },
        {
          id: 2,
          title: 'Donate food for Asian',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll02.jpeg',
          progress: 20,
          positionName: 'Asia',
          positionLatLng: '',
          charity: 'Asia-Charity',
          price: 7.99
        },
        {
          id: 3,
          title: 'Donate food',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 4,
          title: 'Donate food to America',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 5,
          title: 'Donate food to europe',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 5,
          title: 'Donate food to europe',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 5,
          title: 'Donate food to europe',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 5,
          title: 'Donate food to europe',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/Foodforall.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
        {
          id: 5,
          title: 'Donate food to europe',
          content: 'Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ea repellat aliquam minima iure quo sequi fuga ex assumenda maiores nemo illo dolor repudiandae alias unde saepe obcaecati possimus, nulla consequatur?',
          img: '/FoodforAll03.jpeg',
          progress: 30,
          positionName: 'UK',
          positionLatLng: '',
          charity: 'UK-Charity',
          price: 6
        },
      ]
    }
  },
  methods: {
  }
})