import axios from 'axios';

const http = axios.create({
    baseURL : "http://localhost:8080"
})

export default {

    getSegments(address) {
        //Need to figure out how we want to catch this request on server
        return http.get(`/segments/?address=${address}`)
    }

}
