import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8080/api';

function getByDate (date) {
    return axios.get('slot/date/' + date)
}

function bookSlot (slot) {
    return axios({
        url: '/slot/book',
        method: 'post',
        data: slot
    })
}

export {
    getByDate,
    bookSlot
}
