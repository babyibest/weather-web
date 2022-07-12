(function () {
  // fc40
  var directionMap = {
    0: '无持续风向',
    1: '东北风',
    2: '东风',
    3: '东南风',
    4: '南风',
    5: '西南风',
    6: '西风',
    7: '西北风',
    8: '北风',
    9: '旋转风',
  }
  var windAngleMap = {
    0: '',
    1: 0,
    2: Math.PI * 45 / 180,
    3: Math.PI * 90 / 180,
    4: Math.PI * 135 / 180,
    5: Math.PI,
    6: Math.PI * 225 / 180,
    7: Math.PI * 270 / 180,
    8: Math.PI * 315 / 180,
    9: 0,
  }
  var speedMap = {
    0: '微风',
    1: '3-4级',
    2: '4-5级',
    3: '5-6级',
    4: '6-7级',
    5: '7-8级',
    6: '8-9级',
    7: '9-10级',
    8: '10-11级',
    9: '11-12级',
  }
  var weatherMap = {
    '00': '晴',
    '01': '多云',
    '02': '阴',
    '03': '阵雨',
    '04': '雷阵雨',
    '05': '雷阵雨伴有冰雹',
    '06': '雨夹雪',
    '07': '小雨',
    '08': '中雨',
    '09': '大雨',
    '10': '暴雨',
    '11': '大暴雨',
    '12': '特大暴雨',
    '13': '阵雪',
    '14': '小雪',
    '15': '中雪',
    '16': '大雪',
    '17': '暴雪',
    '18': '雾',
    '19': '冻雨',
    '20': '沙尘暴',
    '21': '小到中雨',
    '22': '中到大雨',
    '23': '大到暴雨',
    '24': '暴雨到大暴雨',
    '25': '大暴雨到特大暴雨',
    '26': '小到中雪',
    '27': '中到大雪',
    '28': '大到暴雪',
    '29': '浮尘',
    '30': '扬沙',
    '301': '雨',
    '302': '雪',
    '31': '强沙尘暴',
    '32': '浓雾',
    '49': '强浓雾',
    '53': '霾',
    '54': '中度霾',
    '55': '重度霾',
    '56': '严重霾',
    '57': '大雾',
    '58': '特强浓雾',
    '97': '雨',
    '98': '雪',
    '99': '',
  }
  var statusColorMap = {
    '优': 'rgb(126,192,15)',
    '良': 'rgb(239,207,27)',
    '轻度': 'rgb(126,192,15)',
    '中度': 'rgb(161,23,11)',
    '重度': 'rgb(101,1,122)',
  }
  function formatDay(t) {
    return t.slice(4, 6) + '/' + t.slice(6, 8)
  }
  var d = new Date()
  var cYear = d.getFullYear()
  var cMonth = d.getMonth()
  var cDate = d.getDate()
  var weekMap = {
    0: '周日',
    1: '周一',
    2: '周二',
    3: '周三',
    4: '周四',
    5: '周五',
    6: '周六',
  }
  var dayMillisecond = 3600 * 1000 * 25
  function formatWeekDay(t) {
    var year = +t.slice(0, 4)
    var month = +t.slice(4, 6) - 1
    var date = +t.slice(6, 8)
    var tDate = new Date()
    tDate.setFullYear(year)
    tDate.setMonth(month)
    tDate.setDate(date)
    var diffMillisecond = Math.abs(d.getTime() - tDate.getTime())
    if (year == cYear && month == cMonth && date == cDate) {
      return '今天'
    } else if (diffMillisecond > 0 && diffMillisecond < dayMillisecond) {
      return '明天'
    } else if (diffMillisecond < 0 && diffMillisecond < dayMillisecond) {
      return '昨天'
    } else {
      return weekMap[tDate.getDay()]
    }
  }
  window.parseFc40 = function(data) {
    var updateTime, airQuality
    var list = data.map(function (i) {
      if (i['000']) { // 201805290700
        updateTime = i['000'].slice(4, 6) + '-' + i['000'].slice(6, 8) + ' ' + i['000'].slice(8, 10) + ':' + i['000'].slice(10, 12)
      }
      var weekDay = formatWeekDay(i['009'])
      if (weekDay === '今天') {
        airQuality = {
          value: i['011'],
          text: i['012'],
        }
      }
      return {
        f12Icon: 'd' + i['001'], // 前12小时天气icon class
        f12Weather: weatherMap[i['001']], // 前12小时天气
        l12Icon: 'd' + i['002'], // 后12小时天气icon class
        l12Weather: weatherMap[i['002']], // 前12小时天气
        high: +i['003'], // 
        low: +i['004'],
        f12WindSpeed: speedMap[i['005']] || '',
        l12WindSpeed: speedMap[i['006']] || '',
        f12WindDirection: directionMap[i['007']] || '',
        l12WindDirection: directionMap[i['008']] || '',
        day: formatDay(i['009']),
        weekDay: weekDay,
        status: i['012'] || '',
        statusColor: statusColorMap[i['012']] || '',
      }
    })
  
    return {
      updateTime: updateTime,
      list: list,
      airQuality: airQuality,
    }
  }
  
  // index3d
  window.parseIndex3d = function(data) {
    var xc, cl, uv, ct, gm, tr, dy, gj
    data.i.forEach(function (i) {
      if (i.i1 === 'xc') xc = i
      if (i.i1 === 'cl') cl = i
      if (i.i1 === 'uv') uv = i
      if (i.i1 === 'ct') ct = i
      if (i.i1 === 'gm') gm = i
      if (i.i1 === 'tr') tr = i
      if (i.i1 === 'dy') dy = i
      if (i.i1 === 'gj') gj = i
    })
    return {
      xc: xc.i4 + '洗车',
      cl: cl.i4 + '晨练',
      uv: '紫外线' + uv.i4,
      ct: ct.i4, // 穿衣指数
      gm: gm.i4 + '感冒',
      tr: '出行' + tr.i4, // 旅游指数
      dy: '钓鱼' + dy.i4,
      gj: gj.i4 + '逛街',
    }
  }
  
  // fc1h_24
  window.parseFc1h_24 = function(data) {
    return data.jh.map(function (i, index) {
      return {
        icon: i.ja,
        weather: i.ja,
        tempText: i.jb + '℃',
        temp: +i.jb,
        time: i.jf.slice(8, 10) + ':' + i.jf.slice(10, 12),
        windDirection: i.jd,
        windAngle: windAngleMap[i.jd],
        windLevel: +i.jc,
        a: index === 0,
      }
    })
  }
})();