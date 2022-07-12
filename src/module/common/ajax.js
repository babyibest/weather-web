window.ajax = function(data, cb) {
  var xhr = new XMLHttpRequest()

  xhr.open(data.method || 'GET', data.url, true)
  xhr.setRequestHeader('Content-Type', data.contentType || 'application/x-www-form-urlencoded')
  xhr.onload = function () {
    if (xhr.status === 200) {
      cb(xhr.responseText)
    }
  }
  xhr.send()
};