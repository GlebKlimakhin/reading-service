import http from 'k6/http';
import {sleep} from 'k6'

export const options = {
    stages : [
        {duration : '10m', target: 200},
        {duration : '5h 40m', target: 200},
        {duration : '10m', target : 0}
    ]
};

export default function () {
    const urlToLogin = 'http://localhost:8189/auth/login';
    const urlToUser = 'http://localhost:8189/users/1';

    const payload = JSON.stringify({
        username: 'user1',
        password: 'user1'
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
    };

    let loginPost = http.post(urlToLogin, payload, params);
    let token = loginPost.body('token');

    const paramsWithToken = {
        headers: {
            'Accept': 'application/json',
            'Authorization' : token
        },
    };
    let usersRequest = http.get(urlToUser, paramsWithToken);

    sleep(1);
}