export const js = `
  initRainfall2h()
  function initRainfall2h() {
    var res = {
      "time": "2018-05-29 17:00",
      "values": [0, 15, 30, 45, 30, 0, 0, 60, 70, 82, 50, 20, 10, 14, 18, 37, 66, 45, 4, 2, 11, 23, 53, 18, 25],
      "status": "true",
      "times": ["2018-05-29 16:50:00", "2018-05-29 16:55:00", "2018-05-29 17:00:00", "2018-05-29 17:05:00", "2018-05-29 17:10:00", "2018-05-29 17:15:00", "2018-05-29 17:20:00", "2018-05-29 17:25:00", "2018-05-29 17:30:00", "2018-05-29 17:35:00", "2018-05-29 17:40:00", "2018-05-29 17:45:00", "2018-05-29 17:50:00", "2018-05-29 17:55:00", "2018-05-29 18:00:00", "2018-05-29 18:05:00", "2018-05-29 18:10:00", "2018-05-29 18:15:00", "2018-05-29 18:20:00", "2018-05-29 18:25:00", "2018-05-29 18:30:00", "2018-05-29 18:35:00", "2018-05-29 18:40:00", "2018-05-29 18:45:00"],
      "ph": "rain",
      "msg": "十分钟后有小雨，半小时后转中雨"
    }
    var info = document.getElementById('RfInfo')
    info.innerText = res.msg
    var canvas = document.getElementById('Rainfall2hCanvas')
    canvas.width = canvas.offsetWidth
    canvas.height = canvas.offsetHeight
    
    point(res.values, canvas.width, canvas)

    function point(data, totalWidth, canvas) {
      // const totalWidth = 500 // 总宽度
      const textSize = 12 // y轴 文本高度
      const pointSize = 4 // 点直径
      const lineColor = '#bfbfbf' // 竖线颜色
      const textColor = '#efefef' // 文正颜色
      const xColor = '#fff' // x轴颜色

      const xTextSize = textSize * 4 / 5 // x轴文本大小
      const leftWidth = textSize * 5   // 左边使用宽度 y 标记
      const rightWidth = textSize * 2 // 右边间隔
      const levelPad = textSize * 4  // y轴一级长度 无雨-->小雨 小雨-->中雨
      const firstLevel = textSize * 2 // 第一级高度 底-->无雨
      const lastLevel = textSize * 2
      const xStep = (totalWidth - leftWidth - rightWidth) / 24
      const contentHeight = levelPad * 3 + firstLevel + lastLevel
      const yRange = levelPad * 3 + lastLevel
      const pointRaduis = pointSize / 2 + 1

      // const perY = 30 / levelPad // 一级30 小雨到中雨
      const perY = levelPad / 30 // 一级30 小雨到中雨

      var ctx = canvas.getContext('2d');
      ctx.font = textSize + 'px sans-serif'

      ctx.fillStyle = textColor
      ctx.fillText('大雨 ·', 15, lastLevel + textSize / 2)
      ctx.fillText('中雨 ·', 15, lastLevel + levelPad + textSize / 2)
      ctx.fillText('小雨 ·', 15, lastLevel + levelPad * 2 + textSize / 2)
      ctx.fillText('无雨 ·', 15, lastLevel + levelPad * 3 + textSize / 2)
      ctx.strokeStyle = xColor
      ctx.lineWidth = 1
      ctx.beginPath()
      ctx.moveTo(0, contentHeight)
      ctx.lineTo(totalWidth, contentHeight)
      ctx.stroke()

      ctx.font = xTextSize + 'px sans-serif'
      ctx.lineWidth = 1
      const temp = []
      for (let i = 0; i < data.length; i += 1) {
        const item = {
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
          ctx.setLineDash([1, 3])
          ctx.beginPath();
          ctx.moveTo(item.x, item.y - pointRaduis)
          ctx.lineTo(item.x, 0)
          ctx.stroke();
          ctx.setLineDash([])
        } else {
          ctx.setLineDash([1, 3])
          ctx.strokeStyle = lineColor
          ctx.beginPath();
          ctx.moveTo(item.x, contentHeight)
          ctx.lineTo(item.x, item.y + pointRaduis)
          ctx.stroke();

          ctx.setLineDash([])
          ctx.beginPath();
          ctx.arc(item.x, item.y, pointSize, 0, Math.PI * 2, true); // 绘制
          ctx.stroke();
          ctx.setLineDash([1, 3])

          ctx.beginPath();
          ctx.moveTo(item.x, item.y - pointRaduis)
          ctx.lineTo(item.x, 0)
          ctx.stroke();
          ctx.setLineDash([])
        }
        if (item.text) {
          ctx.fillStyle = item.text.c
          const textWidth = ctx.measureText(item.text.t).width
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
`
export const html = `
  <div style="background: rgba(0,0,0,0.7)">
    <canvas style="width: 100%; height: 220px;" id="Rainfall2hCanvas"></canvas>
    <div class="RfInfo" id="RfInfo"></div>
  </div>
`
export const css = `
  .RfInfo {
    font-size: 24px;
    color: #fff;
    text-align: center;
    white-space: nowrap;
    padding-left: 15px;
    overflow: hidden;
    margin-top: 8px;
  }
`
