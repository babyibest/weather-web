export const js = `
  function initWeather24h() {
    renderWeather24h()
    var geolocation = new qq.maps.Geolocation("OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77", "myapp");
		var options = { timeout: 8000, accuracy: 1000 };
		var positionNum = 0;
		if (navigator.geolocation) {
			geolocation.getLocation(
				function showPosition(position) {
					positionNum++;
					var lat = position.lat; //纬度
					var lon = position.lng; //经度

					var fc40Url = getWeather40DayApiUrl(lon, lat)
					if (fc40Url) {
						ajax({ url: fc40Url }, function (responseText) {
              var fc1h_24 = getWeather40DayApiFc1h_24(responseText)
							renderWeather24h(fc1h_24)
						})
					} else {
						renderWeather24h()
					}
				}, function showError(error) {
					console.log(error)
				}, options
			)
		} else {
			alert("浏览器不支持地理定位");
		}
  }
  function renderWeather24h(data) {
    data = data || {
      "jh": [
        {
          "ja": "00",
          "jb": "26",
          "jc": "0",
          "jd": "1",
          "je": "27",
          "jf": "201805291000",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "28",
          "jc": "1",
          "jd": "8",
          "je": "31",
          "jf": "201805291100",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "29",
          "jc": "0",
          "jd": "1",
          "je": "30",
          "jf": "201805291200",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "30",
          "jc": "0",
          "jd": "8",
          "je": "29",
          "jf": "201805291300",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "30",
          "jc": "1",
          "jd": "8",
          "je": "27",
          "jf": "201805291400",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "30",
          "jc": "1",
          "jd": "4",
          "je": "26",
          "jf": "201805291500",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "30",
          "jc": "1",
          "jd": "4",
          "je": "25",
          "jf": "201805291600",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "29",
          "jc": "1",
          "jd": "8",
          "je": "24",
          "jf": "201805291700",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "29",
          "jc": "1",
          "jd": "8",
          "je": "24",
          "jf": "201805291800",
          "jg": "0.0"
        },
        {
          "ja": "01",
          "jb": "27",
          "jc": "0",
          "jd": "8",
          "je": "25",
          "jf": "201805291900",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "25",
          "jc": "0",
          "jd": "8",
          "je": "25",
          "jf": "201805292000",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "24",
          "jc": "0",
          "jd": "8",
          "je": "33",
          "jf": "201805292100",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "23",
          "jc": "0",
          "jd": "8",
          "je": "40",
          "jf": "201805292200",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "22",
          "jc": "0",
          "jd": "8",
          "je": "48",
          "jf": "201805292300",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "21",
          "jc": "0",
          "jd": "4",
          "je": "49",
          "jf": "201805300000",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "19",
          "jc": "0",
          "jd": "4",
          "je": "50",
          "jf": "201805300100",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "18",
          "jc": "0",
          "jd": "8",
          "je": "52",
          "jf": "201805300200",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "17",
          "jc": "0",
          "jd": "4",
          "je": "56",
          "jf": "201805300300",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "16",
          "jc": "0",
          "jd": "4",
          "je": "61",
          "jf": "201805300400",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "16",
          "jc": "0",
          "jd": "8",
          "je": "65",
          "jf": "201805300500",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "18",
          "jc": "0",
          "jd": "8",
          "je": "59",
          "jf": "201805300600",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "20",
          "jc": "0",
          "jd": "8",
          "je": "54",
          "jf": "201805300700",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "22",
          "jc": "0",
          "jd": "8",
          "je": "48",
          "jf": "201805300800",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "24",
          "jc": "0",
          "jd": "1",
          "je": "44",
          "jf": "201805300900",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "25",
          "jc": "0",
          "jd": "3",
          "je": "40",
          "jf": "201805301000",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "27",
          "jc": "0",
          "jd": "6",
          "je": "36",
          "jf": "201805301100",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "30",
          "jc": "0",
          "jd": "4",
          "je": "35",
          "jf": "201805301200",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "31",
          "jc": "0",
          "jd": "4",
          "je": "34",
          "jf": "201805301300",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "32",
          "jc": "0",
          "jd": "6",
          "je": "34",
          "jf": "201805301400",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "32",
          "jc": "0",
          "jd": "4",
          "je": "33",
          "jf": "201805301500",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "32",
          "jc": "0",
          "jd": "4",
          "je": "32",
          "jf": "201805301600",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "32",
          "jc": "0",
          "jd": "6",
          "je": "31",
          "jf": "201805301700",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "31",
          "jc": "0",
          "jd": "4",
          "je": "31",
          "jf": "201805301800",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "28",
          "jc": "0",
          "jd": "5",
          "je": "31",
          "jf": "201805301900",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "26",
          "jc": "0",
          "jd": "6",
          "je": "31",
          "jf": "201805302000",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "25",
          "jc": "0",
          "jd": "6",
          "je": "36",
          "jf": "201805302100",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "24",
          "jc": "0",
          "jd": "5",
          "je": "42",
          "jf": "201805302200",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "24",
          "jc": "0",
          "jd": "5",
          "je": "47",
          "jf": "201805302300",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "23",
          "jc": "0",
          "jd": "3",
          "je": "51",
          "jf": "201805310000",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "22",
          "jc": "1",
          "jd": "4",
          "je": "55",
          "jf": "201805310100",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "21",
          "jc": "0",
          "jd": "5",
          "je": "60",
          "jf": "201805310200",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "19",
          "jc": "0",
          "jd": "3",
          "je": "61",
          "jf": "201805310300",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "18",
          "jc": "0",
          "jd": "3",
          "je": "63",
          "jf": "201805310400",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "18",
          "jc": "0",
          "jd": "5",
          "je": "65",
          "jf": "201805310500",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "20",
          "jc": "0",
          "jd": "3",
          "je": "61",
          "jf": "201805310600",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "21",
          "jc": "0",
          "jd": "3",
          "je": "57",
          "jf": "201805310700",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "23",
          "jc": "0",
          "jd": "5",
          "je": "54",
          "jf": "201805310800",
          "jg": "0.0"
        },
        {
          "ja": "00",
          "jb": "25",
          "jc": "0",
          "jd": "3",
          "je": "51",
          "jf": "201805310900",
          "jg": "0.0"
        }
      ]
    }
    console.log(data)
    var renderList = parseFc1h_24(data)
    renderList = renderList.slice(0, 24)

    var c = document.getElementById('w24hContainer')
    var canvas = document.getElementById('w24hConvas')
    var ctx = canvas.getContext('2d')
    var tempImageEl = document.getElementById('w24hWeatherImage')
    var locationImageEl = document.getElementById('w24hDirectionImage')
    var hightTempEl = document.getElementById('w24hHightTemp')
    var lowTempEl = document.getElementById('w24hLowTemp')

    var tempImageMap = {
      '00': { x: 0, y: 0, h: 25, w: 25 },
      '01': { x: 25, y: 0, h: 25, w: 25 },
      '02': { x: 51, y: 0, h: 25, w: 25 },
      '03': { x: 77, y: 0, h: 25, w: 25 },
      '04': { x: 103, y: 0, h: 25, w: 25 },
      '05': { x: 128, y: 0, h: 25, w: 25 },
      '06': { x: 154, y: 0, h: 25, w: 25 },
      '07': { x: 180, y: 0, h: 25, w: 25 },
      '08': { x: 180, y: 0, h: 25, w: 25 },
      '09': { x: 232, y: 0, h: 25, w: 25 },
      '10': { x: 232, y: 0, h: 25, w: 25 },
      '11': { x: 232, y: 0, h: 25, w: 25 },
      '12': { x: 232, y: 0, h: 25, w: 25 },
      '13': { x: 334.5, y: 0, h: 25, w: 25 },
      '14': { x: 360, y: 0, h: 25, w: 25 },
      '15': { x: 386, y: 0, h: 25, w: 25 },
      '16': { x: 412, y: 0, h: 25, w: 25 },
      '17': { x: 438, y: 0, h: 25, w: 25 },
      '18': { x: 463, y: 0, h: 25, w: 25 },
      '19': { x: 489, y: 0, h: 25, w: 25 },
      '20': { x: 515, y: 0, h: 25, w: 25 },
      '21': { x: 180, y: 0, h: 25, w: 25 },
      '22': { x: 180, y: 0, h: 25, w: 25 },
      '23': { x: 232, y: 0, h: 25, w: 25 },
      '24': { x: 232, y: 0, h: 25, w: 25 },
      '25': { x: 232, y: 0, h: 25, w: 25 },
      '26': { x: 334.5, y: 0, h: 25, w: 25 },
      '27': { x: 386, y: 0, h: 25, w: 25 },
      '28': { x: 412, y: 0, h: 25, w: 25 },
      '29': { x: 747, y: 0, h: 25, w: 25 },
      '30': { x: 747, y: 0, h: 25, w: 25 },
      '31': { x: 798, y: 0, h: 25, w: 25 },
      '32': { x: 824, y: 0, h: 25, w: 25 },
      '33': { x: 824, y: 0, h: 25, w: 25 },
      '49': { x: 824, y: 0, h: 25, w: 25 },
      '53': { x: 824, y: 0, h: 25, w: 25 },
      '54': { x: 824, y: 0, h: 25, w: 25 },
      '55': { x: 824, y: 0, h: 25, w: 25 },
      '56': { x: 824, y: 0, h: 25, w: 25 },
      '57': { x: 824, y: 0, h: 25, w: 25 },
      '58': { x: 824, y: 0, h: 25, w: 25 },
      '301': { x: 154, y: 0, h: 25, w: 25 },
      '302': { x: 360, y: 0, h: 25, w: 25 },
    }

    var totalWidth = 960
    var textSize = 12
    var levelRange = 35
    var levelStart = 180

    var tempRange = 60
    var tempStart = 120
    var pointSize = 5
    var width = 40
    var arcRadius = 8
    var tempArcRadius = 5
    var tempColor = 'rgba(255,255,255,0.2)'
    var y = 210
    var baseLineColor = 'rgba(255,255,255,0.4)'
    var textColor = '#fff'
    var pointColor = '#fff'
    var lineColor = '#d4e157'
    var color = 'rgba(245,245,245,0.5)'
    var aColor = 'rgba(155,155,155,0.6)'

    var maxWindLevel = -Infinity
    var maxTemp = -Infinity
    var minTemp = Infinity
    renderList.forEach(function (i) {
      if (i.windLevel > maxWindLevel) {
        maxWindLevel = i.windLevel
      }
      if (i.temp < minTemp) {
        minTemp = i.temp
      }
      if (i.temp > maxTemp) {
        maxTemp = i.temp
      }
    })
    hightTempEl.innerText = maxTemp + '°'
    lowTempEl.innerText = minTemp + '°'
    var tempDiff = Math.abs(maxTemp - minTemp)
    var perTempH = tempRange / tempDiff
    var perLevelH = levelRange / maxWindLevel
    var data = renderList.map(function (d, i) {
      var startX = i * width
      var tempX = startX + width / 2
      var tempY = tempStart - perTempH * (d.temp - minTemp)
      d.tempPoint = {
        x: tempX,
        y: tempY
      }
      var wrapperBottom = tempY - 30
      var wrapperTop = wrapperBottom - textSize * 1.5
      var wrapperHalf = 1.7 * textSize
      d.tempWrapperPoints = {
        0: { x: tempX, y: wrapperBottom + tempArcRadius }, // moveTo
        1: { x: tempX - tempArcRadius, y: wrapperBottom }, // lineTo
        2: { x: tempX - wrapperHalf + tempArcRadius, y: wrapperBottom }, // lineTo
        3: { x: tempX - wrapperHalf, y: wrapperBottom }, // arcTo 1
        4: { x: tempX - wrapperHalf, y: wrapperBottom - tempArcRadius }, // arcTo 2
        5: { x: tempX - wrapperHalf, y: wrapperTop + tempArcRadius }, // lineTo
        6: { x: tempX - wrapperHalf, y: wrapperTop }, // arcTo 1
        7: { x: tempX - wrapperHalf + tempArcRadius, y: wrapperTop }, // arcTo 2
        8: { x: tempX + wrapperHalf - tempArcRadius, y: wrapperTop }, // lineTo
        9: { x: tempX + wrapperHalf, y: wrapperTop }, // arcTo 1
        10: { x: tempX + wrapperHalf, y: wrapperTop + tempArcRadius }, // arcTo 2
        11: { x: tempX + wrapperHalf, y: wrapperBottom - tempArcRadius }, // lineTo
        12: { x: tempX + wrapperHalf, y: wrapperBottom }, // arcTo 1
        13: { x: tempX + wrapperHalf - tempArcRadius, y: wrapperBottom }, // arcTo 2
        14: { x: tempX + tempArcRadius, y: wrapperBottom }, // lineTo
      }
      d.tempImage = {
        sx: tempImageMap[d.weather].x * 2,
        sy: tempImageMap[d.weather].y * 2,
        sw: tempImageMap[d.weather].w * 2,
        sh: tempImageMap[d.weather].h * 2,
        dy: wrapperTop + 0.2 * textSize,
        dx: tempX + 0.2 * textSize,
        dh: textSize * 1.2,
        dw: textSize * 1.2,
      }
      d.tempText = {
        y: wrapperBottom - 0.4 * textSize,
        x: tempX - 1.3 * textSize
      }

      var levelY = levelStart - d.windLevel * perLevelH
      d.levelPoints = {
        0: { x: startX, y: levelStart }, // moveTo
        1: { x: startX, y: levelY + arcRadius }, // lineTo
        2: { x: startX, y: levelY }, // arcTo 1
        3: { x: startX + arcRadius, y: levelY },  // arcTo 2
        4: { x: startX + width - arcRadius, y: levelY }, // lineTo
        5: { x: startX + width, y: levelY }, // arcTo 1
        6: { x: startX + width, y: levelY + arcRadius }, // arcTo 2
        7: { x: startX + width, y: levelStart }, // lineTo
      }
      d.levelImage = {
        x: width * i + textSize * 4 / 5,
        y: levelY - textSize * 4 / 5,
        h: textSize * 1.3,
        w: textSize * 1.3,
      }
      d.textPoint = {
        x: width * (i + 1) - 1.8 * textSize,
        y: levelY - textSize / 2,
      }
      return d
    })
    tempImageEl.onload = function () {
      render(data)
    }
    locationImageEl.onload = function () {
      render(data)
    }
    c.addEventListener('scroll', function (e) {
      var el = e.target
      var sl = el.scrollLeft

      var aIndex = +((sl / (totalWidth - c.offsetWidth)) * (data.length - 1)).toFixed()
      data = data.map(function (i, index) {
        if (index === aIndex) {
          i.a = true
        } else {
          i.a = false
        }
        return i
      })
      render(data)
    })
    render(data)
    function render(data) {
      ctx.clearRect(0, 0, width * data.length, y)
      // base line
      ctx.strokeStyle = baseLineColor
      ctx.lineWidth = 0.5
      ctx.beginPath()
      ctx.moveTo(0, levelStart)
      ctx.lineTo(totalWidth, levelStart)
      ctx.stroke()
      ctx.moveTo(0, tempStart)
      ctx.lineTo(totalWidth, tempStart)
      ctx.stroke()
      ctx.moveTo(0, tempStart - tempRange)
      ctx.lineTo(totalWidth, tempStart - tempRange)
      ctx.stroke()
      for (var i = 0; i < data.length; i += 1) {
        // line
        ctx.strokeStyle = lineColor
        ctx.lineWidth = 3
        if (data[i + 1]) {
          ctx.beginPath()
          ctx.moveTo(data[i].tempPoint.x, data[i].tempPoint.y)
          ctx.lineTo(data[i + 1].tempPoint.x, data[i + 1].tempPoint.y)
          ctx.stroke()
        }
        // line point
        ctx.fillStyle = pointColor
        ctx.beginPath()
        ctx.arc(data[i].tempPoint.x, data[i].tempPoint.y, pointSize, 0, 2 * Math.PI)
        ctx.fill()
        //
        // var x = width * i
        var lp = data[i].levelPoints
        if (data[i].a) {
          ctx.fillStyle = tempColor
          var tp = data[i].tempWrapperPoints
          ctx.moveTo(tp[0].x, tp[0].y)
          ctx.lineTo(tp[1].x, tp[1].y)
          ctx.lineTo(tp[2].x, tp[2].y)
          ctx.arcTo(tp[3].x, tp[3].y, tp[4].x, tp[4].y, tempArcRadius)
          ctx.lineTo(tp[5].x, tp[5].y)
          ctx.arcTo(tp[6].x, tp[6].y, tp[7].x, tp[7].y, tempArcRadius)
          ctx.lineTo(tp[8].x, tp[8].y)
          ctx.arcTo(tp[9].x, tp[9].y, tp[10].x, tp[10].y, tempArcRadius)
          ctx.lineTo(tp[11].x, tp[11].y)
          ctx.arcTo(tp[12].x, tp[12].y, tp[13].x, tp[13].y, tempArcRadius)
          ctx.lineTo(tp[14].x, tp[14].y)
          ctx.fill()

          var ti = data[i].tempImage
          var tt = data[i].tempText
          ctx.drawImage(tempImageEl, ti.sx, ti.sy, ti.sw, ti.sh, ti.dx, ti.dy, ti.dw, ti.dh)
          ctx.fillStyle = textColor
          ctx.fillText(data[i].temp + '°', tt.x, tt.y)

          ctx.fillStyle = aColor
        } else {
          ctx.fillStyle = color
        }
        if (data[i].windLevel !== 0) {
          ctx.beginPath()
          ctx.moveTo(lp[0].x, lp[0].y)
          ctx.lineTo(lp[1].x, lp[1].y)
          ctx.arcTo(lp[2].x, lp[2].y, lp[3].x, lp[3].y, arcRadius)
          ctx.lineTo(lp[4].x, lp[4].y)
          ctx.arcTo(lp[5].x, lp[5].y, lp[6].x, lp[6].y, arcRadius)
          ctx.lineTo(lp[7].x, lp[7].y)
          ctx.fill()

          var li = data[i].levelImage
          ctx.translate(li.x, li.y)
          // ctx.rotate(Math.PI * 315 / 180)
          ctx.rotate(data[i].windAngle)
          ctx.drawImage(locationImageEl, -li.w / 2, -li.h / 2, li.w, li.h)
          ctx.setTransform(1, 0, 0, 1, 0, 0)
        }
        // level text
        ctx.fillStyle = textColor
        ctx.font = textSize + 'px serif'
        if (data[i].windLevel) {
          ctx.fillText(data[i].windLevel + '级', data[i].textPoint.x, data[i].textPoint.y)
        }
        // x text
        var xTextWidth = ctx.measureText(data[i].time).width
        ctx.fillText(data[i].time, width * (i + 0.5) - xTextWidth / 2, levelStart + 1.2 * textSize)
      }
    }
  }

  initWeather24h({})
`
export const html = `
  <div>
    <div class="w24hTitle">
      <span>24小时</span>
    </div>
    <div class="w24hMain">
      <div class="w24hLeft">
        <div>
          <div id="w24hHightTemp"></div>
        </div>
        <div>
          <div id="w24hLowTemp"></div>
        </div>
        <div></div>
      </div>
      <div class="w24hRight" id="w24hContainer">
        <canvas style="width: 960px; height: 200px;" id="w24hConvas" width="960" height="200"></canvas>
      </div>
    </div>
    <img id="w24hWeatherImage" class="w24hHideImage" src="http://oh14ph22t.bkt.clouddn.com/weather1.png" />
    <img id="w24hDirectionImage" class="w24hHideImage" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACqUlEQVRYR8WX/VFUQRDEuyNQIhAjECMAIhAjACJQIxAjECMQIgAiACNQIoAQIIKxflfzrvbe1+6DP26rqKvj7dvt6enpmbO2vLzl+7UIQETsSvok6SiB8531mJ/Xkm5sd9+r8TUBiIgDSd8l8Xkj6Z+ku97pPNtLgDz7Ybu/ZwBoFkBEvJV0JemjpHPbZ9WQJEUE+75K+ivps+2nqfcmAUQE0fyWdM9hc4eMHZ7gzyV9kHRqG9baGMjLbyX9ao16KsKCjYMxEAMGEjmXI6YmymtpSRCI97DP5BgAhPNo+6R28JLnEXEh6Z3tw/K9DQCpdkppd2nOa2CSWcrzqKyOPgCEcmEb8bxoRQTMndimLDdWpmK/ZGENIIV3Z5vSW7Qyui9cDHupeigfrIgISe87syoBULcotXO5Koh0RgyKdzrgz3NBRAQpJtAVyyUAxHfdQn9q5Tgj7gPFASerJ9NAoKsU9QGczdln5peLB/ktUOzMCTjBc88AAHa5oVAOzfxSw0TVNZ+p9FzWyjcBXNne6TMwAJCXI6wpYRLFfoFmLa4ZZ+QdUr06c1EKJsoKEbJwzqqA51LQLMIOSAqqA4DNVttvRFBtpHqggZeUIboAwL1tumd1zZUhBywyooIB2u2o8YykbdyIUvF4NSXSehgMYLu16ljhyDJmtliz9apmlAw8NZoXqn/ICWmtlal2/GD7tJbQFBTNa3LkKgQLq3TZDRObGkjoisyAs10Rn2i8HIHzt1cdSDJXK0HmLNikhxnj4WK00jaSFZQBgs7FePatJdISRLroT8awrPv2obQAgXAAwWSLei9ruijUzuVM1JjO8rG8Fw3CIRVvMjWA6v/6oRSxYvY+Z3lWnbHpl1EvLd0l/LtrRH9yTzdsjNI9xt4iAC30L92zdQD/Ad/kTjA0W8pdAAAAAElFTkSuQmCC"
    />
  </div>
`
export const css = `
    .w24hTitle {
      border-bottom: 1px solid rgba(255, 255, 255, 0.2);
      padding: 6px 12px;
      color: #fff;
      font-size: 0.9rem;
    }

    .w24hMain {
      height: 222px;
      width: 100%;
      position: relative;
    }

    .w24hLeft {
      position: absolute;
      top: 0;
      left: 0;
      width: 35px;
      height: 100%;
    }

    .w24hLeft>div {
      box-sizing: border-box;
      height: 60px;
      border-bottom: 2px solid rgba(255, 255, 255, 0.2);
      transform: translateY(1px);
      position: relative;
    }

    .w24hLeft>div>div {
      position: absolute;
      right: 0;
      bottom: 0;
      color: white;
      font-size: 0.9rem;
      width: 100%;
      text-align: center;
    }

    .w24hRight {
      margin-left: 35px;
      overflow-y: hidden;
      overflow-x: scroll;
    }

    .w24hHideImage {
      display: none;
    }
  `
