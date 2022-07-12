const fs = require('fs')

fs.readdirSync('./').forEach(fn => {
  if (/\.html$/.test(fn)) {
    const content = fs.readFileSync(fn).toString()
    const jsMatch = content.match(/<script>([\s\S]*)<\/script>/)
    const js = jsMatch ? jsMatch[1] : ''
    const htmlMatch = content.match(/<body>([\s\S]*)<\/body>/)
    const html = htmlMatch ? htmlMatch[1] : ''
    const cssMatch = content.match(/<style>([\s\S]*)<\/style>/)
    const css = cssMatch ? cssMatch[1] : ''

    const name = fn.slice(0, fn.length - 5)

    fs.writeFileSync('../components/' + name + '.js', `export const js = \`${js}\`\nexport const html = \`${html}\`\nexport const css = \`${css}\`\n`)
    fs.writeFileSync('../components/' + name + '.css', css)
  }
})