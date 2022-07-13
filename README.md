## 介绍

《weather-react》是一个天气类的H5可视化搭建项目。您可以通过简单的拖拽方式快速生产一个H5页面，目前行业内罕有关于H5的可视化搭建的开源项目，《weather-react》是一个相对比较完整的开源项目，仅抛砖引玉希望您喜欢。

 
### 编辑器整体设计

- 一个组件选择区，提供使用者选择需要的组件
- 一个编辑预览画板，提供使用者拖拽排序页面预览的功能
- 一个组件属性编辑，提供给使用者编辑组件内部 props、公共样式和动画的功能
- 用户在左侧组件区域选择组件添加到页面上，编辑区域通过动态组件特性渲染出每个元素组件。

**项目预览**
- 登录
![登录](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/dl.png)  
- 首页
![首页](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/sy.png)  
- 选择模块
![选择模块](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/szmk.png)  
- 添加模块
![添加模块](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/tjmk.png)  
- 修改样式
![修改样式](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/xgys.png)  
- 导出H5
![导出H5](https://github.com/xianzifeng/weather-imgs/blob/master/github-weather-react/dch5.png)   
## 开发调试
 
 
### 安装依赖

```
npm i
```
 
### 启动服务端

```
npm run start
```


##### 启动完访问http://localhost:3000 就可以看到工程页面了
 
 
## 发布部署 
 

### 需要全局安装 pm2

```
npm install pm2 -g
```

### 部署

```
 npm run build
```

### License

Apache License 2.0