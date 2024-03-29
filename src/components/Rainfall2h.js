export const js = `
  function initRainfall2h() {
    renderRainfall2h()
    var geolocation = new qq.maps.Geolocation("OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77", "myapp");
		var options = { timeout: 8000, accuracy: 1000 };
		var positionNum = 0;
		if (navigator.geolocation) {
			geolocation.getLocation(
				function showPosition(position) {
					positionNum++;
					var lat = position.lat; //纬度
					var lon = position.lng; //经度

					var url = getRainfallApiUrl(lon, lat, 'renderRainfall2h')
					if (url) {
						ajax({ url: url }, eval)
					} else {
						renderRainfall2h()
					}
				}, function showError(error) {
					console.log(error)
				}, options
			)
		} else {
			alert("浏览器不支持地理定位");
		}
  }
  window.renderRainfall2h = function(res) {
    res = res || {
      "time": "2018-05-29 17:00",
      "values": [0, 0.02, 0.02, 0.02, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      "status": "true",
      "times": ["2018-05-29 16:50:00", "2018-05-29 16:55:00", "2018-05-29 17:00:00", "2018-05-29 17:05:00", "2018-05-29 17:10:00", "2018-05-29 17:15:00", "2018-05-29 17:20:00", "2018-05-29 17:25:00", "2018-05-29 17:30:00", "2018-05-29 17:35:00", "2018-05-29 17:40:00", "2018-05-29 17:45:00", "2018-05-29 17:50:00", "2018-05-29 17:55:00", "2018-05-29 18:00:00", "2018-05-29 18:05:00", "2018-05-29 18:10:00", "2018-05-29 18:15:00", "2018-05-29 18:20:00", "2018-05-29 18:25:00", "2018-05-29 18:30:00", "2018-05-29 18:35:00", "2018-05-29 18:40:00", "2018-05-29 18:45:00"],
      "ph": "rain",
      "msg": "十分钟后有小雨，半小时后转中雨"
    }
    res.values = res.values.map(function (v) { return v * 500 })
    var info = document.getElementById('RfInfo')
    info.innerText = res.msg
    var canvas = document.getElementById('Rainfall2hCanvas')
    canvas.width = canvas.offsetWidth
    canvas.height = canvas.offsetHeight

    point(res.values, canvas.width, canvas)

    function point(data, totalWidth, canvas) {
      // var totalWidth = 500 // 总宽度
      var textSize = 12 // y轴 文本高度
      var pointSize = 4 // 点直径
      var lineColor = '#bfbfbf' // 竖线颜色
      var textColor = '#efefef' // 文正颜色
      var xColor = '#fff' // x轴颜色

      var xTextSize = textSize * 5 / 6 // x轴文本大小
      var leftWidth = textSize * 4   // 左边使用宽度 y 标记
      var rightWidth = textSize * 2 // 右边间隔
      var levelPad = textSize * 3.5  // y轴一级长度 无雨-->小雨 小雨-->中雨
      var firstLevel = textSize * 1.8 // 第一级高度 底-->无雨
      var lastLevel = textSize * 2
      var xStep = (totalWidth - leftWidth - rightWidth) / 24
      var contentHeight = levelPad * 3 + firstLevel + lastLevel
      var yRange = levelPad * 3 + lastLevel
      var pointRaduis = pointSize / 2 + 1

      // var perY = 30 / levelPad // 一级30 小雨到中雨
      var perY = levelPad / 30 // 一级30 小雨到中雨

      var ctx = canvas.getContext('2d');
      ctx.font = textSize + 'px sans-serif'

      ctx.fillStyle = textColor
      ctx.fillText('大雨 ·', 10, lastLevel + textSize / 2)
      ctx.fillText('中雨 ·', 10, lastLevel + levelPad + textSize / 2)
      ctx.fillText('小雨 ·', 10, lastLevel + levelPad * 2 + textSize / 2)
      ctx.fillText('无雨 ·', 10, lastLevel + levelPad * 3 + textSize / 2)
      ctx.strokeStyle = xColor
      ctx.lineWidth = 1
      ctx.beginPath()
      ctx.moveTo(0, contentHeight)
      ctx.lineTo(totalWidth, contentHeight)
      ctx.stroke()

      ctx.font = xTextSize + 'px sans-serif'
      ctx.lineWidth = 1
      var temp = []
      for (var i = 0; i < data.length; i += 1) {
        var item = {
          value: data[i],
          y: yRange - data[i] * perY,
          x: leftWidth + xStep * i,
          color: getColor(data[i]),
          isFill: data[i] > 5,
          text: getText(i, textColor),
        }

        if (item.isFill) {
          ctx.strokeStyle = item.color
          ctx.fillStyle = item.color
          ctx.beginPath();
          ctx.moveTo(item.x, contentHeight)
          ctx.lineTo(item.x, item.y)
          ctx.stroke();

          ctx.beginPath();
          ctx.arc(item.x, item.y, pointSize, 0, Math.PI * 2, true); // 绘制
          ctx.fill();

          ctx.strokeStyle = lineColor
          if (ctx.setLineDash) {
            ctx.setLineDash([1, 3])
          }
          ctx.beginPath();
          ctx.moveTo(item.x, item.y - pointRaduis)
          ctx.lineTo(item.x, 0)
          ctx.stroke();
          if (ctx.setLineDash) {
            ctx.setLineDash([])
          }
        } else {
          if (ctx.setLineDash) {
            ctx.setLineDash([1, 3])
          }
          ctx.strokeStyle = lineColor
          ctx.beginPath();
          ctx.moveTo(item.x, contentHeight)
          ctx.lineTo(item.x, item.y + pointRaduis)
          ctx.stroke();

          if (ctx.setLineDash) {
            ctx.setLineDash([])
          }
          ctx.beginPath();
          ctx.arc(item.x, item.y, pointSize, 0, Math.PI * 2, true); // 绘制
          ctx.stroke();
          if (ctx.setLineDash) {
            ctx.setLineDash([1, 3])
          }

          ctx.beginPath();
          ctx.moveTo(item.x, item.y - pointRaduis)
          ctx.lineTo(item.x, 0)
          ctx.stroke();
          if (ctx.setLineDash) {
            ctx.setLineDash([])
          }
        }
        if (item.text) {
          ctx.fillStyle = item.text.c
          var textWidth = ctx.measureText(item.text.t).width
          ctx.fillText(item.text.t, item.x - (textWidth / 2), contentHeight + xTextSize + 2)
        }
      }
    }

    function getColor(value) {
      if (value < 10) {
        return '#e3f2df'
      } else if (value < 20) {
        return '#bbdefb'
      } else if (value < 30) {
        return '#90caf9'
      } else if (value < 40) {
        return '#64b5f6'
      } else if (value < 50) {
        return '#42a5f5'
      } else if (value < 60) {
        return '#2196f3'
      } else if (value < 70) {
        return '#1e88e5'
      } else if (value < 80) {
        return '#1976d2'
      } else if (value < 90) {
        return '#1565c0'
      } else {
        return '#0047a1'
      }
    }
    function getText(index, textColor) {
      if (index === 0) {
        return {
          c: textColor,
          t: '现在'
        }
      } else if (index === 24) {
        return { t: '2h', c: textColor }
      } else if (index === 12) {
        return { t: '1h', c: textColor }
      } else if (index % 2 === 0) {
        return { t: (index / 2) + '0', c: '#999' }
      } else {
        return ''
      }
    }
  }

  initRainfall2h()
`
export const html = `
  <div>
    <canvas style="width: 100%; height: 210px;" id="Rainfall2hCanvas"></canvas>
    <div class="RfInfo" id="RfInfo"></div>
  </div>
`
export const css = `
  .RfInfo {
    font-size: 1.3rem;
    color: #fff;
    text-align: center;
    white-space: nowrap;
    padding-left: 15px;
    overflow: hidden;
    margin-bottom: 12px;
  }
`
