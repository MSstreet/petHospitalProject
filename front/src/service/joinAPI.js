import axios from 'axios'

const getUserInfo1 = (userId, userPw, userName) => {
    const reqData = {
        'user_id': userId,
        'user_pw': userPw,
        'user_name' : userName
    }

    let serverUrl = '//localhost:8081'

    return axios.post(serverUrl + '/user/join', reqData, {
        headers: {
            'Content-type': 'application/json'
        }
    })
}

export default {
    async doJoin(userId, userPw, userName) {
        try {
            const getUserInfoPromise = getUserInfo1(userId, userPw, userName)
            const [userInfoResponse] = await Promise.all([getUserInfoPromise])
            if (userInfoResponse.data.length === 0) {
                return 'notFound'
            } else {
                return userInfoResponse
            }
        } catch (err) {
            console.error(err)
        }
    }
}

