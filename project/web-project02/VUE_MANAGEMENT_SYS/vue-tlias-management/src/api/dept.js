import request from "../utils/request";

//queryAll
export const queryAllApi = () => request.get('/depts');

//Ajouter dept
export const addDeptApi = (data) => request.post('/depts', data)


//根据ID查询
export const queryInfoApi = (id) => request.get(`/depts/${id}`)