/*
 * @Author: Jipu Li 
 * @Date: 2022-03-28 17:56:01 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-04-26 12:04:37
 */

var app = new Vue({
  el: '#app',
  data() {
    return {
      title: 'Food For All',
      loginState: true,
      tagActives: {
        projects: false,
        graphs: true,
        settings: false,
        profiles: false,
      }
    }
  },
  methods: {
  }
})

// graph settings
var lineDom = document.getElementById("lineChart");
var myLineChart = echarts.init(lineDom);
var app = {};
var option;
option = {
  title: {
    text: 'Average Income'
  },
  xAxis: {
    type: 'category',
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [150, 230, 224, 218, 135, 147, 260],
      type: 'line'
    }
  ]
};
if (option && typeof option === 'object') {
  myLineChart.setOption(option);
}

// pie chart
var pieDom = document.getElementById("pieChart");
var myPieChart = echarts.init(pieDom);
var app = {};
var option;

option = {
  title: {
    text: 'Projects Income',
    subtext: 'Fake Data',
    left: 'center'
  },
  tooltip: {
    trigger: 'item'
  },
  series: [
    {
      name: 'income calculate by dollar',
      type: 'pie',
      radius: '50%',
      data: [
        { value: 1048, name: 'Project 1' },
        { value: 735, name: 'Project 2' },
        { value: 580, name: 'Project 3' },
        { value: 484, name: 'Project 4' },
        { value: 300, name: 'Project 5' }
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
    }
  ]
};

if (option && typeof option === 'object') {
  myPieChart.setOption(option);
}