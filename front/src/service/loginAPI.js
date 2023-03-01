import axios from 'axios'

const getUserInfo = (userId, userPw) => {
    const reqData = {
        'user_id': userId,
        'user_pw': userPw
    }

    let serverUrl = '//localhost:8081'

    return axios.post(serverUrl + '/user/login', reqData, {
        headers: {
            'Content-type': 'application/json'
        }
    })
}

export default {
    async doLogin(userId, userPw) {
        try {
            const getUserInfoPromise = getUserInfo(userId, userPw)
            const [userInfoResponse] = await Promise.all([getUserInfoPromise])

            console.log("11111111" + userInfoResponse.data.errorCode)

            if (userInfoResponse.data.length === 0) {
                return 'notFound'
            }else if(userInfoResponse.data.errorCode == 402){
                return 'withdrawal'
            } else {
                localStorage.setItem('user_token', userInfoResponse.data.user_token)
                localStorage.setItem('user_role', userInfoResponse.data.user_role)
                //localStorage.setItem('user_idx', userInfoResponse.data.user_idx)
                //console.log("!!!!!!!!!!!!!" + userInfoResponse.data.errorCode)
                return userInfoResponse
            }
        } catch (err) {
            //console.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+err)
        }
    }
}