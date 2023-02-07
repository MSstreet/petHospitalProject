import axios from 'axios'

const getUserInfo1 = (userId, userPw, userName,phoneNum,zipCode,addr,detailAddress ) => {
    const reqData = {
        'user_id': userId,
        'user_pw': userPw,
        'user_name' : userName,
        'phone_num' : phoneNum,
        'zip_code' : zipCode,
        'addr':addr,
        'detail_address':detailAddress
    }

    let serverUrl = '//localhost:8081'

    return axios.post(serverUrl + '/user/join', reqData, {
        headers: {
            'Content-type': 'application/json'
        }
    })
}

export default {
    async doJoin(userId, userPw, userName,phoneNum,zipCode,addr,detailAddress) {
        try {
            const getUserInfoPromise = getUserInfo1(userId, userPw, userName,phoneNum,zipCode,addr,detailAddress)
            const [userInfoResponse] = await Promise.all([getUserInfoPromise])
            console.log(userInfoResponse.data.errorCode)
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

