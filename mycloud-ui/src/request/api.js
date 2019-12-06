import {get, post} from './http';
import {request} from './http';

//测试
export const test = {
  getList: body => get('/hello/getList', body),
  postList:body=>post('/hello/getList', body),
  requestList: body => request('/hello/getList', body, 'get'),
}
