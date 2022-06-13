import axios from "axios";


export default{

    getEquipment() {
        return axios.get(`/equipment`)
    },
    createEquipment(equipment){
        return axios.post(`/equipment`, equipment)
    },
    addUserInfo(user) {
      return axios.put(`/update`, user)
    },
    getUserById() {
        return axios.get('/info')
    },
    updateEquipment(equipment, equipmentId){
        return axios.put(`/equipment/${equipmentId}`, equipment)
    },
    deleteEquipment(equipmentId){
        return axios.delete(`/equipment/${equipmentId}`)
    }
}