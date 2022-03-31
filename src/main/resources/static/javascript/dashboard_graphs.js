/*
 * @Author: Jipu Li 
 * @Date: 2022-03-28 17:56:01 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-03-31 12:51:12
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
    text: 'Stacked Line'
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
    text: 'Referer of a Website',
    subtext: 'Fake Data',
    left: 'center'
  },
  tooltip: {
    trigger: 'item'
  },
  series: [
    {
      name: 'Access From',
      type: 'pie',
      radius: '50%',
      data: [
        { value: 1048, name: 'Search Engine' },
        { value: 735, name: 'Direct' },
        { value: 580, name: 'Email' },
        { value: 484, name: 'Union Ads' },
        { value: 300, name: 'Video Ads' }
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