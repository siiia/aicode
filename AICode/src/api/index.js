import axios from "axios";
const service = axios.create({
    // api的base_url
    // baseURL: process.env.VUE_APP_URL, // 本地-后端解决跨域后
    baseURL: "aicode", // 本地-前端解决跨域
    timeout: 60000 // 请求超时时间
});
export default service