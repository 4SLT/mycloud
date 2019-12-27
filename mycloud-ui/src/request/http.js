import axios from 'axios';
import vue from 'vue';
import QS from 'qs';


axios.defaults.timeout = 10000;


/**
 * get方法，对应get请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function get(url, params) {
  return new Promise((resolve, reject) => {
    axios.get(url, {
      params: params
    }).then(res => {
      resolve(res.data);
    }).catch(err => {
      reject(err.data)
    })
  });
}


/**
 * post方法，对应post请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function post(url, params) {
  return new Promise((resolve, reject) => {
    axios.post(url, QS.stringify(params))
      .then(res => {
        resolve(res.data);
      })
      .catch(err => {
        reject(err.data)
      })
  });
}

export const request = (url, body, type) => {
  const query = {
    url: url,
    method: type,
    withCredentials: true,
    timeout: 50000
  }
  if (type === 'get') {
    query.params = body
  } else {
    query.data = QS.stringify(body)
  }
  return axios.request(query)
    .then(res => {
      return new Promise((resolve, reject) => {
        if (!res.data) {
          console.log('request >> ', query);
          reject(new Error('服务器响应超时'));
          return
        } else {
          if (res.data.status === 0 || res.data.status === -1) {
            resolve(res.data)
          } else {
            reject(res.data)
          }
        }
      })
    }, e => {
      console.log(e)
      switch (e.response.status) {
        // 未登录访问
        case 401:
          top.window.postMessage({
            type: 'NO_LOGIN',
            msg: '401'
          }, '*')
          this.$router.push('/login')
          return Promise.reject(e.response)
        // 无权限操作
        case 403:
          top.window.postMessage({
            type: 'NO_PERMISSION',
            msg: '403'
          }, '*')
          return Promise.reject(new Error('无权访问此资源'))
        case 404: // 服务器找不到页面
          top.window.postMessage({
            type: 'NO_MAPPING',
            msg: '404'
          }, '*')
          this.$router.push('/404')
          return Promise.reject(new Error('请求失败: 404'))
        default:
          break
      }
      return Promise.reject(new Error('请求失败'))
    })
    .catch(e => {
      console.warn('--------------', e)
      vue.prototype.$message.error(e && e.message ? e.message : '系统错误')
      return Promise.reject(e)
    }).finally(() => {
      // loadingInstance.close()
    })
}

