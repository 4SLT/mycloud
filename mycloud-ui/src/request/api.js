// import {get, post} from './http';
import {request} from './http';

//测试
export const test = {
  // getList: body => get('/user/getList', body),
  // postList:body=>post('/user/getList', body),
  requestList: body => request('/user/getList', body, 'get'),
}

//登陆
export const userLogin = {
  register: body => request('/login/register', body, 'get'),
}
