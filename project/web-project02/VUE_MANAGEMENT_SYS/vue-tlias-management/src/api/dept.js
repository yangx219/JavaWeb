import request from "../utils/request";

//queryAll
export const queryAllApi = () => request.get('/depts');

//Ajouter dept
export const addDeptApi = (data) => request.post('/depts', data)


//queryById
export const queryByIdApi = (id) => request.get(`/depts/${id}`)


//Modifier un dept
export const updateDeptApi = (data) => request.put('/depts', data)

//supprimer
export const deleteDeptApi = (id) => request.delete(`/depts?id=${id}`)