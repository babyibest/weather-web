export const js = `
  initPollutionIndex()
  function initPollutionIndex() {
    rawPollutionChart(180, 360, Date.now())
    var geolocation = new qq.maps.Geolocation("OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77", "myapp");
		var options = { timeout: 8000, accuracy: 1000 };
		var positionNum = 0;
		if (navigator.geolocation) {
			geolocation.getLocation(
				function showPosition(position) {
					positionNum++;
					var lat = position.lat; //纬度
					var lon = position.lng; //经度

          var locationUrl = getLocationApiUrl(lon, lat, 'renderPollutionIndexLocation')
          if (locationUrl) {
            ajax({ url: locationUrl }, eval)
          }
          var fc40Url = getWeather40DayApiUrl(lon, lat)
					if (fc40Url) {
						ajax({ url: fc40Url }, function (responseText) {
							var fc40 = getWeather40DayApiFc40(responseText)
							renderPollutionIndexChart(fc40)
						})
					} else {
						renderPollutionIndexChart()
					}
				}, function showError(error) {
					console.log(error)
				}, options
			)
		} else {
			alert("浏览器不支持地理定位");
		}
  }
  function renderPollutionIndexChart(fc40) {
    fc40 = fc40 || [
      {
        "001": "01",
        "002": "01",
        "003": "31",
        "004": "16",
        "005": "1",
        "006": "0",
        "007": "8",
        "008": "8",
        "009": "20180529",
        "010": "四月十五",
        "014": "04:50",
        "015": "19:33",
        "016": "星期二",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "30",
        "012": "优",
        "013": "1",
        "000": "201805290700"
      },
    ]
    var data = fc40[0]
    rawPollutionChart(+data['011'], 360, Date.now())
  }
  window.renderPollutionIndexLocation = function(res) {
    var cityEl = document.getElementById('pollutionLocation')
    if (res.data && res.data.station) {
      var station = res.data.station
      cityEl.innerText = station.distictcn
    }
  }
  /**
 * 画污染饼状图
 * pollutionIdx Number 污染指数
 * totalPollutionIdx Number 污染总指数
 * updateDate Number 更新时间(毫秒)
*/
  function rawPollutionChart(pollutionIdx, totalPollutionIdx, updateDate) {
    var canvas = document.getElementById('chartCanvas')
    var ctx = canvas.getContext('2d')
    var width = document.getElementById('PollutionChart').offsetWidth
    width = width * 3 / 5
    // var width=document.body.offsetWidth/1.7
    var pollutionRate = pollutionIdx / totalPollutionIdx//污染比例
    canvas.width = width
    canvas.height = width
    // 底圆
    ctx.beginPath()
    ctx.arc(width / 2, width / 2, width / 2.3, 135 / 180 * Math.PI, 45 / 180 * Math.PI)
    ctx.strokeStyle = '#fff'
    ctx.lineWidth = 2
    ctx.stroke()
    // 进度圆
    ctx.beginPath()
    ctx.strokeStyle = '#c14e59'
    ctx.lineWidth = 8
    ctx.arc(width / 2, width / 2, width / 2.3, 135 / 180 * Math.PI, 0.75 * 2 * Math.PI * pollutionRate + 135 / 360 * 2 * Math.PI)
    ctx.stroke()
    // 污染指数
    ctx.fillStyle = '#fff'
    ctx.font = width / 3.5 + 'px sans-serif'
    var textLength = ctx.measureText(pollutionIdx + '').width
    ctx.textBaseline = 'middle'
    ctx.fillText(pollutionIdx + '', width / 2 - textLength / 2, width / 2)
    // 污染情况
    var pollutionStatus = '中度污染'//模拟污染情况
    ctx.font = width / 16 + 'px sans-serif'
    var pollutionStatusLen = ctx.measureText(pollutionStatus + '').width
    ctx.fillText(pollutionStatus + '', width / 2 - pollutionStatusLen / 2, width / 1.25)
    // 更新时间
    updateDate = updateDate.valueOf()
    var temDate = new Date(updateDate)
    var m = temDate.getMonth()
    var d = temDate.getDate()
    var h = temDate.getHours()
    var mi = temDate.getMinutes()
    var s = temDate.getSeconds()
    var dateStr = (m < 9 ? ('0' + (m + 1)) : m) + '-' + (d < 10 ? ('0' + d) : d) + ' ' + (h < 10 ? ('0' + h) : h) + ':' + (mi < 10 ? ('0' + mi) : mi) + ':' + (s < 10 ? ('0' + s) : s) + '更新'
    ctx.font = width / 22 + 'px sans-serif'
    var updateDateLen = ctx.measureText(dateStr + '').width
    ctx.fillStyle = '#999'
    ctx.fillText(dateStr + '', width / 2 - updateDateLen / 2, width / 1.1)
  }
  /**
   * 画污染指标
   * 参数为...[pm2,pm10,co,no2,so2,o3,total]
   * pm2 Number PM2.5
   * pm10 Number PM10
   * co Number CO
   * no2 Number NO2
   * so2 Number SO2
   * o3 Number O3
   * total Number 指标总分
   */
  function drawPollutionValue() {
    var args = [180, 90, 30, 180, 30, 30, 360]
    var chartValue = document.getElementById('chartValue')
    var ctx = chartValue.getContext('2d')
    // var width=document.body.offsetWidth/1.5
    var width = document.getElementById('PollutionChart').offsetWidth
    width = width * 3 / 5
    chartValue.width = width
    chartValue.height = width
    var x = width / 10
    var y = width / 2
    for (var i = 0; i < 6; i++) {
      // 画名称
      var title
      switch (i) {
        case 0:
          title = 'PM2.5'
          break
        case 1:
          title = 'PM10'
          break
        case 2:
          title = 'CO'
          break
        case 3:
          title = 'NO₂'
          break
        case 4:
          title = 'SO₂'
          break
        case 5:
          title = 'O₃'
          break
      }
      if (i < 3) {
        ctx.beginPath()
        ctx.fillStyle = '#999'
        ctx.font = width / 20 + 'px sans-serif'
        var titleLen = ctx.measureText(title).width
        ctx.fillText(title, x - titleLen / 2, width / 8)
        // 画值
        ctx.beginPath()
        ctx.fillStyle = '#fff'
        ctx.font = width / 14 + 'px sans-serif'
        var valLen = ctx.measureText(args[i]).width
        ctx.fillText(args[i], x - valLen / 2, width / 4.35)
        // 画进度条
        ctx.beginPath()
        ctx.moveTo(x - width / 12, width / 3.5)
        ctx.lineTo(x + width / 12, width / 3.5)
        ctx.strokeStyle = '#fff'
        ctx.stroke()
        ctx.beginPath()
        ctx.moveTo(x - width / 12, width / 3.5)
        ctx.lineTo(x + width / 12 - width / 6 * (1 - (args[i] / args[args.length - 1])), width / 3.5)
        ctx.strokeStyle = (args[i] / args[args.length - 1]) >= 0.5 ? '#c14e59' : '#9cca7f'
        ctx.lineWidth = 4
        ctx.stroke()
        ctx.lineWidth = 1
        x += width / 2.5
        i == 2 && (x = width / 10)
      } else {
        ctx.beginPath()
        ctx.fillStyle = '#999'
        ctx.font = width / 20 + 'px sans-serif'
        var titleLen = ctx.measureText(title).width
        ctx.fillText(title, x - titleLen / 2, width / 8 + y)
        // 画值
        ctx.beginPath()
        ctx.fillStyle = '#fff'
        ctx.font = width / 14 + 'px sans-serif'
        var valLen = ctx.measureText(args[i]).width
        ctx.fillText(args[i], x - valLen / 2, width / 4.35 + y)
        // 画进度条
        ctx.beginPath()
        ctx.moveTo(x - width / 12, width / 3.5 + y)
        ctx.lineTo(x + width / 12, width / 3.5 + y)
        ctx.strokeStyle = '#fff'
        ctx.stroke()
        ctx.beginPath()
        ctx.moveTo(x - width / 12, width / 3.5 + y)
        ctx.lineTo(x + width / 12 - width / 6 * (1 - (args[i] / args[args.length - 1])), width / 3.5 + y)
        ctx.strokeStyle = (args[i] / args[args.length - 1]) >= 0.5 ? '#c14e59' : '#9cca7f'
        ctx.lineWidth = 4
        ctx.stroke()
        ctx.lineWidth = 1
        x = x + width / 2.5
      }
    }
  }
  drawPollutionValue(180, 90, 30, 180, 30, 30, 360)
`
export const html = `
  <div class="PollutionOuter">
    <div class="PollutionLocation">
      <div class="PollutionLocationOuter">
        <span class="" id="pollutionLocation">海淀区</span>
        <img class="PollutionLocationIcon" src="../../static/imgs/location_icon.png" alt="">
      </div>
    </div>
    <div class="PollutionChart" id="PollutionChart">
      <canvas id="chartCanvas"></canvas>
    </div>
    <div class="PollutionChart">
      <canvas id="chartValue" class="chartValueCanvas"></canvas>
    </div>
    <div class="PollutionTips">
      <span class="PollutionTipsTxt">温馨提示：空气质量比较糟糕，建议出行做好防护工作。</span>
    </div>
  </div>
`
export const css = `
    .PollutionOuter {
      color: #fff;
      font-size: 1rem;
      padding-top: 10px;
    }

    .PollutionLocation {
      display: flex;
      flex-direction: column;
      align-items: center;
      color: #999;
    }

    .PollutionLocationOuter {
      display: flex;
      flex-direction: row;
      align-items: center;
    }

    .PollutionLocationIcon {
      width: 1rem;
      margin-left: 0.7rem;
    }

    .PollutionChart {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 20px;
    }

    .PollutionTips {
      display: flex;
      flex-direction: column;
      align-items: center;
      color: #999;
      padding: 0 20px;
      margin-bottom: 15px;
    }

    .PollutionTipsTxt {
      width: 75%;
      padding: 2%;
      background: rgba(0, 0, 0, 0.2);
      border-radius: 5px;
      text-align: justify;
    }
  `
