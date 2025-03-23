import request from '@/utils/request'

//login
export const loginApi = (data) => request.post('/login', data)