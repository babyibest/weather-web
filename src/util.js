import { js as commonJs, css as commonCss } from './module/common/output'
import { configJs } from './config'

const styleParser = (style, prepend) => {
  let styleText = prepend || ''
  Object.keys(style).map(key => {
    if (style[key]) {
      styleText += `${key}: ${style[key]};`
    }
  })
  return styleText
}

const moduleHtml = (module) => {
  const styleText = styleParser(module.style, 'width: 100%;')
  return `<div style="${styleText}">${module.html}</div>`
}

export const htmlBuilder = (moduleList, wrapperStyle, backgroundImg) => {
  const jsList = moduleList.map(i => i.js).filter(i => !!i)
  jsList.unshift(commonJs)
  jsList.unshift(configJs)
  const cssList = moduleList.map(i => i.css).filter(i => !!i)
  cssList.unshift(commonCss)
  const html = moduleList.map(moduleHtml).join('\n')
  const css = cssList.join('\n')
  const js = jsList.join('\n')

  return `
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="theme-color" content="#000000">
      <title>App</title>
      <style>
      html, body {
        padding: 0;
        margin: 0;
        width: 100%;
        height: 100%;
      }
      ${css}
      </style>
    </head>
    <body>
      <div style="position: fixed;top: 0;left:0;width: 100%;height: 100%;z-index: -1;background-image: url(${backgroundImg});background-size: 100% 100%;"></div>
      <div style="${styleParser(wrapperStyle, 'height: 100%; width: 100%;')}">
        ${html}
      </div>
    </body>
    <script>
      ${js}
    </script>
  </html>
  `
}