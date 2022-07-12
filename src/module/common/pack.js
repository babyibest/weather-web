const fs = require('fs')

const fileNams = fs.readdirSync('./')

const cssList = []
const jsList = []
fileNams.forEach(fn => {
  if (fn === 'pack.js' || fn === 'output.js') return
  if (/^.+\.js$/.test(fn)) {
    const js = fs.readFileSync(fn)
    jsList.push(js.toString())
  }
  if (/^.+\.css$/.test(fn)) {
    const css = fs.readFileSync(fn)
    cssList.push(css.toString())
  }
})

const cssText = `export const css = \`${cssList.join('\n')}\``
const jsText = `export const js = \`${jsList.join('\n')}\``

fs.writeFileSync('output.js', `${cssText}\n${jsText}`)