var ecstatic = require('ecstatic')
var server = require('http').createServer(ecstatic({ 
  root: './src/module',
  handleError: false,
  cache: 'max-age=0',
}))

server.listen('3030', function () {
  console.log('===> listen on 3030')
})