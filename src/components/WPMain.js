export const js = `
  function initWPMain() {
    renderWPMain()
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
							var fc40 = getWeather40DayApiFc40(responseText)
							renderWPMain(fc40)
						})
					} else {
						renderWPMain()
					}
				}, function showError(error) {
					console.log(error)
				}, options
			)
		} else {
			alert("浏览器不支持地理定位");
		}
  }
  function renderWPMain(fc40) {
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
      {
        "001": "00",
        "002": "00",
        "003": "33",
        "004": "18",
        "005": "0",
        "006": "0",
        "007": "6",
        "008": "5",
        "009": "20180530",
        "010": "四月十六",
        "014": "04:50",
        "015": "19:34",
        "016": "星期三",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "22",
        "012": "优",
        "013": "1"
      },
      {
        "001": "00",
        "002": "00",
        "003": "34",
        "004": "20",
        "005": "0",
        "006": "0",
        "007": "5",
        "008": "5",
        "009": "20180531",
        "010": "四月十七",
        "014": "04:50",
        "015": "19:35",
        "016": "星期四",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "31",
        "012": "优",
        "013": "1"
      },
      {
        "001": "00",
        "002": "00",
        "003": "35",
        "004": "21",
        "005": "0",
        "006": "0",
        "007": "5",
        "008": "5",
        "009": "20180601",
        "010": "四月十八",
        "014": "04:49",
        "015": "19:35",
        "016": "星期五",
        "017": "儿童节",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "41",
        "012": "优",
        "013": "1"
      },
      {
        "001": "00",
        "002": "01",
        "003": "35",
        "004": "22",
        "005": "1",
        "006": "0",
        "007": "4",
        "008": "4",
        "009": "20180602",
        "010": "四月十九",
        "014": "04:49",
        "015": "19:36",
        "016": "星期六",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "44",
        "012": "优",
        "013": "1"
      },
      {
        "001": "01",
        "002": "01",
        "003": "33",
        "004": "23",
        "005": "0",
        "006": "0",
        "007": "4",
        "008": "8",
        "009": "20180603",
        "010": "四月二十",
        "014": "04:48",
        "015": "19:37",
        "016": "星期日",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": "1"
      },
      {
        "001": "01",
        "002": "02",
        "003": "33",
        "004": "22",
        "005": "0",
        "006": "0",
        "007": "4",
        "008": "4",
        "009": "20180604",
        "010": "四月廿一",
        "014": "04:48",
        "015": "19:37",
        "016": "星期一",
        "017": "",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": "3"
      },
      {
        "001": "01",
        "002": "01",
        "003": "34",
        "004": "18",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "2",
        "009": "20180605",
        "010": "四月廿二",
        "014": "04:48",
        "015": "19:38",
        "016": "星期二",
        "017": "世界环境日",
        "018": "",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
      {
        "001": "01",
        "002": "02",
        "003": "34",
        "004": "19",
        "005": "0",
        "006": "0",
        "007": "3",
        "008": "1",
        "009": "20180606",
        "010": "四月廿三",
        "014": "04:48",
        "015": "19:39",
        "016": "星期三",
        "017": "",
        "018": "芒种",
        "019": "0.0",
        "020": "0.0",
        "011": "",
        "012": "",
        "013": ""
      },
    ]
    var parsedData = parseFc40(fc40)

    function createTopItem(i, iw) {
      return '<div class="WPMItem" style="min-width: ' + iw + 'px;">\
        <span class="WPMItemDay">'+ i.weekDay + '</span>\
        <span class="WPMItemDate">'+ i.day + '</span>\
        <span class="yb-big '+ i.f12Icon + ' WPMItemImg"></span>\
        <span class="WPMItemWeather">'+ i.f12Weather + '</span>\
      </div>'
    }
    function createBottomItem(i, iw) {
      return '<div class="WPMItem" style="min-width: ' + iw + 'px;">\
        <span class="yb-big '+ i.l12Icon + '"></span>\
        <span class="WPMBotWeather">'+ i.l12Weather + '</span>\
        <span class="WPMBotWind">'+ i.f12WindDirection + '</span>\
        <span class="WPMBotWindClass">'+ i.f12WindSpeed + '</span>\
        <span class="WPMBotBtn" style="background-color:'+ i.statusColor + ';">' + i.status + '</span>\
      </div>'
    }
    function createCanvasBgItem(iw) {
      return '<div class="WPMCanvasBg WPMItem" style="min-width: ' + iw + 'px;"></div>'
    }
    var topContainer = document.getElementById('WPMainTop')
    var bottomContainer = document.getElementById('WPMainBottom')
    var canvasBgContainer = document.getElementById('WPMCbgContainer')
    var canvas = document.getElementById('WPMainCanvas')

    var showData = parsedData.list.slice(0, 15)

    var topHtml = ''
    var bottomHtml = ''
    var canvasBgHtml = ''
    var w = document.getElementById('WPMContainer').offsetWidth
    var itemWidth = w / 6
    for (var i = 0; i < showData.length; i += 1) {
      topHtml += createTopItem(showData[i], itemWidth)
      bottomHtml += createBottomItem(showData[i], itemWidth)
      canvasBgHtml += createCanvasBgItem(itemWidth)
    }
    topContainer.innerHTML = topHtml
    bottomContainer.innerHTML = bottomHtml
    canvasBgContainer.innerHTML = canvasBgHtml

    // canvas.width = canvas.offsetWidth
    canvas.width = w * 15 / 6
    canvas.style.width = (w * 15 / 6) + 'px'
    canvas.height = canvas.offsetHeight
    line(showData, canvas.width, canvas.height, canvas)

    function line(data, totalWidth, totalHeight, canvas) {
      var textSize = 12 // 文字大小

      var cutLineColor = 'rgba(255,255,255,0.6)'
      var textColor = '#efefef' // 文字颜色
      var highLineColor = 'rgb(246,141,59)' // 高线颜色
      var lowLineColor = 'rgb(142,194,242)' // 低线颜色
      var pointSize = 5 // 点大小
      var lineWidth = 2 // 线宽

      var buttom = textSize * 5 // 最低点距底边的距离 文本预留
      var top = textSize * 5 // 最高点在top下 文本预留
      var step = totalWidth / 15 // 两点x间距
      var left = step / 2 // 最左边点在left右边
      var height = totalHeight - top - buttom // 点的绘制范围高度

      var ctx = canvas.getContext('2d')
      // 分割线
      var cutLineRange = height
      var cutLineStep = cutLineRange / 6
      var cutLineStart = top + height + textSize

      ctx.strokeStyle = cutLineColor
      if (ctx.setLineDash) {
        ctx.setLineDash([1, 3])
      }
      ctx.beginPath()
      for (var i = 0; i < 7; i += 1) {
        var currentHeight = cutLineStart - i * cutLineStep
        ctx.moveTo(0, currentHeight)
        ctx.lineTo(totalWidth, currentHeight)
      }
      ctx.stroke()
      if (ctx.setLineDash) {
        ctx.setLineDash([])
      }

      // 点折线
      var max = 0
      var min = 100
      data.forEach(function(i) {
        if (i.high > max) {
          max = i.high
        }
        if (i.low < min) {
          min = i.low
        }
      })
      var diff = max - min
      var perHeight = height / diff // 数据中1在canvas中的高度
      for (var i = 0; i < data.length; i += 1) {
        var x = left + step * i
        data[i].highPoint = {
          x: x,
          y: height - (data[i].high - min) * perHeight + top
        }
        data[i].lowPoint = {
          x: x,
          y: height - (data[i].low - min) * perHeight + top
        }
      }
      ctx.lineWidth = lineWidth
      ctx.font = textSize + 'px sans-serif'
      for (var i = 0; i < data.length; i += 1) {
        ctx.fillStyle = highLineColor
        ctx.strokeStyle = highLineColor
        var x = data[i].highPoint.x
        var y = data[i].highPoint.y
        ctx.beginPath();
        ctx.arc(x, y, pointSize, 0, Math.PI * 2, true);
        ctx.fill();
        ctx.fillStyle = textColor
        ctx.fillText(data[i].high + '℃', x - textSize, y - textSize)
        if (data[i + 1]) {
          var next = data[i + 1].highPoint
          ctx.beginPath();
          ctx.moveTo(x, y);
          ctx.lineTo(next.x, next.y)
          ctx.stroke();
        }
      }
      for (var i = 0; i < data.length; i += 1) {
        ctx.fillStyle = lowLineColor
        ctx.strokeStyle = lowLineColor
        var x = data[i].lowPoint.x
        var y = data[i].lowPoint.y
        ctx.beginPath();
        ctx.arc(x, y, pointSize, 0, Math.PI * 2, true);
        ctx.fill();
        ctx.fillStyle = textColor
        ctx.fillText(data[i].low + '℃', x - textSize, y + textSize * 2)
        if (data[i + 1]) {
          var next = data[i + 1].lowPoint
          ctx.beginPath();
          ctx.moveTo(x, y);
          ctx.lineTo(next.x, next.y)
          ctx.stroke();
        }
      }
    }
  }

  initWPMain()
`
export const html = `
  <div class="WPMainOuter">
    <div class="WPMHeader">
      <span>天气预报</span>
    </div>
    <div style="overflow-x: scroll;" id="WPMContainer">
      <div class="WPMItemOuter" id="WPMainTop">
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
        <div class="WPMItem">
          <span class="WPMItemDay">昨天</span>
          <span class="WPMItemDate">01/16</span>
          <span class="yb-big d01 WPMItemImg"></span>
          <span class="WPMItemWeather">中雪</span>
        </div>
      </div>
      <div class="WPMCanvasContainer">
        <div class="WPMCbgContainer" id="WPMCbgContainer">
          <div class="WPMCanvasBg WPMItem"></div>
          <div class="WPMCanvasBg WPMItem"></div>
          <div class="WPMCanvasBg WPMItem"></div>
          <div class="WPMCanvasBg WPMItem"></div>
          <div class="WPMCanvasBg WPMItem"></div>
          <div class="WPMCanvasBg WPMItem"></div>
        </div>
        <canvas class="WPMChart" id="WPMainCanvas"></canvas>
      </div>
      <div class="WPMBottom" id="WPMainBottom">
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
        <div class="WPMItem">
          <span class="yb-big d01"></span>
          <span class="WPMBotWeather">阴</span>
          <span class="WPMBotWind">北风阿斯顿发大水</span>
          <span class="WPMBotWindClass">3级</span>
          <span class="WPMBotBtn">中度</span>
        </div>
      </div>
    </div>
  </div>
`
export const css = `
    .WPMainOuter {
      font-size: 1rem;
      color: #fff;
    }

    .WPMHeader {
      font-size: 1.3rem;
      padding: 10px 20px;
      border-bottom: 1px solid #999;
    }

    .WPMItemOuter {
      display: flex;
      flex-direction: row;
      /* flex-wrap: wrap; */
    }

    .WPMItem:first-child {
      opacity: 0.5;
    }
    .WPMItem {
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
      align-items: center;
      /* width: 16.66%; */
      /* width: 100px; */
      padding: 20px 10px;
    }

    .WPMItemOuter .WPMItem:nth-child(even) {
      background: rgba(0, 0, 0, 0.2);
    }

    .WPMItemDate {
      margin-top: 10px;
      margin-bottom: 12px;
    }

    .WPMItemImg {
      margin-top: 15px;
    }

    .WPMItemWeather {
      margin-top: 15px;
    }

    .WPMChart {
      height: 250px;
      width: 100%;
      /* background: #fff; */
    }

    .WPMBottom {
      display: flex;
      flex-direction: row;
      /* flex-wrap: wrap; */
    }

    .WPMBotWeather {
      margin-top: 15px;
    }

    .WPMBotWind {
      margin-top: 15px;
      text-align: center;
      font-size: 0.8em;
    }

    .WPMBotWindClass {
      margin-top: 10px;
      font-size: 0.8em;
      color: #bfbfbf;
    }

    .WPMBotBtn {
      margin-top: 15px;
      padding: 3px 5px;
      /* background: #7ec037; */
      text-align: center;
      border-radius: 5px;
      font-size: 0.9em;
      width: 35px;
    }

    .WPMMore {
      text-align: center;
      border-top: 1px solid #999;
      padding: 10px 0;
    }

    .WPMBottom .WPMItem:nth-child(even) {
      background: rgba(0, 0, 0, 0.2);
    }

    .WPMItemDay {
      font-size: 0.9em;
    }

    .WPMItemDate {
      font-size: 0.8em;
      color: #999;
    }

    .WPMCanvasContainer {
      position: relative;
    }

    .WPMCbgContainer {
      position: absolute;
      display: flex;
      flex-direction: row;
      /* flex-wrap: nowrap; */
      top: 0;
      left: 0;
      /* width: 100%; */
      height: 100%;
      z-index: 1;
    }

    .WPMCbgContainer .WPMCanvasBg:nth-child(even) {
      background: rgba(0, 0, 0, 0.2);
    }

    .WPMCanvasBg {
      height: 100%;
    }
  `
