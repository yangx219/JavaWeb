import request from "../utils/request";

//queryAll
export const queryAllApi = () => request.get('/depts');

//Ajouter dept
export const addDeptApi = (data) => request.post('/depts', data)


//根据ID查询
export const queryByIdApi = (id) => request.get(`/depts/${id}`)


//修改部门
export const updateDeptApi = (data) => request.put('/depts', data)

//删除部门
export const deleteDeptApi = (id) => request.delete(`/depts?id=${id}`)