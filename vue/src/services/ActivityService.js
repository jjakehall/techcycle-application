import axios from 'axios';


export default {

    getPublicActivities() {
        return axios.get(`/activity/public`)
    },

    getUserActivities() {
      return axios.get(`/activity/user`)
    },

    createNewActivity(activity) {
        return axios.post(`/activity`, activity)
    },

    updateActivity(activity, activityId) {
        return axios.put(`/activity/${activityId}`, activity)
    },

    deleteActivity(activityId) {
        return axios.delete(`/activity/${activityId}`)
    },

    getUserActivity(activityId) {
        return axios.get(`/activity/${activityId}`)
    }

}