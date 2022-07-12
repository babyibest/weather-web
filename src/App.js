import React, { Component } from 'react';
import { SketchPicker } from 'react-color'
import { Card, Row, Col, Layout, Tabs, Button, Popover, Icon, Input, Select, Modal, message } from 'antd'
import { DragSource, DropTarget, DragDropContext } from 'react-dnd'
import HTML5Backend from 'react-dnd-html5-backend'

import './App.css';
import IcityLoc from './assets/城市定位.png'
import { js as commonJs, css as commonCss } from './module/common/output'
import { html as headerHtml, css as headerCss, js as headerJs } from './components/WPHeader'
import { html as mainHtml, css as mainCss, js as mainJs } from './components/WPMain'
import { html as lifeHtml, css as lifeCss, js as lifeJs } from './components/LifeInstructor'
import { html as pollutionHtml, css as pollutionCss, js as pollutionJs } from './components/PollutionIndex'
import { html as predictionHtml, css as predictionCss, js as predictionJs } from './components/PredictionByHour'
import { html as warningHtml, css as warningCss, js as warningJs } from './components/Warning'
import { html as rainfallHtml, css as rainfallCss, js as rainfallJs } from './components/Rainfall2h'
import { html as weather24hHtml, css as weather24hCss, js as weather24hJs } from './components/Weather24h'
import './components/WPHeader.css'
import './components/WPMain.css'
import './components/LifeInstructor.css'
import './components/PollutionIndex.css'
import './components/PredictionByHour.css'
import './components/Warning.css'
import './components/Rainfall2h.css'
import './components/Weather24h.css'
import './assets/icon.css'
import Iweather from './assets/天气预报.png'
import Ilife from './assets/生活指数.png'
import Iair from './assets/空气质量.png'
import IrealTime from './assets/逐小时预报.png'
import Irain from './assets/降水预报.png'
import Iwarn from './assets/预警.png'
import { configJs } from './config'

import styles from './App.less'
import { htmlBuilder } from './util'

import { compose } from 'redux'

const mainColor = 'rgb(245, 159, 22)'

const { Header, Content, Sider } = Layout
const { TabPane } = Tabs
const { Option } = Select


const DRAGTYPE = 'module'

const DragModule = ({
  connectDragSource,
  connectDropTarget,
  isDraging,
  isOver,
  content,
}) => compose(connectDragSource, connectDropTarget)(
  <div
    className="AppDraggable"
    style={{ opacity: isDraging || isOver ? 0 : 1 }}
  >
    {content}
  </div>
)
const dragSource = {
  beginDrag(props) {
    return { id: props.id }
  }
}
const dropTarget = {
  drop(targetProps, monitor) {
    const targetId = targetProps.id;
    const sourceProps = monitor.getItem();
    const sourceId = sourceProps.id;
    if (sourceId !== targetId) {
      targetProps.onDrop({ sourceId, targetId });
    }
  }
}
const DraggableModule = compose(DragSource(DRAGTYPE, dragSource, (connect, monitor) => ({
  connectDragSource: connect.dragSource(),
  isDragging: monitor.isDragging(),
})), DropTarget(DRAGTYPE, dropTarget, (connect, monitor) => ({
  connectDropTarget: connect.dropTarget(),
  isOver: monitor.isOver(),
})))(DragModule)

const getCssStyle = (style) => style.formater ? style.formater(style.value) : (style.unit ? (style.value + style.unit) : style.value)
const getValueCssStyle = (style, value) => style.formater ? style.formater(value) : (style.unit ? (value + style.unit) : value)

const renderStyleOption = ({ data, onStyleChange, onChangeUnit, onShowUnitOption, eventInfo }) =>
  <Row key={data.name} className={styles.styles}>
    <Col span={8} className={styles.styleName}>{data.name}:</Col>
    <Col span={16}>
      <Input size="small" type="text" className={styles.unitInput} disabled={data.disabled} value={data.value} onChange={(e) => onStyleChange(e, data)} />
      <Select
        disabled={data.disabled}
        value={data.unit}
        size="small"
        style={{ width: '32%' }}
        onChange={(e) => onChangeUnit(data, e, eventInfo)}
      >
        {data.unitOption.map(unit => <Option value={unit}>{unit}</Option>)}
      </Select>
    </Col>
  </Row>
const renderColorOption = ({ data, onStyleChange, onHideUnitOption, onShowUnitOption, eventInfo }) =>
  <Row key={data.name} className={styles.styles}>
    <Col span={8} className={styles.styleName} style={{ lineHeight: '50px' }}>{data.name}:</Col>
    <Col span={16} className={styles.styleColorUnits}>
      {data.disabled ?
        <div className={styles.styleColor} /> :
        <div className={styles.styleColor} style={{ backgroundColor: data.value }} onClick={() => onShowUnitOption(data, eventInfo)} />}
      {data.showUnitOption &&
        <div className={styles.styleColorPanel}>
          <SketchPicker
            color={data.value}
            onChangeComplete={(e) => {
              const styleE = { target: { value: `rgba(${e.rgb.r},${e.rgb.g},${e.rgb.b},${e.rgb.a})` } }
              onStyleChange(styleE, data)
            }} />
          <button className={styles.styleColorPanelClose} onClick={() => onHideUnitOption(eventInfo)}>关闭</button>
        </div>}
    </Col>
  </Row>

const moduleDefaultStyle = { 'margin-bottom': '40', 'background': 'rgba(0,0,0,0.5)' }
class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      activeTab: 'style', // module-模块 style-样式
      tabModuleShowIcon: 'picture',  // image-显示图片 profile-只显示文字
      moduleList: [
        { name: '城市定位', component: <img alt="ni" src={IcityLoc} />, html: headerHtml, js: headerJs, css: headerCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        { name: '天气预报', component: <img alt="ni" src={Iweather} />, html: mainHtml, js: mainJs, css: mainCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        { name: '生活指数', component: <img alt="ni" src={Ilife} />, html: lifeHtml, js: lifeJs, css: lifeCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        { name: '空气质量', component: <img alt="ni" src={Iair} />, html: pollutionHtml, js: pollutionJs, css: pollutionCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '逐小时预报', component: <img alt="ni" src={IrealTime} />, html: predictionHtml, js: '', css: predictionCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        { name: '逐小时预报', component: <img alt="ni" src={IrealTime} />, html: weather24hHtml, js: weather24hJs, css: weather24hCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        { name: '降水预报', component: <img alt="ni" src={Irain} />, html: rainfallHtml, js: rainfallJs, css: rainfallCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        {
          name: '预警',
          component: <img alt="ni" src={Iwarn} />,
          html: warningHtml,
          js: warningJs,
          css: warningCss,
          selected: false,
          edit: false,
          style: { 'margin-bottom': '40', 'background': 'rgba(0,0,0,0.5)' },
        },
      ], // [{ name, component, selected }] 所有模块
      moduleStyleSet: [
        { name: '宽', unit: '%', unitOption: ['px', '%'], showUnitOption: false, value: '100', default: '100', disabled: true, styleKey: 'width', render: renderStyleOption },
        { name: '高', unit: '%', unitOption: ['px', '%'], showUnitOption: false, value: '', default: '', disabled: true, styleKey: 'height', render: renderStyleOption },
        { name: '左边边距', unit: 'px', unitOption: ['px', '%'], showUnitOption: false, value: '0', default: '0', disabled: true, styleKey: 'margin-left', render: renderStyleOption },
        { name: '下间距', unit: 'px', unitOption: ['px'], showUnitOption: false, value: '20', default: '20', disabled: true, styleKey: 'margin-bottom', render: renderStyleOption },
        { name: '背景颜色', showUnitOption: false, value: 'rgba(0,0,0,0.2)', default: 'rgba(0,0,0,0.2)', disabled: true, styleKey: 'background-color', render: renderColorOption },
        // {
        //   name: '透明度',
        //   unit: '%', // 当前样式单位
        //   unitOption: ['%'], // 单位选项
        //   showUnitOption: false,
        //   value: '20',  // 样式值
        //   disabled: true,
        //   styleKey: 'opacity', // 样式对应的css名称
        //   formater: (v) => v / 100, // 值转换为css值 修改样式时转化到module style中
        //   unFormater: (v) => v * 100, // 反向转换 选中module时 转换style css 到样式值
        //   render: renderStyleOption,
        // },
      ],
      totalStyleSet: [
        { name: '背景颜色', showUnitOption: false, value: 'rgba(0,0,0,0.2)', default: 'rgba(0,0,0,0.2)', disabled: false, styleKey: 'background-color', render: renderColorOption },
        // {
        //   name: '背景透明度',
        //   unit: '%',
        //   unitOption: ['%'],
        //   showUnitOption: false,
        //   value: '0',
        //   disabled: false,
        //   styleKey: 'background-color',
        //   formater: (v) => `rgba(0,0,0,${+v / 100})`,
        //   render: renderStyleOption,
        // },
      ],
      usingModuleList: [
        // { name: '城市定位', component: <img alt="ni" src={IcityLoc} />, html: headerHtml, js: headerJs, css: headerCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '天气预报', component: <img alt="ni" src={Iweather} />, html: mainHtml, js: mainJs, css: mainCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '生活指数', component: <img alt="ni" src={Ilife} />, html: lifeHtml, js: lifeJs, css: lifeCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '空气质量', component: <img alt="ni" src={Iair} />, html: pollutionHtml, js: pollutionJs, css: pollutionCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '逐小时预报', component: <img alt="ni" src={IrealTime} />, html: weather24hHtml, js: weather24hJs, css: weather24hCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // { name: '降水预报', component: <img alt="ni" src={Irain} />, html: rainfallHtml, js: rainfallJs, css: rainfallCss, selected: false, edit: false, style: { 'margin-bottom': '40px', 'background-color': 'rgba(0,0,0,0.5)' } },
        // {
        //   name: '预警',
        //   component: <img alt="ni" src={Iwarn} />,
        //   html: warningHtml,
        //   js: warningJs,
        //   css: warningCss,
        //   selected: false,
        //   edit: false,
        //   style: { 'margin-bottom': '40', 'background': 'rgba(0,0,0,0.5)' },
        // }
      ], // [{ name, component, style }]使用中模块

      showModuleSeletor: false,
      backgroundImage: '',

      viewWidth: 375,
      viewHeight: 667,
    }
    eval(configJs + commonJs)
  }

  componentDidMount() {
    if (this.state.usingModuleList.length) {
      this.state.usingModuleList.forEach(i => {
        if (i.js) eval(i.js)
      })
    }
  }


  onResetStyle = () => {
    const { moduleList, usingModuleList, totalStyleSet, moduleStyleSet } = this.state
    this.setState({
      moduleList: moduleList.map(i => {
        i.style = { ...moduleDefaultStyle }
        return i
      }),
      usingModuleList: usingModuleList.map(i => {
        i.style = { ...moduleDefaultStyle }
        return i
      }),
      totalStyleSet: totalStyleSet.map(i => {
        i.value = i.default
        return i
      }),
      moduleStyleSet: moduleStyleSet.map(i => {
        i.value = i.default
        return i
      }),
    })
  }
  onExportHtml = () => {
    const { usingModuleList, totalStyleSet, backgroundImage } = this.state
    const wrapperStyle = totalStyleSet.reduce((acc, cur) => ({
      ...acc,
      [cur.styleKey]: getCssStyle(cur)
    }), {})
    const html = htmlBuilder(usingModuleList, wrapperStyle, backgroundImage)
    var aLink = document.createElement('a')
    var blob = new Blob([html])
    var evt = document.createEvent("MouseEvents")
    evt.initEvent("click", false, false)
    aLink.download = 'export.html'
    aLink.href = URL.createObjectURL(blob)
    aLink.dispatchEvent(evt)
  }
  onShowSelector = () => {
    if (this.state.backgroundImage) {
      this.setState({ showModuleSeletor: true })
    } else {
      message.info('请先选择背景图')
    }
  }
  onCloseSelector = () => {
    this.setState({ showModuleSeletor: false })
  }
  onUsingModuleChange = (e, module) => {
    const newList = this.state.moduleList.map(i => {
      if (i.name === module.name) {
        i.selected = e.target.checked
        i.edit = false
      }
      return i
    })
    const usingList = newList.filter(i => i.selected)
    this.setState({
      moduleList: newList,
      usingModuleList: usingList,
    }, () => {
      usingList.forEach(i => {
        if (i.js) eval(i.js)
      })
    })
  }
  onChangeTab = (tab) => {
    this.setState({ activeTab: tab })
  }
  onShowUnitOption = (style, styleSetType) => {
    const styleSet = this.state[styleSetType]
    const { name } = style
    this.setState({
      [styleSetType]: styleSet.map(i => {
        if (i.name === name) {
          i.showUnitOption = true
        } else {
          i.showUnitOption = false
        }
        return i
      }),
    })
  }
  // 只隐藏单位选项 用于 背景色 等
  onHideUnitOption = (styleSetType) => {
    this.setState({
      [styleSetType]: this.state[styleSetType].map(i => {
        i.showUnitOption = false
        return i
      })
    })
  }
  // 修改单位并隐藏单位选项
  onChangeUnit = (style, unit, styleSetType) => {
    const styleSet = this.state[styleSetType]
    const { name } = style
    this.setState({
      [styleSetType]: styleSet.map(i => {
        if (i.name === name) {
          i.unit = unit
        }
        i.showUnitOption = false
        return i
      }),
      usingModuleList: this.state.usingModuleList.map(i => {
        const styleValue = i.style[style.styleKey]
        if (i.edit && styleValue) {
          i.style[style.styleKey] = style.unitOption.reduce((acc, cur) => {
            return acc.replace(cur, '')
          }, styleValue) + unit
        }
        return i
      })
    })
  }
  onDrapModule = (data) => {
    const sourceName = data.sourceId
    const targetName = data.targetId
    const list = this.state.usingModuleList
    const source = list.filter(i => i.name === sourceName)[0]
    const sourceIndex = list.indexOf(source)
    const target = list.filter(i => i.name === targetName)[0]
    const targetIndex = list.indexOf(target)
    const newList = list.filter(i => i !== source)
    const targetNewIndex = newList.indexOf(target)
    if (source && target) {
      if (sourceIndex > targetIndex) {
        newList.splice(targetNewIndex, 0, source)
      } else {
        newList.splice(targetNewIndex + 1, 0, source)
      }
      this.setState({
        usingModuleList: newList
      })
    }
  }
  onBackgroundChange = (e) => {
    const file = e.target.files[0]
    if (file) {
      const reader = new FileReader()
      reader.readAsDataURL(file)
      reader.onload = (e) => {
        this.setState({ backgroundImage: e.currentTarget.result })
      }
    }
  }
  onSelectTabModule = (module) => {
    this.onEditModule(module, 'module')
  }
  onEditModule = (module, activeTab = 'style') => {
    const startEdit = !module.edit
    const newState = {
      usingModuleList: this.state.usingModuleList.map(i => {
        if (i.name === module.name) {
          i.edit = !i.edit
        } else {
          i.edit = false
        }
        return i
      }),
      moduleStyleSet: this.state.moduleStyleSet.map(i => {
        if (startEdit) {
          i.disabled = false
          i.showUnitOption = false
          const mValue = module.style[i.styleKey]
          if (mValue) {
            if (i.unFormater) {
              i.value = i.unFormater(mValue)
            } else if (i.unit && i.unitOption) {
              const unit = i.unitOption.find(u => mValue.indexOf(u) > -1)
              if (unit) {
                i.unit = unit
              }
              i.value = i.unitOption.reduce((acc, cur) => {
                return acc.replace(cur, '')
              }, mValue)
            } else {
              i.value = mValue
            }
          }
        } else {
          i.disabled = true
          i.value = ''
        }
        return i
      }),
      activeTab,
    }
    this.setState(newState)
  }
  onTotalStyleChange = (e, s) => {
    this.setState({
      totalStyleSet: this.state.totalStyleSet.map(i => {
        if (i.name === s.name) {
          i.value = e.target.value
        }
        return i
      })
    })
  }
  onModuleStyleChange = (e, s) => {
    const value = e.target.value
    this.setState({
      usingModuleList: this.state.usingModuleList.map(i => {
        if (i.edit && value) {
          i.style[s.styleKey] = getValueCssStyle(s, value)
        }
        return i
      }),
      moduleStyleSet: this.state.moduleStyleSet.map(i => {
        if (i.name === s.name) {
          i.value = value
        }
        return i
      })
    })
  }
  onRemoveSelectedModule = () => {
    this.setState({
      usingModuleList: this.state.usingModuleList.filter(i => !i.edit)
    })
  }
  onRemoveModule = (module) => {
    this.setState({
      usingModuleList: this.state.usingModuleList.filter(i => i.name !== module.name),
      moduleList: this.state.moduleList.map(i => {
        if (i.name === module.name) {
          i.selected = false
        }
        return i
      })
    })
  }
  onTabModuleShowIconChange = (icon) => {
    this.setState({ tabModuleShowIcon: icon })
  }
  onViewSizeChange = (width, height) => {
    const newState = {}
    if (width !== null) { newState.viewWidth = width }
    if (height !== null) { newState.viewHeight = height }
    this.setState(newState, () => {
      this.state.usingModuleList.forEach(i => {
        eval(i.js)
      })
    })
  }
  get tabModule() {
    const { activeTab, tabModuleShowIcon, usingModuleList, moduleStyleSet, totalStyleSet } = this.state
    const editModule = usingModuleList.find(i => i.edit)
    const disableRemove = !editModule
    if (activeTab === 'module') {
      return (
        <div>
          <div>
            <div className={styles.tabModules}>
              {usingModuleList.map(i =>
                <div onClick={() => this.onSelectTabModule(i)} className={styles.tabModuleWrapper} style={{ border: i.edit ? `2px solid ${mainColor}` : 'none' }}>
                  {i.edit && <div className={styles.tabModuleOption}><Icon onClick={(e) => {
                    e.stopPropagation()
                    this.onRemoveModule(i)
                  }} type="close" /></div>}
                  <DraggableModule
                    key={i.name}
                    id={i.name}
                    onDrop={this.onDrapModule}
                    content={tabModuleShowIcon === 'picture' ?
                      <Card
                        hoverable
                        style={{ width: 160, position: 'relative' }}
                        bodyStyle={{ padding: '5px 0' }}
                        cover={<div style={{ overflow: 'hidden', height: 96 }}>{i.component}</div>}
                      >
                        <div>{i.name}</div>
                      </Card> :
                      <div style={{ display: 'block', padding: '6px 0', width: 178, fontSize: '18px' }}>{i.name}</div>
                    }
                  /></div>)}
            </div>
          </div>
        </div>
      )
    }
  }
  get tabStyle() {
    const { activeTab, usingModuleList, moduleStyleSet, totalStyleSet } = this.state
    const editModule = usingModuleList.find(i => i.edit)
    const disableRemove = !editModule
    return (
      <div>
        <div className={styles.styleTitle}>模块样式</div>
        {moduleStyleSet.map(i => i.render({
          data: i,
          onStyleChange: this.onModuleStyleChange,
          onChangeUnit: this.onChangeUnit,
          onShowUnitOption: this.onShowUnitOption,
          eventInfo: 'moduleStyleSet',
          onHideUnitOption: this.onHideUnitOption,
        }))}
        <div className={styles.styleTitle}>整体样式</div>
        {totalStyleSet.map(i => i.render({
          data: i,
          onStyleChange: this.onTotalStyleChange,
          onChangeUnit: this.onChangeUnit,
          onShowUnitOption: this.onShowUnitOption,
          eventInfo: 'totalStyleSet',
          onHideUnitOption: this.onHideUnitOption,
        }))}
      </div>
    )
  }
  get tabContent() {
    const { activeTab, usingModuleList, moduleStyleSet, totalStyleSet } = this.state
    const editModule = usingModuleList.find(i => i.edit)
    const disableRemove = !editModule
    if (activeTab === 'module') {
      return (
        <div>
          <div>
            <button onClick={this.onShowSelector}>选择模块</button>
            <button disabled={disableRemove} onClick={this.onRemoveSelectedModule}>删除模块</button>
          </div>
          <div>
            <div className={styles.tabModules}>
              {usingModuleList.map(i =>
                <DraggableModule
                  key={i.name}
                  id={i.name}
                  onDrop={this.onDrapModule}
                  content={
                    <div className={styles.tabModuleItem}>
                      <div className={styles.tabModule}>{i.component}</div>
                      <div className="">{i.name}</div>
                    </div>
                  }
                />)}
            </div>
          </div>
        </div>
      )
    }
    return (
      <div>
        <div>模块样式</div>
        {moduleStyleSet.map(i => i.render({
          data: i,
          onStyleChange: this.onModuleStyleChange,
          onChangeUnit: this.onChangeUnit,
          onShowUnitOption: this.onShowUnitOption,
          eventInfo: 'moduleStyleSet',
          onHideUnitOption: this.onHideUnitOption,
        }))}
        <div>整体样式</div>
        {totalStyleSet.map(i => i.render({
          data: i,
          onStyleChange: this.onTotalStyleChange,
          onChangeUnit: this.onChangeUnit,
          onShowUnitOption: this.onShowUnitOption,
          eventInfo: 'totalStyleSet',
          onHideUnitOption: this.onHideUnitOption,
        }))}
      </div>
    )
  }
  get viewContent() {
    const { usingModuleList } = this.state
    return usingModuleList.map(i => <div key={i.name} onClick={() => this.onEditModule(i)} style={{ ...i.style, border: i.edit ? '2px solid #81D4FA' : '', overflow: 'hidden' }}>
      {i.html ? <div dangerouslySetInnerHTML={{ __html: i.html }} /> : <div className="module view">{i.component}</div>}
    </div>)
  }
  get moduleSeletor() {
    const { moduleList } = this.state
    return (
      <div>
        <div className={styles.selectorContent}>
          {moduleList.map(i => <div key={i.name} className={styles.selectorItem}>
            {/* <p style={{textAlign: 'center'}}>{i.name}</p> */}
            <div className={styles.selectorModule}>
              {i.component}
            </div>
            <div className={i.selected ? `${styles.selected} ${styles.check}` : styles.check}>
              <label htmlFor={i.name}>{i.name}</label>
              <input id={i.name} type="checkbox" onChange={(e) => this.onUsingModuleChange(e, i)} checked={i.selected} />
            </div>
          </div>)}
        </div>
      </div>
    )
  }
  render() {
    const { activeTab, tabModuleShowIcon, showModuleSeletor, backgroundImage, totalStyleSet, viewHeight, viewWidth } = this.state
    const totalStyle = totalStyleSet.reduce((acc, cur) => {
      return { ...acc, [cur.styleKey]: getCssStyle(cur) }
    }, {})
    return (
      <Layout style={{ minHeight: '100%' }}>
        <Header style={{ background: 'rgb(235,235,235)', paddingLeft: 10, borderBottom: '1px solid #d8d8d8' }}>
          <Popover placement="bottom" content={<div>
            <div onClick={() => this.onTabModuleShowIconChange('picture')} style={{ color: tabModuleShowIcon === 'picture' ? mainColor : '', cursor: 'pointer', padding: '12px 5px' }}>
              <Icon type="picture" />显示页面缩略图
            </div>
            <div onClick={() => this.onTabModuleShowIconChange('profile')} style={{ color: tabModuleShowIcon === 'profile' ? mainColor : '', cursor: 'pointer', padding: '12px 5px' }}>
              <Icon type="profile" />只显示页面标题
            </div>
          </div>} title="">
            <Button style={{ marginRight: 20 }}><Icon type={tabModuleShowIcon} />显示</Button>
          </Popover>
          <Button onClick={this.onShowSelector} style={{ margin: '0 20px' }}><Icon type="plus" />添加模块</Button>
          <Button onClick={this.onResetStyle} style={{ margin: '0 20px' }}>重置样式</Button>
          <Button style={{ margin: '0 20px' }}>
            <label htmlFor="bgImage" className={styles.test}>修改背景</label>
            <input id="bgImage" onChange={this.onBackgroundChange} type="file" accept="image/*" style={{ display: 'none' }} />
          </Button>
          <Button style={{ margin: '0 20px' }} onClick={this.onExportHtml}>导出html</Button>
          <Button style={{ float: 'right', marginTop: 14 }} onClick={this.props.onBack}>退出</Button>
        </Header>
        <Layout>
          <Sider width={240} style={{ background: 'white', borderRight: '1px solid #a8a8a8' }}>
            <Tabs style={{ textAlign: 'center', overflow: 'visible' }} defaultActiveKey="module" activeKey={activeTab} onChange={this.onChangeTab}>
              <TabPane key="module" tab={<span>模块</span>}>
                {this.tabModule}
              </TabPane>
              <TabPane key="style" tab={<span>样式</span>}>
                {this.tabStyle}
              </TabPane>
            </Tabs>
          </Sider>
          <Content style={{ background: 'rgb(243,243,243)' }}>
            <div style={{ margin: '25px 300px 25px 25px', display: 'flex', justifyContent: 'center' }}>
              <div style={{ position: 'relative' }}>
                <div style={{ width: viewWidth, height: viewHeight, zIndex: 3, position: 'absolute', top: 0, left: 0, backgroundImage: `url(${backgroundImage})`, backgroundSize: '100% 100%' }}></div>
                <div style={{ width: viewWidth, height: viewHeight, ...totalStyle, zIndex: 5 }} className={styles.viewContainer} id="htmlContent">
                  {this.viewContent}
                </div>
              </div>
            </div>
          </Content>
          <Sider
            className={styles.rightSider}
            width={300}
          >
            <Button style={{ borderColor: viewWidth === 375 && viewHeight === 667 ? mainColor : '' }} onClick={() => this.onViewSizeChange(375, 667)} type="dashed">iPhone6/7/8 375*667</Button>
            <Button style={{ borderColor: viewWidth === 414 && viewHeight === 736 ? mainColor : '' }} onClick={() => this.onViewSizeChange(414, 736)} type="dashed">iPhone6/7/8 Plus 414*736</Button>
            <Button style={{ borderColor: viewWidth === 375 && viewHeight === 812 ? mainColor : '' }} onClick={() => this.onViewSizeChange(375, 812)} type="dashed">iPhoneX 375*812</Button>
            <Button style={{ borderColor: viewWidth === 768 && viewHeight === 1024 ? mainColor : '' }} onClick={() => this.onViewSizeChange(768, 1024)} type="dashed">iPad 768*1024</Button>
            <Button style={{ borderColor: viewWidth === 800 && viewHeight === 450 ? mainColor : '' }} onClick={() => this.onViewSizeChange(800, 450)} type="dashed">PC 800*450</Button>
            <p>自定义宽高</p>
            <Row className={styles.rightRow}>
              <Col className={styles.rightCol1} span={6}>宽 :</Col>
              <Col className={styles.rightCol2} span={18}><Input value={viewWidth} onChange={e => this.onViewSizeChange(+e.target.value || 0, null)} /></Col>
            </Row>
            <Row className={styles.rightRow}>
              <Col className={styles.rightCol1} span={6}>高 :</Col>
              <Col className={styles.rightCol2} span={18}><Input value={viewHeight} onChange={e => this.onViewSizeChange(null, +e.target.value || 0)} /></Col>
            </Row>
          </Sider>
        </Layout>
        <Modal
          width={840}
          style={{ top: 20 }}
          title="前选择模块"
          onCancel={this.onCloseSelector}
          visible={showModuleSeletor}
          footer={<Button onClick={this.onCloseSelector}>确认</Button>}
        >
          {this.moduleSeletor}
        </Modal>
      </Layout>
    );
  }
}

export default DragDropContext(HTML5Backend)(App);
