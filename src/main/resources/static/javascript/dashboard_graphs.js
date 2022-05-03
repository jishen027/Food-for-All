/*
 * @Author: Jipu Li 
 * @Date: 2022-03-28 17:56:01 
 * @Last Modified by: Jipu Li
 * @Last Modified time: 2022-05-03 17:05:18
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
      },
      totlaProjects: dashboardData.numOfProjects,
      completedProjects: dashboardData.numOfCompletedProjects,
      totalRevenue: dashboardData.totalRevenue,
    }
  },
  methods: {
  }
})

function ProcessPieChartData(dashboardData) {
  var projects = dashboardData.revenueList
  var dataList = []
  projects.forEach(project => {
    var data = { value: project.revenue, name: project.title }
    dataList.push(data);
  });

  return dataList
}

function RenderPieCharts(data) {
  // pie chart
  var pieDom = document.getElementById("pieChart");
  var myPieChart = echarts.init(pieDom);
  // var app = {};
  var option;
  var pieData = data

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
        data: pieData,
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
}

async function DrawPieChart() {
  var data = await ProcessPieChartData(dashboardData)
  await RenderPieCharts(data)
  
}

function ProcessLineChartData() {
  var lineData = []
  
  return lineData;
}



function RenderLineChart(data) {
  // graph settings
  var lineDom = document.getElementById("lineChart");
  var myLineChart = echarts.init(lineDom);
  var lineData = data

  // var app = {};
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
}

function init() {
  DrawPieChart();
}
window.onload = init

