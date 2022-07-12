import React from 'react'

import { Form, Icon, Input, Button, Spin, message, Modal } from 'antd'

import App from './App'

const FormItem = Form.Item

class Login extends React.Component {
  state = {
    showApp: true
  }
  handleSubmit = (e) => {
    e.preventDefault()
    this.props.form.validateFields((err, fields) => {
      if (!err) {
        const { username, password, captcha } = fields
        if(captcha.toLowerCase() !== '4g7s')  {
          message.error('验证码错误')
          return
        }
        if (username !== 'test' || password !== 'test') {
          message.error('账号或密码错误')
          return
        }
        this.setState({ showApp: true })
      }
    })
  }
  onBackLogin = () => {
    this.setState({ showApp: false })
  }
  render() {
    if (this.state.showApp) {
      return <App onBack={this.onBackLogin} />
    }
    const { getFieldDecorator } = this.props.form;
    return (
      <div style={{ color: 'white' }}>
        <video
          loop
          autoPlay
          src="./video2018summer.mp4"
          style={{ objectFit: 'fill', width: '100%', height: '100%', position: 'fixed' }}
          width={window.innerWidth}
          height={window.innerHeight}
        />
        <div style={{ backgroundColor: 'rgba(0,0,0,0.5)', height: 350, position: 'fixed', top: '50%', transform: 'translateY(-50%)', width: '100%' }}>
          <div style={{ position: 'absolute', top: 50, left: 540 }}>
            <span style={{ fontSize: 38 }}>中国气象</span>
            <span style={{ fontSize: 38, padding: '0 12px' }}>|</span>
            <span style={{ fontSize: 22 }}>智能气象平台</span>
          </div>
        </div>
        <div style={{
          position: 'absolute',
          right: 400,
          background: 'rgba(0,0,0,0.2)',
          position: 'fixed',
          top: '50%',
          transform: 'translateY(-50%)',
          padding: '30px 25px',
        }}>
          <p>欢迎登录</p>
          <div>
            <Form onSubmit={this.handleSubmit} className="login-form">
              <FormItem>
                {getFieldDecorator('username', {
                  rules: [{ required: true, message: '请输入账号' }]
                })(
                  <Input style={{ width: 250 }} prefix={<Icon type="user" style={{ fontsize: 14 }} />} placeholder="账号" />
                )}
              </FormItem>
              <FormItem>
                {getFieldDecorator('password', {
                  rules: [{ required: true, message: '请输入密码' }]
                })(<Input style={{ width: 250 }} type="password" prefix={<Icon type="lock" style={{ fontsize: 14 }} />} placeholder="密码" />)}
              </FormItem>
              <FormItem>
                {getFieldDecorator('captcha', {
                  rules: [{ required: true, message: '请输入验证码' }]
                })(<Input style={{ width: 80 }} placeholder="验证码" />)}
                <div style={{ float: 'right', transform: 'translateY(-2px)' }} className="children-image-alt" onClick={this.handleRefreshCaptcha}>
                  <img src="./coe.jpg" style={{ width: '100px', height: '30px' }} alt="lost" />
                </div>
              </FormItem>
              <FormItem>
                <Button style={{ width: '100%' }} type="primary" htmlType="submit">登录</Button>
              </FormItem>
            </Form>
          </div>
        </div>
      </div>
    )
  }
}

export default Form.create()(Login)